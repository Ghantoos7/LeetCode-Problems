# Write your MySQL query statement below

select
t.driver_id,
d.driver_name,

ROUND(AVG(CASE WHEN MONTH(t.trip_date) <= 6 then (distance_km / fuel_consumed) else NULL END),2) as first_half_avg   ,
ROUND(AVG(CASE WHEN MONTH(t.trip_date) > 6 then (distance_km / fuel_consumed) else NULL END),2 ) as 
second_half_avg   ,
ROUND((AVG(CASE WHEN MONTH(t.trip_date) > 6 then (distance_km / fuel_consumed) else NULL END) ) - (AVG(CASE WHEN MONTH(t.trip_date) <= 6 then (distance_km / fuel_consumed) else NULL END)),2) AS efficiency_improvement 

FROM trips t 
LEFT JOIN drivers d on t.driver_id = d.driver_id
group by t.driver_id, d.driver_name
having(first_half_avg < second_half_avg )
ORDER BY efficiency_improvement desc, d.driver_name asc