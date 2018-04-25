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
- BoardDao.java 변경
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
- MemberDao.java 변경
- MemberXxxController.java 변경
- pms_classroom 테이블 생성
```
drop table pms_classroom;

create table pms_classroom (
    crno int not null,
    titl varchar(255) not null,
    sdt datetime not null,
    edt datetime not null,
    room varchar(50)
);

alter table pms_classroom
    add constraint pms_classroom_pk primary key (crno);
    
alter table pms_classroom
    modify column crno int not null auto_increment;
```
- Classroom.java 변경
- ClassroomDao.java 변경
- ClassroomXxxController.java 변경
- pms_team 테이블 생성
```
drop table pms_team;

create table pms_team (
    name varchar(100) not null,
    dscrt text,
    max_qty int not null,
    sdt datetime not null,
    edt datetime not null
);

alter table pms_team
    add constraint pms_team_pk primary key (name);
```
- Team.java 변경
- TeamDao.java 변경
- TeamXxxController.java 변경
- pms_task 테이블 생성
```
drop table pms_task;

create table pms_task (
    tano int not null,
    titl varchar(255) not null,
    sdt datetime not null,
    edt datetime not null,
    stat int default 0,
    mid varchar(20) not null,
    tnm varchar(100) not null
);

alter table pms_task
    add constraint pms_task_pk primary key (tano);

alter table pms_task
    modify column tano int not null auto_increment;
```
- Task.java 변경
- TaskDao.java 변경
- TaskXxxController.java 변경
- pms_team_member 테이블 생성
```
drop table pms_team_member;

create table pms_team_member (
    tnm varchar(100) not null,
    mid varchar(20) not null
);

alter table pms_team_member
    add constraint pms_team_member_pk primary key (tnm, mid);
```
- AbstractDao.java 삭제









