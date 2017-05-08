DataStructor
drop database if exists scm;
create database scm default character set utf8;
use scm;
drop table if exists account;
drop table if exists sys_param;
drop table if exists goods;
drop table if exists store_house;
drop table if exists supplier;
/*============================*/
/* Table: 管理员表结构       */
/*============================*/
create table account
(
   /* 管理员编号,自动增长 */
   acc_id                  int not null auto_increment,
   /* 管理员登录名  */
   acc_login               varchar(20),
   /* 管理员姓名  */
   acc_name                varchar(20),
   /* 管理员密码 */
   acc_pass                varchar(20),
   /* 设置编号为主键 */
   primary key (acc_id)
);
/*====================================系统参数表==============================*/
/*==============================================================*/
/* Table: sys_param                                             */
/*==============================================================*/
create table sys_param
(
   sys_param_id         bigint  auto_increment,
   sys_param_field      varchar(50),
   sys_param_value      varchar(50),
   sys_param_text       varchar(50),
   primary key (sys_param_id)
);
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('supType','1','一级供应商');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('supType','2','二级供应商');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('supType','3','普通供应商');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('goodsColor','1','红色');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('goodsColor','2','绿色');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('goodsColor','3','蓝色');
/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
/*
goods_Id         商品编号
   goods_name           商品名称
   goods_unit          商品单位
   goods_type           类型
   goods_color          颜色,
   goods_store          库存下限,
   goods_limit          有效的修改时间,
   goods_commission     提成,
   goods_producer       生产商
   goods_remark         备注,
   goods_sel_price        售价
   goods_buy_price         进价
                                               */
/*==============================================================*/
create table goods
(
   goods_Id             varchar(36) not null,
   goods_name           varchar(20),
   goods_unit           varchar(10),
   goods_type           varchar(10),
   goods_color          varchar(10),
   goods_store          int,
   goods_limit          int,
   goods_commission     decimal(2,2),
   goods_producer       varchar(50),
   goods_remark         varchar(100),
   goods_sel_price      decimal(12,2),
   goods_buy_price      decimal(12,2),
   primary key (goods_Id)
);
/*==============================================================*/
/* Table: store_house                                           */
/*
   sh_id                仓库编号,
   sh_name              仓库名称,
   sh_responsible       责任人,
   sh_phone             联系电话,
   sh_address           联系地址,
   sh_type              仓库类型,
   sh_remark            备注,
*/
/*==============================================================*/
create table store_house
(
   sh_id                varchar(10) not null,
   sh_name              varchar(20),
   sh_responsible       varchar(20),
   sh_phone             varchar(11),
   sh_address           varchar(50),
   sh_type              varchar(10),
   sh_remark            varchar(100),
   primary key (sh_id)
);
/*==============================================================*/
/* Table: supplier                                              */ 
/*==============================================================*/
/*                  
sup_id               编号,
   sup_name             供应商名称,
   sup_linkman          联系人,
   sup_phone            电话,
   sup_address          地址,
   sup_remark           备注,
   sup_pay              期初应付,
   sup_type             类型,
*/
/*==============================================================*/
/*==============================================================*/
create table supplier
(
   sup_id               int not null,
   sup_name             varchar(20),
   sup_linkman          varchar(20),
   sup_phone            varchar(11),
   sup_address          varchar(100),
   sup_remark           varchar(100),
   sup_pay              decimal(12,2),
   sup_type             varchar(10),
   primary key (sup_id)
);
/* 添加帐户数据, */
insert into account (acc_login,acc_pass) values ('admin','admin');
insert into account (acc_login,acc_pass) values ('admin2','admin2');
/* 添加供应商数据, */
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (1,'苹果供应商','小张','12388888887','广州花都','普通供应商',0,1);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (2,'三星供应商','小王','12388888888','广州增城','普通供应商',0,1);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (3,'华为供应商','小王','12388888889','广东深圳','一级供应商',0,2);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (4,'TCL供应商','小王','12388888666','广州增城','普通供应商',0,1);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (5,'Nokia供应商','小王','12388888777','广东深圳','一级供应商',0,2);
/*添加商品信息*/
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('1','note4','部','1','red note4',2500.00,2000.00);
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('2','note5','部','5','red note5',3500.00,3000.00);
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('3','note6','部','6','blue note5',4500.00,4000.00);
/*添加仓库信息*/
insert into store_house (sh_id,sh_name,sh_address) values('1','主仓库','广州');
insert into store_house (sh_id,sh_name,sh_address) values('2','分仓库','广州');
