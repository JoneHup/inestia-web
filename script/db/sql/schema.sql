drop table if exists sys_user;
drop table if exists sys_organization;
drop table if exists sys_resource;
drop table if exists sys_role;
drop table if exists sys_group;
drop table if exists sys_log;
drop table if exists sys_news;

create table sys_user (
  id bigint auto_increment COMMENT '编号',
  organization_id bigint COMMENT '组织机构编号',
  username varchar(100) COMMENT '用户名',
  password varchar(100) COMMENT '密码',
  salt varchar(100) COMMENT '盐值',
  role_ids varchar(100) COMMENT '角色列表',
  group_ids varchar(100) COMMENT '组列表',
  locked bool default false COMMENT '是否锁定',
  constraint pk_sys_user primary key(id)
) charset=utf8 ENGINE=InnoDB COMMENT '用户表';
create unique index idx_sys_user_username on sys_user(username);
create index idx_sys_user_organization_id on sys_user(organization_id);

create table sys_organization (
  id bigint auto_increment COMMENT '编号',
  name varchar(100) COMMENT '组织名称',
  parent_id bigint COMMENT '父编号',
  parent_ids varchar(100) COMMENT '父编号列表',
  available bool default false  COMMENT '是否有效',
  priority int(11) COMMENT '优先级',
  leaf bool default false COMMENT '叶子节点',
  constraint pk_sys_organization primary key(id)
) charset=utf8 ENGINE=InnoDB  COMMENT '组织机构表';
create index idx_sys_organization_parent_id on sys_organization(parent_id);
create index idx_sys_organization_parent_ids on sys_organization(parent_ids);

create table sys_resource (
  id bigint auto_increment COMMENT '编号',
  name varchar(100) COMMENT '名称',
  type varchar(50) COMMENT '资源类型',
  url varchar(200) COMMENT '链接地址',
  parent_id bigint COMMENT '父编号',
  parent_ids varchar(100) COMMENT '父编号列表',
  permission varchar(100) COMMENT '权限字符串',
  available bool default false COMMENT '是否有效',
  icon varchar(100) COMMENT '图标',
  priority int(11) COMMENT '优先级',
  leaf bool default false COMMENT '叶子节点',
  constraint pk_sys_resource primary key(id)
) charset=utf8 ENGINE=InnoDB COMMENT '资源表';
create index idx_sys_resource_parent_id on sys_resource(parent_id);
create index idx_sys_resource_parent_ids on sys_resource(parent_ids);

create table sys_role (
  id bigint auto_increment COMMENT '编号',
  role varchar(100) COMMENT '角色名',
  description varchar(100) COMMENT '描述',
  resource_ids varchar(100) COMMENT '资源编号列表',
  available bool default false COMMENT '是否有效',
  constraint pk_sys_role primary key(id)
) charset=utf8 ENGINE=InnoDB COMMENT='角色表';
create index idx_sys_role_resource_ids on sys_role(resource_ids);

CREATE TABLE sys_group (
  id bigint AUTO_INCREMENT COMMENT '编号',
  name varchar(100) COMMENT '组名称',
  type varchar(50) COMMENT '组类型',
  description varchar(100) COMMENT '描述',
  constraint pk_sys_group PRIMARY KEY (id)
  ) CHARSET=utf8 ENGINE=InnoDB COMMENT='用户组表';

CREATE TABLE sys_log (
  id bigint AUTO_INCREMENT COMMENT '主键',
  username varchar(100) COMMENT '用户名',
  ip varchar(45) COMMENT '用户ip',
  req_method varchar(200) COMMENT '请求方法',
  req_uri text COMMENT '请求URL',
  exec_method varchar(200) COMMENT '执行方法',
  exec_time bigint(20) COMMENT '响应时间',
  args text COMMENT '参数',
  return_val text COMMENT '返回值',
  exec_desc varchar(200) COMMENT '描述',
  status varchar(45) COMMENT '状态',
  create_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  constraint pk_sys_log PRIMARY KEY (id)
)  CHARSET=utf8 ENGINE=InnoDB COMMENT='系统日志表';

CREATE TABLE sys_news (
  id bigint AUTO_INCREMENT COMMENT '主键',
  title varchar(1000) COMMENT '标题',
  create_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  modify_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  creator bigint COMMENT '创建人',
  source varchar(100) COMMENT '来源',
  content longtext COMMENT '内容',
  dr bool default false COMMENT '是否删除',
  constraint pk_sys_news PRIMARY KEY (id)
)  CHARSET=utf8 ENGINE=InnoDB COMMENT='系统新闻表';
create index sys_news_title_index on sys_news(title);

CREATE TABLE sys_product (
  id bigint AUTO_INCREMENT COMMENT '主键',
  root_name varchar(1000) COMMENT '根名称',
  parent_name varchar(1000) COMMENT '父节点名称',
  node_name varchar(1000) COMMENT '节点名称',
  url varchar(100) COMMENT '访问地址',
  dr bool default false COMMENT '是否删除',
  constraint pk_sys_product PRIMARY KEY (id)
)  CHARSET=utf8 ENGINE=InnoDB COMMENT='系统产品表';

CREATE TABLE sys_news_content (
  id bigint AUTO_INCREMENT COMMENT '主键',
  content longtext COMMENT '内容',
  constraint pk_sys_news PRIMARY KEY (id)
)  CHARSET=utf8 ENGINE=InnoDB COMMENT='新闻内容表';