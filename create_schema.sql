drop table city if exists cascade;
drop sequence city_seq if exists;
drop table VIEW if exists cascade;
drop table geek if exists cascade;
drop sequence geek_seq if exists;
drop table GEEK_INTEREST if exists cascade;
drop table interest if exists cascade;
drop sequence interest_seq if exists;

create table city (
	id numeric not null,
	city varchar(20) not null,
	primary key(id)
);

create sequence city_seq start with 0;

create table geek (
	id numeric not null,
	name varchar(255) not null,
	firstname varchar(255) not null,
	gender boolean not null,
	mail varchar(255) not null,
	dateOfBirth date not null,
	id_city numeric not null,
	FOREIGN KEY(id_city) REFERENCES public.city (id),
	primary key(id)
);

create sequence geek_seq start with 0;

create table interest (
	id numeric not null,
	interest varchar(20) unique not null,
	primary key(id)
);

create sequence interest_seq start with 0;

create table GEEK_INTEREST (
	id_geek numeric not null,
	id_interest numeric not null,
	FOREIGN KEY(id_geek) REFERENCES public.geek (id),
	FOREIGN KEY(id_interest) REFERENCES public.interest (id),
	primary key(id_geek, id_interest)
);

create table VIEW (
	id_geek numeric not null,
	timestampView timestamp not null,
	ip varchar(37) not null,
	FOREIGN KEY(id_geek) REFERENCES public.geek (id),
	primary key(id_geek, timestampView, ip)
);