/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 11                       */
/* Created on:     2012-2-15 16:08:26                           */
/*==============================================================*/
drop database haos;
create database haos;
use haos;


/*==============================================================*/
/* Table: comment                                             */
/*==============================================================*/
create table comment 
(
   id                   number                         auto_increment not null,
   title                varchar2(40)                    null,
   advantage            varchar2(40)                    null,
   shortcoming          varchar2(40)                    null,
   usage_experience     varchar2(100)                   null,
   comment_time         timestamp                      	null,
   commodity_id         number                          null,
   commodity_code       varchar2(20)                    null,
   commodity_name       varchar2(40)                    null,
   user_code            varchar2(20)                    null,
   create_time          timestamp                       null,
   update_time          timestamp                       null,
   yn                   number(1)                       null,
   constraint PK_COMMENT primary key clustered (id)
);



/*==============================================================*/
/* Table: commodity                                             */
/*==============================================================*/
create table commodity 
(
   id                   number                         auto_increment not null,
   commodity_code       varchar2(20)                   null,
   commodity_name       varchar2(40)                   null,
   category_code        varchar2(20)                   null,
   category_name        varchar2(40)                   null,
   qty          		number                         null,
   price                number(10,2)                   null,
   new_price            number(10,2)                   null,
   sales_count          number                         null,
   viewed_count         number                         null,
   comment_count        number                         null,
   quick_override       text                  		   null,
   description          text                           null,
   specifications       text                           null,
   packing_list         text                           null,
   commodity_photo      text                           null,
   status               number                         null,
   remark               varchar2(255)                  null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_COMMODITY primary key clustered (id)
);

alter table commodity ADD INDEX Index_Commodity_Code(commodity_code);
alter table commodity ADD FULLTEXT Index_Commodity_Name(commodity_name);


/*==============================================================*/
/* Table: commodity_category                                    */
/*==============================================================*/
create table commodity_category 
(
   id                   number                         auto_increment not null,
   category_code        varchar2(20)                   null,
   category_name        varchar2(40)                   null,
   remark               varchar2(100)                  null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_COMMODITY_CATEGORY primary key clustered (id)
);
alter table commodity_category ADD INDEX Index_Category_Code(category_code);
/*==============================================================*/
/* Table: consumer_records                                      */
/*==============================================================*/
create table consumer_records 
(
   id                   number                         auto_increment not null,
   user_code            varchar2(20)                   null,
   order_code           varchar2(20)                   null,
   commodity_id         number                         null,
   commodity_code       varchar2(20)                   null,
   commodity_name       varchar2(40)                   null,
   amount               number(10,2)                   null,
   consumer_time        timestamp                      null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_CONSUMER_RECORDS primary key clustered (id)
);

/*==============================================================*/
/* Table: level                                                 */
/*==============================================================*/
create table level 
(
   id                   number                         auto_increment not null,
   level_code           varchar2(20)                   null,
   level_name           varchar2(40)                   null,
   start_point          number                         null,
   end_point            number                         null,
   remark               varchar2(100)                  null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_LEVEL primary key clustered (id)
);


alter table level ADD INDEX index_level_code(level_code);
/*==============================================================*/
/* Table: t_order                                               */
/*==============================================================*/
create table t_order 
(
   id                   number                         auto_increment not null,
   order_code           varchar2(20)                   null,
   commodity_id         number                         null,
   commodity_code       varchar2(20)                   null,
   commodity_name       varchar2(40)                   null,
   commodity_count      number                         null,
   amount               number(10,2)                   null,
   order_time           timestamp                      null,
   user_code            varchar2(20)                   null,
   user_name            varchar2(40)                   null,
   consignee            varchar2(40)                   null,
   address              varchar2(50)                   null,
   mobile               varchar2(20)                   null,
   email                varchar2(20)                   null,
   zip_code             varchar2(10)                   null,
   payment_method       number(1)                      null,
   shipping_method      number(1)                      null,
   status               number(1)                      null,
   employee_code        varchar2(20)                   null,
   remark               varchar2(100)                  null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_ORDER primary key clustered (id)
);

alter table t_order ADD INDEX index_order_code(order_code);
alter table t_order ADD INDEX index_commodity_code(commodity_code);
/*==============================================================*/
/* Table: send                                                  */
/*==============================================================*/
create table send 
(
   id                   number                         auto_increment not null,
   send_code            varchar2(20)                   null,
   order_code           varchar2(20)                   null,
   commodity_name       varchar2(40)                   null,
   type_code            varchar2(20)                   null,
   type_name            varchar2(40)                   null,
   carrier_code         varchar2(20)                   null,
   carrier_name         varchar2(40)                   null,
   deal_time            timestamp                      null,
   deal_information     varchar2(100)                  null,
   operator             varchar2(30)                   null,
   remark               varchar2(100)                  null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_SEND primary key clustered (id)
);
alter table send ADD INDEX index_send_code(send_code);
alter table send ADD INDEX index_order_code(order_code);
/*==============================================================*/
/* Table: send_type                                             */
/*==============================================================*/
create table send_type 
(
   id                   number                         auto_increment not null,
   type_code            varchar2(20)                   null,
   type_name            varchar2(40)                   null,
   remark               varchar2(100)                  null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_SEND_TYPE primary key clustered (id)
);
alter table send_type ADD INDEX index_type_code(type_code);

