CREATE TABLE addresses_by(
id_address integer not null primary key autoincrement,
address varchar(40) not null
);

CREATE TABLE addresses_rus(
id_address integer not null primary key autoincrement,
address varchar(40) not null
);

CREATE TABLE addresses_usa(
id_address integer not null primary key autoincrement,
address varchar(40) not null
);

CREATE TABLE cities_by(
id_city integer not null primary key autoincrement,
city varchar(40) not null,
"index" integer not null
);

CREATE TABLE cities_rus(
id_city integer not null primary key autoincrement,
city varchar(40) not null,
"index" integer not null
);

CREATE TABLE cities_usa(
id_city integer not null primary key autoincrement,
city varchar(40) not null,
"index" integer not null
);

CREATE TABLE "names_by" (
"id_name" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
"name" VARCHAR(40) NOT NULL
);

CREATE TABLE "names_rus" (
"id_name" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
"name" VARCHAR(40) NOT NULL
);

CREATE TABLE "names_usa" (
"id_name" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
"name" VARCHAR(40) NOT NULL
);

CREATE TABLE phones_by(
id_phone integer not null primary key autoincrement,
phone varchar(15) not null
);

CREATE TABLE phones_rus(
id_phone integer not null primary key autoincrement,
phone varchar(15) not null
);

CREATE TABLE phones_usa(
id_phone integer not null primary key autoincrement,
phone varchar(15) not null
);