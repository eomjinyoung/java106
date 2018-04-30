# select 테스트 용 테이블 준비

-- 수강생
DROP TABLE IF EXISTS stnt RESTRICT;

-- 강사
DROP TABLE IF EXISTS tcher RESTRICT;

-- 강의
DROP TABLE IF EXISTS lect RESTRICT;

-- 강의실
DROP TABLE IF EXISTS room RESTRICT;

-- 매니저
DROP TABLE IF EXISTS mgr RESTRICT;

-- 수강신청
DROP TABLE IF EXISTS lect_appl RESTRICT;

-- 강의실사진
DROP TABLE IF EXISTS room_phot RESTRICT;

-- 멤버
DROP TABLE IF EXISTS memb RESTRICT;

-- 주소
DROP TABLE IF EXISTS addr RESTRICT;

-- 강의배정
DROP TABLE IF EXISTS lect_tcher RESTRICT;

-- 수강생
CREATE TABLE stnt (
    mno    INTEGER     NOT NULL COMMENT '수강생번호', -- 수강생번호
    work   CHAR(1)     NOT NULL COMMENT '재직여부', -- 재직여부
    acc_no VARCHAR(20) NULL     COMMENT '통장번호', -- 통장번호
    bank   VARCHAR(50) NULL     COMMENT '은행명' -- 은행명
)
COMMENT '수강생';

-- 수강생
ALTER TABLE stnt
    ADD CONSTRAINT PK_stnt -- 수강생 기본키
        PRIMARY KEY (
            mno -- 수강생번호
        );

-- 수강생 유니크 인덱스
CREATE UNIQUE INDEX UIX_stnt
    ON stnt ( -- 수강생
        acc_no ASC, -- 통장번호
        bank ASC    -- 은행명
    );

-- 강사
CREATE TABLE tcher (
    mno    INTEGER     NOT NULL COMMENT '강사번호', -- 강사번호
    acc_no VARCHAR(20) NULL     COMMENT '통장번호', -- 통장번호
    bank   VARCHAR(50) NULL     COMMENT '은행명', -- 은행명
    hr_pay INTEGER     NULL     COMMENT '시강료' -- 시강료
)
COMMENT '강사';

-- 강사
ALTER TABLE tcher
    ADD CONSTRAINT PK_tcher -- 강사 기본키
        PRIMARY KEY (
            mno -- 강사번호
        );

-- 강사 유니크 인덱스
CREATE UNIQUE INDEX UIX_tcher
    ON tcher ( -- 강사
        acc_no ASC, -- 통장번호
        bank ASC    -- 은행명
    );

-- 강의
CREATE TABLE lect (
    lno     INTEGER      NOT NULL COMMENT '강의번호', -- 강의번호
    titl    VARCHAR(255) NOT NULL COMMENT '강의명', -- 강의명
    sdt     DATE         NOT NULL COMMENT '시작일', -- 시작일
    edt     DATE         NOT NULL COMMENT '종료일', -- 종료일
    qnty    INTEGER      NOT NULL COMMENT '최대수용인원', -- 최대수용인원
    pric    INTEGER      NOT NULL COMMENT '강의료', -- 강의료
    nat_sup CHAR(1)      NOT NULL COMMENT '정부지원여부', -- 정부지원여부
    sup_typ VARCHAR(50)  NOT NULL COMMENT '지원타입', -- 지원타입
    dsct    TEXT         NOT NULL COMMENT '설명', -- 설명
    rno     INTEGER      NULL     COMMENT '강의실번호', -- 강의실번호
    mno     INTEGER      NULL     COMMENT '매니저번호' -- 매니저번호
)
COMMENT '강의';

-- 강의
ALTER TABLE lect
    ADD CONSTRAINT PK_lect -- 강의 기본키
        PRIMARY KEY (
            lno -- 강의번호
        );

-- 강의 인덱스
CREATE INDEX IX_lect
    ON lect( -- 강의
        titl ASC -- 강의명
    );

ALTER TABLE lect
    MODIFY COLUMN lno INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의번호';

-- 강의실
CREATE TABLE room (
    rno  INTEGER     NOT NULL COMMENT '강의실번호', -- 강의실번호
    loc  VARCHAR(50) NOT NULL COMMENT '지점명', -- 지점명
    name VARCHAR(50) NOT NULL COMMENT '강의실명', -- 강의실명
    qnty INTEGER     NOT NULL COMMENT '수용인원' -- 수용인원
)
COMMENT '강의실';

