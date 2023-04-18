/*No 13:
36. Display the first 5 records of the EMP table.
*/
select * from EMP where rownum<6

 

--37. List the emps empno, ename, job, sal of all emps.
select empNo,EName,JOB,SAL from emp;
--38. List all the unique deptno of emps.
select distinct DEPTNO from EMP;