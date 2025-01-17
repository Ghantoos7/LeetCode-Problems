SELECT request_at as "Day", average_cancellations as "Cancellation Rate" 
FROM (
    SELECT 
        t.request_at, 
        COUNT(CASE 
                  WHEN t.status IN ('cancelled_by_driver', 'cancelled_by_client') THEN 1 
                  ELSE NULL 
              END) AS cancellation_count,
        ROUND(AVG(CASE 
                     WHEN t.status IN ('cancelled_by_driver', 'cancelled_by_client') THEN 1 
                     ELSE 0 
                 END), 2) AS average_cancellations
    FROM 
        Trips t
    LEFT JOIN 
        Users u1 ON t.client_id = u1.users_id
    LEFT JOIN 
        Users u2 ON t.driver_id = u2.users_id
    WHERE 
        t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
        AND u2.banned != 'Yes' 
        AND u1.banned != 'Yes'
    GROUP BY 
        t.request_at
) AS cancellation_table;
