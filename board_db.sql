create database board_db;

use board_db;

create table `Users` (
	id bigint auto_increment primary key,
    user_id varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null unique,
    name varchar(255) not null,
    phone varchar(255) not null,
    gender enum('M', 'F')    
);

create table if not exists Articles(
   id bigint auto_increment primary key,
    title varchar(255) not null,
    content text not null,
    author_id bigint not null,
    foreign key(author_id) references users(id) on delete cascade
);


create table `Comments` (
	id bigint auto_increment primary key,
    article_id bigint not null,
    commenter_id bigint not null,
    content text not null,
    foreign key (article_id) references `Articles` (id) on delete cascade,
    foreign key (commenter_id) references `Users` (id) on delete cascade
);

