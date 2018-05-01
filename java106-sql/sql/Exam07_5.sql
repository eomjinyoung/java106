/* 조인
=> 서로 관련된 테이블의 데이터를 연결하여 추출하는 방법
=> 기법
1) CROSS 조인
2) NATURAL 조인
3) JOIN ~ ON
4) OUTER JOIN
*/

/* cross join : 두 테이블의 데이터를 1:1로 모두 연결한다.*/
select mno, name from memb;
select mno, work, bank from stnt;   

/* => mno가 어떤 테이블의 컬럼인지 지정하지 않으면 실행 오류!*/
select mno, name, mno, work, bank
from memb cross join stnt;

/* => select  컬럼이 두 테이블 모두 있을 경우,
         컬럼명 앞에 테이블명을 명시하여 구분하라!*/ 
select memb.mno, name, stnt.mno, work, bank
from memb cross join stnt;
/* 예전 문법 */
select memb.mno, name, stnt.mno, work, bank
from memb, stnt;


/* => 컬럼명 앞에 테이블명을 붙이면 너무 길다.
         테이블에 별명을 부여하고 
         그 별명을 사용하여 컬럼을 지정하라. */
select m.mno, name, s.mno, work, bank
from memb m cross join stnt s;         
/* 예전 문법 */
select m.mno, name, s.mno, work, bank
from memb m, stnt s;


/* natural join: 같은 이름을 가진 컬럼 값을 기준으로 연결한다. */
select m.mno, name, s.mno, work, bank
from memb m natural join stnt s;   
/* 예전 문법 */
select m.mno, name, s.mno, work, bank
from memb m, stnt s
where m.mno=s.mno;

/* natural join 의 문제점
 * 1) 두 테이블의 조인 기준이 되는 컬럼 이름이 다를 때 연결되지 못한다. 
   2) 상관 없는 컬럼과 이름이 같을 때 잘못 연결된다.
   3) 같은 이름의 컬럼이 여러 개 있을 경우 잘못 연결된다. 
        모든 컬럼의 값이 일치할 경우에만 연결되기 때문이다. */

/* 만약에 두 테이블에 같은 이름을 가진 컬럼이 여러 개 있다면, 
   join ~ using (기준컬럼) 을 사용하여 
   두 테이블의 데이터를 연결할 때 기준이 될 컬럼을 지정한다.*/
select m.mno, name, s.mno, work, bank
from memb m join stnt s using (mno);            
      
/* natural join 의 문제점 2      
   => 두 테이블에 같은 이름의 컬럼이 없을 경우
        연결하지 못한다.*/

/* 만약 두 테이블에 같은 이름을 가진 컬럼이 없으면, 
   natural join을 수행하지 못한다.
   또한 join using 으로도 해결할 수 없다.
   이럴 경우 join ~ on 컬럼a=컬럼b 문법을 사용하여
   각 테이블의 어떤 컬럼과 값을 비교할 것인지 지정하라!*/
select m.mno, name, s.mno, work, bank
from memb m inner join stnt s on m.mno=s.mno;       
/* inner는 생략 가능하다 */
select m.mno, name, s.mno, work, bank
from memb m join stnt s on m.mno=s.mno;
/* 즉 inner join 은 기준 컬럼의 값이 일치할 때만 데이터를 연결한다. */

/* 예전의 조인 문법 = inner join */
select m.mno, name, s.mno, work, bank
from memb m, stnt s
where m.mno=s.mno;       
      

/* [inner] join ~ on 의 문제점
   => 반드시 on 에서 지정한 컬럼의 값이 같을 경우에만 
        두 테이블의 데이터가 연결된다.
   => 같은 값을 갖는 데이터가 없다면 연결되지 않고, 결과로 출력되지 않는다.
*/
/* 전체 강의 목록 */
select lno, titl, rno, mno from lect;

/* 전체 강의실 목록 */
select rno, loc, name from room;

/* 강의 테이블에서 강의명을 가져오고, 강의실 테이블에서 지점명과 강의실명을 가져오자. */
select 
    l.lno, 
    l.titl, 
    r.rno, 
    r.loc, 
    r.name
