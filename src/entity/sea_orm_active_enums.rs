//! `SeaORM` Entity. Generated by sea-orm-codegen 0.12.3

use sea_orm::entity::prelude::*;
use serde::{Deserialize, Serialize};

#[derive(Debug, Clone, PartialEq, Eq, EnumIter, DeriveActiveEnum, Serialize, Deserialize)]
#[sea_orm(rs_type = "String", db_type = "Enum", enum_name = "attachment_type")]
pub enum AttachmentType {
    #[sea_orm(string_value = "IMAGE")]
    Image,
    #[sea_orm(string_value = "VIDEO")]
    Video,
}
#[derive(Debug, Clone, PartialEq, Eq, EnumIter, DeriveActiveEnum, Serialize, Deserialize)]
#[sea_orm(rs_type = "String", db_type = "Enum", enum_name = "auth_provider")]
pub enum AuthProvider {
    #[sea_orm(string_value = "APPLE")]
    Apple,
    #[sea_orm(string_value = "BASIC")]
    Basic,
    #[sea_orm(string_value = "FACEBOOK")]
    Facebook,
    #[sea_orm(string_value = "GITHUB")]
    Github,
    #[sea_orm(string_value = "GOOGLE")]
    Google,
    #[sea_orm(string_value = "MICROSOFT")]
    Microsoft,
    #[sea_orm(string_value = "TWITTER")]
    Twitter,
}
#[derive(Debug, Clone, PartialEq, Eq, EnumIter, DeriveActiveEnum, Serialize, Deserialize)]
#[sea_orm(rs_type = "String", db_type = "Enum", enum_name = "group_role")]
pub enum GroupRole {
    #[sea_orm(string_value = "ADMIN")]
    Admin,
    #[sea_orm(string_value = "MODERATOR")]
    Moderator,
    #[sea_orm(string_value = "USER")]
    User,
}
#[derive(Debug, Clone, PartialEq, Eq, EnumIter, DeriveActiveEnum, Serialize, Deserialize)]
#[sea_orm(rs_type = "String", db_type = "Enum", enum_name = "post_type")]
pub enum PostType {
    #[sea_orm(string_value = "BASIC")]
    Basic,
    #[sea_orm(string_value = "POLLING")]
    Polling,
}
#[derive(Debug, Clone, PartialEq, Eq, EnumIter, DeriveActiveEnum, Serialize, Deserialize)]
#[sea_orm(rs_type = "String", db_type = "Enum", enum_name = "report_status")]
pub enum ReportStatus {
    #[sea_orm(string_value = "CANCELED")]
    Canceled,
    #[sea_orm(string_value = "CLOSED")]
    Closed,
    #[sea_orm(string_value = "OPEN")]
    Open,
}
#[derive(Debug, Clone, PartialEq, Eq, EnumIter, DeriveActiveEnum, Serialize, Deserialize)]
#[sea_orm(rs_type = "String", db_type = "Enum", enum_name = "report_type")]
pub enum ReportType {
    #[sea_orm(string_value = "POST")]
    Post,
    #[sea_orm(string_value = "USER")]
    User,
}
#[derive(Debug, Clone, PartialEq, Eq, EnumIter, DeriveActiveEnum, Serialize, Deserialize)]
#[sea_orm(rs_type = "String", db_type = "Enum", enum_name = "user_gender")]
pub enum UserGender {
    #[sea_orm(string_value = "FEMALE")]
    Female,
    #[sea_orm(string_value = "MALE")]
    Male,
}
#[derive(Debug, Clone, PartialEq, Eq, EnumIter, DeriveActiveEnum, Serialize, Deserialize)]
#[sea_orm(rs_type = "String", db_type = "Enum", enum_name = "user_status")]
pub enum UserStatus {
    #[sea_orm(string_value = "ACTIVE")]
    Active,
    #[sea_orm(string_value = "INACTIVE")]
    Inactive,
    #[sea_orm(string_value = "LOCKED")]
    Locked,
    #[sea_orm(string_value = "SUSPENDED")]
    Suspended,
    #[sea_orm(string_value = "WAITING_CONFIRMATION")]
    WaitingConfirmation,
}