-- 강의실
ALTER TABLE room
    ADD CONSTRAINT PK_room -- 강의실 기본키
        PRIMARY KEY (
            rno -- 강의실번호
        );

-- 강의실 유니크 인덱스
CREATE UNIQUE INDEX UIX_room
    ON room ( -- 강의실
        loc ASC,  -- 지점명
        name ASC  -- 강의실명
    );

ALTER TABLE room
    MODIFY COLUMN rno INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의실번호';

-- 매니저
CREATE TABLE mgr (
    mno  INTEGER     NOT NULL COMMENT '매니저번호', -- 매니저번호
    dept VARCHAR(50) NULL     COMMENT '부서', -- 부서
    posi VARCHAR(50) NULL     COMMENT '직위', -- 직위
    fax  VARCHAR(20) NULL     COMMENT '팩스' -- 팩스
)
COMMENT '매니저';

-- 매니저
ALTER TABLE mgr
    ADD CONSTRAINT PK_mgr -- 매니저 기본키
        PRIMARY KEY (
            mno -- 매니저번호
        );

-- 수강신청
CREATE TABLE lect_appl (
    lano INTEGER  NOT NULL COMMENT '수강신청번호', -- 수강신청번호
    lno  INTEGER  NOT NULL COMMENT '강의번호', -- 강의번호
    mno  INTEGER  NOT NULL COMMENT '수강생번호', -- 수강생번호
    rdt  DATETIME NOT NULL COMMENT '신청일', -- 신청일
    stat INTEGER  NULL     COMMENT '진행상태' -- 진행상태
)
COMMENT '수강신청';

-- 수강신청
ALTER TABLE lect_appl
    ADD CONSTRAINT PK_lect_appl -- 수강신청 기본키
        PRIMARY KEY (
            lano -- 수강신청번호
        );

-- 수강신청 유니크 인덱스
CREATE UNIQUE INDEX UIX_lect_appl
    ON lect_appl ( -- 수강신청
        lno ASC, -- 강의번호
        mno ASC  -- 수강생번호
    );

ALTER TABLE lect_appl
    MODIFY COLUMN lano INTEGER NOT NULL AUTO_INCREMENT COMMENT '수강신청번호';

-- 강의실사진
CREATE TABLE room_phot (
    rpno INTEGER      NOT NULL COMMENT '강의실사진번호', -- 강의실사진번호
    rno  INTEGER      NOT NULL COMMENT '강의실번호', -- 강의실번호
    phot VARCHAR(255) NOT NULL COMMENT '사진' -- 사진
)
COMMENT '강의실사진';

-- 강의실사진
ALTER TABLE room_phot
    ADD CONSTRAINT PK_room_phot -- 강의실사진 기본키
        PRIMARY KEY (
            rpno -- 강의실사진번호
        );

ALTER TABLE room_phot
    MODIFY COLUMN rpno INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의실사진번호';

-- 멤버
CREATE TABLE memb (
    mno      INTEGER      NOT NULL COMMENT '멤버번호', -- 멤버번호
    name     VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
    tel      VARCHAR(20)  NOT NULL COMMENT '전화', -- 전화
    email    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
    pwd      VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
    phot     VARCHAR(255) NULL     COMMENT '사진', -- 사진
    ano      INTEGER      NULL     COMMENT '주소번호', -- 주소번호
    det_addr VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
    finl_edu VARCHAR(50)  NULL     COMMENT '최종학력', -- 최종학력
    maj      VARCHAR(50)  NULL     COMMENT '전공', -- 전공
    sch_nm   VARCHAR(50)  NULL     COMMENT '최종학교' -- 최종학교
)
COMMENT '멤버';

-- 멤버
ALTER TABLE memb
    ADD CONSTRAINT PK_memb -- 멤버 기본키
        PRIMARY KEY (
            mno -- 멤버번호
        );

-- 멤버 유니크 인덱스
CREATE UNIQUE INDEX UIX_memb
    ON memb ( -- 멤버
        email ASC -- 이메일
    );

-- 멤버 인덱스
CREATE INDEX IX_memb
    ON memb( -- 멤버
        name ASC -- 이름
    );

ALTER TABLE memb
    MODIFY COLUMN mno INTEGER NOT NULL AUTO_INCREMENT COMMENT '멤버번호';

