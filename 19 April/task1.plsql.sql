/*
Create a stored procedure called UPD_SAL to update the  salaries
for a specific job in the EMP table.
Pass three parameters to the procedure: the job , a new minimum salary, and a new
maximum salary for the job. Add exception handling to account for an invalid job name in the
EMP table. Also, raise an exception if the maximum salary supplied is less than the
minimum salary.
*/
CREATE OR REPLACE PROCEDURE UPD_SAL (IN_JOB in varchar2,IN_MIN_SALARY in NUMBER,IN_MAX_SALARY in NUMBER)     
IS
BEGIN
    
    SELECT 1 from dual;
END;
/