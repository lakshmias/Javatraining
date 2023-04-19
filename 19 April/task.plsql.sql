/*
Create a program to retrieve the number of years of service for a specific employee.


*/
/*Make these functions available in a package name EMPPACK
*/
--select floor(months_between(CURRENT_DATE,Hiredate)/12),EMPNO from emp;
/*
a. Create a stored function called GET_SERVICE_YRS to retrieve the total number of years
of service for a specific employee.
*/
CREATE OR REPLACE PACKAGE EMPPACK as
BEGIN
CREATE OR REPLACE FUNCTION GET_SERVICE_YRS (EMPNUMBER integer)
    RETURN NUMBER
IS
     
    lNumberOfYearsOfExperience NUMBER :=0;
    BEGIN
    select floor(months_between(CURRENT_DATE,Hiredate)/12)
    
    into lNumberOfYearsOfExperience
    from emp
    where EMPNO =EMPNUMBER;
    return lNumberOfYearsOfExperience;
    /*The function should accept the employee ID as a parameter and return the number of years
    of service. Add error handling to account for an invalid employee ID.*/
    
    Exception
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Employee ID Not found');
            RETURN lNumberOfYearsOfExperience;
END;
/
/*b. Invoke the function. You can use the following data:
EXECUTE DBMS_OUTPUT.PUT_LINE(get_service_yrs(999))
Hint: The above statement should produce an error message because there is no employee
with employee ID 999.*/
EXECUTE DBMS_OUTPUT.PUT_LINE(get_service_yrs(999)) ;

 

/*EXECUTE DBMS_OUTPUT.PUT_LINE ('Approximately .... ' ||get_service_yrs(7499) || ' years')
Hint: The above statement should be successful and return the number of years of service
for employee with employee ID 7499
*/
EXECUTE DBMS_OUTPUT.PUT_LINE ('Approximately .... ' ||get_service_yrs(7499) || ' years')
 
END;

