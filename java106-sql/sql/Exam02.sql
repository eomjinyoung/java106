# DML(Data Manipulation Language)
데이터 등록, 변경, 삭제를 다루는 SQL 문법

## insert
- 데이터를 입력할 때 사용하는 문법이다.

```
/* 연락처 테이블 생성 */
create table test1 (
  no int not null,
  name varchar(20) not null,
  tel varchar(20) not null,
  fax varchar(20),
  pstno varchar(5),
  addr varchar(200)
);

/* PK 컬럼 지정 */
alter table test1
  add constraint primary key (no);

/* 자동 증가 컬럼 지정 */
alter table test1
  modify column no int not null auto_increment;
  
```

- 전체 컬럼 값 입력하기
```
/* 컬럼을 지정하지 않으면 
 * 테이블을 생성할 때 선언한 컬럼 순서대로 
 * 값을 지정해야 한다.*/
insert into 테이블명 value(값,....);
insert into test1 values(null,'aaa','111','222','10101','seoul');

/* 컬럼을 명시할 수 있다. 이때 값을 입력하는 컬럼의 순서를 바꿀 수 있다. */
insert into 테이블명(컬럼,컬럼,...) values(값,값,...);
insert into test1(name,fax,tel,no,pstno,addr) 
    values('bbb','222','111',null,'10101','seoul');
```

- 값을 입력할 컬럼을 선택하기. 단 필수 입력 컬럼은 반드시 선택해야 한다.
```
/* no 컬럼은 필수 입력 컬럼이지만, 
  자동 증가 컬럼이기 때문에 값을 입력하지 않아도 된다.*/
insert into test1(name,tel) values('ccc','333');
```

### select 결과를 테이블에 insert하기
```
create table test2 (
  no int not null primary key auto_increment,
  name varchar(20) not null,
  tel varchar(20) not null,
  kor int,
  eng int,
  math int
);
insert into test2(name,tel)
  select name, tel from test1 where addr='seoul'; 
```

## update 
- 등록된 데이터를 변경할 때 사용하는 명령이다.
```
update 테이블명 set 컬럼명=값, 컬럼명=값, ... where 조건...;
update test1 set pstno='11111', fax='222' where no=3;
update test1 set tel='3030', fax='1212' where no=2;

/* 조건을 지정하지 않으면, 모든 데이터에 대해 변경한다.*/
update test1 set fax='333';
```

## autocommit
mysql은 autocommit의 기본 값이 true이다. 따라서 명령창에서 SQL을 실행하면 바로 실제 테이블에 
적용된다. 수동으로 처리하고 싶다면 autocommit을 false로 설정하라!
```
> set autocommit=false;
```

insert/update/delete을 수행한 후 승인을 해야만 실제 테이블에 적용된다.
```
> commmit;
```

마지막 commit 상태로 되돌리고 싶다면,
```
> rollback;
```

연습1:
```
insert into test1(name, tel) values('xxx', '1111');
insert into test1(name, tel) values('yyy', '2222');
insert into test1(name, tel) values('zzz', '2222');

update test1 set fax='1212' where name='xxx';

delete from test1 where no=1;

rollback; /* 지금까지 작업한 insert, update, delete은 최소된다.*/

```

연습2:
```
insert into test1(name, tel) values('xxx', '1111');
insert into test1(name, tel) values('yyy', '2222');
insert into test1(name, tel) values('zzz', '2222');

update test1 set fax='1212' where name='xxx';

delete from test1 where no=1;

commit; /* 지금까지 한 작업을 테이블에 적용한다.*/

rollback; /* 지금까지 작업한 insert, update, delete은 최소된다.*/
```

## delete
- 데이터를 삭제할 때 사용하는 명령이다.
```
delete from 테이블명 where 조건;
delete from test1 where no=2 or no=3;

/* 조건을 지정하지 않으면 모든 데이터가 삭제된다. 주의!*/
delete from test1;
```

















