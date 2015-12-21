-- Delete Existing Data:
-- truncate table customer_options;
-- truncate table question_options;
-- truncate table question;
-- truncate table address;
-- truncate table customer;
-- truncate table theme;
-- truncate table theme_category;

use mobily_dev;

-- ID STARTS FROM
-- customer        101
-- address         201
-- theme_category  301
-- theme           401
-- question        501
-- opations        601
INSERT INTO theme_category(`name`, `description`) VALUES ("category1", "category1");
INSERT INTO theme_category (`name`, `description`) VALUES ("category2", "category2");

INSERT INTO theme(`name`,`category_id`,`description`)VALUES("theme1",301,"theme1");
INSERT INTO theme(`name`,`category_id`,`description`)VALUES("theme2",301,"theme2");
INSERT INTO theme(`name`,`category_id`,`description`)VALUES("theme3",302,"theme3");
INSERT INTO theme(`name`,`category_id`,`description`)VALUES("theme4",302,"theme4");

INSERT INTO customer(`user_name`,`password`,`encrypt_key`,`theme_id`,`first_name`,`last_name`,`email`,`self_description`)VALUES("user1","user1","wwwwwfsad",402,"aaa","bbb","bbb@gmail.com","user1");
INSERT INTO customer(`user_name`,`password`,`encrypt_key`,`theme_id`,`first_name`,`last_name`,`email`,`self_description`)VALUES("user2","user2","wwwwwfsad",402,"ccc","ddd","bbb@gmail.com","user2");
INSERT INTO customer(`user_name`,`password`,`encrypt_key`,`first_name`,`last_name`,`email`,`self_description`)VALUES("user3","user3","wwwwwfsad","aaa","bbb","bbb@gmail.com","user3");
INSERT INTO customer(`user_name`,`password`,`encrypt_key`,`first_name`,`last_name`,`email`,`self_description`)VALUES("user4","user4","wwwwwfsad","ccc","ddd","bbb@gmail.com","user4");

INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`)VALUES(101,"main office","89","landmark1","street1","area1","district1","city1","453245","646432365465","4534542355675");
INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`)VALUES(101,"main office","89","landmark2","street2","area2","district2","city2","7457646432","453454675","53425324");
INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`)VALUES(102,"main office","89","landmark3","street3","area3","district3","city3","453245","646432365465","4534542355675");

INSERT INTO question(`question`)VALUES("Question1");
INSERT INTO question(`question`)VALUES("Question2");

INSERT INTO question_options(`question_id`,`option_key`,`option_description`)VALUES(501,"a","option1");
INSERT INTO question_options(`question_id`,`option_key`,`option_description`)VALUES(501,"b","option2");
INSERT INTO question_options(`question_id`,`option_key`,`option_description`)VALUES(502,"a","option1");
INSERT INTO question_options(`question_id`,`option_key`,`option_description`)VALUES(502,"b","option2");

INSERT INTO customer_options(`customer_id`,`option_id`)VALUES(101,601);
INSERT INTO customer_options(`customer_id`,`option_id`)VALUES(102,602);
INSERT INTO customer_options(`customer_id`,`option_id`)VALUES(101,603);
INSERT INTO customer_options(`customer_id`,`option_id`)VALUES(102,604);

-- SET @g1 = 'POINT(1 1)';
-- SET @g2 = 'POINT(1 2)';
-- SET @g3 = 'POINT(1 3)';
-- SET @g4 = 'POINT(1 4)';
-- SET @g5 = 'POINT(1 5)';
-- SET @g6 = 'POINT(1 6)';

-- INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`,`location`)VALUES(101,"main office","89","landmark1","street1","area1","district1","city1","453245","646432365465","4534542355675",ST_GeomFromText(@g1));
-- INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`,`location`)VALUES(101,"main office","89","landmark1","street1","area1","district1","city1","453245","646432365465","4534542355675",ST_GeomFromText(@g2));
-- INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`,`location`)VALUES(101,"main office","89","landmark1","street1","area1","district1","city1","453245","646432365465","4534542355675",ST_GeomFromText(@g3));
-- INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`,`location`)VALUES(101,"main office","89","landmark1","street1","area1","district1","city1","453245","646432365465","4534542355675",ST_GeomFromText(@g4));
-- INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`,`location`)VALUES(101,"main office","89","landmark1","street1","area1","district1","city1","453245","646432365465","4534542355675",ST_GeomFromText(@g5));
-- INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`,`location`)VALUES(101,"main office","89","landmark1","street1","area1","district1","city1","453245","646432365465","4534542355675",ST_GeomFromText(@g6));

