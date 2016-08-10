
/* Drop Tables */

DROP TABLE b_review CASCADE CONSTRAINTS;
DROP TABLE b_beverage CASCADE CONSTRAINTS;
DROP TABLE b_cafe CASCADE CONSTRAINTS;
DROP TABLE b_favor CASCADE CONSTRAINTS;
DROP TABLE b_member CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_b_beverage_beverage_id;
DROP SEQUENCE SEQ_b_member_member_num;
DROP SEQUENCE SEQ_b_cafe_cafe_id;


/* Create Sequences */

CREATE SEQUENCE SEQ_b_beverage_beverage_id INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_b_member_member_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_b_cafe_cafe_id INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE b_cafe
(
	cafe_id number NOT NULL,
	cafe_name varchar2(30),
	PRIMARY KEY (cafe_id)
);


CREATE TABLE b_review
(
	beverage_id number NOT NULL,
	review_level number NOT NULL,
	beverage_review varchar2(100)
);


CREATE TABLE b_favor
(
	member_num number NOT NULL,
	beverage_id number
	cafe_name varchar2(30)
	beverage_name varchar2(30)
);

CREATE TABLE b_beverage
(
	beverage_id number NOT NULL,
	cafe_id number NOT NULL,
	beverage_price number(5,0) NOT NULL,
	beverage_type varchar2(9) NOT NULL,
	beverage_name varchar2(30) NOT NULL,
	beverage_text varchar2(1000),
	PRIMARY KEY (beverage_id)
);


CREATE TABLE b_member
(
	member_num number NOT NULL,
	name varchar2(30) NOT NULL,
	gender char(3),
	email varchar2(30) NOT NULL,
	birth_date date NOT NULL,
	member_id varchar2(30) NOT NULL,
	password varchar2(10) NOT NULL,
	PRIMARY KEY (member_num)
);



/* Create Foreign Keys */

ALTER TABLE b_beverage
	ADD FOREIGN KEY (cafe_id)
	REFERENCES b_cafe (cafe_id)
;


ALTER TABLE b_preference
	ADD FOREIGN KEY (beverage_id)
	REFERENCES beverage (beverage_id)
;


ALTER TABLE b_favor
	ADD FOREIGN KEY (member_num)
	REFERENCES b_member (member_num)
;

