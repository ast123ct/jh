select*from tab;
purge recyclebin;

create table bus_Seoul_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Seoul foreign key(bus_no) 
	references bus_list(bus_no)
)
insert into bus_Seoul_schedule values(18,1,'06:00','08:00');
insert into bus_Seoul_schedule values(18,2,'07:00','09:00');
insert into bus_Seoul_schedule values(18,3,'08:00','10:00');
insert into bus_Seoul_schedule values(18,4,'09:00','11:00');
insert into bus_Seoul_schedule values(18,5,'10:00','12:00');
insert into bus_Seoul_schedule values(18,6,'11:00','13:00');
insert into bus_Seoul_schedule values(18,7,'12:00','14:00');
insert into bus_Seoul_schedule values(18,8,'13:00','15:00');
insert into bus_Seoul_schedule values(35,1,'13:00','15:00');

select*from bus_Seoul_schedule;
delete from bus_Seoul_schedule where bus_no=80;
insert into bus_Seoul_schedule values(75,1,'13:00','15:00');
update bus_Seoul_schedule set bus_seq=3, bus_departure='13:02', bus_arrival='13:05' where bus_no=75;
select*from BUS_SEOUL_SCHEDULE where bus_no=80;
select*from bus_list natural join bus_Seoul_schedule where bus_no=77 and bus_seq=1;

create table bus_Incheon_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Incheon foreign key(bus_no) 
	references bus_list(bus_no)
)


create table bus_Daejeon_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Daejeon foreign key(bus_no) 
	references bus_list(bus_no)
)


create table bus_Busan_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Busan foreign key(bus_no) 
	references bus_list(bus_no)
)


create table bus_Daegu_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Daegu foreign key(bus_no) 
	references bus_list(bus_no)
)
create table bus_Gwangju_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Gwangju foreign key(bus_no) 
	references bus_list(bus_no)
)
create table bus_Ulsan_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Ulsan foreign key(bus_no) 
	references bus_list(bus_no)
)


create table bus_Sejong_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Sejong foreign key(bus_no) 
	references bus_list(bus_no)
)


create table bus_Jeju_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Jeju foreign key(bus_no) 
	references bus_list(bus_no)
)


create table bus_Gyeonggi_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Gyeonggi foreign key(bus_no) 
	references bus_list(bus_no)
)


create table bus_Gangwon_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Gangwon foreign key(bus_no) 
	references bus_list(bus_no)
)

+

create table bus_Chungbuk_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Chungbuk foreign key(bus_no) 
	references bus_list(bus_no)
)


create table bus_Chungnam_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Chungnam foreign key(bus_no) 
	references bus_list(bus_no)
)


create table bus_Jeonbuk_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Jeonbuk foreign key(bus_no) 
	references bus_list(bus_no)
)


create table bus_Jeonnam_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Jeonnam foreign key(bus_no) 
	references bus_list(bus_no)
)


create table bus_Gyeongbuk_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Gyeongbuk foreign key(bus_no) 
	references bus_list(bus_no)
)


create table bus_Gyeongnam_schedule(
	bus_no			number not null,
	bus_seq			number not null,
	bus_departure	varchar2(10) not null,
	bus_arrival		varchar2(10) not null,
	
	constraint fk_no_Gyeongnam foreign key(bus_no) 
	references bus_list(bus_no)
)



insert into bus_schedule values(1,1,'06:00','08:20');
insert into bus_schedule values(1,2,'06:30','08:50');

insert into bus_schedule values(2,1,'05:00','08:00');
insert into bus_schedule values(2,2,'06:00','09:00');





insert into bus_schedule values(1,1,'06:00','08:20');
insert into bus_schedule values(1,2,'06:30','08:50');

insert into bus_schedule values(2,1,'05:00','08:00');
insert into bus_schedule values(2,2,'06:00','09:00');
