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

첨부파일 데이터 입력:
```
insert into test2(filepath, bno) values('c:/download/a.gif', 1);
insert into test2(filepath, bno) values('c:/download/b.gif', 1);
insert into test2(filepath, bno) values('c:/download/c.gif', 1);
insert into test2(filepath, bno) values('c:/download/d.gif', 5);
insert into test2(filepath, bno) values('c:/download/e.gif', 5);
insert into test2(filepath, bno) values('c:/download/f.gif', 10);
```

## FK 제약 조건이 없을 때
- 첨부파일 데이터를 입력할 때 존재하지 않는 게시물 번호가 들어 갈 수 있다.
- 그러면 첨부파일 데이터를 무효한 데이타 된다.
```
insert into test2(filepath, bno) values('c:/download/x.gif', 100);
```

- 첨부 파일이 있는 게시물이 삭제될 수 있다.
- 마찬가지로 게시물이 존재하지 않는 첨부파일 데이터이기 때문에 무효한 데이터가 된다.
```
delete from test1 where no=1;
```

## FK(foreign key) 제약 조건 설정
- 다른 테이블의 데이터와 연관된 데이터를 저장할 때 무효한 데이터가 입력되지 않도록 하는 문법이다.
- 다른 테이블의 데이터가 참조하는 데이터를 임의의 지우지 못하도록 하는 문법이다.
- 그래서 데이터의 무결성(data integrity; 결함이 없는 상태)을 유지하게 도와주는 문법이다.


다른 테이블의 PK를 참조하는 컬럼으로 선언한다.
```
alter table 테이블명
    add constraint 제약조건이름 foreign key (컬럼명) references 테이블명(컬럼명);

예)
/* 기존에 테이블에 무효한 데이터가 있을 수 있기 때문에 먼저 테이블의 데이터를 지운다.*/
delete from test2;

alter table test2
    add constraint test2_bno_fk foreign key (bno) references test1(no);
```

위와 같이 test2 테이블에 FK 제약 조건을 건 다음에 데이터를 입력해보자!
```
/* 1번 게시물이 존재하지 않기 때문에 데이터를 입력할 수 없다 */
insert into test2(filepath, bno) values('c:/download/a.gif', 1);
insert into test2(filepath, bno) values('c:/download/b.gif', 1);
insert into test2(filepath, bno) values('c:/download/c.gif', 1);

/* 5번, 10번 게시물은 존재하기 때문에 첨부파일 데이터를 입력할 수 있다.*/
insert into test2(filepath, bno) values('c:/download/d.gif', 5);
insert into test2(filepath, bno) values('c:/download/e.gif', 5);
insert into test2(filepath, bno) values('c:/download/f.gif', 10);

/* 2번 게시물은 test2 테이블의 데이터들이 참조하지 않기 때문에 마음대로 지울 수 있다.*/
delete from test1 where no=2; -- OK!

/* 그러나 5번 게시물은 삭제할 수 없다. 왜? test2 테이블의 데이터 중 일부가 참조하기 때문이다.*/
delete from test1 where no=5; -- Error!
```

## 용어 정리 
- test1 처럼 다른 테이블에 의해 참조되는 테이블을 '부모 테이블'이라 부른다.
- test2 처럼 다른 테이블의 데이터를 참조하는 테이블을 '자식 테이블'이라 부른다.























