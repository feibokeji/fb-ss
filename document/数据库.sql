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

--\u4fdd\u4fee\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_warranty](
	[uid] [uniqueidentifier] NOT NULL,
	[iday] [int] NOT NULL,
	[ccontent] [varchar](100) NULL,
 CONSTRAINT [PK_t_warranty] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

--\u624b\u673a\u578b\u53f7\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_phone_model](
	[uid] [uniqueidentifier] NOT NULL,
	[ubrandid] [uniqueidentifier] NOT NULL,
	[uwarranty] [uniqueidentifier] NOT NULL,
	[cname] [varchar](50) NOT NULL,
	[cram] [varchar](50) NULL,
	[crom] [varchar](50) NULL,
	[ccpu] [varchar](50) NULL,
	[ccamera] [varchar](100) NULL,
	[cbattery] [varchar](50) NULL,
	[cnetwork] [varchar](100) NULL,
	[chighlightdesc] [varchar](200) NULL,
 CONSTRAINT [PK_t_phone_model] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[t_phone_model]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_model_t_brand] FOREIGN KEY([ubrandid])
REFERENCES [dbo].[t_brand] ([uid])
GO

ALTER TABLE [dbo].[t_phone_model] CHECK CONSTRAINT [FK_t_phone_model_t_brand]
GO

ALTER TABLE [dbo].[t_phone_model]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_model_t_warranty] FOREIGN KEY([uwarranty])
REFERENCES [dbo].[t_warranty] ([uid])
GO

ALTER TABLE [dbo].[t_phone_model] CHECK CONSTRAINT [FK_t_phone_model_t_warranty]

--\u624b\u673a\u578b\u53f7\u7684\u989c\u8272\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_phone_model_color](
	[uid] [uniqueidentifier] NOT NULL,
	[uphonemodelid] [uniqueidentifier] NOT NULL,
	[ucolorid] [uniqueidentifier] NOT NULL,
 CONSTRAINT [PK_t_phone_model_color] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[t_phone_model_color]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_model_color_t_color] FOREIGN KEY([ucolorid])
REFERENCES [dbo].[t_color] ([uid])
GO

ALTER TABLE [dbo].[t_phone_model_color] CHECK CONSTRAINT [FK_t_phone_model_color_t_color]
GO

ALTER TABLE [dbo].[t_phone_model_color]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_model_color_t_phone_model] FOREIGN KEY([uphonemodelid])
REFERENCES [dbo].[t_phone_model] ([uid])
GO

ALTER TABLE [dbo].[t_phone_model_color] CHECK CONSTRAINT [FK_t_phone_model_color_t_phone_model]

--\u624b\u673a\u578b\u53f7\u4ef7\u683c\u8bb0\u5f55\u8868
CREATE TABLE [dbo].[t_phone_model_price_record](
	[uid] [uniqueidentifier] NOT NULL,
	[uphonemodelid] [uniqueidentifier] NOT NULL,
	[ncostprice] [decimal](18, 2) NOT NULL,
	[nretailprice] [decimal](18, 2) NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[istatus] [int] NOT NULL,
 CONSTRAINT [PK_t_phone_model_price_record] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[t_phone_model_price_record]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_model_price_record_t_phone_model] FOREIGN KEY([uphonemodelid])
REFERENCES [dbo].[t_phone_model] ([uid])
GO

ALTER TABLE [dbo].[t_phone_model_price_record] CHECK CONSTRAINT [FK_t_phone_model_price_record_t_phone_model]
GO

ALTER TABLE [dbo].[t_phone_model_price_record] ADD  CONSTRAINT [DF_t_phone_model_price_record_istatus]  DEFAULT ((0)) FOR [istatus]
GO

--\u4f9b\u5e94\u5546\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_supplier](
	[uid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[cno] [varchar](50) NOT NULL,
	[cname] [varchar](50) NOT NULL,
	[cbusinessscope] [varchar](100) NULL,
	[caddress] [varchar](100) NULL,
	[cfixedtelephone] [varchar](50) NULL,
	[clinkman] [varchar](50) NULL,
	[ccontactnumber] [varchar](50) NULL,
	[cemail] [varchar](100) NULL,
	[cqq] [varchar](50) NULL,
	[cwechat] [varchar](50) NULL,
	[copenbank] [varchar](50) NULL,
	[cbankcardnumber] [varchar](50) NULL,
	[ipaymentdays] [int] NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_supplier] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[t_supplier]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_supplier] CHECK CONSTRAINT [FK_t_supplier_t_dept]
