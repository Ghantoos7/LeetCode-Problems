# Write your MySQL query statement below



SELECT u.name AS name, 
       COALESCE(SUM(r.distance),0) AS travelled_distance 
FROM Users u 
LEFT JOIN Rides r ON r.user_id = u.id
GROUP BY u.id
ORDER BY travelled_distance DESC, name ASC;

