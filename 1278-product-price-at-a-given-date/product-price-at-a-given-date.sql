# Write your MySQL query statement below
SELECT product_id, new_price AS price
FROM (
    SELECT product_id, new_price, 
           ROW_NUMBER() OVER (PARTITION BY product_id ORDER BY change_date DESC) AS current
    FROM products
    WHERE change_date <= '2019-08-16'
) AS latest_price
where current=1

union 

select product_id, 10 as price
from products
where product_id not in (
    select distinct(product_id)
    from products 
    where change_date <= '2019-08-16'
)
