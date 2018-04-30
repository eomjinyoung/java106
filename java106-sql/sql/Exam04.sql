# FK(Foreign Key)
- 다른 테이블의 PK를 참조하는 컬럼이다.

```
/* 게시판 테이블 */
create table test1(
  no int not null primary key auto_increment,
  title varchar(255) not null,
  content text,
  rdt datetime not null
);

/* 첨부 파일 테이블 */
create table test2(
  fno int not null primary key auto_increment, /* 첨부파일 고유번호 */
  filepath varchar(255) not null, /* 파일시스템에 저장된 첨부파일의 경로 */
  bno int not null /* 게시판 번호 */
);
```

게시판 데이터 입력:
```
insert into test1(title,rdt) values('aaa', now());
insert into test1(title,rdt) values('bbb', now());
insert into test1(title,rdt) values('ccc', now());
insert into test1(title,rdt) values('ddd', now());
insert into test1(title,rdt) values('eee', now());
insert into test1(title,rdt) values('fff', now());
insert into test1(title,rdt) values('ggg', now());
insert into test1(title,rdt) values('hhh', now());
insert into test1(title,rdt) values('iii', now());
insert into test1(title,rdt) values('jjj', now());
```


















