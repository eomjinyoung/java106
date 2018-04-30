# select 테스트 용 데이터 준비

/* 강의실 데이터 준비 */
insert into room(rno, loc, name, qnty) values(1, '강남', '501', 30);
insert into room(rno, loc, name, qnty) values(2, '강남', '502', 30);
insert into room(rno, loc, name, qnty) values(3, '강남', '503', 30);
insert into room(rno, loc, name, qnty) values(4, '종로', '301', 30);
insert into room(rno, loc, name, qnty) values(5, '종로', '302', 30);
insert into room(rno, loc, name, qnty) values(6, '종로', '303', 30);
insert into room(rno, loc, name, qnty) values(7, '서초', '301', 30);
insert into room(rno, loc, name, qnty) values(8, '서초', '302', 30);
insert into room(rno, loc, name, qnty) values(9, '서초', '501', 30);
insert into room(rno, loc, name, qnty) values(10, '서초', '601', 30);

/* 학생 데이터 입력 */
insert into memb(mno, name, tel, email, pwd)
values(100, 's100', '111-1111', 's100@', sha2('1111', 224));
insert into memb(mno, name, tel, email, pwd)
values(101, 's101', '111-1111', 's101@', sha2('1111', 224));
insert into memb(mno, name, tel, email, pwd)
values(102, 's102', '111-1111', 's102@', sha2('1111', 224));
insert into memb(mno, name, tel, email, pwd)
values(103, 's103', '111-1111', 's103@', sha2('1111', 224));
insert into memb(mno, name, tel, email, pwd)
values(104, 's104', '111-1111', 's104@', sha2('1111', 224));

insert into stnt(mno, work, acc_no, bank)
values(100, 'N', '1000', '비트은행');
insert into stnt(mno, work, acc_no, bank)
values(101, 'Y', '1001', '비트은행');
insert into stnt(mno, work, acc_no, bank)
values(102, 'N', '1002', '캠프은행');
insert into stnt(mno, work, acc_no, bank)
values(103, 'Y', '1003', '우리은행');
insert into stnt(mno, work, acc_no, bank)
values(104, 'N', '1004', '국민은행');

/* 강사 데이터 입력 */
insert into memb(mno, name, tel, email, pwd)
values(200, 's200', '111-1111', 's200@', sha2('1111', 224));
insert into memb(mno, name, tel, email, pwd)
values(201, 's201', '111-1111', 's201@', sha2('1111', 224));
insert into memb(mno, name, tel, email, pwd)
values(202, 's202', '111-1111', 's202@', sha2('1111', 224));
insert into memb(mno, name, tel, email, pwd)
values(203, 's203', '111-1111', 's203@', sha2('1111', 224));
insert into memb(mno, name, tel, email, pwd)
values(204, 's204', '111-1111', 's204@', sha2('1111', 224));

insert into tcher(mno, hr_pay, acc_no, bank)
values(200, 10000, '2000', '신한은행');
insert into tcher(mno, hr_pay, acc_no, bank)
values(201, 20000, '2001', '농협');
insert into tcher(mno, hr_pay, acc_no, bank)
values(202, 15000, '2002', '기업은행');
insert into tcher(mno, hr_pay, acc_no, bank)
values(203, 25000, '2003', '우리은행');
insert into tcher(mno, hr_pay, acc_no, bank)
values(204, 30000, '2004', '국민은행');

/* 매니저 데이터 입력 */
insert into memb(mno, name, tel, email, pwd)
values(300, 'm300', '111-1111', 'm300@', sha2('1111', 224));
insert into memb(mno, name, tel, email, pwd)
values(301, 'm301', '111-1111', 'm301@', sha2('1111', 224));
insert into memb(mno, name, tel, email, pwd)
values(302, 'm302', '111-1111', 'm302@', sha2('1111', 224));
insert into memb(mno, name, tel, email, pwd)
values(303, 'm303', '111-1111', 'm303@', sha2('1111', 224));
insert into memb(mno, name, tel, email, pwd)
values(304, 'm304', '111-1111', 'm304@', sha2('1111', 224));

insert into mgr(mno, dept, posi)
values(300, '시설관리', '주임');
insert into mgr(mno, dept, posi)
values(301, '시설관리', '대리');
insert into mgr(mno, dept, posi)
values(302, '회계', '과장');
insert into mgr(mno, dept, posi)
values(303, '교육', '주임');
insert into mgr(mno, dept, posi)
values(304, '교육', '과장');

/* 200번 강사는 교육팀 과장이기도 하다.*/
insert into mgr(mno, dept, posi)
values(200, '교육', '과장');

/* 강의 데이터 입력 */
insert into lect(lno, titl, sdt, edt, qnty, pric, nat_sup, sup_typ, dsct)
values(1, '자바프로그래밍', '2018-1-1', '2018-5-30', 30, 100, 'Y', '미취업자', 'ok');
insert into lect(lno, titl, sdt, edt, qnty, pric, nat_sup, sup_typ, dsct)
values(2, 'IoT프로그래밍', '2018-3-1', '2018-7-30', 30, 200, 'Y', '미취업자', 'ok');
insert into lect(lno, titl, sdt, edt, qnty, pric, nat_sup, sup_typ, dsct)
values(3, '윈도우프로그래밍', '2018-5-1', '2018-10-30', 30, 300, 'Y', '노동부', 'ok');


/* 강의에 매니저 배정 */
update lect set mno=303 where lno=1;
update lect set mno=304 where lno=3;

/* 강의에 강의실 배정 */
update lect set rno=1 where lno=1;
update lect set rno=4 where lno=2;

/* 수강신청 데이터 입력 */
insert into lect_appl(lano, lno, mno, rdt) values(1, 1, 100, '2017-11-2');
insert into lect_appl(lano, lno, mno, rdt) values(2, 1, 101, '2017-11-3');
insert into lect_appl(lano, lno, mno, rdt) values(3, 1, 102, '2017-11-4');
insert into lect_appl(lano, lno, mno, rdt) values(4, 2, 104, '2017-12-6');
insert into lect_appl(lano, lno, mno, rdt) values(5, 2, 100, '2017-12-7');
insert into lect_appl(lano, lno, mno, rdt) values(6, 3, 101, '2017-10-8');
insert into lect_appl(lano, lno, mno, rdt) values(7, 3, 102, '2017-11-9');
insert into lect_appl(lano, lno, mno, rdt) values(8, 3, 104, '2017-11-11');















