/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.eureka.controller;

import com.bluehabit.eureka.common.BaseResponse;
import com.bluehabit.eureka.component.model.CompleteProfileRequest;
import com.bluehabit.eureka.component.model.LinkResetPasswordConfirmationRequest;
import com.bluehabit.eureka.component.model.LinkResetPasswordConfirmationResponse;
import com.bluehabit.eureka.component.model.OtpConfirmationRequest;
import com.bluehabit.eureka.component.model.OtpConfirmationResponse;
import com.bluehabit.eureka.component.model.RequestResetPasswordRequest;
import com.bluehabit.eureka.component.model.ResetPasswordRequest;
import com.bluehabit.eureka.component.model.SignInResponse;
import com.bluehabit.eureka.component.model.SignInWithEmailRequest;
import com.bluehabit.eureka.component.model.SignInWithGoogleRequest;
import com.bluehabit.eureka.component.model.CompleteProfileResponse;
import com.bluehabit.eureka.component.model.SignUpWithEmailRequest;
import com.bluehabit.eureka.services.ResetPasswordService;
import com.bluehabit.eureka.services.SignInService;
import com.bluehabit.eureka.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthenticationController {
    @Autowired
    private SignUpService signUpService;

    @Autowired
    private SignInService signInService;

    @Autowired
    private ResetPasswordService resetPasswordService;

    private final String tokenResetPassword = "4adf-3ed";

    //region sign up

    @PostMapping(
        path = "/api/v1/auth/sign-up-email",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse<Object>> signUpWithEmail(
        @RequestBody SignUpWithEmailRequest request
    ) {
        return signUpService.signUpWithEmail(request);
    }

    @PostMapping(
        path = "/api/v1/auth/otp-confirmation"
    )
    public ResponseEntity<BaseResponse<OtpConfirmationResponse>> otpConfirmation(
        @RequestBody OtpConfirmationRequest request
    ) {
        return signUpService.otpConfirmation(request);
    }

    @PostMapping(
        path = "/api/v1/auth/complete-profile",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse<CompleteProfileResponse>> completeProfile(
        @RequestBody CompleteProfileRequest request
    ) {
        return signUpService.completeProfile(request);
    }

    //end region
    //region sign in

    @PostMapping(
        path = "/api/v1/auth/sign-in-google",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse<SignInResponse>> signInWithGoogle(
        @RequestBody SignInWithGoogleRequest request
    ) {
        return signInService.signInWithGoogle(request);
    }

    //end region
    //region reset password
    @PostMapping(
        path = "/api/v1/auth/request-reset-password"
    )
    public ResponseEntity<BaseResponse<Map<Object, Object>>> requestResetPassword(
        @RequestBody RequestResetPasswordRequest request
    ) {
        return resetPasswordService.requestResetPassword(request);
    }

    @PostMapping(
        path = "/api/v1/auth/link-confirmation"
    )
    public ResponseEntity<BaseResponse<LinkResetPasswordConfirmationResponse>> linkResetPasswordConfirmation(
        @RequestBody LinkResetPasswordConfirmationRequest request
    ) {
        return resetPasswordService.linkConfirmation(request);
    }

    @PostMapping(
        path = "/api/v1/auth/reset-password"
    )
    public ResponseEntity<BaseResponse<Map<Object, Object>>> resetPassword(
        @RequestHeader(value = tokenResetPassword, required = false) String token,
        @RequestBody ResetPasswordRequest request
    ) {
        return resetPasswordService.setNewPassword(token, request);
    }
    //end region

    @PostMapping(
        path = "/api/v1/auth/sign-in"
    )
    public ResponseEntity<BaseResponse<SignInResponse>> signIn(@RequestBody SignInWithEmailRequest request) {
        return signInService.signIn(request);
    }

}
