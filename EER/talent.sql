create database if not exists project_module_6_sprint_2;
use project_module_6_sprint_2;

create table if not exists user(
	username varchar(30) primary key,
    password varchar(200),
    is_delete bit default 0
);

create table  if not exists role(
	id int primary key auto_increment,
    name varchar(30),
    is_delete bit default 0
);

create table if not exists user_role(
	username varchar(50),
    role_id int,
    is_delete bit default 0,
    foreign key(username) references user(username),
    foreign key(role_id) references role(id),
    primary key(username, role_id)
);

create table if not exists talent_type(
	id int primary key auto_increment,
    name varchar(30),
    is_delete bit default 0
);

create table if not exists talent(
	id int primary key auto_increment,
    name varchar(100),
    prime int,
    discount int,
    decription_talent text,
    image text,
	is_delete bit default 0,
    talent_type_id int,
    foreign key(talent_type_id) references talent_type(id)
);


create table if not exists customer(
	id int primary key auto_increment,
	name varchar(100),
	is_delete bit default 0,
	email varchar(100),
	address varchar(200),
	phone_number varchar(15),
	username varchar(30) unique,
	foreign key (username) references user(username)
);

create table if not exists booking(
id int primary key auto_increment,
status bit default 0,
 date_payment datetime,
  customer_id int,
    talent_id int,
 foreign key (customer_id) references customer(id),
foreign key (talent_id) references talent(id)
);

create table if not exists employee(
	id int primary key auto_increment,
	name varchar(100),
	is_delete bit default 0,
	birthday varchar(30),
	gender int,
	id_card varchar(12),
	email varchar(100),
	address varchar(200),
	phone_number varchar(15),
	username varchar(30) unique,
	foreign key (username) references user(username)
);

