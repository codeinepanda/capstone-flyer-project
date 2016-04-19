-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

-- TEST 

-- users -- 
INSERT INTO user (first_name, last_name, password, salt, user_id, email) VALUES ('Hayden', 'Thompson', 'byXr2Bu18+NoGlGHT3AczA==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'mhaydent', 'hayden@techelevator.com');
INSERT INTO user (first_name, last_name, password, salt, user_id, email) VALUES ('Kevin', 'Glick', 'byXr2Bu18+NoGlGHT3AczA==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'keving', 'kevin@techelevator.com');
INSERT INTO user (first_name, last_name, password, salt, user_id, email) VALUES ('Jonathan', 'Funk', 'byXr2Bu18+NoGlGHT3AczA==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'jfunk', 'funk@techelevator.com');
INSERT INTO user (first_name, last_name, password, salt, user_id, email) VALUES ('Sean', 'Jenkins', 'byXr2Bu18+NoGlGHT3AczA==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'sjenkins', 'sean@techelevator.com');

-- flyer --
INSERT INTO flyer (company, flyer_id, user_name, flyer_name, start_date, end_date, num_tabs, flyer_info) VALUES ('TECH ELEVATOR', '1','keving', 'Car Wash', '2016-01-01' , '2016-30-01','4', 'free car wash! redeem tab');
INSERT INTO flyer (company, flyer_id, user_name, flyer_name, start_date, end_date, num_tabs, flyer_info) VALUES ('TECHNO ESCALATOR', '2','mhaydent', 'FREE DJ', '2016-21-12' , '2016-31-12','5', 'free DJ! redeem tab');
INSERT INTO flyer (company, flyer_id, user_name, flyer_name, start_date, end_date, num_tabs, flyer_info) VALUES ('TECHNOLOGICAL ELEPHANT', '3','jfunk', 'Mind Reading Class', '2016-11-11' , '2016-12-12','7', 'Come learn how to read your own mind!! redeem tab');
INSERT INTO flyer (company, flyer_id, user_name, flyer_name, start_date, end_date, num_tabs, flyer_info) VALUES ('LOGICAL ELEPHANT', '4','sjenkins', 'Rebellion Signup', '2016-21-12' , '2016-31-12','20', 'Freedom Fighters Rebellion Sign Up! redeem tab');

-- tab -- 

INSERT INTO tab (flyer_id, user_id) VALUES ('1','keving');
INSERT INTO tab (flyer_id, user_id) VALUES ('2','mhaydent');
INSERT INTO tab (flyer_id, user_id) VALUES ('3','jfunk');
INSERT INTO tab (flyer_id, user_id) VALUES ('4','sjenkins');



COMMIT;