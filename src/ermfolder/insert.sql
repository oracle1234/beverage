select * from b_member;
insert into b_member(member_num, name, gender, email, birth_date, member_id, password) 
values(SEQ_b_member_member_num.nextval,'유재민', '남', 'dfw@nate.com', '12341212', 'qwerasd', '123456');


select * from B_CAFE;
insert into b_cafe(cafe_id, cafe_name)
values(SEQ_b_cafe_cafe_id.nextval, '스타벅스');
insert into b_cafe(cafe_id, cafe_name)
values(SEQ_b_cafe_cafe_id.nextval, '투썸');
insert into b_cafe(cafe_id, cafe_name)
values(SEQ_b_cafe_cafe_id.nextval, '할리스');
insert into b_cafe(cafe_id, cafe_name)
values(SEQ_b_cafe_cafe_id.nextval, '이디야');


select * from B_BEVERAGE;
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 4000, '커피', '아메리카노', '왜부적합하니');
 



































