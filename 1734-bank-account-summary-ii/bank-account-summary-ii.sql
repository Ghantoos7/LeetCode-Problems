# Write your MySQL query statement below


select u.name, SUM(t.amount) AS balance
FROM Transactions t
LEFT JOIN Users u ON t.account = u.account
GROUP BY u.account
HAVING SUM(t.amount) > 10000 