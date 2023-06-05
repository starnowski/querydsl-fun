-- users
INSERT INTO user_info (id, login) VALUES (1, 'Szymon Tarnowski');
INSERT INTO user_info (id, login) VALUES (2, 'John Doe');
INSERT INTO user_info (id, login) VALUES (3, 'Jane Doe');

-- posts
INSERT INTO post (id, user_id, body, title) VALUES (8, 1, 'Some phrase', 'post1');
INSERT INTO post (id, user_id, body, title) VALUES (9, 2, 'Some phrase', 'post2');