GO

ALTER TABLE [dbo].[t_supplier]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_t_user] FOREIGN KEY([uuserid])
REFERENCES [dbo].[t_user] ([uid])
GO

ALTER TABLE [dbo].[t_supplier] CHECK CONSTRAINT [FK_t_supplier_t_user]

--\u5ba2\u6237\u7c7b\u578b\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_customer_type](
	[uid] [uniqueidentifier] NOT NULL,
	[cno] [varchar](50) NOT NULL,
	[cname] [varchar](50) NOT NULL,
	[ipaymentdays] [int] NOT NULL,
 CONSTRAINT [PK_t_customer_type] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[t_customer_type] ADD  CONSTRAINT [DF_t_customer_type_ipaymentdays]  DEFAULT ((0)) FOR [ipaymentdays]
--\u5ba2\u6237\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_customer](
	[uid] [uniqueidentifier] NOT NULL,
	[ucustomertypeid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[cname] [varchar](50) NOT NULL,
	[isex] [int] NOT NULL,
	[ccontactnumber] [varchar](50) NULL,
	[caddress] [varchar](100) NULL,
	[cwechat] [varchar](50) NULL,
	[dbirthday] [date] NULL,
	[iintegral] [int] NULL,
	[ipaymentdays] [int] NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_customer] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[t_customer]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_t_customer_type] FOREIGN KEY([ucustomertypeid])
REFERENCES [dbo].[t_customer_type] ([uid])
GO

ALTER TABLE [dbo].[t_customer] CHECK CONSTRAINT [FK_t_customer_t_customer_type]
GO

ALTER TABLE [dbo].[t_customer]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_customer] CHECK CONSTRAINT [FK_t_customer_t_dept]
GO

ALTER TABLE [dbo].[t_customer]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_t_user] FOREIGN KEY([uuserid])
REFERENCES [dbo].[t_user] ([uid])
GO

ALTER TABLE [dbo].[t_customer] CHECK CONSTRAINT [FK_t_customer_t_user]
GO

ALTER TABLE [dbo].[t_customer] ADD  CONSTRAINT [DF_t_customer_iintegral]  DEFAULT ((0)) FOR [iintegral]
GO

