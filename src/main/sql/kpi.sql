create table teacher (
teacherID bigint(20) not null auto_increment comment '教师ID', 
name varchar(10) not null comment '教师名称',
primary key(teacherID)
)engine=InnoDB auto_increment=1000 default charset=utf8 comment='教师表';

create table class (
classID bigint(20) not null auto_increment comment '课程ID',
teacherID bigint(20) not null comment'授课教师ID',
name varchar(100) not null comment '课程名称',
theoryduration int(20) not null comment '理论课时',
experimentduration int(20) not null comment '实验课时',
computerduration int(20) not null comment '上机课时',
studentnumber int(20) not null comment '学生人数',
adjustmentnumber int(20) not null comment '调课次数',
isEnglish tinyint(1) default 0 comment '全英文授课',
primary key(classID),
foreign key(teacherID) references teacher(teacherID)
)engine=InnoDB auto_increment=1000 default charset=utf8 comment='课程表';

create table project (
projectID bigint(20) not null auto_increment comment '项目ID', 
teacherID bigint(20) not null comment '项目负责教师ID',
name varchar(100) not null comment '项目名称',
start date not null comment '项目开始时间',
end date not null comment '项目结束时间',
types varchar(100) not null comment '项目类型',
funding bigint(20) not null comment '项目经费',
primary key(projectID),
foreign key(teacherID) references teacher(teacherID)
)engine=InnoDB auto_increment=1000 default charset=utf8 comment='项目表';
create table student (
studentID bigint(20) not null auto_increment comment '学生ID', 
teacherID bigint(20) not null comment '教师ID',
name varchar(100) not null comment '学生姓名',
type varchar(100) not null comment '学生类型',
task varchar(100) not null comment '研究课题',
primary key(studentID),
foreign key(teacherID) references teacher(teacherID)
)engine=InnoDB auto_increment=1000 default charset=utf8 comment='学生表';
create table paper (
paperID bigint(20) not null auto_increment comment '论文ID', 
teacherID bigint(20) not null ,
name varchar(100) not null ,
book varchar(100) not null ,
number varchar(100) not null ,
page varchar(100) not null ,
time date not null ,
type varchar(100) not null ,
level varchar(100) not null ,
primary key(paperID),
foreign key(teacherID) references teacher(teacherID)
)engine=InnoDB auto_increment=1000 default charset=utf8 comment='论文表';
create table patent (
paperID bigint(20) not null auto_increment comment '专利ID', 
teacherID bigint(20) not null ,
name varchar(100) not null ,
state varchar(100) not null ,
time date not null ,
isInter tinyint(1) default 0 comment '是否国际专利',
primary key(paperID),
foreign key(teacherID) references teacher(teacherID)
)engine=InnoDB auto_increment=1000 default charset=utf8 comment='论文表';
create table funding(
fundingID bigint(20) not null auto_increment comment '经费ID', 
teacherID bigint(20) not null ,
type varchar(100) not null ,
number int(16) not null,
primary key(fundingID),
foreign key(teacherID) references teacher(teacherID)
)engine=InnoDB auto_increment=1000 default charset=utf8 comment='论文表';
create table other(
otherID bigint(20) not null auto_increment, 
teacherID bigint(20) not null ,
message varchar(100) not null ,
kpi float(32) not null,
primary key(otherID),
foreign key(teacherID) references teacher(teacherID)
)engine=InnoDB auto_increment=1000 default charset=utf8 ;
