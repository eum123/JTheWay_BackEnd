-- create database
CREATE DATABASE jtheway_db;

-- create user
CREATE USER 'jtheway'@'localhost' IDENTIFIED BY 'jtheway01';

-- insert , update, delete etc
GRANT ALL PRIVILEGES on jtheway_db.* TO 'jtheway'@'localhost';
FLUSH PRIVILEGES;

-- sample table
create table sample (
	name varchar (10) not null, 
    age int(3) default 0,
    PRIMARY KEY (name)
) default charset=utf8;

insert into sample values('hong', 30);

