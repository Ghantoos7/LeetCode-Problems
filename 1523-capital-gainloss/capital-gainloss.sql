# Write your MySQL query statement below

with temp as (

SELECT stock_name,
    CASE 
        WHEN operation = 'Buy' THEN price * -1
        ELSE price
    END AS price
from Stocks 

)


select stock_name , SUM(price) as capital_gain_loss
from temp
group by stock_name