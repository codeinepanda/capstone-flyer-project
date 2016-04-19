-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

DROP TABLE IF EXISTS flyer;
DROP TABLE IF EXISTS flyer_user;

DROP SEQUENCE flyer_flyer_id_seq;


CREATE TABLE flyer_user (
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
    CONSTRAINT fk_user_userid FOREIGN (user_id) REFERENCES flyer_user(user_id),
	CONSTRAINT pk_flyer_flyer_id PRIMARY KEY (flyer_id)
);

CREATE TABLE tab
	flyer_id integer,
	user_name varchar(256),
	CONSTRAINT fk_flyer_flyer_id FOREIGN KEY (flyer_id) REFERENCES flyer(flyer_id),
	CONSTRAINT fk_user_userid FOREIGN KEY (user_id) REFERENCES flyer_user(user_id)
);



COMMIT;