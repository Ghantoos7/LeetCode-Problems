/* Write your PL/SQL query statement below */

select email
from (
    select count(*) as email_count, email
    from Person
    group by email
)
where email_count > 1;