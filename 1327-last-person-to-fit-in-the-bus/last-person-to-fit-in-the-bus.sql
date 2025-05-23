SELECT person_name
FROM (
    SELECT person_name,
           SUM(weight) OVER (ORDER BY turn) AS total_up_now
    FROM queue
) AS sub
WHERE total_up_now <= 1000
ORDER BY total_up_now DESC
LIMIT 1;
