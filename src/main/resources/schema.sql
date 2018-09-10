create table ticket
(
   seat_number integer not null,
   seat_rank integer not null,
   status varchar(255) not null,
   hold_id integer,
   confirmation_code varchar(255),
   email varchar(255),
   primary key(seat_number),
   last_updated_time timestamp
);