-- 주소
CREATE TABLE addr (
    ano      INTEGER      NOT NULL COMMENT '주소번호', -- 주소번호
    pst_no   VARCHAR(5)   NOT NULL COMMENT '우편번호', -- 우편번호
    bas_addr VARCHAR(255) NOT NULL COMMENT '기본주소' -- 기본주소
)
COMMENT '주소';

-- 주소
ALTER TABLE addr
    ADD CONSTRAINT PK_addr -- 주소 기본키
        PRIMARY KEY (
            ano -- 주소번호
        );

-- 주소 인덱스
CREATE INDEX IX_addr
    ON addr( -- 주소
        pst_no ASC -- 우편번호
    );

ALTER TABLE addr
    MODIFY COLUMN ano INTEGER NOT NULL AUTO_INCREMENT COMMENT '주소번호';

-- 강의배정
CREATE TABLE lect_tcher (
    lno INTEGER NOT NULL COMMENT '강의번호', -- 강의번호
    mno INTEGER NOT NULL COMMENT '강사번호' -- 강사번호
)
COMMENT '강의배정';

-- 강의배정
ALTER TABLE lect_tcher
    ADD CONSTRAINT PK_lect_tcher -- 강의배정 기본키
        PRIMARY KEY (
            lno, -- 강의번호
            mno  -- 강사번호
        );

-- 수강생
ALTER TABLE stnt
    ADD CONSTRAINT FK_memb_TO_stnt -- 멤버 -> 수강생
        FOREIGN KEY (
            mno -- 수강생번호
        )
        REFERENCES memb ( -- 멤버
            mno -- 멤버번호
        );

-- 강사
ALTER TABLE tcher
    ADD CONSTRAINT FK_memb_TO_tcher -- 멤버 -> 강사
        FOREIGN KEY (
            mno -- 강사번호
        )
        REFERENCES memb ( -- 멤버
            mno -- 멤버번호
        );

-- 강의
ALTER TABLE lect
    ADD CONSTRAINT FK_mgr_TO_lect -- 매니저 -> 강의
        FOREIGN KEY (
            mno -- 매니저번호
        )
        REFERENCES mgr ( -- 매니저
            mno -- 매니저번호
        );

-- 강의
ALTER TABLE lect
    ADD CONSTRAINT FK_room_TO_lect -- 강의실 -> 강의
        FOREIGN KEY (
            rno -- 강의실번호
        )
        REFERENCES room ( -- 강의실
            rno -- 강의실번호
        );

-- 매니저
ALTER TABLE mgr
    ADD CONSTRAINT FK_memb_TO_mgr -- 멤버 -> 매니저
        FOREIGN KEY (
            mno -- 매니저번호
        )
        REFERENCES memb ( -- 멤버
            mno -- 멤버번호
        );

-- 수강신청
ALTER TABLE lect_appl
    ADD CONSTRAINT FK_stnt_TO_lect_appl -- 수강생 -> 수강신청
        FOREIGN KEY (
            mno -- 수강생번호
        )
        REFERENCES stnt ( -- 수강생
            mno -- 수강생번호
        );

-- 수강신청
ALTER TABLE lect_appl
    ADD CONSTRAINT FK_lect_TO_lect_appl -- 강의 -> 수강신청
        FOREIGN KEY (
            lno -- 강의번호
        )
        REFERENCES lect ( -- 강의
            lno -- 강의번호
        );

-- 강의실사진
ALTER TABLE room_phot
    ADD CONSTRAINT FK_room_TO_room_phot -- 강의실 -> 강의실사진
        FOREIGN KEY (
            rno -- 강의실번호
        )
        REFERENCES room ( -- 강의실
            rno -- 강의실번호
        );

-- 멤버
ALTER TABLE memb
    ADD CONSTRAINT FK_addr_TO_memb -- 주소 -> 멤버
        FOREIGN KEY (
            ano -- 주소번호
        )
        REFERENCES addr ( -- 주소
            ano -- 주소번호
        );

-- 강의배정
ALTER TABLE lect_tcher
    ADD CONSTRAINT FK_tcher_TO_lect_tcher -- 강사 -> 강의배정
        FOREIGN KEY (
            mno -- 강사번호
        )
        REFERENCES tcher ( -- 강사
            mno -- 강사번호
        );

-- 강의배정
ALTER TABLE lect_tcher
    ADD CONSTRAINT FK_lect_TO_lect_tcher -- 강의 -> 강의배정
        FOREIGN KEY (
            lno -- 강의번호
        )
        REFERENCES lect ( -- 강의
            lno -- 강의번호
        );