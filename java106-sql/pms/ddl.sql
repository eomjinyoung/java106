-- 게시판
DROP TABLE IF EXISTS pms2_board RESTRICT;

-- 회원
DROP TABLE IF EXISTS pms2_member RESTRICT;

-- 팀
DROP TABLE IF EXISTS pms2_team RESTRICT;

-- 수업
DROP TABLE IF EXISTS pms2_classroom RESTRICT;

-- 작업
DROP TABLE IF EXISTS pms2_task RESTRICT;

-- 팀회원
DROP TABLE IF EXISTS pms2_team_member RESTRICT;

-- 게시판
CREATE TABLE pms2_board (
    bno  INT          NOT NULL COMMENT '번호', -- 번호
    titl VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
    cont TEXT         NULL     COMMENT '내용', -- 내용
    cdt  DATETIME     NOT NULL COMMENT '등록일' -- 등록일
)
COMMENT '게시판';

-- 게시판
ALTER TABLE pms2_board
    ADD CONSTRAINT PK_pms2_board -- 게시판 기본키
        PRIMARY KEY (
            bno -- 번호
        );

ALTER TABLE pms2_board
    MODIFY COLUMN bno INT NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 회원
CREATE TABLE pms2_member (
    mid   VARCHAR(20)  NOT NULL COMMENT '아이디', -- 아이디
    email VARCHAR(255) NOT NULL COMMENT '이메일', -- 이메일
    pwd   VARCHAR(100) NOT NULL COMMENT '암호' -- 암호
)
COMMENT '회원';

-- 회원
ALTER TABLE pms2_member
    ADD CONSTRAINT PK_pms2_member -- 회원 기본키
        PRIMARY KEY (
            mid -- 아이디
        );

-- 팀
CREATE TABLE pms2_team (
    name    VARCHAR(100) NOT NULL COMMENT '이름', -- 이름
    dscrt   TEXT         NULL     COMMENT '설명', -- 설명
    max_qty INT          NOT NULL COMMENT '최대인원', -- 최대인원
    sdt     DATETIME     NOT NULL COMMENT '시작일', -- 시작일
    edt     DATETIME     NOT NULL COMMENT '종료일' -- 종료일
)
COMMENT '팀';

-- 팀
ALTER TABLE pms2_team
    ADD CONSTRAINT PK_pms2_team -- 팀 기본키
        PRIMARY KEY (
            name -- 이름
        );

-- 수업
CREATE TABLE pms2_classroom (
    crno INT          NOT NULL COMMENT '번호', -- 번호
    titl VARCHAR(255) NOT NULL COMMENT '수업명', -- 수업명
    sdt  DATETIME     NOT NULL COMMENT '시작일', -- 시작일
    edt  DATETIME     NOT NULL COMMENT '종료일', -- 종료일
    room VARCHAR(50)  NULL     COMMENT '교실' -- 교실
)
COMMENT '수업';

-- 수업
ALTER TABLE pms2_classroom
    ADD CONSTRAINT PK_pms2_classroom -- 수업 기본키
        PRIMARY KEY (
            crno -- 번호
        );

ALTER TABLE pms2_classroom
    MODIFY COLUMN crno INT NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 작업
CREATE TABLE pms2_task (
    tano INT          NOT NULL COMMENT '번호', -- 번호
    titl VARCHAR(255) NOT NULL COMMENT '작업명', -- 작업명
    sdt  DATETIME     NOT NULL COMMENT '시작일', -- 시작일
    edt  DATETIME     NOT NULL COMMENT '종료일', -- 종료일
    stat INT          NULL     COMMENT '상태', -- 상태
    mid  VARCHAR(20)  NULL     COMMENT '작업자', -- 작업자
    tnm  VARCHAR(100) NOT NULL COMMENT '팀명' -- 팀명
)
COMMENT '작업';

-- 작업
ALTER TABLE pms2_task
    ADD CONSTRAINT PK_pms2_task -- 작업 기본키
        PRIMARY KEY (
            tano -- 번호
        );

ALTER TABLE pms2_task
    MODIFY COLUMN tano INT NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 팀회원
CREATE TABLE pms2_team_member (
    tnm VARCHAR(100) NOT NULL COMMENT '팀명', -- 팀명
    mid VARCHAR(20)  NOT NULL COMMENT '아이디' -- 아이디
)
COMMENT '팀회원';

-- 팀회원
ALTER TABLE pms2_team_member
    ADD CONSTRAINT PK_pms2_team_member -- 팀회원 기본키
        PRIMARY KEY (
            tnm, -- 팀명
            mid  -- 아이디
        );

-- 작업
ALTER TABLE pms2_task
    ADD CONSTRAINT FK_pms2_member_TO_pms2_task -- 회원 -> 작업
        FOREIGN KEY (
            mid -- 작업자
        )
        REFERENCES pms2_member ( -- 회원
            mid -- 아이디
        );

-- 작업
ALTER TABLE pms2_task
    ADD CONSTRAINT FK_pms2_team_TO_pms2_task -- 팀 -> 작업
        FOREIGN KEY (
            tnm -- 팀명
        )
        REFERENCES pms2_team ( -- 팀
            name -- 이름
        );

-- 팀회원
ALTER TABLE pms2_team_member
    ADD CONSTRAINT FK_pms2_team_TO_pms2_team_member -- 팀 -> 팀회원
        FOREIGN KEY (
            tnm -- 팀명
        )
        REFERENCES pms2_team ( -- 팀
            name -- 이름
        );

-- 팀회원
ALTER TABLE pms2_team_member
    ADD CONSTRAINT FK_pms2_member_TO_pms2_team_member -- 회원 -> 팀회원
        FOREIGN KEY (
            mid -- 아이디
        )
        REFERENCES pms2_member ( -- 회원
            mid -- 아이디
        );