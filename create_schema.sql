drop table geek if exists cascade;
drop sequence geek_seq if exists;
drop table GEEK_INTEREST if exists cascade;
drop table interest if exists cascade;
drop sequence interest_seq if exists;

create table geek (
	id numeric not null,
	name varchar(255) not null,
	firstname varchar(255) not null,
	gender boolean not null,
	mail varchar(255) not null,
	city varchar(255) not null,
	primary key(id)
);

create sequence geek_seq start with 0;

create table interest (
	id numeric not null,
	interest varchar(20) not null,
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