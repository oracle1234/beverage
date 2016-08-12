select * from b_member;
insert into b_member(member_num, name, gender, email, birth_date, member_id, password) 
values(SEQ_b_member_member_num.nextval,'a', '남', 'dfw@nate.com', '20001212', 'a', 'a');


select * from B_CAFE;
insert into b_cafe(cafe_id, cafe_name)
values(SEQ_b_cafe_cafe_id.nextval, '스타벅스');
insert into b_cafe(cafe_id, cafe_name)
values(SEQ_b_cafe_cafe_id.nextval, '투썸');
insert into b_cafe(cafe_id, cafe_name)
values(SEQ_b_cafe_cafe_id.nextval, '할리스');
insert into b_cafe(cafe_id, cafe_name)
values(SEQ_b_cafe_cafe_id.nextval, '이디야');


select * from B_MEMBER;

 --1 스타벅스
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 4500,'커피', '콜드브루',  '');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5000,'커피', '콜드브루 라떼', '');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5600,'커피', '카라멜마키아또',  '');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5600,'커피','화이트초코모카', '');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 4600,'커피', '카페라떼', '');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 4100,'커피', '카페아메리카노',  '');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5900,'티', '제주 티 라떼',  '');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5900,'티', '그린 티 라떼', '');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5100,'티', '차이 티 라떼', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 4000,'주스', '사과당근주스',  ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 4500,'주스', '자몽주스',  ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 3800, '주스','토마토주스',  ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 6100,'기타', '애플망고 요거트',  ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 6100,'기타', '딸기요거트',  ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 6700,'기타', '베리베리 요거트',  ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5000,'기타', '망고패션 후르츠',  ' ');

-- 투썸
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4100, '커피', '아메리카노', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4400, '커피', '카페라떼', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4900, '커피', '바닐라라떼', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 5400, '커피', '카랴멜마끼야또', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 3300, '커피', '에스프레소', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4000, '티', '아이스티', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 5300, '티', '마샬라 차이 라떼', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4800, '티', '그린티 라떼', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4500, '티', '핫초콜릿', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4800, '티', '허브티', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4800, '티', '블랙티', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 5500, '주스', '키위 바나나 주스', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 6000, '주스', '오렌지 자몽 주스', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4300, '기타', '플레인 요거트', '투썸');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4800, '기타', '플레인 요거트 아이스크림', '투썸');



--3번 할리스
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 4500, '커피', '콜드브루 라떼', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5000, '커피', '콜드브루', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 4100, '커피', '아메리카노', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5100, '커피', '카페모카', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5100, '커피', '화이트 카페모카', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5500, '커피', '카라멜 마끼아또', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 4500, '커피', '카푸치노', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 4500, '커피', '카페라떼', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 3600, '커피', '에스프레소', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5000, '주스', '리얼 청포도주스', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5000, '주스', '리얼 키위주스', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5000, '기타', '리얼 파인애플주스', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5500, '기타', '딸기 스무디', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5500, '기타', '딸기 스무디', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5500, '기타', '골드키위 스무디', ' ');


 
--이디야 ------------
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 2300, '커피', '에스프레소', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 2800, '커피', '카페아메리카노', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3200, '커피', '카페라떼', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3500, '커피', '카페모카', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3500, '커피', '카라멜마끼아또', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3500, '티', '레몬티', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3500, '티', '밀크티', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 2500, '티', '아이스티복숭아', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 2500, '티', '아이스티레몬', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '주스', '딸기주스', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '주스', '골드키위주스', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '주스', '홍시주스', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '기타', '플레인요거트', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '기타', '딸기요거트', ' ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '기타', '녹차요거트', ' ');



