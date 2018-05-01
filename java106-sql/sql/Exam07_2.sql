/* order by */

/* 기본 인덱스 컬럼을 기준으로 정렬한다.*/
select rno, loc, name 
from room;

/* 이름의 오름 차순으로 정렬하기 */
select rno, loc, name 
from room
order by name asc;

/* asc는 생략 가능하다. */
select rno, loc, name 
from room
order by name;

/* 이름의 내림 차순으로 정렬하기 */
select rno, loc, name 
from room
order by name desc;

/* 이름은 오름차순, 지점명도 오름차순으로 정렬하기*/
select rno, loc, name 
from room
order by name asc, loc asc;

/* 이름은 오름차순, 지점명은 내림차순으로 정렬하기*/
select rno, loc, name 
from room
order by name asc, loc desc;

/* 지점명은 오름차순으로, 이름은 오름차순  정렬하기*/
select rno, loc, name 
from room
order by loc asc, name asc;











