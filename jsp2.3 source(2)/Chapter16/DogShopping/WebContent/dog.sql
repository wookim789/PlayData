CREATE TABLE dog(
	id NUMBER PRIMARY KEY,
	kind VARCHAR2(12) NOT NULL,
	price NUMBER NOT NULL,
	image VARCHAR2(20) NOT NULL,
	country VARCHAR2(12) NOT NULL,
	height NUMBER,
	weight NUMBER,
	content VARCHAR2(400),
	readcount NUMBER
);
CREATE SEQUENCE dog_seq;

INSERT INTO dog VALUES(dog_seq.nextval,'Çªµé',1000,'pu.jpg','ÇÁ¶û½º',1,20,'ÅÐ¸¹´Ù',0);
INSERT INTO dog VALUES(dog_seq.nextval,'ºÒµ¶',2000,'bul.jpg','µ¶ÀÏ',1,20,'¸ø»ý°å´Ù',0);
INSERT INTO dog VALUES(dog_seq.nextval,'Áøµµ°³',3000,'jin.jpg','´ëÇÑ¹Î±¹',1,20,'ÃÖ°í´Ù',0);
INSERT INTO dog VALUES(dog_seq.nextval,'Çã½ºÅ°',4000,'h.jpg','ºÏ±Ø',1,20,'¸ÚÁö´Ù',0);
COMMIT

