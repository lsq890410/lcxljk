create table lc_sso_session(
	id int primary key auto_increment,
	skey varchar(100),
	createtime char(19),
	lastvisittime char(19),
	sessionkey varchar(100),
	appsession varchar(50),
	openid varchar(100),
	ts char(19),
	dr smallint
);

create table lc_sm_user(
	userid char (32) primary key,
	createtime char(19),
	appsession varchar(50),
	usercode varchar(50),
	ts char(19),
	dr smallint
);

create table lc_pub_billno(
	id int primary key auto_increment,
	createtime char(19),
	codetype varchar(10),
	ts char(19),
	dr smallint
);
 
create table lc_pub_smscheckcode(
	smscheckid varchar(50),
	telno varchar(20),
	smscheckcode char(4),
	createtime char(19),
	disabletime char(19)
)