from lect l inner join room r on l.rno=r.rno;
/* inner join의 문제는 위의 경우처럼 
   강의실이 아직 지정되지 않은 강의의 경우 강의실 테이블의 데이터와 연결하지 못해 
   결과로 출력되지 않는 문제가 있다. */



/* => 만약 기준 컬럼의 값과 일치하는 데이터가 없어서 
      다른 테이블의 데이터와 연결되지 않았다 하더라도 
      결과로 뽑아내고 싶다면 outer join을 사용하라!*/
/* 즉 아직 강의실이 배정되지 않은 강의 데이터도 출력하고 싶을 때
   출력하고 싶은 테이블을 바깥쪽 테이블로 지정하라!
 */
select 
    l.lno, 
    l.titl, 
    r.rno, 
    r.loc, 
    r.name
from lect l left outer join room r on l.rno=r.rno;
/* 왼쪽 테이블인 lect를 기준으로 room 데이터를 연결한다. 
 * 만약 lect와 일치하는 데이터가 room에 없더라도 
 * lect 데이터를 출력한다!
 */


/* 요구사항:
   모든 멤버의 번호와 이름을 출력하라!  
   단 학생의 경우 재직여부도 출력하라!*/
    
/* 다음 질의문은 안타깝게도 학생 목록만 출력한다.
    왜? memb테이블의 데이터와 stnt 테이블의 데이터를 
    추출할 때 mno가 같은 데이터만 추출한다.*/
select m.mno, name, work
from memb m join stnt s on m.mno=s.mno;                     
      
/* 상대 테이블(stnt)에 연결할 대상(데이터)이 없더라도
    select에서 추출하는 방법 */
select m.mno, name, work
from memb m left outer join stnt s on m.mno=s.mno;           




/* 여러 테이블의 데이터를 연결하기
    => 다음의 결과가 출력될 수 있도록 수강 신청 데이터를 출력하시오!
    수강신청번호, 강의명, 학생명, 재직여부, 수강신청일, 강의실명, 매니저명, 직위 */

/* 1단계: 수강신청 데이터를 출력 */
select la.lano, la.lno, la.mno, la.rdt
from lect_appl la;     
 
/* 2단계: 수강신청한 학생의 번호 대신 이름을 출력 */
select la.lano, la.lno, m.name, la.rdt
from lect_appl la 
     inner join memb m on la.mno=m.mno;

/* 3단계: 수강 신청한 학생의 재직 여부 출력
 * => inner join 에서 inner는 생략 가능 
 */
select la.lano, la.lno, m.name, s.work, la.rdt
from lect_appl la 
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno;
  
/* 4단계: 수상신청한 강의 번호 대신 강의명을 출력 */
select la.lano, l.titl, m.name, s.work, la.rdt
from lect_appl la 
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno 
        join lect l on la.lno=l.lno;

/* 5단계: 강의실 이름을 출력한다.
 * => 강의실 번호는 lect 테이블 데이터에 있다.
 * => 강의실 이름은 room 테이블 데이터에 있다. 
 */
select la.lano, l.titl, m.name, s.work, la.rdt, r.name
from lect_appl la 
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno 
        join lect l on la.lno=l.lno
        left outer join room r on l.rno=r.rno;

/* 6단계: 매니저 이름을 출력
 * => 매니저 번호는 lect 테이블에 있다.
 * => 매니저 이름은 memb 테이블에 있다. 
 */
select la.lano, l.titl, m.name, s.work, la.rdt, r.name, m2.name
from lect_appl la 
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno 
        join lect l on la.lno=l.lno
        left outer join room r on l.rno=r.rno 
        left outer join memb m2 on l.mno=m2.mno; 

/* 7단계: 매니저의 직위 출력
 * => 매니저 번호는 lect 테이블 있다.
 * => 매니저 직위는 mgr 테이블에 있다.  
 */
select la.lano, l.titl, m.name, s.work, la.rdt, r.name, m2.name, mr.posi
from lect_appl la 
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno 
        join lect l on la.lno=l.lno
        left outer join room r on l.rno=r.rno 
        left outer join memb m2 on l.mno=m2.mno 
        left outer join mgr mr on l.mno=mr.mno;  
   


