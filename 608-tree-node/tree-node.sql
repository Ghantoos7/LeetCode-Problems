# Write your MySQL query statement below
SELECT id, 
CASE 
WHEN p_id is NULL then 'Root' 
WHEN id IN (SELECT p_id FROM Tree) then 'Inner' 
else 'Leaf' 
END type 
FROM Tree 