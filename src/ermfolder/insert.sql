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

select*from B_FAVOR
select * from B_MEMBER;

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 4500,'커피', '콜드브루',  '스타벅스 바리스타의 정성으로 탄생한 콜드 브루!
콜드 브루 전용 원두를 차가운 물로 14시간 동안 추출하여 한정된 양만 제공됩니다. 
깊은 풍미의 새로운 커피 경험을 즐겨보세요.');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5000,'커피', '콜드브루 라떼', '스타벅스 바리스타의 정성으로 탄생한 콜드 브루 라떼! 

콜드 브루의 깊은 풍미와 더욱 깔끔한 라떼의 맛을 즐길 수 있습니다.');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5600,'커피', '카라멜마키아또',  '바닐라 시럽과 우유, 그리고 그 위에 얹어진 에스프레소 샷과 달콤한 카라멜 드리즐의 조화');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5600,'커피','화이트초콜릿모카', '화이트 초콜릿과 스팀밀크가 첨가된 에스프레소 음료.');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 4600,'커피', '카페라떼', '에스프레소 샷과 따뜻한 우유와 거품으로 마무리 된 음료.');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 4100,'커피', '카페아메리카노',  '강렬한 에스프레소 샷에 뜨거운 물의 조화');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5900,'티', '제주 호지 티 라떼',  '녹차를 한 번 더 덖어 고소한 맛을 만들어내는, 제주 호지 차를 이용한 스타벅스의 새로운 티 라떼 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5900,'티', '그린 티 라떼', '시원하게 즐기는, 약간의 시럽과 우유, 쌉싸름한 녹차가 혼합된 밀크 티');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5100,'티', '차이 티 라떼', '시원하게 즐기는 이국적인 향과 계피맛이 특징적인 블랙 티 
(약 5분 정도의 티 추출 시간이 소요됩니다.)');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 4000,'주스', '비트&사과주스',  '빈혈에 좋은 비트와 새콤 달콤한 사과가 혼합된 주스');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 4500,'주스', '자몽주스',  '오렌지와 자몽의 상큼함이 함께 느껴지는 과일 주스');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 3800, '주스','토마토주스',  '국내산 토마토의 생생함이 그대로 담겨 있는 주스');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 6100,'기타', '망고바나나',  '인기 음료인 망고 패션후르츠 블렌디드에 신선한 바나나 1개가 통째로 들어간 달콤한 프라푸치노');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 6100,'기타', '딸기요거트',  '딸기와 요거트의 상큼함이 가득 느껴지는 가벼운 컨셉의 블렌디드 음료입니다.');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 6700,'기타', '베리베리 요거트',  '다양한 고객층에서 사랑 받는 세 가지 베리 류의 과일과 가벼운 저지방 요거트가 함께 믹스되어 신선하고 건강하게 즐길 수 있는 블렌디드 음료입니다.');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 1, 5000,'기타', '망고패션 후르츠',  '갓 추출한 타조 티에 망고 패션 후르츠 주스가 조합된 아이스 블렌드 음료');

--2번 투썸
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4100, '커피', '아메리카노', '진하게 로스팅한 커피 원두에서 에스프레소를 추출하여 시원한 얼음을 담아 산뜻하게 즐길 수 있는 깔끔한 스타일의 에스프레소 음료');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4400, '커피', '카페라떼', '풍부하고 진한 농도의 에스프레소와 시원한 우유가 어우러진 부드러운 에스프레소 음료');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4900, '커피', '바닐라라떼', '달콤한 바닐라 향과 풍부한 에스프레소가 조화를 이룬 부드러운 라떼');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 5400, '커피', '카랴멜마끼야또', '잘 어우러진 바닐라 향과 우유, 에스프레소 샷 위에 카라멜 소스를 뿌려 시원하면서도 달콤하게 즐길 수 있는 에스프레소 음료');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 3300, '커피', '에스프레소', '에스프레소 원액에 휘핑크림이 어우러져 진한 향과 휘핑크림의 부드럽고 달콤한 맛을 함께 느낄 수 있는 에스프레소 음료');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4000, '티', '아이스티', '복숭아 아이스티');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 5300, '티', '마샬라 차이 라떼', '새로운 블렌딩으로 재탄생한 다질리언 마샬라 차이 향신료의 조각 크기를 조금 키우고 가루사용을 최소화하여 맛은 더욱 선명해지고 향신료 비중을 대폭 높혀 풍부한 스파이스향을 느낄수 있는 티라떼');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4800, '티', '그린티 라떼', '녹차향과 우유가 만나 입안 가득 부드러움을 느낄 수 있는 티라떼');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4500, '티', '핫초콜릿', '초콜릿의 풍부한 맛과 휘핑크림, 초코칩이 조화로운 달콤한 초콜릿 음료');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4800, '티', '허브티', '아쌈 : 뚜렷하고 강한 맛이 나며 몰트향과 색이 조화로운 티 얼그레이 : 베르가못 과실향이 특징인 깔끔하면서 우아한 티   잉글리쉬 브렉퍼스트 : 실론차와 인도차를 블렌딩한 티로 맛과 향에서 진한 무게감이 느껴지는 티  민트 : 민트의 시원한 맛과 향기가 특징인 깔끔한 허브티     카모마일 : 국화과에 속하는 노란꽃 티로 은은한 향이 나며 카페인이 없는 티');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4800, '티', '블랙티', '진하고 고소한 맛의 아쌈 CTC 잎을 블렌딩하여 밀크티로 즐기며 세븐어클락에 바닐라 향을 첨가한 티라떼');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 5500, '주스', '키위 바나나 주스', '그린키위와 바나나가 블렌딩 된 주스');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 6000, '주스', '오렌지 자몽 주스', '통 오렌지와 자몽을 블렌딩한 상큼함이 입안 가득 느껴지는 주스');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4300, '기타', '플레인 요거트', '상큼하고 부드러운 투썸 그릭요거트 아이스크림');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 2, 4800, '기타', '플레인 요거트 아이스크림', '상큼하고 부드러운 투썸 그릭요거트 아이스크림');



