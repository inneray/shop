﻿/*删除商城数据库,如果存在*/
drop database if exists shop;
/*创建数据库,并设置编码*/
create database shop default character set utf8;

use shop;
/*删除管理员表*/
drop table if exists account;
/*删除商品类别表*/
drop table if exists category;
/*删除商品信息表*/
drop table if exists product;

/*============================*/
/* Table: 管理员表结构 		  */
/*============================*/
create table account
(
   /* 管理员编号,自动增长 */
   id                  int not null auto_increment,
   /* 管理员登录名  */
   login               varchar(20),
   /* 管理员姓名  */
   name                varchar(20),
   /* 管理员密码 */
   pass                varchar(20),
   /* 设置编号为主键 */
   primary key (id)
);

/*=============================*/
/* Table: 商品类别表结构 		   */
/*=============================*/
create table category
(
   /* 类别编号,自动增长 */
   id                  int not null auto_increment,
   /* 类别名称 */
   type                varchar(20),
   /* 类别是否为热点类别,热点类别才有可能显示在首页 */
   hot                 bool default false,
   /* 外键,此类别由哪位管理员管理 */
   aid                  int,
   /* 设置类别编号为主键 */
   primary key (id)
);

/*=============================*/
/* Table: 商品表结构	 		   */
/*=============================*/
create table product
(
   /* 商品编号,自动增长 */
   id                  int not null auto_increment,
   /* 商品名称 */
   name                varchar(20),
   /* 商品价格 */
   price               decimal(8,2),
   /* 商品图片 */
   pic                 varchar(200),
   /* 商品简单介绍 */
   remark              longtext,
   /* 商品详细介绍 */
   xremark             longtext,
   /* 商品生产日期 */
   date                timestamp default CURRENT_TIMESTAMP,
   /* 是否为推荐商品,推荐商品才有可能显示在商城首页 */
   commend             bool,
   /* 是否为有效商品,有效商品才有可能显示在商城首页 */
   open                bool,
   /* 商品所在的类别编号*/
   cid                  int,
   /* 设置商品编号为主键 */
   primary key (id)
);

/*============================*/
/* Table: 用户表结构 		  */
/*============================*/
create table user
(
   /* 用户编号,自动增长 */
   id                  int not null auto_increment,
   /* 用户登录名 */
   login               varchar(20),
   /* 用户真实姓名 */
   name                varchar(20),
   /* 用户登录密码 */
   pass                varchar(20),
   /* 用户性别 */
   sex                 varchar(20),
   /* 用户电话 */
   phone               varchar(20),
   /* 用户Email */
   email               varchar(20),
   /* 设置用户编号为主键 */
   primary key (id)
);

/*=============================*/
/* Table: 订单状态表结构 		   */
/*=============================*/
create table status
(
   /* 状态编号,自动增长 */
   id                  int not null auto_increment,
   /* 订单状态 */
   status               varchar(10),
   /* 设置订单编号为主键 */
   primary key (id)
);
/*=============================*/
/* Table: 订单表结构	 		   */
/*=============================*/
create table forder
(
   /* 订单编号,自动增长 */
   id                  int not null auto_increment,
   /* 收件人名字 */
   name                varchar(20),
   /* 收件人电话 */
   phone               varchar(20),
   /* 配送信息 */
   remark              varchar(20),
   /* 下单日期 */
   date                timestamp default CURRENT_TIMESTAMP,
   /* 订单总金额 */
   total               decimal(8,2),
   /* 收件人邮编 */
   post                varchar(20),
    /* 收件人地址 */
   address             varchar(200),
   /* 订单状态 */
   sid                 int default 1,
   /* 会员编号 */
   uid                 int,
   /* 设置订单编号为主键 */
   primary key (id)
);
/* 修改自动增长的初始值 */
ALTER TABLE forder AUTO_INCREMENT = 2093021801;

/*=============================*/
/* Table: 购物项表结构 		   */
/*=============================*/

create table sorder
(
   /* 购物项编号,自动增长 */
   id                  int not null auto_increment,
   /* 被购买商品的名称 */
   name                varchar(20),
   /* 购买时商品的价格 */
   price               decimal(8,2),
   /* 购买的数量 */
   number              int not null,
   /* 所属商品编号 */
   pid                  int,
   /* 此订单项,所属的订单编号 */
   fid                  int,
   /* 设置购物项编号为主键 */
   primary key (id)
);


/*插入测试用例*/
INSERT INTO account(login,name,pass) values ('admin','管理员','admin');
INSERT INTO account(login,name,pass) values ('user','客服A','user');

INSERT INTO category (type,hot,aid) VALUES ('男士休闲',true,1);
INSERT INTO category (type,hot,aid) VALUES ('女士休闲',true,1);
INSERT INTO category (type,hot,aid) VALUES ('儿童休闲',true,2);
INSERT INTO category (type,hot,aid) VALUES ('老人休闲',false,2);


/* 商品测试用例 */
INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('圣得西服',2999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('罗蒙西服',1999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('衫衫西服',3999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('金利来西服',4999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('韩版女装',199.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('雪地靴',299.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('欧版女装',3999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('女款手套',4999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('佳能单反机',3998.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('金士顿优盘',299.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('日立硬盘',599.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('大水牛机箱',399.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('电脑桌',150.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('老板椅',199.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('空调',3599.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('电视',699.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

/* 用户测试用例 */
INSERT INTO user (login,name,pass,sex,phone,email)
VALUES ('user','小刚','user','男','13812345678','10000@qq.com');

INSERT INTO user (login,name,pass,sex,phone,email)
VALUES ('user2','小琴','user2','女','13812345679','20000@qq.com');

/*插入状态测试用例*/
INSERT INTO status (status) VALUES ('未支付');
INSERT INTO status (status) VALUES ('已支付');
INSERT INTO status (status) VALUES ('配送中');
INSERT INTO status (status) VALUES ('订单完成');

/*插入购物车测试用例*/
INSERT INTO forder (name,phone,remark,date,total,address,post,uid) VALUES ('bb','123','备注',default,200.3,'广州天河区','1000',1);

/*插入购物车项测试用例*/
INSERT INTO sorder (name,price,number,gid,fid) VALUES ('空调',200,1,15,2013021801);
INSERT INTO sorder (name,price,number,gid,fid) VALUES ('电视',0.3,1,16,2013021801);


SELECT * FROM account;
SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM user;
SELECT * FROM status;
SELECT * FROM forder;
SELECT * FROM sorder;
