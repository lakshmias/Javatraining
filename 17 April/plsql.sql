/*
Exercise 1
To write a  Cursor to display the list of employees who are Working as a Managers or Analyst.
*/
DECLARE
CURSOR EMPCURSOR IS SELECT * FROM EMP where job='MANAGER' OR job='ANALYST';
EMPLOYEERECORD EMP%rowtype;

BEGIN
OPEN EMPCURSOR;
LOOP
FETCH EMPCURSOR INTO EMPLOYEERECORD;
    IF EMPCURSOR%NOTFOUND
    THEN
        EXIT;
    END IF;
    DBMS_OUTPUT.PUT_LINE('EMPLOYEE NAME :'||EMPLOYEERECORD.ENAME);
END LOOP;
CLOSE EMPCURSOR;
END;


/* Write PL/SQL code in Cursor to display employee names and salary */
DECLARE
CURSOR EMPCURSOR IS SELECT * FROM EMP ;
EMPLOYEERECORD EMP%rowtype;

BEGIN
OPEN EMPCURSOR;
LOOP
FETCH EMPCURSOR INTO EMPLOYEERECORD;
    IF EMPCURSOR%NOTFOUND
    THEN
        EXIT;
    END IF;
    DBMS_OUTPUT.PUT_LINE('EMPLOYEE NAME :'||EMPLOYEERECORD.ENAME || ' SALARY: '|| EMPLOYEERECORD.SAL);
END LOOP;
CLOSE EMPCURSOR;
END;

/*Write PL/SQL code in Procedure to find the Reverse of the  number*/
set serveroutput on;

declare
	number1 varchar2(10):=&number1;
	length1 int;
    result1 varchar2(10);
begin
    length1:=length(number1);
    for i in reverse 1..length1 loop
        result1 := result1 || substr(number1,i,1);
        end loop;
    dbms_output.put_line(number1 || ' Reverse Number : ' || result1);
end;

/*Cursor with parameters example */

declare
    emprec emp%rowtype;
    CURSOR c_emp (job1 VARCHAR2, job2 VARCHAR2)
    IS
        select * from emp where job in(job1,job2);
   
begin
    open c_emp('MANAGER','ANALYST');
    loop
    fetch c_emp into emprec;
    exit when c_emp%NOTFOUND;    
    dbms_output.put_line(emprec.empno || '     ' || emprec.ename || '    ' || emprec.deptno || '    ' || emprec.sal || '    ' || emprec.job); 
    end loop;
    close c_emp;
end;