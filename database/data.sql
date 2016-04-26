-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************


-- TEST --

-- users -- 
INSERT INTO flyer_user (first_name, last_name, password, salt, user_name, email) VALUES ('Hayden', 'Thompson', '6tTGJCbV+09/DCwqDGCt/g==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'haydent', 'hayden@techelevator.com');
INSERT INTO flyer_user (first_name, last_name, password, salt, user_name, email) VALUES ('Kevin', 'Glick', '6tTGJCbV+09/DCwqDGCt/g==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'kev', 'kevin@techelevator.com');
INSERT INTO flyer_user (first_name, last_name, password, salt, user_name, email) VALUES ('Jonathan', 'Funk', '6tTGJCbV+09/DCwqDGCt/g==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'funky', 'funk@techelevator.com');
INSERT INTO flyer_user (first_name, last_name, password, salt, user_name, email) VALUES ('Sean', 'Jenkins', '6tTGJCbV+09/DCwqDGCt/g==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'jenkins', 'sean@techelevator.com');
INSERT INTO flyer_user (first_name, last_name, password, salt, user_name, email) VALUES ('Watson', 'Sherlock', '6tTGJCbV+09/DCwqDGCt/g==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'Watson', 'watson@techelevator.com');
INSERT INTO flyer_user (first_name, last_name, password, salt, user_name, email) VALUES ('Sherlock', 'Holmes', '6tTGJCbV+09/DCwqDGCt/g==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'Sherlock', 'sherlock@techelevator.com');
INSERT INTO flyer_user (first_name, last_name, password, salt, user_name, email) VALUES ('The Tank', 'Thomas', '6tTGJCbV+09/DCwqDGCt/g==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'Tank', 'tank@techelevator.com');
INSERT INTO flyer_user (first_name, last_name, password, salt, user_name, email) VALUES ('George', 'Washington', '6tTGJCbV+09/DCwqDGCt/g==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'Washington', 'washington@techelevator.com');
INSERT INTO flyer_user (first_name, last_name, password, salt, user_name, email) VALUES ('Henry', 'Danger', '6tTGJCbV+09/DCwqDGCt/g==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'Henry', 'henry@techelevator.com');
INSERT INTO flyer_user (first_name, last_name, password, salt, user_name, email) VALUES ('Jeffrey', 'Baker', '6tTGJCbV+09/DCwqDGCt/g==', 'YnrgCxHq3NS8RQ79qZP6h5vYu+wkyIFqRQ2mCC4zxjHdlAPoh+cJiMECMv7q95pRW8pTbe/LPv8EtVj6W5eUN//YKTICZ1MA6IKkdDlt16x5uyAubpH0CjAOUIJV8WaxYQKze9acfD6pZaQPr6NC7pgYfMWFqODCK+x2c9CcbhI=', 'Jeff', 'Jbaker@techelevator.com');






-- flyer --
INSERT INTO flyer (isRetired, company, flyer_id, user_name, flyer_name, create_date, start_date, end_date, num_tabs, tabs_taken, flyer_info) VALUES (false, 'TECH ELEVATOR','2', 'kev', 'Car Wash', '2015-01-01' ,  '2016-01-01' , '2016-11-20','5', '4', 'free car wash! redeem tab');
INSERT INTO flyer (isRetired, company, flyer_id, user_name, flyer_name, create_date, start_date, end_date, num_tabs, tabs_taken, flyer_info) VALUES (false, 'TECHNO ESCALATOR', '1','haydent', 'FREE DJ', '2016-11-12' ,'2016-11-12' , '2016-11-26','5', '5' ,  'free DJ! redeem tab');
INSERT INTO flyer (isRetired, company, flyer_id, user_name, flyer_name, create_date, start_date, end_date, num_tabs, tabs_taken, flyer_info) VALUES (false, 'TECHNOLOGICAL ELEPHANT', '3','funky', 'Mind Reading Class', '2016-11-11' , '2016-11-11' , '2016-12-12','7', '2' ,'Come learn how to read your own mind!! redeem tab');
INSERT INTO flyer (isRetired, company, flyer_id, user_name, flyer_name, create_date, start_date, end_date, num_tabs, tabs_taken, flyer_info) VALUES (false, 'LOGICAL ELEPHANT','4', 'jenkins', 'Rebellion Signup', '2016-01-23', '2016-01-23', '2016-10-22','20', '2', 'Freedom Fighters Rebellion Sign Up! redeem tab');

-- tab -- 

INSERT INTO tab (isRedeemed,pull_date, flyer_id, user_name) VALUES (false,'2016-01-01', '1' ,'kev');
INSERT INTO tab (isRedeemed,pull_date, flyer_id, user_name) VALUES (false,'2016-01-01','2' ,'haydent');
INSERT INTO tab (isRedeemed,pull_date, flyer_id, user_name) VALUES (true,'2016-01-01', '3' , 'funky');
INSERT INTO tab (isRedeemed,pull_date, flyer_id, user_name) VALUES (true,'2016-01-01',  '4' ,'jenkins');

