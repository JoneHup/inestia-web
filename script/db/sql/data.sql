INSERT INTO `sys_user` (`id`,`organization_id`,`username`,`password`,`salt`,`role_ids`,`group_ids`,`locked`) VALUES (1,1,'admin','d3c59d25033dbf980d29554025c23a75','8d78869f470951332959580424d4bf4f','1','1',0);
INSERT INTO `sys_role` (`id`,`role`,`description`,`resource_ids`,`available`) VALUES (1,'admin','超级管理员','11,21,31,41,46,69,70',0);


INSERT INTO `sys_organization` (`id`,`name`,`parent_id`,`parent_ids`,`available`,`priority`,`leaf`) VALUES (1,'用友',0,'0/',1,0,0);
INSERT INTO `sys_organization` (`id`,`name`,`parent_id`,`parent_ids`,`available`,`priority`,`leaf`) VALUES (2,'财务事业部',1,'0/1/',1,1,0);

INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (1,'资源','MENU','#',0,'0/','',1,'',0,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (11,'组织机构管理','MENU','#',1,'0/1/','organization:*',1,'fa fa-sitemap',3,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (12,'组织机构新增','BUTTON','',11,'0/1/11/','organization:create',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (13,'组织机构修改','BUTTON','',11,'0/1/11/','organization:update',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (14,'组织机构删除','BUTTON','',11,'0/1/11/','organization:delete',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (15,'组织机构查看','BUTTON','',11,'0/1/11/','organization:view',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (21,'用户管理','MENU','#',1,'0/1/','',1,'fa fa-user',1,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (22,'用户新增','BUTTON','',46,'0/1/21/','user:create',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (23,'用户修改','BUTTON','',46,'0/1/21/','user:update',1,'',NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (24,'用户删除','BUTTON','',46,'0/1/21/','user:delete',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (25,'用户查看','BUTTON','',46,'0/1/21/','user:view',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (31,'资源管理','MENU','#',1,'0/1/','resource:*',1,'fa fa-desktop',2,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (32,'资源新增','BUTTON','',31,'0/1/31/','resource:create',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (33,'资源修改','BUTTON','',31,'0/1/31/','resource:update',1,'',NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (34,'资源删除','BUTTON','',31,'0/1/31/','resource:delete',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (35,'资源查看','BUTTON','',31,'0/1/31/','resource:view',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (41,'角色管理','MENU','#role',21,'0/1/','role:*',1,'fa fa-child',2,1);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (42,'角色新增','BUTTON','',41,'0/1/41/','role:create',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (43,'角色修改','BUTTON','',41,'0/1/41/','role:update',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (44,'角色删除','BUTTON','',41,'0/1/41/','role:delete',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (45,'角色查看','BUTTON','',41,'0/1/41/','role:view',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (46,'系统用户','MENU','#user',21,'0/1/11/','user:*',1,'fa fa-wrench',1,1);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (47,'组织机构','MENU','#organization',11,'0/1/11/','organization:*',1,'fa fa-suitcase',NULL,1);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (50,'资源管理','MENU','#resource',31,'0/1/','resource:*',1,'fa fa-cubes',NULL,1);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (69,'系统管理','MENU','#',1,'0/1/','',1,'fa fa-wrench',4,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (70,'发新闻','MENU','#news',69,'0/1/69/','news:*',1,'fa fa-history',NULL,1);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (71,'新闻新增','BUTTON','',70,'0/1/70/','news:create',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (72,'新闻修改','BUTTON','',70,'0/1/70/','news:update',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (73,'新闻删除','BUTTON','',70,'0/1/70/','news:delete',1,NULL,NULL,0);
INSERT INTO `sys_resource` (`id`,`name`,`type`,`url`,`parent_id`,`parent_ids`,`permission`,`available`,`icon`,`priority`,`leaf`) VALUES (74,'新闻查看','BUTTON','',70,'0/1/70/','news:view',1,NULL,NULL,0);


INSERT INTO `sys_product`(`id`, `root_name`, `parent_name`, `node_name`, `url`, `dr`) VALUES (1, '横琴先进智能计算平台的产品', '产品1', NULL, NULL, 0);
INSERT INTO `sys_product`(`id`, `root_name`, `parent_name`, `node_name`, `url`, `dr`) VALUES (2, '横琴先进智能计算平台的产品', '产品2', NULL, NULL, 0);
INSERT INTO `sys_product`(`id`, `root_name`, `parent_name`, `node_name`, `url`, `dr`) VALUES (3, '寒武纪的部分产品及技术', '系列1', '产品1', NULL, 0);
INSERT INTO `sys_product`(`id`, `root_name`, `parent_name`, `node_name`, `url`, `dr`) VALUES (4, '寒武纪的部分产品及技术', '系列1', '产品2', NULL, 0);
INSERT INTO `sys_product`(`id`, `root_name`, `parent_name`, `node_name`, `url`, `dr`) VALUES (5, '寒武纪的部分产品及技术', '系列2', '产品1', NULL, 0);
INSERT INTO `sys_product`(`id`, `root_name`, `parent_name`, `node_name`, `url`, `dr`) VALUES (6, '寒武纪的部分产品及技术', '系列2', '产品2', NULL, 0);
INSERT INTO `sys_product`(`id`, `root_name`, `parent_name`, `node_name`, `url`, `dr`) VALUES (7, '产品的各项实际应用', '智慧城市', '城市实时仿真', NULL, 0);
INSERT INTO `sys_product`(`id`, `root_name`, `parent_name`, `node_name`, `url`, `dr`) VALUES (8, '产品的各项实际应用', '智慧城市', '智能交通系统', NULL, 0);
INSERT INTO `sys_product`(`id`, `root_name`, `parent_name`, `node_name`, `url`, `dr`) VALUES (9, '产品的各项实际应用', '智慧产业', '智能教育', NULL, 0);
INSERT INTO `sys_product`(`id`, `root_name`, `parent_name`, `node_name`, `url`, `dr`) VALUES (10, '产品的各项实际应用', '智慧产业', '智能物流', NULL, 0);
INSERT INTO `sys_product`(`id`, `root_name`, `parent_name`, `node_name`, `url`, `dr`) VALUES (11, '产品的各项实际应用', '智慧产业', '智能医疗', NULL, 0);
INSERT INTO `sys_product`(`id`, `root_name`, `parent_name`, `node_name`, `url`, `dr`) VALUES (12, '产品的各项实际应用', '智慧产业', '智能医疗', NULL, 0);
