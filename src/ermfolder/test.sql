select cafe_id, cafe_name, count(*) as "count"
from b_cafe 
where cafe_id = 5
group by cafe_id, cafe_name;