/* Write your PL/SQL query statement below */

select name as Customers 
from Customers
where id in (
select id 
from Customers
where id not in(
    select customerId  
    from Orders
    )
);

