# Write your MySQL query statement below

select employee_id , department_id 
FROM Employee
GROUP BY employee_id 
HAVING COUNT(*)=1

UNION

select employee_id , department_id 
FROM Employee
WHERE primary_flag = "Y"
