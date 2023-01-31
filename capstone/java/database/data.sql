BEGIN TRANSACTION;

INSERT INTO users (username,password_hash, name, email, role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'bob', 'bob@gmail.com','ROLE_USER');
INSERT INTO users (username,password_hash, name, email, role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'sue', 'sue@gmail.com','ROLE_ADMIN');

COMMIT TRANSACTION;
