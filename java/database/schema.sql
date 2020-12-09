BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS plot;
DROP TABLE IF EXISTS users_plot;
DROP TABLE IF EXISTS crops;
DROP TABLE IF EXISTS crops_plot;
DROP TABLE IF EXISTS notes;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE users
(
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE plot
(
    plot_id serial PRIMARY KEY,
    width int NOT NULL,
    height int NOT NULL,
    active BOOL DEFAULT 't'
);

CREATE TABLE users_plot
(
    user_id int NOT NULL,
    plot_id int NOT NULL,
    
    constraint fk_users_users_plot foreign key (user_id) references users (user_id),
    constraint fk_plot_users_plot foreign key (plot_id) references plot (plot_id)
);

CREATE TABLE crops
(
    crop_id serial PRIMARY KEY,
    name varchar(25),
    yield varchar(50),
    crops_per_square_foot int,
    details varchar(1000)
);

CREATE TABLE crops_plot
(
    crop_id int NOT NULL,
    plot_id int NOT NULL,
    
    constraint fk_crops_crops_plot foreign key (crop_id) references crops (crop_id),
    constraint fk_plot_crops_plot foreign key (plot_id) references plot (plot_id)
);

CREATE TABLE notes
(
    note_id serial PRIMARY KEY,
    plot_id int NOT NULL,
    note varchar(1000),
    
    constraint fk_notes_plot foreign key (note_id) references plot (plot_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

-- TEMPORARY FAKE DATA --
INSERT INTO crops (name,yield,crops_per_square_foot,details) VALUES ('Tomatoes','20 per plant',3,'Tomatoes are red.');
INSERT INTO crops (name,yield,crops_per_square_foot,details) VALUES ('Carrots','4 per plant',8,'Carrots can be found underground.');

COMMIT TRANSACTION;

