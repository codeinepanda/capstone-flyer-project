DROP TABLE IF EXISTS flyer;
DROP TABLE IF EXISTS user;

DROP SEQUENCE user_user_id_seq;


CREATE TABLE user (
  first_name varchar(256) NOT NULL,   										 -- First Name
  last_name varchar(256) NOT NULL 	 										 -- Last Name
  password varchar(32) NOT NULL,     										 -- Password (in plain-text)
  salt varchar(256) NOT NULL,		 										 -- Password Salt
  user_name varchar(256) NOT NULL ,	 										 -- User ID for pairing flyers to users etc.
  email varchar(256) NOT NULL,				  								 -- Email
  CONSTRAINT pk_flyer_user_userid PRIMARY KEY (user_id)
);

CREATE SEQUENCE flyer_flyer_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE flyer (
	company varchar(256) NOT NULL,																		-- Company Name used for categorizing and searching for flyers
	flyer_id integer DEFAULT nextval('flyer_flyer_id_seq'::regclass) NOT NULL,					-- Flyer ID
	user_name varchar(256) NOT NULL,																	-- User ID Foreign Key
	flyer_name varchar(256) NOT NULL,															-- Name Of Flyer
	start_date date NOT NULL,																	-- Year, Month, Day : 4 digits - 2 digit - 2 digit
	end_date date NOT NULL, 																	-- number of tabs a flyer has
	num_tabs integer,																			-- number of tabs on flyer
	flyer_info varchar(1000),																	-- User created
    CONSTRAINT fk_user_userid FOREIGN (user_id) REFERENCES user(user_id),
	CONSTRAINT pk_flyer_flyer_id PRIMARY KEY (flyer_id)
);

CREATE TABLE tab
	flyer_id integer,
	user_name varchar(256),
	CONSTRAINT fk_flyer_flyer_id FOREIGN KEY (flyer_id) REFERENCES flyer(flyer_id),
	CONSTRAINT fk_user_userid FOREIGN KEY (user_id) REFERENCES user(user_id)
);

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


