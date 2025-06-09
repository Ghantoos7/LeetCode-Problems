# Write your MySQL query statement below



WITH TEMP AS (

    SELECT pr.employee_id AS employee_id , e.name as name, pr.review_date as review_date , pr.rating as rating, 
    ROW_NUMBER() OVER (PARTITION BY pr.employee_id  ORDER BY pr.review_date DESC) AS review_rank
    FROM performance_reviews pr 
    LEFT JOIN employees e on pr.employee_id = e.employee_id
    

), COUNTED AS (
    SELECT employee_id, name, review_date, rating, review_rank
    FROM TEMP
    WHERE review_rank <= 3

), LATEST_THREE AS (

    SELECT employee_id, name,
        MAX(CASE WHEN review_rank = 1 THEN rating END) AS r1,
        MAX(CASE WHEN review_rank = 2 THEN rating END) AS r2,
        MAX(CASE WHEN review_rank = 3 THEN rating END) AS r3
    FROM COUNTED
    GROUP BY employee_id, name
)

SELECT employee_id, name,
r1-r3 as improvement_score 
FROM  LATEST_THREE
WHERE r1 > r2 AND r2 > r3 AND r3 IS NOT NULL
ORDER BY improvement_score DESC, name ASC