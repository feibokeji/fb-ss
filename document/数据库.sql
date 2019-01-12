CREATE TABLE [dbo].[t_corp] (
	[uid] [uniqueidentifier] NOT NULL ,
	[ccode] [varchar] (30) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[cname] [varchar] (100) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[cnameen] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[cnameab] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[cprincipal] [varchar] (30) COLLATE Chinese_PRC_CI_AS NULL ,
	[ctaxno] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[caddr] [varchar] (200) COLLATE Chinese_PRC_CI_AS NULL ,
	[czip] [varchar] (10) COLLATE Chinese_PRC_CI_AS NULL ,
	[cfax] [varchar] (30) COLLATE Chinese_PRC_CI_AS NULL ,
	[ctelgeneral] [varchar] (30) COLLATE Chinese_PRC_CI_AS NULL ,
	[ctelguard] [varchar] (30) COLLATE Chinese_PRC_CI_AS NULL ,
	[cemail] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[cwebsite] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[cmemo] [varchar] (500) COLLATE Chinese_PRC_CI_AS NULL ,
	[cprovinces] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[ccity] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[dcreatetime] [datetime] NULL ,
	[dupdatetime] [datetime] NULL 
) ON [PRIMARY]
alter table t_corp add constraint t_corp_pk	primary key (uid);

