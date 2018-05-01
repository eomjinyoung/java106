/* 서브 쿼리
=> 쿼리문 안에 쿼리문을 실행하는 기법
=> 성능 문제를 생각하면서 사용해야 한다.
*/

/* join이용하여 데이터를 추출한 방법 */
select la.lano, l.titl, m.name, s.work, la.rdt, r.name, m2.name, mr.posi
from lect_appl la 
        inner join memb m on la.mno=m.mno
        inner join stnt s on la.mno=s.mno 
        inner join lect l on la.lno=l.lno
        left outer join room r on l.rno=r.rno 
        left outer join memb m2 on l.mno=m2.mno 
        left outer join mgr mr on l.mno=mr.mno;  

/* select 절에 서브쿼리 사용하기 */

/* => 1단계: 수강신청 데이터를 출력 */
select la.lano, la.lno, la.mno, la.rdt
from lect_appl la; 

/* => 2단계 : 서브 쿼리를 이용하여 강의명을 가져오기 */
select 
    la.lano, 
    (select titl from lect where lno=la.lno) as lect_title, 
    la.mno, 
    la.rdt
from lect_appl la;

/* => 3단계 : 서브 쿼리를 이용하여 학생명을 가져오기 */
select 
    la.lano, 
    (select titl from lect where lno=la.lno) as lect_title, 
    (select name from memb where mno=la.mno) as stud_name,
    la.rdt
from lect_appl la;

/* from 절에 서브쿼리 사용하기 */
/* 0단계 : 강의 정보를 가져온다. */
select
    l.lno,
    l.titl,
    l.rno,
    l.mno
from lect l;

/* 1단계 : 강의 상세 정보를 가져오는 select를 준비한다.
    => 서브 쿼리를 이용하여 강의실 이름과 매니저 이름, 직위 정보를 가져오기 */
select 
    l.lno, 
    l.titl, 
    (select name from room where rno=l.rno) as room_name, 
    (select name from memb where mno=l.mno) as manager_name,
    (select posi from mgr where mno=l.mno) as manager_posi
from lect l

/* 2단계: 위에서 준비한 select 결과를 가상 테이블로 사용하여 
             기존의 lect_appl 테이블과 조인한다.*/
select 
    la.lano, 
    (select titl from lect where lno=la.lno) as lect_title, 
    (select name from memb where mno=la.mno) as stud_name,
    lec.titl,
    lec.room_name,
    lec.manager_name,
    lec.manager_posi
from lect_appl la 
    join (select 
                l.lno, 
                l.titl, 
                (select name from room where rno=l.rno) as room_name, 
                (select name from memb where mno=l.mno) as manager_name,
                (select posi from mgr where mno=l.mno) as manager_posi
            from lect l) as lec on la.lno=lec.lno;

/* from 절에서 반복적으로 사용하는 서브 쿼리가 있다면,
 * 차라리 가상 테이블인 view로 정의해놓고 사용하는 것이 편하다. 
 */ 
create view lect2 as
select 
    l.lno, 
    l.titl, 
    (select name from room where rno=l.rno) as room_name, 
    l.mno as manager_no,
    (select name from memb where mno=l.mno) as manager_name,
    (select posi from mgr where mno=l.mno) as manager_posi
from lect l;
            
/* 위의 질의문을 view를 사용하여 다시 작성해보자! */
select 
    la.lano, 
    (select titl from lect where lno=la.lno) as lect_title, 
    (select name from memb where mno=la.mno) as stud_name,
    lec.titl,
    lec.room_name,
    lec.manager_name,
    lec.manager_posi
from lect_appl la 
    join lect2 as lec on la.lno=lec.lno;
            
            
/* where 절에 서브쿼리 사용하기 */

/* 과장 또는 대리 매니저가 담당하고 있는 수강 신청만 추출하기 */
select 
    la.lano, 
    (select titl from lect where lno=la.lno) as lect_title, 
    (select name from memb where mno=la.mno) as stud_name,
    lec.titl,
    lec.room_name,
    lec.manager_no,
    lec.manager_name,
    lec.manager_posi
from lect_appl la 
    join lect2 as lec on la.lno=lec.lno 
where
    lec.manager_no in (select 
                           mno 
                       from
                           mgr 
                       where 
                           posi in ('과장', '대리'));








