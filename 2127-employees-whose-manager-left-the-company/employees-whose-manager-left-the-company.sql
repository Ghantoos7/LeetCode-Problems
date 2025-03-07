# Write your MySQL query statement below

select employee_id 
FROM Employees 
WHERE salary < 30000 and manager_id NOT IN (
                            SELECT DISTINCT(employee_id)
                            FROM Employees)
ORDER BY employee_id ASC