ALTER TABLE [dbo].[t_customer] ADD  CONSTRAINT [DF_t_customer_ipaymentdays]  DEFAULT ((0)) FOR [ipaymentdays]
GO
--\u5355\u4f4d\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_unit](
	[uid] [uniqueidentifier] NOT NULL,
	[cname] [varchar](50) NOT NULL,
 CONSTRAINT [PK_t_unit] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
--\u5176\u5b83\u5546\u54c1\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_other_goods](
	[uid] [uniqueidentifier] NOT NULL,
	[ucategoryid] [uniqueidentifier] NOT NULL,
	[ubrandid] [uniqueidentifier] NOT NULL,
	[uunitid] [uniqueidentifier] NOT NULL,
	[uwarrantyid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[cno] [varchar](50) NOT NULL,
	[cbarcode] [varchar](50) NULL,
	[cname] [varchar](50) NOT NULL,
	[cfullname] [varchar](100) NULL,
	[cmnemoniccode] [varchar](50) NULL,
	[cspecifications] [varchar](100) NULL,
	[iintegral] [int] NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_other_goods] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[t_other_goods]  WITH CHECK ADD  CONSTRAINT [FK_t_other_goods_t_brand] FOREIGN KEY([ubrandid])
REFERENCES [dbo].[t_brand] ([uid])
GO

ALTER TABLE [dbo].[t_other_goods] CHECK CONSTRAINT [FK_t_other_goods_t_brand]
GO

ALTER TABLE [dbo].[t_other_goods]  WITH CHECK ADD  CONSTRAINT [FK_t_other_goods_t_category] FOREIGN KEY([ucategoryid])
REFERENCES [dbo].[t_category] ([uid])
GO

ALTER TABLE [dbo].[t_other_goods] CHECK CONSTRAINT [FK_t_other_goods_t_category]
GO

ALTER TABLE [dbo].[t_other_goods]  WITH CHECK ADD  CONSTRAINT [FK_t_other_goods_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_other_goods] CHECK CONSTRAINT [FK_t_other_goods_t_dept]
GO

ALTER TABLE [dbo].[t_other_goods]  WITH CHECK ADD  CONSTRAINT [FK_t_other_goods_t_unit] FOREIGN KEY([uunitid])
REFERENCES [dbo].[t_unit] ([uid])
GO

ALTER TABLE [dbo].[t_other_goods] CHECK CONSTRAINT [FK_t_other_goods_t_unit]
GO

ALTER TABLE [dbo].[t_other_goods]  WITH CHECK ADD  CONSTRAINT [FK_t_other_goods_t_user] FOREIGN KEY([uuserid])
REFERENCES [dbo].[t_user] ([uid])
GO

ALTER TABLE [dbo].[t_other_goods] CHECK CONSTRAINT [FK_t_other_goods_t_user]
GO

ALTER TABLE [dbo].[t_other_goods]  WITH CHECK ADD  CONSTRAINT [FK_t_other_goods_t_warranty] FOREIGN KEY([uwarrantyid])
REFERENCES [dbo].[t_warranty] ([uid])
GO

ALTER TABLE [dbo].[t_other_goods] CHECK CONSTRAINT [FK_t_other_goods_t_warranty]
GO

ALTER TABLE [dbo].[t_other_goods] ADD  CONSTRAINT [DF_t_other_goods_iintegral]  DEFAULT ((0)) FOR [iintegral]
GO
--\u4ed8\u6b3e\u65b9\u5f0f\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_payment_method](
	[uid] [uniqueidentifier] NOT NULL,
	[cname] [varchar](50) NOT NULL,
	[ccode] [varchar](50) NOT NULL,
	[cdesc] [varchar](100) NULL,
 CONSTRAINT [PK_t_payment_method] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
--\u5176\u5b83\u5546\u54c1\u4ef7\u683c\u8bb0\u5f55\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_other_goods_price_record](
	[uid] [uniqueidentifier] NOT NULL,
	[uothergoodsid] [uniqueidentifier] NOT NULL,
	[ncostprice] [decimal](18, 2) NOT NULL,
	[nretailprice] [decimal](18, 2) NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[istatus] [int] NOT NULL,
 CONSTRAINT [PK_t_other_goods_price_record] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[t_other_goods_price_record]  WITH CHECK ADD  CONSTRAINT [FK_t_other_goods_price_record_t_other_goods] FOREIGN KEY([uothergoodsid])
REFERENCES [dbo].[t_other_goods] ([uid])
GO

ALTER TABLE [dbo].[t_other_goods_price_record] CHECK CONSTRAINT [FK_t_other_goods_price_record_t_other_goods]
GO

ALTER TABLE [dbo].[t_other_goods_price_record] ADD  CONSTRAINT [DF_t_other_goods_price_record_istatus]  DEFAULT ((0)) FOR [istatus]
GO

--\u624b\u673a\u5e93\u5b58\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_phone_inventory](
	[IMEI] [int] NOT NULL,
	[usupplierid] [uniqueidentifier] NULL,
	[ucustomerid] [uniqueidentifier] NULL,
	[uphonemodelid] [uniqueidentifier] NOT NULL,
	[ucolorid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[ncostprice] [decimal](18, 2) NOT NULL,
	[nretailprice] [decimal](18, 2) NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_phone_inventory] PRIMARY KEY CLUSTERED 
(
	[IMEI] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[t_phone_inventory]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_inventory_t_color] FOREIGN KEY([ucolorid])
REFERENCES [dbo].[t_color] ([uid])
GO

ALTER TABLE [dbo].[t_phone_inventory] CHECK CONSTRAINT [FK_t_phone_inventory_t_color]
GO

ALTER TABLE [dbo].[t_phone_inventory]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_inventory_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_phone_inventory] CHECK CONSTRAINT [FK_t_phone_inventory_t_dept]
GO