CREATE TABLE [dbo].[t_dept] (
	[uid] [uniqueidentifier] NOT NULL ,
	[ucorpid] [uniqueidentifier] NOT NULL ,
	[ctype] [varchar] (30) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[ccode] [varchar] (30) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[cname] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[cparentcode] [varchar] (30) COLLATE Chinese_PRC_CI_AS NULL ,
	[ilevel] [int] NOT NULL ,
	[ccodepath] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
alter table t_dept add constraint t_dept_pk	primary key (uid);

CREATE TABLE [dbo].[t_login_log] (
	[uid] [uniqueidentifier] NOT NULL ,
	[ctype] [varchar] (4) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[dlogintime] [datetime] NOT NULL ,
	[uuserid] [uniqueidentifier] NOT NULL ,
	[cloginip] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[cloginurl] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[cmemo] [varchar] (200) COLLATE Chinese_PRC_CI_AS NULL ,
	[cmac] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
alter table t_login_log add constraint t_login_log_pk	primary key (uid);

CREATE TABLE [dbo].[t_module] (
	[uid] [uniqueidentifier] NOT NULL ,
	[ctype] [varchar] (10) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[ccode] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[cname] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[cparent] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[ilevel] [int] NOT NULL ,
	[isort] [int] NOT NULL ,
	[ccodepath] [varchar] (100) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[caddr] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
alter table t_module add constraint t_module_pk	primary key (uid);

CREATE TABLE [dbo].[t_module_group] (
	[uid] [uniqueidentifier] NOT NULL ,
	[ccode] [varchar] (30) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[cname] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL 
) ON [PRIMARY]
alter table t_module_group add constraint t_module_group_pk	primary key (uid);

CREATE TABLE [dbo].[t_module_group_module] (
	[uid] [uniqueidentifier] NOT NULL ,
	[umoduleid] [uniqueidentifier] NOT NULL ,
	[umodulegroupid] [uniqueidentifier] NOT NULL 
) ON [PRIMARY]
alter table t_module_group_module add constraint t_module_group_module_pk	primary key (uid);

CREATE TABLE [dbo].[t_operate_log] (
	[uid] [uniqueidentifier] NOT NULL ,
	[ctype] [varchar] (30) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[doperatetime] [datetime] NOT NULL ,
	[uuserid] [uniqueidentifier] NOT NULL ,
	[coperateip] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[coperateurl] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[clinktable] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[ulinktableid] [uniqueidentifier] NULL ,
	[cstatus] [varchar] (30) COLLATE Chinese_PRC_CI_AS NULL ,
	[cchoice] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[ccancel] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[cmemo] [varchar] (200) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
alter table t_operate_log add constraint t_operate_log_pk	primary key (uid);

CREATE TABLE [dbo].[t_role] (
	[uid] [uniqueidentifier] NOT NULL ,
	[udeptid] [uniqueidentifier] null,
	[uuserid] [uniqueidentifier] null,
	[ccode] [varchar] (30) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[cname] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL 
) ON [PRIMARY]
alter table t_role add constraint t_role_pk	primary key (uid);

CREATE TABLE [dbo].[t_role_access] (
	[uid] [uniqueidentifier] NOT NULL ,
	[uroleid] [uniqueidentifier] NULL ,
	[uaccessroleid] [uniqueidentifier] NULL ,
	[iaccess] [int] NULL ,
	[iaudit] [int] NULL 
) ON [PRIMARY]
alter table t_role_access add constraint t_role_access_pk	primary key (uid);

CREATE TABLE [dbo].[t_role_module_group] (
	[uid] [uniqueidentifier] NOT NULL ,
	[uroleid] [uniqueidentifier] NOT NULL ,
	[umodulegroupid] [uniqueidentifier] NOT NULL 
) ON [PRIMARY]
alter table t_role_module_group add constraint t_role_module_group_pk	primary key (uid);

CREATE TABLE [dbo].[t_user] (
	[uid] [uniqueidentifier] NOT NULL ,
	[udeptid] [uniqueidentifier] NOT NULL ,
	[ccode] [varchar] (30) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[cname] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[cnameen] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[cpassword] [varchar] (100) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[cduty] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[crank] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[djoindate] [datetime] NOT NULL ,
	[cidcard] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[csex] [varchar] (2) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[dbirthday] [datetime] NULL ,
	[ceducate] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[cofficetel] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[cofficefax] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[cofficeaddr] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[cmobiletel] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[chometel] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[chomeaddr] [varchar] (200) COLLATE Chinese_PRC_CI_AS NULL ,
	[cemail] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[cmsn] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[cqq] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[cmemo] [varchar] (200) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
alter table t_user add constraint t_user_pk	primary key (uid);
----------------------------------------------------------
CREATE TABLE [dbo].[t_account_type](
	[uid] [uniqueidentifier] NOT NULL,
	[cno] [varchar](30) NOT NULL,
	[cname] [varchar](30) NOT NULL,
	[ctype] [varchar](30) NOT NULL,
	[cmemo] [varchar](100) NULL
) ON [PRIMARY]
alter table t_account_type add constraint t_account_type_pk	primary key (uid);

CREATE TABLE [dbo].[t_account_order](
	[uid] [uniqueidentifier] NOT NULL,
	[ccode] [varchar](30) NOT NULL,
	[cname] [varchar](100) NOT NULL,
	[ctype] [varchar](30) NOT NULL,
	[uaccounttypeid] [uniqueidentifier] NULL,
	[ucorpid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[cmemo] [varchar](200) NULL,
	[dcreatetime] [datetime] NOT NULL,
	[dupdatetime] [datetime] NOT NULL,
	[iaudit] [int] NOT NULL,
	[daudittime] [datetime] NULL
) ON [PRIMARY]
alter table t_account_order add constraint t_account_order_pk	primary key (uid);

CREATE TABLE [dbo].[t_account_order_detail](
	[uid] [uniqueidentifier] NOT NULL,
	[uaccountorderid] [uniqueidentifier] NOT NULL,
	[nprice] [decimal](18, 2) NULL,
	[nqty] [decimal](18, 2) NULL,
	[namount] [decimal](18, 2) NULL,
	[isort] [int] NOT NULL,
	[cmemo] [varchar](100) NULL
) ON [PRIMARY]
alter table t_account_order_detail add constraint t_account_order_detail_pk	primary key (uid);
----------------------------------------------------------
CREATE TABLE [dbo].[t_category](
	[uid] [uniqueidentifier] NOT NULL,
	[cno] [varchar](36) NOT NULL,
	[cname] [varchar](50) NOT NULL
) ON [PRIMARY]
alter table t_category add constraint t_category_pk	primary key (uid);

CREATE TABLE [dbo].[t_product](
	[uid] [uniqueidentifier] NOT NULL,
	[ucategoryid] [uniqueidentifier] NOT NULL,
	[cno] [varchar](36) NOT NULL,
	[cname] [varchar](50) NOT NULL,
	[nprice] [decimal](18, 2) NOT NULL
) ON [PRIMARY]
alter table t_product add constraint t_product_pk	primary key (uid);

ALTER TABLE [dbo].[t_product]  WITH CHECK ADD  CONSTRAINT [FK_t_product_t_category] FOREIGN KEY([ucategoryid])
REFERENCES [dbo].[t_category] ([uid])

ALTER TABLE [dbo].[t_product] CHECK CONSTRAINT [FK_t_product_t_category]

CREATE TABLE [dbo].[t_material](
	[uid] [uniqueidentifier] NOT NULL,
	[cno] [varchar](36) NOT NULL,
	[cname] [varchar](50) NOT NULL,
	[cspecifications] [varchar](200) NULL,
	[nprice] [decimal](18, 2) NOT NULL
) ON [PRIMARY]
alter table t_material add constraint t_material_pk	primary key (uid);

CREATE TABLE [dbo].[t_product_material](
	[uid] [uniqueidentifier] NOT NULL,
	[uproductid] [uniqueidentifier] NOT NULL,
	[umaterialid] [uniqueidentifier] NOT NULL,
	[nqty] [decimal](18, 2) NOT NULL,
	[ienablesign] [int] NOT NULL
) ON [PRIMARY]
alter table t_product_material add constraint t_product_material_pk	primary key (uid);

ALTER TABLE [dbo].[t_product_material]  WITH CHECK ADD  CONSTRAINT [FK_t_product_material_t_material] FOREIGN KEY([umaterialid])
REFERENCES [dbo].[t_material] ([uid])

ALTER TABLE [dbo].[t_product_material] CHECK CONSTRAINT [FK_t_product_material_t_material]

ALTER TABLE [dbo].[t_product_material]  WITH CHECK ADD  CONSTRAINT [FK_t_product_material_t_product] FOREIGN KEY([uproductid])
REFERENCES [dbo].[t_product] ([uid])

ALTER TABLE [dbo].[t_product_material] CHECK CONSTRAINT [FK_t_product_material_t_product]

ALTER TABLE [dbo].[t_product_material] ADD  CONSTRAINT [DF_t_product_material_nqty]  DEFAULT ((1)) FOR [nqty]

ALTER TABLE [dbo].[t_product_material] ADD  CONSTRAINT [DF_t_product_material_ienablesign]  DEFAULT ((0)) FOR [ienablesign]

CREATE TABLE [dbo].[t_order](
	[uid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[cusername] [varchar](50) NOT NULL,
	[cno] [varchar](36) NOT NULL,
	[ctype] [varchar](50) NOT NULL,
	[cstatus] [varchar](10) NOT NULL,
	[dordertime] [datetime] NOT NULL,
	[dcreatetime] [datetime] NOT NULL,
	[dupdatetime] [datetime] NOT NULL
) ON [PRIMARY]
alter table t_order add constraint t_order_pk	primary key (uid);

CREATE TABLE [dbo].[t_order_material](
	[uid] [uniqueidentifier] NOT NULL,
	[uorderid] [uniqueidentifier] NOT NULL,
	[umaterialid] [uniqueidentifier] NOT NULL,
	[cmaterialname] [varchar](50) NOT NULL,
	[nprice] [decimal](18, 2) NOT NULL,
	[nqty] [decimal](18, 2) NOT NULL,
	[namount] [decimal](18, 2) NOT NULL,
	[isort] [int] NOT NULL
) ON [PRIMARY]
alter table t_order_material add constraint t_order_material_pk	primary key (uid);
alter table t_order_material alter column nprice decimal(18,2)

ALTER TABLE [dbo].[t_order_material]  WITH CHECK ADD  CONSTRAINT [FK_t_order_material_t_material] FOREIGN KEY([umaterialid])
REFERENCES [dbo].[t_material] ([uid])

ALTER TABLE [dbo].[t_order_material] CHECK CONSTRAINT [FK_t_order_material_t_material]

ALTER TABLE [dbo].[t_order_material]  WITH CHECK ADD  CONSTRAINT [FK_t_order_material_t_order] FOREIGN KEY([uorderid])
REFERENCES [dbo].[t_order] ([uid])

ALTER TABLE [dbo].[t_order_material] CHECK CONSTRAINT [FK_t_order_material_t_order]

CREATE TABLE [dbo].[t_order_product](
	[uid] [uniqueidentifier] NOT NULL,
	[isort] [int] NOT NULL, --\u5e8f\u53f7
	[uorderid] [uniqueidentifier] NOT NULL, --\u8ba2\u5355\u5916\u952e
	[uproductid] [uniqueidentifier] NOT NULL, --\u4ea7\u54c1\u5916\u952e
	[cproductno] [varchar](50) NOT NULL, --\u4ea7\u54c1\u7f16\u7801
	[cproductname] [varchar](50) NOT NULL, --\u4ea7\u54c1\u540d\u79f0
	[ccategoryname] [varchar](50) NOT NULL, --\u7c7b\u522b\u540d\u79f0
	[nsqty] [decimal](18, 2) NOT NULL, --\u9500\u552e\u6570\u91cf 
	[nsamount] [decimal](18, 2) NOT NULL, --\u9500\u552e\u91d1\u989d
	[nbqty] [decimal](18, 2) NOT NULL, --\u9000\u8d27\u6570\u91cf 
	[nbamount] [decimal](18, 2) NOT NULL, --\u9000\u8d27\u91d1\u989d
	[ngqty] [decimal](18, 2) NOT NULL, --\u8d60\u9001\u6570\u91cf 
	[ngamount] [decimal](18, 2) NOT NULL, --\u8d60\u9001\u91d1\u989d
	[nqtysubtotal] [decimal](18, 2) NOT NULL, --\u6570\u91cf\u5c0f\u8ba1
	[namountsubtotal] [decimal](18, 2) NOT NULL, --\u91d1\u989d\u5c0f\u8ba1
	[nreferenceprice] [decimal](18, 2) NOT NULL, --\u53c2\u8003\u8fdb\u4ef7
	[npurchaseprice] [decimal](18, 2) NOT NULL, --\u8fdb\u4ef7\u91d1\u989d
	[nreferenceprofits] [decimal](18, 2) NOT NULL, --\u53c2\u8003\u5229\u6da6
	[cmainsupplier] [varchar](50) NULL, --\u4e3b\u4f9b\u5e94\u5546
	[cbrand] [varchar](50) NULL --\u54c1\u724c
) ON [PRIMARY]
alter table t_order_product add constraint t_order_product_pk	primary key (uid);

ALTER TABLE [dbo].[t_order_product]  WITH CHECK ADD  CONSTRAINT [FK_t_order_product_t_order] FOREIGN KEY([uorderid])
REFERENCES [dbo].[t_order] ([uid])

ALTER TABLE [dbo].[t_order_product] CHECK CONSTRAINT [FK_t_order_product_t_order]

ALTER TABLE [dbo].[t_order_product]  WITH CHECK ADD  CONSTRAINT [FK_t_order_product_t_product] FOREIGN KEY([uproductid])
REFERENCES [dbo].[t_product] ([uid])

ALTER TABLE [dbo].[t_order_product] CHECK CONSTRAINT [FK_t_order_product_t_product]
--\u8d26\u6237\u8868
create table t_account(
	uid uniqueidentifier not null,
	uuserid uniqueidentifier null,
	cusername varchar(50) null,
	udeptid uniqueidentifier null,
	cdeptname varchar(50) null,
	ucorpid uniqueidentifier null,
	ccorpname varchar(50) null,
	cno varchar(50) not null,
	cname varchar(50) not null
)
alter table t_account add constraint t_account_pk primary key (uid)
alter table t_account_order add uaccountid uniqueidentifier not null
alter table t_account add namount [decimal](18,2) null
--\u76d8\u70b9\u5dee\u5f02\u8868
create table t_material_check_diff(
	uid uniqueidentifier not null,
	uorderid uniqueidentifier not null,
	umaterialid uniqueidentifier not null,
	cmaterialname varchar(50) not null,
	nqty [decimal](18, 2) NOT NULL,
	nqty1 [decimal](18, 2) NOT NULL,
	nqty2 [decimal](18, 2) NOT NULL,
	dcreatetime [datetime] NOT NULL
)
alter table t_material_check_diff add constraint t_material_check_diff_pk primary key (uid)

--2019/01/12
--\u54c1\u724c\u8868\u5efa\u7acb
--\u54c1\u724c
CREATE TABLE [dbo].[t_brand](
	[uid] [uniqueidentifier] NOT NULL,
	[cname] [varchar](50) NOT NULL,
	[clogo] [varchar](100) NULL,
	[curl] [varchar](100) NULL,
	[cdesc] [varchar](100) NULL,
	[isort] [int] NOT NULL,
 CONSTRAINT [PK_t_brand] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]