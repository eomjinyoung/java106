# 변경 내역
- build.gradle 변경
- eclipse 설정 파일 갱신
- pms_board 테이블 생성
```
drop table pms_board;

create table pms_board (
    bno int not null,
    titl varchar(255) not null,
    cont text,
    cdt datetime not null
);

alter table pms_board
    add constraint pms_board_pk primary key (bno);

alter table pms_board
    modify column bno int not null auto_increment;   
```
- Board.java 변경
- BoardXxxController.java 변경
- pms_member 테이블 생성
```
drop table pms_member;

create table pms_member (
    mid varchar(20) not null,
    email varchar(255) not null,
    pwd varchar(100) not null
);

alter table pms_member
    add constraint pms_member_pk primary key (mid);
```
- Member.java 변경 


