-- Delete Existing Data:
-- truncate table customer_options;
-- truncate table question_options;
-- truncate table question;
-- truncate table address;
-- truncate table customer;
-- truncate table theme;
-- truncate table theme_category;

use mobily;

-- ID STARTS FROM
-- customer        101
-- address         201
-- theme_category  301
-- theme           401
-- question        501

INSERT INTO theme_category(`name`, `description`) VALUES ("category1", "category1");
INSERT INTO theme_category (`name`, `description`) VALUES ("category2", "category2");
INSERT INTO theme_category (`name`, `description`) VALUES ("category3", "category3");
INSERT INTO theme_category (`name`, `description`) VALUES ("category4", "category4");
INSERT INTO theme_category (`name`, `description`) VALUES ("category5", "category5");

INSERT INTO theme(`name`,`category_id`,`description`)VALUES("theme1",301,"theme1");
INSERT INTO theme(`name`,`category_id`,`description`)VALUES("theme2",301,"theme2");
INSERT INTO theme(`name`,`category_id`,`description`)VALUES("theme3",302,"theme3");
INSERT INTO theme(`name`,`category_id`,`description`)VALUES("theme4",302,"theme4");
INSERT INTO theme(`name`,`category_id`,`description`)VALUES("theme5",303,"theme5");
INSERT INTO theme(`name`,`category_id`,`description`)VALUES("theme6",303,"theme6");
INSERT INTO theme(`name`,`category_id`,`description`)VALUES("theme7",304,"theme7");
INSERT INTO theme(`name`,`category_id`,`description`)VALUES("theme8",304,"theme8");

INSERT INTO customer(`user_name`,`password`,`encrypt_key`,`theme_id`,`first_name`,`last_name`,`email`,`self_description`)VALUES("user1","user1","wwwwwfsad",402,"aaa","bbb","bbb@gmail.com","user1");
INSERT INTO customer(`user_name`,`password`,`encrypt_key`,`theme_id`,`first_name`,`last_name`,`email`,`self_description`)VALUES("user2","user2","wwwwwfsad",402,"ccc","ddd","bbb@gmail.com","user2");

INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`)VALUES(101,"main office","89","landmark1","street1","area1","district1","city1","453245","646432365465","4534542355675");
INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`)VALUES(101,"main office","89","landmark1","street1","area1","district1","city1","453245","646432365465","4534542355675");
INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`)VALUES(101,"main office","89","landmark1","street1","area1","district1","city1","453245","646432365465","4534542355675");
INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`)VALUES(101,"main office","89","landmark1","street1","area1","district1","city1","453245","646432365465","4534542355675");
INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`)VALUES(101,"main office","89","landmark1","street1","area1","district1","city1","453245","646432365465","4534542355675");
INSERT INTO address(`customer_id`,`address_type`,`door_num`,`landmark`,`street`,`area_name`,`district`,`city`,`postal_code`,`phone1`,`phone2`)VALUES(101,"main office","89","landmark1","street1","area1","district1","city1","453245","646432365465","4534542355675");

INSERT INTO question(`question`)VALUES("Question1");
INSERT INTO question(`question`)VALUES("Question2");
INSERT INTO question(`question`)VALUES("Question3");
INSERT INTO question(`question`)VALUES("Question4");

INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(501,"a","option1");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(501,"b","option2");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(501,"c","option3");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(501,"d","option4");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(501,"e","option5");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(502,"a","option1");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(502,"b","option2");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(502,"c","option3");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(502,"d","option4");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(503,"a","option1");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(503,"b","option2");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(503,"c","option3");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(504,"a","option1");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(504,"b","option2");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(504,"c","option3");
INSERT INTO question_options(`question_id`,`option_id`,`option_description`)VALUES(504,"d","option4");

INSERT INTO customer_options(`customer_id`,`question_id`,`option_id`)VALUES(101,501,"a");
INSERT INTO customer_options(`customer_id`,`question_id`,`option_id`)VALUES(102,502,"b");
INSERT INTO customer_options(`customer_id`,`question_id`,`option_id`)VALUES(101,502,"a");
INSERT INTO customer_options(`customer_id`,`question_id`,`option_id`)VALUES(102,503,"c");
INSERT INTO customer_options(`customer_id`,`question_id`,`option_id`)VALUES(101,501,"d");
INSERT INTO customer_options(`customer_id`,`question_id`,`option_id`)VALUES(102,504,"a");
INSERT INTO customer_options(`customer_id`,`question_id`,`option_id`)VALUES(101,501,"c");
INSERT INTO customer_options(`customer_id`,`question_id`,`option_id`)VALUES(102,503,"a");
INSERT INTO customer_options(`customer_id`,`question_id`,`option_id`)VALUES(101,503,"a");

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