--3번 할리스

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 4500, '커피', '콜드브루 라떼', '콜드브루 커피의 풍부한 풍미와 우유의 고소함이 더해진 라떼');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5000, '커피', '콜드브루', '찬물로 추출해서 향미가 풍부한 할리스 콜브브루');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 4100, '커피', '아메리카노', '진한 에스프레소의 맛과 향을 부드럽게 즐길 수 있는 아메리칸 스타일의 커피');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5100, '커피', '카페모카', '진한 에스프레소와 우유, 달콤 쌉싸름한 초콜릿이 어우러진 커피');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5100, '커피', '화이트 카페모카', '화이트 초콜렛과 에스프레소가 만나 한층 더 부드러운 초콜릿맛을 즐길 수 있는 커피');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5500, '커피', '카라멜 마끼아또', '진한 에스프레소에 바닐라 시럽과 카라멜소스가 더해진 카라멜 커피음료의 대표');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 4500, '커피', '카푸치노', '에스프레소에 실키하고 폭신폭신한 우유 거품이 풍부하게 더해진 커피');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 4500, '커피', '카페라떼', '진한 에스프레소에 우유를 넣어 풍부한 커피향을 부드럽게 즐길 수 있는 커피');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 3600, '커피', '에스프레소', '강렬한 첫 맛, 풍부한 바디감, 깔끔한 뒷 맛이 특징인 커피의 심장');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5000, '주스', '리얼 청포도주스', '신선한 청포도 생과일을 직접 갈아 만든 주스');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5000, '주스', '리얼 키위주스', '신선한 그린키위를 통째로 갈아 과육과 과즙이 그대로 살아있는 100% 천연 그린키위 주스');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5000, '기타', '리얼 파인애플주스', '신선한 파인애플를 통째로 갈아 과육과 과즙이 그대로 살아있는 100% 천연 파인애플 주스');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5500, '기타', '망고 스무디', '리얼 망고과육을 그대로 넣어 본연의 맛을 살린 스무디');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5500, '기타', '딸기 스무디', '리얼 딸기과육을 그대로 넣어 본연의 맛을 살린 스무디');

insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 3, 5500, '기타', '골드키위 스무디', '뉴질랜드산 골드 키위를 사용하여 키위 고유의 상큼함과 비타민이 풍부한 스무디');



 
--이디야 ------------
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 2300, '커피', '에스프레소', ' 정통 이탈리안 방식으로 고압을 이용하여 빠르게 추출된 커피 이디야의 모든 음료의 기본');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 2800, '커피', '카페아메리카노', '에스프레소에 정수된 물을 혼합한 커피 이디야의 스모키한 맛과 풍부한 바디감을 느낄 수 있는 이디야 대표 음료 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3200, '커피', '카페라떼', '진한 에스프레소와 부드러운 우유가 만나 고소한 풍미를 더하는 메뉴 가장 대중적인 메뉴 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3500, '커피', '카페모카', '모카시럽을 만나 한층 풍부해진 에스프레소에 우유로 부드러움을 더한 달콤한 휘핑크림이 곁들여진 음료 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3500, '커피', '카라멜마끼아또', '폼 밀크 속에 감춰진 카라멜의 달콤함과 에스프레소의 진한 맛이 돋보이는 이디야의 인기 메뉴 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3500, '티', '레몬티', '비타민C가 풍부하고, 레몬의 상큼함을 즐길 수 있는 음료 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3500, '티', '밀크티', '잉글리시 브랙퍼스트와 바닐라향이 어우러져 따뜻한 우유에 은은하게 퍼지는 향이 돋보이는 음료 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 2500, '티', '아이스티복숭아', '홍차의 깊은 맛과 풍부한 복숭아 향이 어우러진 달콤한 여름철 인기 음료 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 2500, '티', '아이스티레몬', '입안 가득 상큼한 레몬향이 퍼지는 새콤달콤한 맛의 아이스티 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '주스', '딸기주스', '국내산 딸기 과육을 그대로 넣어 새콤하고 달콤한 딸기 본연의 맛을 느낄 수 있는 음료 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '주스', '골드키위주스', '고급 골드키위를 사용하여 비타민 C가 풍부하고 상큼한 음료 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '주스', '홍시주스', '부드럽고 달콤한 홍시 본연의 맛을 느낄 수 있는 음료 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '기타', '플레인요거트', '요거트 고유의 새콤달콤한 맛을 그대로 살린 메뉴로 여성들에게 인기가 좋은 음료 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '기타', '딸기요거트', '남녀노소 누구나 좋아하는 딸기와 상큼한 요커트가 조화롭게 어우려진 플랫치노 ');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '기타', '녹차요거트', '녹차의 깊은 맛과 요거트의 상큼함이 어우러진 플랫치노 ');
