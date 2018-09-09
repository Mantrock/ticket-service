create table student
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);

create table ticket
(
   seat_number integer not null,
   seat_rank integer not null,
   status varchar(255) not null,
   hold_id integer,
   confirmation_code varchar(255),
   email varchar(255),
   primary key(seat_number)
);