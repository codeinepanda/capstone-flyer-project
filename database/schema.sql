-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

CREATE TABLE flyer_user (
 -- redeemScore integer DEFAULT 1,
  first_name varchar(256) NOT NULL,   										 -- First Name
  last_name varchar(256) NOT NULL,	 										 -- Last Name
  password varchar(256) NOT NULL,     										 -- Password (in plain-text)
  salt varchar(256) NOT NULL,		 										 -- Password Salt
  user_name varchar(256) NOT NULL ,	 										 -- User Name for pairing flyers to users etc.
  email varchar(256) NOT NULL,				  								 -- Email
  CONSTRAINT pk_flyer_user_user_name PRIMARY KEY (user_name)
);

CREATE SEQUENCE flyer_flyer_id_seq
  START WITH 5
  INCREMENT BY 1
  NO MAXVALUE
  CACHE 1;

CREATE TABLE flyer (
	isRetired BOOLEAN NOT NULL DEFAULT false,
	company varchar(256) NOT NULL,																		-- Company Name used for categorizing and searching for flyers
	flyer_id integer DEFAULT nextval('flyer_flyer_id_seq') NOT NULL,					-- Flyer ID
	user_name varchar(1000) NOT NULL,																	-- User ID Foreign Key
	flyer_name varchar(1000) NOT NULL,															-- Name Of Flyer
	create_date date NOT NULL, 																	-- Date Created
	start_date date NOT NULL,																	-- Year, Month, Day : 4 digits - 2 digit - 2 digit
	end_date date NOT NULL, 																	-- number of tabs a flyer has
	num_tabs integer,																			-- number of tabs on flyer
	tabs_taken integer DEFAULT 0,
	flyer_info varchar(1000),																	-- User created
	category varchar(256) NOT NULL,
    CONSTRAINT fk_flyer_user_user_name FOREIGN KEY (user_name) REFERENCES flyer_user(user_name),
	CONSTRAINT pk_flyer_flyer_id PRIMARY KEY (flyer_id)
);

CREATE TABLE tab (
	
	isRedeemed BOOLEAN NOT NULL DEFAULT false,
	pull_date date NOT NULL, 
	flyer_id integer,
	user_name varchar(256),
	CONSTRAINT pk_flyer_user_flyer_flyer_id PRIMARY KEY (flyer_id, user_name),
	CONSTRAINT fk_flyer_flyer_id FOREIGN KEY (flyer_id) REFERENCES flyer(flyer_id),
	CONSTRAINT fk_flyer_user_user_name FOREIGN KEY (user_name) REFERENCES flyer_user(user_name)
);



