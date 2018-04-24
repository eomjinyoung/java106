# 변경 내역
- build.gradle 변경
- eclipse 설정 파일 갱신
- pms_board 테이블 생성
```
create table pms_board (
    bno int not null,
    titl varchar(255) not null,
    content text,
    cdt datetime not null
);

alter table pms_board
    add constraint pms_board_pk primary key (bno);

alter table pms_board
    modify column bno int not null auto_increment;   
```
- Board.java 변경



