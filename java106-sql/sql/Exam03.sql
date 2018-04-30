# DQL(Data Query Language)
데이터를 조회할 때 사용하는 문법

## 테스트 용 테이블 및 데이터 준비
```
create table test1 (
  no int primary key auto_increment,
  name varchar(20) not null,
  class varchar(10) not null,
  working char(1) not null,
  tel varchar(20)
);

insert into test1(name,class,working) values('aaa','java100','Y');
insert into test1(name,class,working) values('bbb','java100','N');
insert into test1(name,class,working) values('ccc','java100','Y');
insert into test1(name,class,working) values('ddd','java100','N');
insert into test1(name,class,working) values('eee','java100','Y');
insert into test1(name,class,working) values('kkk','java101','N');
insert into test1(name,class,working) values('lll','java101','Y');
insert into test1(name,class,working) values('mmm','java101','N');
insert into test1(name,class,working) values('nnn','java101','Y');
insert into test1(name,class,working) values('ooo','java101','N'); 
```

## select
- 테이블의 데이터를 조회할 때 사용하는 명령이다.
```
/* 모든 컬럼 값 조회하기. 컬럼 순서는 테이블을 생성할 때 선언한 순서이다.*/
select * from 테이블;
select * from test1;

/* 특정 컬럼의 값만 조회할 때*/
select 컬럼명,컬럼명 from 테이블;
select no, name, tel from test1;

/* 가상의 컬럼 값을 조회하기*/
select no, concat(name,'(',class,')') from test1;
```

### 조회하는 컬럼에 별명 붙이기 
- 별명을 붙이지 않으면 원래의 컬럼명이 조회 결과의 컬럼이름으로 사용된다.
- 위의 예제처럼 복잡한 식으로 표현한 컬럼인 경우 컬럼명도 그 식이 된다.
- 이런 경우 별명을 붙이면 조회 결과를 보기 쉽다.

```
/* 컬럼에 별명 붙이기*/
select 컬럼명 [as] 별명 ...
select 
    no as num, 
    concat(name,'(',class,')') as title 
from test1; 

/* as를 생략해도 된다.*/
select 
    no as num, 
    concat(name,'(',class,')') title 
from test1; 
``` 

### 조회할 때 조건 지정하기
- where 절과 연산자를 이용하여 조회 조건을 지정할 수 있다.

```
select ... from ... where 조건...
select * 
from test1
where no > 5;
```

## 연산자

### OR, AND, NOT
- OR : 두 조건 중에 참인 것이 있으면 조회 결과에 포함시킨다.
- AND : 두 조건 모두 참일 때만 조회 결과에 포함시킨다.
- NOT : 조건에 일치하지 않을 때만 결과에 포함시킨다.
```
select * from test1;

/* 재직자 또는 java100기 학생만 조회하라!*/
select no, name
from test1
where working='Y' or class='java100';

/* java100기 학생 중에 재직자만 조회하라!*/
select no, name
from test1
where working='Y' and class='java100';

/* 재직자가 아닌 사람만 조회하라!*/
select no, name
from test1
where not working = 'Y';

select no, name
from test1
where working != 'Y';

select no, name
from test1
where working <> 'Y';

/* 학생 번호가 짝수인 경우 전화 번호를 '1111'로 변경하라*/
update test1 set 
    tel = '1111'
where (no % 2) = 0;

/* 학생 번호가 3의 배수인 경우 전화번호를 '2222'로 변경하라*/
update test16 set
  tel = '2222'
where (no % 3) = 0;

/* 전화 번호가 있는 학생만 조회하라!*/
/* => 다음과 같이 null에 != 연산자를 사용하면 조건이 맞지 않는다.*/
select *
from test1
where tel != null; 

/* => null인지 여부를 가릴 때는 is 또는 is not 연산자를 사용하라!*/
select *
from test1
where tel is not null;

select *
from test1
where not (tel is null);

/* 전화 번호가 없는 학생만 조회하라!*/
/* => null인지 여부를 가릴 때는 = 연산자가 아닌 is 연산자를 사용해야 한다.*/
select *
from test1
where tel = null; /* 실패 */

select *
from test1
where tel is null; /* OK */

```

### 사칙연산
- +, -, *, /, % 연산자를 사용할 수 있다.
```
select (4 + 5), (4 - 5), (4 * 5), (4 / 5), (4 % 5);
```

### 비교연산
_ =, !=, >, >=, <, <=, <> 
```
select (4=5), (4!=5), (4>5), (4>=5), (4<5), (4<=5), (4<>5);
```

### between 값1 and 값2 
- 두 값 사이(두 값도 포함)에 있는지 검사한다.
```
select 5 between 3 and 5;
```

