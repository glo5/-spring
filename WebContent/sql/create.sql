create table employee1_tbl(
	empno number(5) NOT NULL,
	empname varchar2(20),
	joindate date,
	rank char(1),
	dept char(1),
	CONSTRAINT employee1_tbl PRIMARY KEY (empno)
)

INSERT INTO employee_tbl(empno, empname, joindate, rank, dept)
values (10001, '고영만','2017-03-01','A','A');
INSERT INTO employee_tbl(empno, empname, joindate, rank, dept)
values (10002, '만준원','2017-03-01','A','B');
INSERT INTO employee_tbl(empno, empname, joindate, rank, dept)
values (10003, '원성휘','2017-03-01','B','A');
INSERT INTO employee_tbl(empno, empname, joindate, rank, dept)
values (10004, '휘현진','2015-05-01','B','B');
INSERT INTO employee_tbl(empno, empname, joindate, rank, dept)
values (10005, '진유민','2015-05-01','C','C');

create table salary_tbl(
	empno number(5) NOT NULL,
	payday date NOT NULL,
	pay number(10),
	CONSTRAINT salary_tbl PRIMARY KEY (empno,payday)
)

INSERT INTO salary_tbl(empno , payday, pay)
VALUES (10001 , '2019-03-01' , 1540000);
INSERT INTO salary_tbl(empno , payday, pay)
VALUES (10001 , '2019-04-01' , 1570000);
INSERT INTO salary_tbl(empno , payday, pay)
VALUES (10002 , '2019-03-01' , 1740000);
INSERT INTO salary_tbl(empno , payday, pay)
VALUES (10002 , '2019-04-01' , 1770000);
INSERT INTO salary_tbl(empno , payday, pay)
VALUES (10003 , '2019-03-01' , 2400000);
INSERT INTO salary_tbl(empno , payday, pay)
VALUES (10003 , '2019-04-01' , 2450000);
INSERT INTO salary_tbl(empno , payday, pay)
VALUES (10004 , '2019-03-01' , 3400000);
INSERT INTO salary_tbl(empno , payday, pay)
VALUES (10004 , '2019-04-01' , 3450000);
INSERT INTO salary_tbl(empno , payday, pay)
VALUES (10005 , '2019-03-01' , 4500000);
INSERT INTO salary_tbl(empno , payday, pay)
VALUES (10005 , '2019-04-01' , 4550000);
