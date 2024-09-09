use gb;
drop table user;

create table reservationInfo(
	resnum int primary key auto_increment,
    userid varchar(300),
    hotelnum int,
    roomnum int,
    checkin datetime,
    checkout datetime,
    days int,
    usepoolcnt int,
    usehealthcnt int,
    price int,
    constraint user_fk foreign key(userid) references user(userid),
    constraint hotel_fk foreign key(hotelnum) references hotel(hotelnum),
    constraint room_fk foreign key(roomnum) references room(roomnum)
);
create table hotel(
	hotelnum int primary key auto_increment,
    hotelname varchar(300)
);
create table room(
	roomnum int primary key,
    type varchar(300),
    price int
);
create table user(
	userid varchar(300) primary key,
    userpw varchar(300) not null,
    username varchar(300) not null,
    userphone varchar(300),
    userage int,
    gender char(1) check (gender in('M','F','m','f')),
    credit int
);
create table blacklist(
	reason varchar(2000),
	userid varchar(300),
    userphone varchar(300),
    constraint user_fk2 foreign key(userid) references user(userid)
);