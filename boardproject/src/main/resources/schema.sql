DROP TABLE IF EXISTS BOARD;
create table BOARD
(
    SEQ      INT           not null
        primary key AUTO_INCREMENT,
    TITLE    VARCHAR(255)  not null,
    CONTENT  VARCHAR(1000) not null,
    WRITER   VARCHAR(20)   not null,
    PASSWORD INT           not null,
    REGDATE  VARCHAR(50)   not null,
    CNT      INT           not null
);
