INSERT INTO t_corp(uid,ccode,cname,cnameen,cnameab,cprincipal,ctaxno,caddr,czip,cfax,ctelgeneral,ctelguard,cemail,cwebsite,cmemo,cprovinces,ccity)
VALUES ('4190f866-5a6d-435c-9cc5-01c85ae6c4ad','NXFBKJ','\u98de\u535a\u79d1\u6280','FBKJ','FB','\u5218\u535a','41132719890306031201','\u6cb3\u5357\u7701\u5185\u4e61\u53bf\u57ce\u5173\u9547\u5de5\u5546\u5c40\u5357100\u7c73\u8def\u897f','474350'
           ,'037765111168'
           ,'13462592681'
           ,'13462592681'
           ,'595380228@qq.com'
           ,'http://localhost:8080/fb/login.jsp'
           ,'\u7cfb\u7edf\u516c\u53f8'
           ,'\u6cb3\u5357'
           ,'\u5357\u9633')
INSERT INTO t_dept(uid,ucorpid,ctype,ccode,cname,cparentcode,ilevel,ccodepath)
VALUES('56a52861-b77e-4670-aab4-928abf093d84','4190f866-5a6d-435c-9cc5-01c85ae6c4ad','\u7ba1\u7406'
           ,'FBGL01'
           ,'\u7ba1\u7406\u90e8'
           ,''
           ,1
           ,'')
--202cb962ac59075b964b07152d234b70\u9ed8\u8ba4\u5bc6\u7801123
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
           ,'\u5218\u535a'
           ,'Liu bo'
           ,'202cb962ac59075b964b07152d234b70'
           ,'\u7ecf\u7406'
           ,'1'
           ,'2013-10-01 00:00:00.000'
           ,'411327198903060312'
           ,'\u7537'
           ,'1989-03-06 00:00:00.000'
           ,'\u9ad8\u4e2d'
           ,'13462592681'
           ,'037765111168'
           ,'\u5185\u4e61\u53bf\u98de\u535a\u7535\u8111\u4e2d\u5fc3'
           ,'13462592681'
           ,'13462592681'
           ,'\u5185\u4e61\u53bf'
           ,'595380228@qq.com'
           ,'happinessbo@hotmail.com'
           ,'595380228'
           ,'\u57fa\u7840\u8d26\u53f7')

insert into t_role(uid,udeptid,uuserid,ccode,cname) values ('83220890-D1B2-45BB-820F-A9313261415D','56a52861-b77e-4670-aab4-928abf093d84','FFAA5D1B-12C8-416C-8D68-513D4E982754','ADMINISTRATOR','\u7cfb\u7edf\u7ba1\u7406\u5458')

insert into t_module_group (uid,ccode,cname) values ('5DD35237-1EBB-4433-9282-2F57C55687FB','ADMINISTRATOR','\u7cfb\u7edf\u7ba1\u7406\u5458')
insert into t_module_group (uid,ccode,cname) values ('6C23A3F1-B108-4F6C-9584-AC936897AD21','REGISTEREDUSERS','\u6ce8\u518c\u7528\u6237')

insert into t_role_module_group (uid,uroleid,umodulegroupid) values (newid(),'83220890-D1B2-45BB-820F-A9313261415D','5DD35237-1EBB-4433-9282-2F57C55687FB')

insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('FBB296CF-38B6-4B1D-A7DA-A1A0EF0AE550','BPR','SYSTEMMANAGEMENT','\u7cfb\u7edf\u7ba1\u7406',null,1,10,'|SYSTEMMANAGEMENT|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('EA3DB831-9586-449F-9DE7-657E972E35A7','BPR','SYSTEMMODULE','\u529f\u80fd\u6a21\u5757','SYSTEMMANAGEMENT',2,11,'|SYSTEMMANAGEMENT|SYSTEMMODULE|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('AF204B6D-3C7C-4E27-A799-C06079CB57B0','BPR','SYSTEMMODULEGROUP','\u529f\u80fd\u6a21\u5757\u7ec4','SYSTEMMANAGEMENT',2,12,'|SYSTEMMANAGEMENT|SYSTEMMODULEGROUP|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('6CDF8B41-10CB-42CC-B0AD-4B980DC997DF','BPR','SYSTEMUSER','\u8d26\u6237\u5217\u8868','SYSTEMMANAGEMENT',2,13,'|SYSTEMMANAGEMENT|SYSTEMUSER|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('94C00969-A15E-43AF-965C-520D96D77A02','BPR','SYSTEMROLE','\u89d2\u8272\u5217\u8868','SYSTEMMANAGEMENT',2,14,'|SYSTEMMANAGEMENT|SYSTEMROLE|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('55F36CA0-9165-4C5A-9FE0-9DB0EA3E95FB','BPR','SYSTEMLOG','\u65e5\u5fd7\u7ba1\u7406','SYSTEMMANAGEMENT',2,15,'|SYSTEMMANAGEMENT|SYSTEMLOG|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('85A341BE-DBC6-42C2-9CF9-B47D7D2AD77F','BPR','LOVELYSTORES','\u53ef\u7231\u96ea\u95e8\u5e97',null,1,20,'|LOVELYSTORES|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('9E384F95-2201-417F-A3E9-42B58C8A83AE','BPR','LOVELYSTORESCATEGORY','\u53ef\u7231\u96ea-\u7c7b\u522b','LOVELYSTORES',2,21,'|LOVELYSTORES|LOVELYSTORESCATEGORY|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('09EC45B0-CF77-44BD-BF6B-5AC94EB4D5B9','BPR','LOVELYSTORESMATERAIL','\u53ef\u7231\u96ea-\u7269\u6599','LOVELYSTORES',2,22,'|LOVELYSTORES|LOVELYSTORESMATERAIL|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('CC900B43-7C8D-4ECD-9F07-FD069BDBD19C','BPR','LOVELYSTORESPRODUCT','\u53ef\u7231\u96ea-\u4ea7\u54c1','LOVELYSTORES',2,23,'|LOVELYSTORES|LOVELYSTORESPRODUCT|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('6453A3AD-9995-4124-A4E7-D371B8937995','BPR','LOVELYSTORESPROCUREMENT','\u53ef\u7231\u96ea-\u7269\u6599\u5165\u5e93','LOVELYSTORES',2,24,'|LOVELYSTORES|LOVELYSTORESPROCUREMENT|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('5724F4B4-1E9F-47EE-B50C-10E97EF0D231','BPR','LOVELYSTORESPRODUCTSELL','\u53ef\u7231\u96ea-\u4ea7\u54c1\u9500\u552e','LOVELYSTORES',2,25,'|LOVELYSTORES|LOVELYSTORESPRODUCTSELL|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('65773438-F5E1-488E-A0A4-13174C9BAFF8','BPR','LOVELYSTORESMATERIALINVENTORY','\u53ef\u7231\u96ea-\u7269\u6599\u5e93\u5b58','LOVELYSTORES',2,26,'|LOVELYSTORES|LOVELYSTORESMATERIALINVENTORY|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('0565693D-74FB-48D3-8DD1-1FA3369AB3DE','BPR','LOVELYSTORESEXCEL','\u53ef\u7231\u96ea-\u4e0a\u4f20\u5546\u54c1\u9500\u552e\u62a5\u8868','LOVELYSTORES',2,27,'|LOVELYSTORES|LOVELYSTORESEXCEL|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('50D8DC7E-1F1D-4141-BF49-28C6B9AC17D3','BPR','LOVELYACCOUNTINGD','\u53ef\u7231\u96ea\u8d26\u52a1',null,1,30,'|LOVELYACCOUNTINGD|','')

insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('773CF61B-84E7-40AF-AC1E-2AA0E2DCC794','BPR','LOVELYSTORESACCOUNT','\u53ef\u7231\u96ea-\u73b0\u91d1\u8d26\u6237','LOVELYACCOUNTINGD',2,31,'|LOVELYACCOUNTINGD|LOVELYSTORESACCOUNT|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('655FC50C-51F1-4A88-93C5-2BE9A9F57637','BPR','LOVELYSTORESTYPE','\u53ef\u7231\u96ea-\u8d26\u52a1\u7c7b\u578b','LOVELYACCOUNTINGD',2,32,'|LOVELYACCOUNTINGD|LOVELYSTORESTYPE|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('8EEB9C92-C91D-43B0-AFD7-371E1F6A4567','BPR','LOVELYSTORESDISBURSEMENT','\u53ef\u7231\u96ea-\u652f\u51fa\u5355','LOVELYACCOUNTINGD',2,33,'|LOVELYACCOUNTINGD|LOVELYSTORESDISBURSEMENT|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('91C79376-F679-42EC-8EB6-3A16AF247B57','BPR','LOVELYSTORESINCOME','\u53ef\u7231\u96ea-\u6536\u5165\u5355','LOVELYACCOUNTINGD',2,34,'|LOVELYACCOUNTINGD|LOVELYSTORESINCOME|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('FA786BF9-926F-4ADD-A024-4F2FD6A43ACA','BPR','LOVELYSTORESINVESTMENT','\u53ef\u7231\u96ea-\u6295\u8d44\u5355','LOVELYACCOUNTINGD',2,35,'|LOVELYACCOUNTINGD|LOVELYSTORESINVESTMENT|','')
insert into t_module(uid,ctype,ccode,cname,cparent,ilevel,isort,ccodepath,caddr) values ('D452567B-0FC2-4382-84C2-561571B7951F','BPR','LOVELYREPORT','\u53ef\u7231\u96ea\u62a5\u8868',null,1,40,'|LOVELYREPORT|','')

insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'FBB296CF-38B6-4B1D-A7DA-A1A0EF0AE550','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'EA3DB831-9586-449F-9DE7-657E972E35A7','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'AF204B6D-3C7C-4E27-A799-C06079CB57B0','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'6CDF8B41-10CB-42CC-B0AD-4B980DC997DF','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'94C00969-A15E-43AF-965C-520D96D77A02','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'55F36CA0-9165-4C5A-9FE0-9DB0EA3E95FB','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'85A341BE-DBC6-42C2-9CF9-B47D7D2AD77F','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'9E384F95-2201-417F-A3E9-42B58C8A83AE','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'09EC45B0-CF77-44BD-BF6B-5AC94EB4D5B9','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'CC900B43-7C8D-4ECD-9F07-FD069BDBD19C','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'6453A3AD-9995-4124-A4E7-D371B8937995','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'5724F4B4-1E9F-47EE-B50C-10E97EF0D231','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'65773438-F5E1-488E-A0A4-13174C9BAFF8','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'0565693D-74FB-48D3-8DD1-1FA3369AB3DE','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'50D8DC7E-1F1D-4141-BF49-28C6B9AC17D3','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'773CF61B-84E7-40AF-AC1E-2AA0E2DCC794','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'655FC50C-51F1-4A88-93C5-2BE9A9F57637','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'8EEB9C92-C91D-43B0-AFD7-371E1F6A4567','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'91C79376-F679-42EC-8EB6-3A16AF247B57','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'FA786BF9-926F-4ADD-A024-4F2FD6A43ACA','5DD35237-1EBB-4433-9282-2F57C55687FB')
insert into t_module_group_module (uid,umoduleid,umodulegroupid) values (newid(),'D452567B-0FC2-4382-84C2-561571B7951F','5DD35237-1EBB-4433-9282-2F57C55687FB')