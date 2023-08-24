/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.eureka.common;

import com.sun.mail.util.MailConnectException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

@Component
public class MailUtil {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    public boolean sendEmail(
        String recipients,
        String subject,
        String folder,
        Map<String, Object> data
    ) {
        return sendEmail(List.of(recipients), subject, folder, data, (success) -> success);
    }

    public boolean sendEmail(
        String recipients,
        String subject,
        String folder,
        Map<String, Object> data,
        Function<Boolean, Boolean> callback
    ) {
        return sendEmail(List.of(recipients), subject, folder, data, callback);
    }

    public boolean sendEmail(
        List<String> recipients,
        String subject,
        String folder,
        Map<String, Object> data
    ) {
        return sendEmail(recipients, subject, folder, data, (success) -> success);
    }

    public boolean sendEmail(
        List<String> recipients,
        String subject,
        String folder,
        Map<String, Object> data,
        Function<Boolean, Boolean> callback
    ) {
        try {
            try {
                final Locale locale = LocaleContextHolder.getLocale();
                final Context ctx = new Context(locale);
                data.forEach(ctx::setVariable);
                final String html = this.templateEngine.process(
                    "/email/" + folder + "/" + ctx.getLocale().getLanguage(),
                    ctx
                );

                final MimeMessage mailMessage = javaMailSender.createMimeMessage();
                final MimeMessageHelper helper = new MimeMessageHelper(mailMessage);

                mailMessage.setFrom(new InternetAddress(sender));
                for (String sendTo : recipients) {
                    helper.addTo(sendTo);
                }
                helper.setSubject(subject);
                helper.setText(html, true);

                javaMailSender.send(mailMessage);
                return callback.apply(true);
            } catch (MailConnectException socketException) {
                return callback.apply(false);
            }
        } catch (MessagingException messagingException) {
            return callback.apply(false);
        }
    }
}
