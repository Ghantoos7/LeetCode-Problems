

select s.user_id , 
    ROUND(AVG(Case
    when c.action="timeout" then 0
    when c.action is null then 0
    else 1 
    End),2) as confirmation_rate
from Signups s
left join Confirmations c on s.user_id = c.user_id 
group by s.user_id