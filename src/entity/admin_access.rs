//! `SeaORM` Entity. Generated by sea-orm-codegen 0.12.3

use sea_orm::entity::prelude::*;
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, DeriveEntityModel, Eq, Serialize, Deserialize)]
#[sea_orm(table_name = "admin_access")]
pub struct Model {
    #[sea_orm(primary_key, auto_increment = false)]
    pub id: String,
    pub admin_id: Option<String>,
    pub access_id: Option<String>,
    pub created_at: DateTime,
    pub updated_at: DateTime,
    pub deleted: bool,
}

#[derive(Copy, Clone, Debug, EnumIter, DeriveRelation)]
pub enum Relation {
    #[sea_orm(
        belongs_to = "super::system_access::Entity",
        from = "Column::AccessId",
        to = "super::system_access::Column::Id",
        on_update = "NoAction",
        on_delete = "NoAction"
    )]
    SystemAccess,
    #[sea_orm(
        belongs_to = "super::user_credential::Entity",
        from = "Column::AdminId",
        to = "super::user_credential::Column::Id",
        on_update = "NoAction",
        on_delete = "NoAction"
    )]
    UserCredential,
}

impl Related<super::system_access::Entity> for Entity {
    fn to() -> RelationDef {
        Relation::SystemAccess.def()
    }
}

impl Related<super::user_credential::Entity> for Entity {
    fn to() -> RelationDef {
        Relation::UserCredential.def()
    }
}

impl ActiveModelBehavior for ActiveModel {}