### like
- 문자열을 비교할 때 사용한다.
```
insert into test1(name,class,working) values('xxx', 'window27', '1');
insert into test1(name,class,working) values('yyy', 'window27', '0');
insert into test1(name,class,working) values('zzz', 'window28', '1');
insert into test1(name,class,working) values('qqq', 'window28', '0');
insert into test1(name,class,working) values('s01', 'javawin1', '1');
insert into test1(name,class,working) values('s02', 'javawin1', '0');
insert into test1(name,class,working) values('s03', 'javawin1', '0');
insert into test1(name,class,working) values('s04', 'iotjava5', '1');
insert into test1(name,class,working) values('s05', 'iotjava5', '0');
insert into test1(name,class,working) values('s06', 'iotjava5', '0');
insert into test1(name,class,working) values('s011', 'iotjava5', '1');
insert into test1(name,class,working) values('s012', 'iotjava5', '1');
insert into test1(name,class,working) values('s013', 'iotjava5', '1');

/* class 이름이 java로 시작하는 모든 학생 조회하기 */
select *
from test1
where class like 'java%';

/* class 이름에 java를 포함한 모든 학생 조회하기 
   이 경우 조회 속도가 느리다.*/
select *
from test1
where class like '%java%';

/* class 이름이 101로 끝나는 반의 모든 학생 조회하기 */
select *
from test1
where class like '%101';

/* 학생의 이름에서 첫번째 문자가 s이고 두번째 문자가 0인 학생 중에서
   딱 세자의 이름을 가진 학생을 모두 조회하라!*/

/* => %는 0자 이상을 의미하기 때문에 이 조건에 맞지 않다.*/
select *
from test1
where name like 's0%';

/* => _는 딱 1자를 의미한다.*/
select *
from test1
where name like 's0_';
```

### 날짜 다루기
- 날짜 함수와 문자열 함수를 사용하여 날짜 값을 다루는 방법.
```
create table test1 (
  no int not null,
  title varchar(200) not null,
  content text,
  regdt datetime not null
);

alter table test1
  add constraint primary key (no),
  modify column no int not null auto_increment;

insert into test1(title, regdt) values('aaaa', '2017-01-27');
insert into test1(title, regdt) values('bbbb', '2017-2-2');
insert into test1(title, regdt) values('cccc', '2017-2-13');
insert into test1(title, regdt) values('dddd', '2017-3-2');
insert into test1(title, regdt) values('eeee', '2017-4-15');
insert into test1(title, regdt) values('ffff', '2017-6-7');
insert into test1(title, regdt) values('gggg', '2017-6-17');
insert into test1(title, regdt) values('hhhh', '2017-6-27');
insert into test1(title, regdt) values('iiii', '2017-9-5');
insert into test1(title, regdt) values('jjjj', '2017-10-12');
insert into test1(title, regdt) values('kkkk', '2017-11-22');
insert into test1(title, regdt) values('llll', '2017-11-24');
insert into test1(title, regdt) values('mmmm', '2017-12-31');
```

- 날짜 값 비교하기
```
/* 특정 날짜의 게시글 찾기 */
select * 
from test1
where regdt = '2017-6-17';

/* 특정 기간의 게시글 조회 */
select * 
from test1
where regdt between '2017-11-1' and '2017-12-31';

select * 
from test1
where regdt >= '2017-11-1' and regdt <= '2017-12-31';
```

- 날짜를 다루는 연산자와 함수
```
/* 현재 날짜 및 시간 알아내기 */
select now();

/* 현재 날짜 알아내기 */
select curdate();

/* 현재 시간 알아내기 */
select curtime();

/* 주어진 날짜, 시간에서 날짜만 뽑거나 시간만 뽑기 */
select regdt, date(regdt), time(regdt) from test1;

/* 특정 날짜에 시,분,초,일,월,년을 추가하거나 빼기*/
date_add(날짜데이터, interval 값 단위);
date_sub(날짜데이터, interval 값 단위);

select date_add(now(), interval 11 day);
select date_sub(now(), interval 11 day);

/* 두 날짜 사이의 간격을 알아내기 */
datediff(날짜1, 날짜2);
select datediff(curdate(), '2018-3-19');

/* 날짜에서 특정 형식으로 값을 추출하기 */
date_format(날짜, 형식)
select date_format(now(), '%m/%e/%Y'); /* 09/7/2017 */
select date_format(now(), '%M/%d/%y'); /* September/07/17 */
select date_format(now(), '%W %w %a'); /* Thursday 4 Thu */
select date_format(now(), '%M %b'); /* September Sep */
select date_format(now(), '%p %h %H %l'); /* PM 01 13 1 */
select date_format(now(), '%i %s'); /* 05 45 */

/* 문자열을 날짜 값으로 바꾸기 */
select str_to_date('11/22/2017', '%m/%d/%Y');
select str_to_date('2017.2.12', '%Y.%m.%d');


/* 날짜 값을 저장할 때 기본 형식은 yyyy-MM-dd이다. */
insert into test1 (title, regdt) values('aaaa', '2017-11-22');

/* 다음 형식의 문자열을 날짜 값으로 지정할 수 없다.*/
insert into test1 (title, regdt) values('bbbb', '11/22/2017');

/* 위 형식의 문자열을 날짜 값으로 저장하려면 str_to_date() 함수를 사용해야 한다.*/
insert into test1 (title, regdt) 
  values('bbbb', str_to_date('11/22/2017', '%m/%d/%Y'));
```



















