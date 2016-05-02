INSERT INTO t_corp(uid,ccode,cname,cnameen,cnameab,cprincipal,ctaxno,caddr,czip,cfax,ctelgeneral,ctelguard,cemail,cwebsite,cmemo,cprovinces,ccity)
VALUES ('4190f866-5a6d-435c-9cc5-01c85ae6c4ad','NXFBKJ','飞博科技','FBKJ','FB','刘博','41132719890306031201','河南省内乡县城关镇工商局南100米路西','474350'
           ,'037765111168'
           ,'13462592681'
           ,'13462592681'
           ,'595380228@qq.com'
           ,'http://localhost:8080/fb/login.jsp'
           ,'系统公司'
           ,'河南'
           ,'南阳')
INSERT INTO t_dept(uid,ucorpid,ctype,ccode,cname,cparentcode,ilevel,ccodepath)
VALUES('56a52861-b77e-4670-aab4-928abf093d84','4190f866-5a6d-435c-9cc5-01c85ae6c4ad','管理'
           ,'FBGL01'
           ,'管理部'
           ,''
           ,1
           ,'')
INSERT INTO [fb-ss].[dbo].[t_user]
           ([uid]
           ,[udeptid]
           ,[ccode]
           ,[cname]
           ,[cnameen]
           ,[cpassword]
           ,[cduty]
           ,[crank]
           ,[djoindate]
           ,[cidcard]
           ,[csex]
           ,[dbirthday]
           ,[ceducate]
           ,[cofficetel]
           ,[cofficefax]
           ,[cofficeaddr]
           ,[cmobiletel]
           ,[chometel]
           ,[chomeaddr]
           ,[cemail]
           ,[cmsn]
           ,[cqq]
           ,[cmemo])
     VALUES
           ('FFAA5D1B-12C8-416C-8D68-513D4E982754'
           ,'56A52861-B77E-4670-AAB4-928ABF093D84'
           ,'595380228'
           ,'刘博'
           ,'Liu bo'
           ,'e10adc3949ba59abbe56e057f20f883e'
           ,'经理'
           ,'1'
           ,'2013-10-01 00:00:00.000'
           ,'411327198903060312'
           ,'男'
           ,'1989-03-06 00:00:00.000'
           ,'高中'
           ,'13462592681'
           ,'037765111168'
           ,'内乡县飞博电脑中心'
           ,'13462592681'
           ,'13462592681'
           ,'内乡县'
           ,'595380228@qq.com'
           ,'happinessbo@hotmail.com'
           ,'595380228'
           ,'基础账号')

insert into t_role(uid,udeptid,uuserid,ccode,cname) values ('83220890-D1B2-45BB-820F-A9313261415D','56a52861-b77e-4670-aab4-928abf093d84','FFAA5D1B-12C8-416C-8D68-513D4E982754','ADMINISTRATOR','系统管理员')
insert into t_module_group (uid,ccode,cname) values ('5DD35237-1EBB-4433-9282-2F57C55687FB','ADMINISTRATOR','系统管理员')
insert into t_module_group (uid,ccode,cname) values ('6C23A3F1-B108-4F6C-9584-AC936897AD21','REGISTEREDUSERS','注册用户')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'9E384F95-2201-417F-A3E9-42B58C8A83AE','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'6CDF8B41-10CB-42CC-B0AD-4B980DC997DF','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'94C00969-A15E-43AF-965C-520D96D77A02','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'09EC45B0-CF77-44BD-BF6B-5AC94EB4D5B9','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'EA3DB831-9586-449F-9DE7-657E972E35A7','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'55F36CA0-9165-4C5A-9FE0-9DB0EA3E95FB','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'FBB296CF-38B6-4B1D-A7DA-A1A0EF0AE550','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'85A341BE-DBC6-42C2-9CF9-B47D7D2AD77F','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'AF204B6D-3C7C-4E27-A799-C06079CB57B0','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'6453A3AD-9995-4124-A4E7-D371B8937995','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'CC900B43-7C8D-4ECD-9F07-FD069BDBD19C','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'FBB296CF-38B6-4B1D-A7DA-A1A0EF0AE550','6C23A3F1-B108-4F6C-9584-AC936897AD21')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'EA3DB831-9586-449F-9DE7-657E972E35A7','6C23A3F1-B108-4F6C-9584-AC936897AD21')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'6CDF8B41-10CB-42CC-B0AD-4B980DC997DF','6C23A3F1-B108-4F6C-9584-AC936897AD21')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'94C00969-A15E-43AF-965C-520D96D77A02','6C23A3F1-B108-4F6C-9584-AC936897AD21')
insert into t_role_module_group (uid,uroleid,umodulegroupid) values (newid(),'83220890-D1B2-45BB-820F-A9313261415D','5DD35237-1EBB-4433-9282-2F57C55687FB')
/*模块数据*/
--基础资料
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('FBB296CF-38B6-4B1D-A7DA-A1A0EF0AE550','BPR','BASE','基础资料',null,1,0,'|BASE|','')
--基础资料--公司信息
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('EA3DB831-9586-449F-9DE7-657E972E35A7','BPR','COMPANYVIEW','公司信息','BASE',2,0,'|BASE|COMPANYVIEW|','/bpr/company/view')
--基础资料--公司列表
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('AF204B6D-3C7C-4E27-A799-C06079CB57B0','BPR','COMPANYLIST','公司列表','BASE',2,1,'|BASE|COMPANYLIST|','/bpr/company/list')
--基础资料--账户信息
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('6CDF8B41-10CB-42CC-B0AD-4B980DC997DF','BPR','USERVIEW','账户信息','BASE',2,2,'|BASE|USERVIEW|','/bpr/user/view')
--基础资料--修改密码
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('94C00969-A15E-43AF-965C-520D96D77A02','BPR','UPDATEPASSWORD','修改密码','BASE',2,3,'|BASE|UPDATEPASSWORD|','/bpr/user/updatePassword')
--基础资料--账户列表
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('55F36CA0-9165-4C5A-9FE0-9DB0EA3E95FB','BPR','USERLIST','账户列表','BASE',2,4,'|BASE|USERLIST|','/bpr/user/list')


--系统管理
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('85A341BE-DBC6-42C2-9CF9-B47D7D2AD77F','BPR','SYSTEM','系统管理',null,1,1,'|SYSTEM|','')
--系统管理--功能模块
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('9E384F95-2201-417F-A3E9-42B58C8A83AE','BPR','MODULEVIEW','功能模块','SYSTEM',2,0,'|SYSTEM|MODULEVIEW|','/bpr/module/view')
--系统管理--功能模块组
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('09EC45B0-CF77-44BD-BF6B-5AC94EB4D5B9','BPR','MODULEGROUPVIEW','功能模块组','SYSTEM',2,1,'|SYSTEM|MODULEGROUPVIEW|','/bpr/module/groupView')
--系统管理--账户模块组
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('CC900B43-7C8D-4ECD-9F07-FD069BDBD19C','BPR','USERMODULEGROUP','账户模块组','SYSTEM',2,2,'|SYSTEM|USERMODULEGROUP|','/bpr/user/moduleGroup')
--系统管理--日志管理
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('6453A3AD-9995-4124-A4E7-D371B8937995','BPR','LOG','日志管理','SYSTEM',2,3,'|SYSTEM|LOG|','/bpr/log/view')