ALTER TABLE [dbo].[t_phone_inventory]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_inventory_t_phone_model] FOREIGN KEY([uphonemodelid])
REFERENCES [dbo].[t_phone_model] ([uid])
GO

ALTER TABLE [dbo].[t_phone_inventory] CHECK CONSTRAINT [FK_t_phone_inventory_t_phone_model]
GO

ALTER TABLE [dbo].[t_phone_inventory]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_inventory_t_supplier] FOREIGN KEY([ucustomerid])
REFERENCES [dbo].[t_customer] ([uid])
GO

ALTER TABLE [dbo].[t_phone_inventory] CHECK CONSTRAINT [FK_t_phone_inventory_t_supplier]
GO

ALTER TABLE [dbo].[t_phone_inventory]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_inventory_t_user] FOREIGN KEY([uuserid])
REFERENCES [dbo].[t_user] ([uid])
GO

ALTER TABLE [dbo].[t_phone_inventory] CHECK CONSTRAINT [FK_t_phone_inventory_t_user]
GO
--\u624b\u673a\u5e93\u5b58\u72b6\u6001\u8868
CREATE TABLE [dbo].[t_phone_inventory_status](
	[uid] [uniqueidentifier] NOT NULL,
	[IMEI] [int] NOT NULL,
	[istatus] [int] NOT NULL,
	[imark] [int] NOT NULL,
	[dupatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_phone_inventory_status] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[t_phone_inventory_status]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_inventory_status_t_phone_inventory] FOREIGN KEY([IMEI])
REFERENCES [dbo].[t_phone_inventory] ([IMEI])
GO

ALTER TABLE [dbo].[t_phone_inventory_status] CHECK CONSTRAINT [FK_t_phone_inventory_status_t_phone_inventory]
--\u624b\u673a\u5e93\u5b58\u5e94\u6536\u5e94\u4ed8\u6b3e\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_phone_inventory_receivable](
	[uid] [uniqueidentifier] NOT NULL,
	[IMEI] [int] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[ctype] [varchar](5) NOT NULL,
	[nactualamount] [decimal](18, 2) NOT NULL,
	[ndiscount] [decimal](18, 2) NOT NULL,
	[namount] [decimal](18, 2) NOT NULL,
	[istatus] [int] NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_phone_inventory_receivable] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[t_phone_inventory_receivable]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_inventory_receivable_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_phone_inventory_receivable] CHECK CONSTRAINT [FK_t_phone_inventory_receivable_t_dept]
GO

ALTER TABLE [dbo].[t_phone_inventory_receivable]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_inventory_receivable_t_phone_inventory] FOREIGN KEY([IMEI])
REFERENCES [dbo].[t_phone_inventory] ([IMEI])
GO

ALTER TABLE [dbo].[t_phone_inventory_receivable] CHECK CONSTRAINT [FK_t_phone_inventory_receivable_t_phone_inventory]
--\u624b\u673a\u5e93\u5b58\u5b9e\u6536\u5b9e\u4ed8\u6b3e\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_phone_inventory_receipts](
	[uid] [uniqueidentifier] NOT NULL,
	[ureceivableid] [uniqueidentifier] NOT NULL,
	[upaymentmethodid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[ctype] [varchar](5) NOT NULL,
	[namount] [decimal](18, 2) NOT NULL,
	[istatus] [int] NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_phone_inventory_receipts] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[t_phone_inventory_receipts]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_inventory_receipts_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_phone_inventory_receipts] CHECK CONSTRAINT [FK_t_phone_inventory_receipts_t_dept]
GO

ALTER TABLE [dbo].[t_phone_inventory_receipts]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_inventory_receipts_t_payment_method] FOREIGN KEY([upaymentmethodid])
REFERENCES [dbo].[t_payment_method] ([uid])
GO

ALTER TABLE [dbo].[t_phone_inventory_receipts] CHECK CONSTRAINT [FK_t_phone_inventory_receipts_t_payment_method]
GO

ALTER TABLE [dbo].[t_phone_inventory_receipts]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_inventory_receipts_t_phone_inventory_receivable] FOREIGN KEY([ureceivableid])
REFERENCES [dbo].[t_phone_inventory_receivable] ([uid])
GO

