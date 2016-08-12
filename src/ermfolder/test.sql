select cafe_id, cafe_name, count(*) as "count"
from b_cafe 
where cafe_id = 5
group by cafe_id, cafe_name;



insert into b_cafe(cafe_id, cafe_name)
values(SEQ_b_cafe_cafe_id.nextval, ?);


delete from b_cafe where cafe_id = 22;


delete from b_beverage where beverage_id = ? CASCADE CONSTRAINTS;


insert into b_review values(1, 2, '들어있어요~~', 'ssss');

select * from b_review;

delete from b_beverage where beverage_id = '1';


select * from b_cafe;

select * from b_review;

select * from b_favor;

select * from b_member;


select * from b_beverage order by beverage_price;

select 
from b_favor f, b_member m, b_review r



select avg(review_level) from b_review where beverage_id = ? group by beverage_id;


select * from b_favor where member_num=2;
