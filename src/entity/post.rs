//! `SeaORM` Entity. Generated by sea-orm-codegen 0.12.3

use super::sea_orm_active_enums::PostType;
use sea_orm::entity::prelude::*;
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, DeriveEntityModel, Eq, Serialize, Deserialize)]
#[sea_orm(table_name = "post")]
pub struct Model {
    #[sea_orm(primary_key, auto_increment = false)]
    pub id: String,
    pub created_by: Option<String>,
    pub post_id: Option<String>,
    #[sea_orm(column_type = "Text", nullable)]
    pub body: Option<String>,
    #[sea_orm(column_type = "Text", nullable)]
    pub location: Option<String>,
    pub likes_count: i64,
    pub comments_count: i64,
    pub post_type: PostType,
    pub created_at: DateTimeWithTimeZone,
    pub updated_at: DateTimeWithTimeZone,
    pub deleted: bool,
}

#[derive(Copy, Clone, Debug, EnumIter, DeriveRelation)]
pub enum Relation {
    #[sea_orm(has_many = "super::attachment::Entity")]
    Attachment,
    #[sea_orm(
        belongs_to = "Entity",
        from = "Column::PostId",
        to = "Column::Id",
        on_update = "NoAction",
        on_delete = "NoAction"
    )]
    SelfRef,
    #[sea_orm(has_many = "super::post_hashtag::Entity")]
    PostHashtag,
    #[sea_orm(has_many = "super::report::Entity")]
    Report,
    #[sea_orm(
        belongs_to = "super::user_credential::Entity",
        from = "Column::CreatedBy",
        to = "super::user_credential::Column::Id",
        on_update = "NoAction",
        on_delete = "NoAction"
    )]
    UserCredential,
}

impl Related<super::attachment::Entity> for Entity {
    fn to() -> RelationDef {
        Relation::Attachment.def()
    }
}

impl Related<super::post_hashtag::Entity> for Entity {
    fn to() -> RelationDef {
        Relation::PostHashtag.def()
    }
}

impl Related<super::report::Entity> for Entity {
    fn to() -> RelationDef {
        Relation::Report.def()
    }
}

impl Related<super::user_credential::Entity> for Entity {
    fn to() -> RelationDef {
        Relation::UserCredential.def()
    }
}

impl ActiveModelBehavior for ActiveModel {}