ALTER TABLE [dbo].[t_phone_inventory_receipts] CHECK CONSTRAINT [FK_t_phone_inventory_receipts_t_phone_inventory_receivable]
GO

ALTER TABLE [dbo].[t_phone_inventory_receipts]  WITH CHECK ADD  CONSTRAINT [FK_t_phone_inventory_receipts_t_user] FOREIGN KEY([uuserid])
REFERENCES [dbo].[t_user] ([uid])
GO

ALTER TABLE [dbo].[t_phone_inventory_receipts] CHECK CONSTRAINT [FK_t_phone_inventory_receipts_t_user]
--\u4f9b\u5e94\u5546\u5355\u636e\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_supplier_order](
	[uid] [uniqueidentifier] NOT NULL,
	[usupplierid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[cno] [varchar](50) NOT NULL,
	[itype] [int] NOT NULL,
	[istatus] [int] NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_supplier_order] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[t_supplier_order]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_order_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_order] CHECK CONSTRAINT [FK_t_supplier_order_t_dept]
GO

ALTER TABLE [dbo].[t_supplier_order]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_order_t_supplier] FOREIGN KEY([usupplierid])
REFERENCES [dbo].[t_supplier] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_order] CHECK CONSTRAINT [FK_t_supplier_order_t_supplier]
GO

ALTER TABLE [dbo].[t_supplier_order]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_order_t_user] FOREIGN KEY([uuserid])
REFERENCES [dbo].[t_user] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_order] CHECK CONSTRAINT [FK_t_supplier_order_t_user]
--\u4f9b\u5e94\u5546\u5355\u636e\u660e\u7ec6\u8868\u8bbe\u8ba1

CREATE TABLE [dbo].[t_supplier_order_detail](
	[uid] [uniqueidentifier] NOT NULL,
	[uorderid] [uniqueidentifier] NOT NULL,
	[uothergoodsid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[nquantity] [decimal](18, 2) NOT NULL,
	[nprice] [decimal](18, 2) NOT NULL,
	[namount] [decimal](18, 2) NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_supplier_order_detail] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[t_supplier_order_detail]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_order_detail_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_order_detail] CHECK CONSTRAINT [FK_t_supplier_order_detail_t_dept]
GO

ALTER TABLE [dbo].[t_supplier_order_detail]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_order_detail_t_other_goods] FOREIGN KEY([uothergoodsid])
REFERENCES [dbo].[t_other_goods] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_order_detail] CHECK CONSTRAINT [FK_t_supplier_order_detail_t_other_goods]
GO

ALTER TABLE [dbo].[t_supplier_order_detail]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_order_detail_t_supplier_order] FOREIGN KEY([uorderid])
REFERENCES [dbo].[t_supplier_order] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_order_detail] CHECK CONSTRAINT [FK_t_supplier_order_detail_t_supplier_order]
GO
--\u4f9b\u5e94\u5546\u5e94\u6536\u5e94\u4ed8\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_supplier_receivable](
	[uid] [uniqueidentifier] NOT NULL,
	[usupplierid] [uniqueidentifier] NOT NULL,
	[uorderid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[ctype] [varchar](5) NOT NULL,
	[nactualamount] [decimal](18, 2) NOT NULL,
	[ndiscount] [decimal](18, 2) NOT NULL,
	[namount] [decimal](18, 2) NOT NULL,
	[istatus] [int] NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_supplier_receivable] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[t_supplier_receivable]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_receivable_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_receivable] CHECK CONSTRAINT [FK_t_supplier_receivable_t_dept]
GO

ALTER TABLE [dbo].[t_supplier_receivable]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_receivable_t_supplier_order] FOREIGN KEY([uorderid])
REFERENCES [dbo].[t_supplier_order] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_receivable] CHECK CONSTRAINT [FK_t_supplier_receivable_t_supplier_order]
GO

ALTER TABLE [dbo].[t_supplier_receivable]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_receivable_t_supplier_receivable] FOREIGN KEY([usupplierid])
REFERENCES [dbo].[t_supplier] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_receivable] CHECK CONSTRAINT [FK_t_supplier_receivable_t_supplier_receivable]
GO

