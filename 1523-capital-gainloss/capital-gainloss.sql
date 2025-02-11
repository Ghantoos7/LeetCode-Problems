Select stock_name, sum(case 
    when operation = "Buy" then  - price
    Else price end) as capital_gain_loss
From Stocks
Group by stock_name