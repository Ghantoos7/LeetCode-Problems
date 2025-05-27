WITH seasons AS (
    SELECT *, 
        CASE 
            WHEN MONTH(sale_date) IN (12, 1, 2) THEN 'Winter'
            WHEN MONTH(sale_date) IN (3, 4, 5) THEN 'Spring'
            WHEN MONTH(sale_date) IN (6, 7, 8) THEN 'Summer'
            WHEN MONTH(sale_date) IN (9, 10, 11) THEN 'Fall'
        END AS season
        , quantity * price as revenue
    FROM sales
), temp AS (
    SELECT  
        SUM(s.quantity) AS total_quantity, 
        s.season, 
        p.category,
        SUM(s.revenue) as total_revenue
    FROM seasons s
    LEFT JOIN products p ON s.product_id = p.product_id 
    GROUP BY s.season, p.category
), seasons_rank as (

    SELECT *,
    ROW_NUMBER() OVER(PARTITION BY season ORDER BY total_quantity DESC, total_revenue DESC) as season_rank
    FROM temp
)

SELECT season, category, total_quantity, total_revenue
from seasons_rank
where season_rank = 1;