ALTER TABLE [dbo].[t_supplier_receivable]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_receivable_t_user] FOREIGN KEY([uuserid])
REFERENCES [dbo].[t_user] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_receivable] CHECK CONSTRAINT [FK_t_supplier_receivable_t_user]
GO
--\u4f9b\u5e94\u5546\u5b9e\u6536\u5b9e\u4ed8\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_supplier_receipts](
	[uid] [uniqueidentifier] NOT NULL,
	[ureceivableid] [uniqueidentifier] NOT NULL,
	[upaymentmethodid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[ctype] [varchar](5) NOT NULL,
	[namount] [decimal](18, 2) NOT NULL,
	[istatus] [int] NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_supplier_receipts] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[t_supplier_receipts]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_receipts_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_receipts] CHECK CONSTRAINT [FK_t_supplier_receipts_t_dept]
GO

ALTER TABLE [dbo].[t_supplier_receipts]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_receipts_t_payment_method] FOREIGN KEY([upaymentmethodid])
REFERENCES [dbo].[t_payment_method] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_receipts] CHECK CONSTRAINT [FK_t_supplier_receipts_t_payment_method]
GO

ALTER TABLE [dbo].[t_supplier_receipts]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_receipts_t_supplier_receivable] FOREIGN KEY([ureceivableid])
REFERENCES [dbo].[t_supplier_receivable] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_receipts] CHECK CONSTRAINT [FK_t_supplier_receipts_t_supplier_receivable]
GO

ALTER TABLE [dbo].[t_supplier_receipts]  WITH CHECK ADD  CONSTRAINT [FK_t_supplier_receipts_t_user] FOREIGN KEY([uuserid])
REFERENCES [dbo].[t_user] ([uid])
GO

ALTER TABLE [dbo].[t_supplier_receipts] CHECK CONSTRAINT [FK_t_supplier_receipts_t_user]
GO
--\u5ba2\u6237\u5355\u636e\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_customer_order](
	[uid] [uniqueidentifier] NOT NULL,
	[ucustomerid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[cno] [varchar](50) NOT NULL,
	[itype] [int] NOT NULL,
	[istatus] [int] NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_customer_order] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[t_customer_order]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_order_t_customer] FOREIGN KEY([ucustomerid])
REFERENCES [dbo].[t_customer] ([uid])
GO

ALTER TABLE [dbo].[t_customer_order] CHECK CONSTRAINT [FK_t_customer_order_t_customer]
GO

ALTER TABLE [dbo].[t_customer_order]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_order_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_customer_order] CHECK CONSTRAINT [FK_t_customer_order_t_dept]
GO

ALTER TABLE [dbo].[t_customer_order]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_order_t_user] FOREIGN KEY([uuserid])
REFERENCES [dbo].[t_user] ([uid])
GO

ALTER TABLE [dbo].[t_customer_order] CHECK CONSTRAINT [FK_t_customer_order_t_user]
GO
--\u5ba2\u6237\u5355\u636e\u660e\u7ec6\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_customer_order_detail](
	[uid] [uniqueidentifier] NOT NULL,
	[uorderid] [uniqueidentifier] NOT NULL,
	[uothergoodsid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[nquantity] [decimal](18, 2) NOT NULL,
	[nprice] [decimal](18, 2) NOT NULL,
	[namount] [decimal](18, 2) NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_customer_order_detail] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[t_customer_order_detail]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_order_detail_t_customer_order] FOREIGN KEY([uorderid])
REFERENCES [dbo].[t_customer_order] ([uid])
GO

ALTER TABLE [dbo].[t_customer_order_detail] CHECK CONSTRAINT [FK_t_customer_order_detail_t_customer_order]
GO

ALTER TABLE [dbo].[t_customer_order_detail]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_order_detail_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_customer_order_detail] CHECK CONSTRAINT [FK_t_customer_order_detail_t_dept]
GO

ALTER TABLE [dbo].[t_customer_order_detail]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_order_detail_t_other_goods] FOREIGN KEY([uothergoodsid])
REFERENCES [dbo].[t_other_goods] ([uid])
GO

ALTER TABLE [dbo].[t_customer_order_detail] CHECK CONSTRAINT [FK_t_customer_order_detail_t_other_goods]
GO

