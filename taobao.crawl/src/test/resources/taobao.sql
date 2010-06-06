--drop database taobao;
--CREATE DATABASE  `taobao` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
--
--drop database taobao;
--CREATE DATABASE  `taobao` DEFAULT CHARACTER SET gbk COLLATE gbk_chinese_ci;

--create table xxx(id int not null);
--drop table xxx;
--
--set GLOBAL storage_engine=InnoDB;
--set GLOBAL storage_engine=MYISAM;
--create table xbxb3(xbxbid int not null);

--clean up table 
delete from TaobaoItem

--how many records in table TaobaoItem ?
select count(*) from taobao.TaobaoItem

select count(*) from taobao.TaobaoItem ti where ti.sale > 10000

select * from taobao.TaobaoItem ti order by ti.sale desc limit 0,100