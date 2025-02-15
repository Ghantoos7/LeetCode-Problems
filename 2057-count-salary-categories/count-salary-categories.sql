# Write your MySQL query statement below


WITH categories AS (
    SELECT 'Low Salary' AS category
    UNION ALL
    SELECT 'Average Salary'
    UNION ALL
    SELECT 'High Salary'
), temp AS (
    SELECT account_id, income, 
        CASE 
            WHEN income < 20000 THEN 'Low Salary'
            WHEN income >= 20000 AND income <= 50000 THEN 'Average Salary'
            WHEN income > 50000 THEN 'High Salary'
        END AS category  
    FROM Accounts 
)
SELECT c.category, COALESCE(t.accounts_count, 0) AS accounts_count
FROM categories c
LEFT JOIN (
    SELECT category, COUNT(*) AS accounts_count
    FROM temp
    GROUP BY category
) t ON c.category = t.category;