ALTER TABLE [dbo].[t_customer_order_detail]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_order_detail_t_user] FOREIGN KEY([uuserid])
REFERENCES [dbo].[t_user] ([uid])
GO

ALTER TABLE [dbo].[t_customer_order_detail] CHECK CONSTRAINT [FK_t_customer_order_detail_t_user]
GO
--\u5ba2\u6237\u5e94\u6536\u5e94\u4ed8\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_customer_receivable](
	[uid] [uniqueidentifier] NOT NULL,
	[ucustomerid] [uniqueidentifier] NOT NULL,
	[uorderid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[ctype] [varchar](5) NOT NULL,
	[nactualamount] [decimal](18, 2) NOT NULL,
	[ndiscount] [decimal](18, 2) NOT NULL,
	[namount] [decimal](18, 2) NOT NULL,
	[istatus] [int] NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_customer_receivable] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[t_customer_receivable]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_receivable_t_customer] FOREIGN KEY([ucustomerid])
REFERENCES [dbo].[t_customer] ([uid])
GO

ALTER TABLE [dbo].[t_customer_receivable] CHECK CONSTRAINT [FK_t_customer_receivable_t_customer]
GO

ALTER TABLE [dbo].[t_customer_receivable]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_receivable_t_customer_order] FOREIGN KEY([uorderid])
REFERENCES [dbo].[t_customer_order] ([uid])
GO

ALTER TABLE [dbo].[t_customer_receivable] CHECK CONSTRAINT [FK_t_customer_receivable_t_customer_order]
GO

ALTER TABLE [dbo].[t_customer_receivable]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_receivable_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_customer_receivable] CHECK CONSTRAINT [FK_t_customer_receivable_t_dept]
GO

ALTER TABLE [dbo].[t_customer_receivable]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_receivable_t_user] FOREIGN KEY([uuserid])
REFERENCES [dbo].[t_user] ([uid])
GO
--\u5ba2\u6237\u5b9e\u6536\u5b9e\u4ed8\u8868\u8bbe\u8ba1
CREATE TABLE [dbo].[t_customer_receipts](
	[uid] [uniqueidentifier] NOT NULL,
	[ureceivableid] [uniqueidentifier] NOT NULL,
	[upaymentmethodid] [uniqueidentifier] NOT NULL,
	[uuserid] [uniqueidentifier] NOT NULL,
	[udeptid] [uniqueidentifier] NOT NULL,
	[ctype] [varchar](5) NOT NULL,
	[namount] [decimal](18, 2) NOT NULL,
	[istatus] [int] NOT NULL,
	[drecorddate] [datetime] NOT NULL,
	[dupdatedate] [datetime] NOT NULL,
 CONSTRAINT [PK_t_customer_receipts] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[t_customer_receipts]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_receipts_t_customer_receivable] FOREIGN KEY([ureceivableid])
REFERENCES [dbo].[t_customer_receivable] ([uid])
GO

ALTER TABLE [dbo].[t_customer_receipts] CHECK CONSTRAINT [FK_t_customer_receipts_t_customer_receivable]
GO

ALTER TABLE [dbo].[t_customer_receipts]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_receipts_t_dept] FOREIGN KEY([udeptid])
REFERENCES [dbo].[t_dept] ([uid])
GO

ALTER TABLE [dbo].[t_customer_receipts] CHECK CONSTRAINT [FK_t_customer_receipts_t_dept]
GO

ALTER TABLE [dbo].[t_customer_receipts]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_receipts_t_payment_method] FOREIGN KEY([upaymentmethodid])
REFERENCES [dbo].[t_payment_method] ([uid])
GO

ALTER TABLE [dbo].[t_customer_receipts] CHECK CONSTRAINT [FK_t_customer_receipts_t_payment_method]
GO

ALTER TABLE [dbo].[t_customer_receipts]  WITH CHECK ADD  CONSTRAINT [FK_t_customer_receipts_t_user] FOREIGN KEY([uuserid])
REFERENCES [dbo].[t_user] ([uid])
GO

ALTER TABLE [dbo].[t_customer_receipts] CHECK CONSTRAINT [FK_t_customer_receipts_t_user]
GO