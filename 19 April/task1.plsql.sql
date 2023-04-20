set SERVEROUTPUT ON;
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

l_max_salary_in_table NUMBER:=0;
BEGIN
    -- check if max salary is less than min salary
    dbms_output.put_line('2');
    if IN_MIN_SALARY > IN_MAX_SALARY THEN
        --dbms_output.put_line('1');
        -- raise exception
        RAISE_APPLICATION_ERROR(-1,'INVALID_MINMAX_SALARY');
        
    ELSE
        --dbms_output.put_line('inside');
        select MAX(SAL) into l_max_salary_in_table from EMPL where JOB=in_job;
        --Check for max salary for the given job
        --if max salary is less than max salary in param
        if l_max_salary_in_table < IN_MAX_SALARY THEN
        -- then update empl for those job as salary = max salary
            update EMPL SET SAL=IN_MAX_SALARY WHERE JOB=in_job;
        -- else
        -- show message max salary already match for the given job
        ELSE
            dbms_output.put_line('max salary already match for the given job');
        END IF;
    END IF;
    
    
   
END;
/

exec UPD_SAL('MANAGER',0,10000);

select * from EMPL where job='MANAGER'