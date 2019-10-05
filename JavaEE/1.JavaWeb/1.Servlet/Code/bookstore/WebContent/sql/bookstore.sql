CREATE DATABASE IF NOT EXISTS bookstore DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use bookstore;

/*用户表*/
CREATE TABLE IF NOT EXISTS tb_user(
	uid CHAR(32) PRIMARY KEY,/*主键*/
	username VARCHAR(50) NOT NULL UNIQUE,/*用户名*/
	`password` VARCHAR(50) NOT NULL,/*密码*/
	email VARCHAR(50) NOT NULL UNIQUE,/*邮箱*/
	code CHAR(64) NOT NULL UNIQUE,/*激活码*/
	state BOOLEAN,/*用户状态，是否激活*/
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,/*创建时间*/
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP/*更新时间*/
);

insert into tb_user(uid,username,`password`,email,code,state) values('weqeqwe23wqe1231','admin','123','admin@123.com','yutsad1231','1');

/*图书分类表*/
CREATE TABLE IF NOT EXISTS category(
	cid INT PRIMARY KEY AUTO_INCREMENT,/*主键*/
	cname VARCHAR(100) NOT NULL,/*分类名称*/
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,/*创建时间*/
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP/*更新时间*/
);

insert into category(cname) values('java');
insert into category(cname) values('javascript');
insert into category(cname) values('php');

/*图书表*/
CREATE TABLE IF NOT EXISTS book(
	bid CHAR(32) PRIMARY KEY,/*主键*/
	bname VARCHAR(100),/*图书名*/
	price DECIMAL(5,1),/*单价*/
	author VARCHAR(30),/*作者*/
	image VARCHAR(200),/*图片*/
	cid INT,/*所属分类*/
	del INT DEFAULT 0,/*是否被删除，删除为1，否则为0*/
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,/*创建时间*/
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,/*更新时间*/
	FOREIGN KEY (cid) REFERENCES category(cid)/*主外键约束*/
);

/*订单表*/
CREATE TABLE IF NOT EXISTS orders(
	oid CHAR(32) PRIMARY KEY,/*主键*/
	total DECIMAL(10,0),/*订单合计*/
	state SMALLINT(1),/*订单状态*/
	uid CHAR(32),/*订单所有者*/
	address VARCHAR(200),/*订单收货地址*/
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,/*创建时间*/
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,/*更新时间*/
	FOREIGN KEY (uid) REFERENCES tb_user (uid)/*建立主外键关系*/
);

/*订单项目表*/
CREATE TABLE IF NOT EXISTS orderitem(
	iid CHAR(32) PRIMARY KEY,/*主键*/
	`count` INT,/*数量*/
	subtotal DECIMAL(10,0),/*小计*/
	oid CHAR(32),/*所属订单*/
	bid CHAR(32),/*订单所指的商品*/
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,/*创建时间*/
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,/*更新时间*/
	FOREIGN KEY (oid) REFERENCES orders (oid),/*与订单表建立主外键关系*/
	FOREIGN KEY (bid) REFERENCES book (bid)/*与图书建立主外键关系表*/
);

/*购物车表*/
CREATE TABLE IF NOT EXISTS cart(
	cid CHAR(32) PRIMARY KEY,/*主键*/
	uid CHAR(32),/*所属用户*/
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,/*创建时间*/
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,/*更新时间*/
	FOREIGN KEY (uid) REFERENCES tb_user (uid)/*与用户表建立外键关系*/
);

/*购物车项目表*/
CREATE TABLE IF NOT EXISTS cartitem(
	iid CHAR(32) PRIMARY KEY,/*主键*/
	`count` INT,/*数量*/
	bid CHAR(32),/*书籍*/
	cid CHAR(32),/*所属购物车*/
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,/*创建时间*/
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,/*更新时间*/
	FOREIGN KEY (bid) REFERENCES book (bid),/*与图书建立外键关系*/
	FOREIGN KEY (cid) REFERENCES cart (cid)/*与购物车表建立外键关系*/
);

