# MySQL 설치 후 설정

## mysql 서버에 접속하기
로컬 MySQL 서버에 접속
> mysql -u root -p
> Enter password: 암호입력

원격 MySQL 서버에 접속
> mysql -h 서버주소 -u root -p
> Enter password: 암호입력

## mysql root 암호 변경
> alter user 'root'@'localhost' identified by '1111';

## MySQL 사용자 추가
> CREATE USER '사용자아이디'@'서버주소' IDENTIFIED BY '암호';

로컬에서만 접속할 수 있는 사용자를 만들기:
> CREATE USER 'study'@'localhost' IDENTIFIED BY '1111';
  => 이 경우 stidu 사용자는 오직 로컬(서버를 실행하는 컴퓨터)에서만 접속 가능한다.
  => 다른 컴퓨터에서 실행하는 MySQL 서버에 접속할 수 없다는 것을 의미한다.

원격에서만 접속할 수 있는 사용자를 만들기:
> CREATE USER 'study'@'%' IDENTIFIED BY '1111';
  => 이 경우 study 사용자는 원력에서만 접속 가능하다.

## MySQL 사용자 목록 조회
> select user from 데이터베이스명.테이블명;
> select user from mysql.user;

## MySQL 데이터베이스 생성
> CREATE DATABASE 데이터베이스명
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

> CREATE DATABASE studydb
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;
  
## MySQL 사용자에게 데이터베이스 사용 권한 부여
> GRANT ALL ON 데이터베이스명.* TO '사용자아이디'@'서버주소';
> GRANT ALL ON studydb.* TO 'study'@'localhost';

## 데이터베이스 목록 조회
> show databases;

## 사용자 교체
> quit    (프로그램 종료 후)
> mysql -u study -p   (다시 실행)

## 기본으로 사용할 데이터베이스 지정하기
> use 데이터베이스명
> use studydb;

## 데이터베이스의 전체 테이블 목록 조회
> show tables;

