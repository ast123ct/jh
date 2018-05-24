drop table bus_list;
drop table bus_schedule;

create sequence bus_no_seq
increment by 1
start with 1;

create table bus_list(
	bus_area		varchar2(20) not null,
	bus_no			number primary key,
	bus_linename	varchar2(30) not null,
	bus_start		varchar2(30) not null,
	bus_end			varchar2(30) not null,
	bus_traveltime	varchar2(10) not null,
	bus_cost_ad		number not null,
	bus_cost_st		number not null,
	bus_cost_ch		number not null
)
delete from bus_list;

select*from bus_list;

select*from bus_list where bus_area='Seoul' and bus_start='남부터미널';


select * from bus_list natural join bus_Seoul_schedule where bus_no=18
from bus_list natural join bus_Seoul_schedule where bus_no=18;

select*from bus_list natural join bus_Seoul_schedule where bus_no=18 order by bus_no;

select*from bus_list natural join bus_schedule where bus_no=1;

insert into bus_list values('Seoul',bus_no_seq.nextval,'서울발충주행','동서울터미널','충주터미널',
	'02:20',15000,10000,5000);
insert into bus_list values('Seoul',bus_no_seq.nextval,'서울발목포행','동서울터미널','목포터미널',
	'02:20',15000,10000,5000);
	
insert into bus_list values('Seoul',bus_no_seq.nextval,'서울발전주행','남부터미널','전주터미널',
	'02:20',15000,10000,5000);
insert into bus_list values('Incheon',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Daejeon',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Busan',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Daegu',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Gwangju',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Ulsan',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Sejong',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Jeju',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Gyeonggi',bus_no_seq.nextval,'경기발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Gangwon',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Chungbuk',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Chungnam',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Jeonbuk',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Jeonnam',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Gyeongbuk',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Gyeongnam',bus_no_seq.nextval,'서울발경주행','남부터미널','경주터미널',
	'03:00',18000,13000,8000);

insert into bus_list values('Seoul',bus_no_seq.nextval,'서울발강릉행','남부터미널','강릉터미널',
	'02:20',15000,10000,5000);
insert into bus_list values('Incheon',bus_no_seq.nextval,'인천발경주행','인천터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Daejeon',bus_no_seq.nextval,'대전발경주행','대전터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Busan',bus_no_seq.nextval,'부산발경주행','부산터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Daegu',bus_no_seq.nextval,'대구발경주행','대구터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Gwangju',bus_no_seq.nextval,'광주발경주행','광주터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Ulsan',bus_no_seq.nextval,'울산발경주행','울산터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Sejong',bus_no_seq.nextval,'세종발경주행','세종터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Jeju',bus_no_seq.nextval,'제주발서귀포행','제주터미널','서귀포터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Gyeonggi',bus_no_seq.nextval,'경기발충주행','경기터미널','충주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Gangwon',bus_no_seq.nextval,'광주발경주행','광주터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Chungbuk',bus_no_seq.nextval,'충북발만주행','충북터미널','만주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Chungnam',bus_no_seq.nextval,'충남발경주행','충남터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Jeonbuk',bus_no_seq.nextval,'전북발경주행','전북터미널','경주터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Jeonnam',bus_no_seq.nextval,'전남발천국행','전남터미널','천국터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Gyeongbuk',bus_no_seq.nextval,'경북발경남행','경북터미널','경남터미널',
	'03:00',18000,13000,8000);
insert into bus_list values('Gyeongnam',bus_no_seq.nextval,'경남발경주행','경남터미널','경주터미널',
	'03:00',18000,13000,8000);