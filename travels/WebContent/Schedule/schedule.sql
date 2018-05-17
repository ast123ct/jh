CREATE TABLE SCHEDULE(
	sch_no number, 	--일정 번호(pk)
	user_no number not null, --회원번호(참조)
	start_date date not null, --일정 시작 일자
	end_date date not null, --일정 종료 일자
	sch_title varchar2(45) not null, --일정 제목
	sch_content varchar2(3000) not null, --일정에 대한 내용,메모
	sch_review varchar2(3000) , --일정에대한 후기
	constraint schedule_sch_no_pk primary key(sch_no), --sch_no를 pk로 설정
	constraint schedule_user_no_fk foreign key(user_no) references client(user_no)
	--user_no를 fk로 설정 user 테이블의 user_no 참조하도록
) --생성 완료

create table sch_detail(
	detail_no number, --세부 일정 번호(pk)
	user_no number not null,-- 회원번호(참조)
	sch_no number not null,	--일정 번호 (참조)
	travel_no number not null,--여행 번호(참조)
	festival_no number not null, --축제 번호(참조)
	det_content varchar2(3000), --세부 일정 내용
	det_start date, --세부 일정 시작 시간(안쓸수도 있음)
	det_end date, --세부 일정 종료 시간(안쓸수도 있음)
	det_date date, --세부 일정 날짜
	constraint detail_user_no_fk foreign key(user_no) references client(user_no), 
	constraint detail_no_pk primary key(detail_no), --세부 일정 번호 pk로 설정
	constraint detail_sch_no_fk foreign key(sch_no) references schedule(sch_no), --sch_no 참조키로 설정
	constraint detail_travel_no_fk foreign key(travel_no) references travel_information(travel_no), --travel_no 참조키로 설정
	constraint detail_festival_no_fk foreign key(festival_no) references festival_information(festival_no) --festival_no 참조키로 설정	
)



create table client(user_no number primary key) --생성 완료
create table travel_information(travel_no number primary key) --생성 완료
create table festival_information(Festival_no number primary key) --생성 완료

drop table client;
select * from schedule
drop table schedule;



create table test(date_test date, char_test varchar2(20));
insert into test values( TO_DATE('19550405'),'예제');
SELECT * FROM TEST;
commit
alter table schedule modify sch_content not null;
alter table schedule modify sch_review  null;
insert into schedule (sch_no,start_date,end_date,sch_title,sch_content) values(1,to_date('19990502'),to_date('2005/04/05'), '바보','바보야');
