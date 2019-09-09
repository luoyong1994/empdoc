create TABLE componentType(
	id int primary key auto_increment,
	name varchar(100) NOT NULL
)ENGINE=INNODB  DEFAULT CHARSET=utf8;


create TABLE component(
	id int primary key auto_increment,
	name varchar(50) NOT NULL,
	type int NOT null comment '类别',
  componentid varchar(50) not null ,
	introduce varchar(200) comment '功能简介',
	impl varchar(100) comment '实现类',
	basicUse varchar(200) comment '基本用法',
	inputParams varchar(400),
	outputParams varchar (400),
	result varchar(20),
	notices varchar(200),
	version int comment '版本号',
	submittime varchar(20) comment '提交时间'
)ENGINE=INNODB  DEFAULT CHARSET=utf8;

