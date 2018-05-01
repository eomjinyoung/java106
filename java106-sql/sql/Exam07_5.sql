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

/* natural join 의 문제점 1
    => 같은 이름의 컬럼이 여러 개 있을 경우 
        특정 컬럼을 기준으로 연결하지 못한다.
        모든 컬럼의 값이 일치할 경우에만 연결한다. */

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
from memb m join stnt s on m.mno=s.mno;       
   
/* 예전의 조인 문법 */
select m.mno, name, s.mno, work, bank
from memb m, stnt s
where m.mno=s.mno;       
      
/* join ~ on 의 문제점
   => 반드시 on 에서 지정한 컬럼의 값이 같을 경우에만 
        두 테이블의 데이터가 연결된다.
   => 만약 연결되지 않은 데이터도 출력하고 싶다면 
        이 문법으로 불가능 하다!*/
        
/* 모든 멤버의 번호와 이름을 출력하라!  
    단 학생의 경우 재직여부도 출력하라!*/
    
/* 다음 질의문은 안타깝게도 학생 목록만 출력한다.
    왜? memb테이블의 데이터와 stnt 테이블의 데이터를 
    추출할 때 mno가 같은 데이터만 추출한다.*/
select m.mno, name, work
from memb m join stnt s on m.mno=s.mno;                     
      
/* 상대 테이블(stnt)에 연결할 대상(데이터)이 없더라도
    select에서 추출하는 방법 */
select m.mno, name, work
from memb m left join stnt s on m.mno=s.mno;           
      
/* 여러 테이블의 데이터를 연결하기
    => 다음의 결과가 출력될 수 있도록 수강 신청 데이터를 출력하시오!
    수강신청번호, 강의명, 학생명, 재직여부, 수강신청일, 강의실명, 매니저명, 직위 */

/* 1단계 */
select la.lano, la.mno, la.rdt
from lect_appl la;     
 
/* 2단계 */
select la.lano, m.name, la.rdt
from lect_appl la 
        join memb m on la.mno=m.mno;

/* 3단계 */
select la.lano, m.name, s.work, la.rdt
from lect_appl la 
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno;
  
/* 4단계 */
select la.lano, l.titl, m.name, s.work, la.rdt
from lect_appl la 
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno 
        join lect l on la.lno=l.lno;

/* 5단계 */
select la.lano, l.titl, m.name, s.work, la.rdt, r.name
from lect_appl la 
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno 
        join lect l on la.lno=l.lno
        left join room r on l.rno=r.rno;

/* 6단계 */
select la.lano, l.titl, m.name, s.work, la.rdt, r.name, m2.name
from lect_appl la 
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno 
        join lect l on la.lno=l.lno
        left join room r on l.rno=r.rno 
        left join memb m2 on l.mno=m2.mno; 

/* 7단계 */
select la.lano, l.titl, m.name, s.work, la.rdt, r.name, m2.name, mr.posi
from lect_appl la 
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno 
        join lect l on la.lno=l.lno
        left join room r on l.rno=r.rno 
        left join memb m2 on l.mno=m2.mno 
        left join mgr mr on l.mno=mr.mno;  
   