/*==============================================================*/
/* Table: carrier                                                */
/*==============================================================*/
create table carrier 
(
   id                  number                         auto_increment not null,
   carrier_code        varchar2(20)                   null,
   carrier_name        varchar2(40)                   null,
   mobile              varchar2(20)                   null,
   email               varchar2(30)                   null,
   contacter           varchar2(30)                   null,
   address             varchar2(50)                   null,
   remark              varchar2(100)                  null,
   create_time         timestamp                      null,
   update_time         timestamp                      null,
   yn                  number(1)                      null,
   constraint PK_CARRIER primary key clustered (id)
);

alter table carrier ADD INDEX index_carrier_code(carrier_code);
/*==============================================================*/
/* Table: user                                                */
/*==============================================================*/
create table user 
(
   id                   number                         auto_increment not null,
   user_code            varchar2(20)                   null,
   user_name            varchar2(40)                   null,
   real_name            varchar2(40)                   null,
   password             varchar2(40)                   null,
   level_code           varchar2(20)                   null,
   level_name           varchar2(40)                   null,
   sex                  number(1)                      null,
   mobile               varchar2(20)                   null,
   email                varchar2(30)                   null,
   id_card              varchar2(20)                   null,
   birthday             date                           null,
   hobbies              varchar2(255)                  null,
   address              varchar2(50)                   null,
   user_photo           varchar2(50)                   null,
   comment_count        number                         null,
   integral             number                         null,
   req_date             timestamp                      null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_USER primary key clustered (id)
);

alter table user ADD INDEX index_user_code(user_code);
/*==============================================================*/
/* Table: employee                                                */
/*==============================================================*/
create table employee 
(
   id                   number                         auto_increment not null,
   employee_code        varchar2(20)                   null,
   employee_name        varchar2(40)                   null,
   password             varchar2(40)                   null,
   sex                  number(1)                      null,
   mobile               varchar2(20)                   null,
   email                varchar2(30)                   null,
   address              varchar2(50)                   null,
   zip_code             varchar2(10)                   null,
   id_card              varchar2(20)                   null,
   birthday             date                           null,
   employee_photo       varchar2(50)                   null,
   req_date             timestamp                      null,
   status               number(1)                      null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_EMPLOYEE primary key clustered (id)
);

alter table employee ADD INDEX index_employee_code(employee_code);
/*==============================================================*/
/* Table: fun                                                 */
/*==============================================================*/
create table fun 
(
   id                   number                         auto_increment not null,
   fun_code             varchar2(20)                   null,
   fun_name             varchar2(40)                   null,
   fun_type     	    number(1)                      null,
   url_name				varchar2(80)                   null,
   url_param            varchar2(30)                   null,
   url_order            number(1)                      null,
   is_status            number(1)                      null,
   parent_code          varchar2(20)                   null,
   fun_system           number(1)                      null,
   remark               varchar2(100)                  null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_FUN primary key clustered (id)
);

alter table fun ADD INDEX index_fun_code(fun_code);
/*==============================================================*/
/* Table: employee_fun                                    */
/*==============================================================*/
create table employee_fun 
(
   id                   number                         auto_increment not null,
   employee_code        varchar2(20)                   null,
   fun_code             varchar2(20)                   null,
   is_read              number(1)                      null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_EMPLOYEE_FUN primary key clustered (id)
);

alter table employee_fun ADD INDEX index_employee_code(employee_code);
alter table employee_fun ADD INDEX index_fun_code(fun_code);
/*==============================================================*/
/* Table: recently_viewed                                       */
/*==============================================================*/
create table recently_viewed 
(
   id                   number                         auto_increment not null,
   user_code            varchar2(20)                   null,
   commodity_id         number                         null,
   commodity_code       varchar2(20)                   null,
   commodity_name       varchar2(40)                   null,
   price                number(10,2)                   null,
   commodity_photo      text                           null,
   viewed_count         number                         null,
   comment_count        number                         null,
   is_read              number(1)                      null,
   status               number(1)                      null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_RECENTLY_VIEWED primary key clustered (id)
);


alter table recently_viewed ADD INDEX index_user_code(user_code);
alter table recently_viewed ADD INDEX index_commodity_code(commodity_code);
/*==============================================================*/
/* Table: favorites                                       */
/*==============================================================*/
create table favorites 
(
   id                   number                         auto_increment not null,
   user_code            varchar2(20)                   null,
   commodity_id         number                         null,
   commodity_code       varchar2(20)                   null,
   commodity_name       varchar2(40)                   null,
   price                number(10,2)                   null,
   commodity_photo      text                           null,
   viewed_count         number                         null,
   comment_count        number                         null,
   is_read              number(1)                      null,
   status               number                         null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_FAVORITES primary key clustered (id)
);

alter table favorites ADD INDEX index_user_code(user_code);
alter table favorites ADD INDEX index_commodity_code(commodity_code);

/*==============================================================*/
/* Table: shopping_cart                                             */
/*==============================================================*/
create table shopping_cart 
(
   id                   number                         auto_increment not null,
   user_code            varchar2(20)                   null,
   commodity_id         number                         null,
   commodity_code       varchar2(20)                   null,
   commodity_name       varchar2(40)                   null,
   price                number(10,2)                   null,
   commodity_num        number                         null,
   commodity_photo      text                           null,
   viewed_count         number                         null,
   comment_count        number                         null,
   status               number(1)                      null,
   remark               varchar2(100)                  null,
   create_time          timestamp                      null,
   update_time          timestamp                      null,
   yn                   number(1)                      null,
   constraint PK_SHOPPING_CART primary key clustered (id)
);


alter table shopping_cart ADD INDEX index_user_code(user_code);
alter table shopping_cart ADD INDEX index_commodity_code(commodity_code);
