INSERT INTO T_CLIENT(CLIENT_ID, LASTNAME, FIRSTNAME, BIRTHDATE) VALUES (1, 'LastTest', 'firstTest', '1984-05-13');
INSERT INTO T_ACCOUNT(ACCOUNT_ID, CLIENT_ID, ACCOUNT_NUMBER, CURRENT_BALANCE) VALUES (1, 1, 'AccountNbr', 10000);
-- User 1 with "password"
INSERT INTO T_USER(USER_ID, USERNAME, PASSWORD_HASH, ROLE) VALUES (1, 'user', '$2a$10$Ht03BRszKTkCS21iAIrJDO9mziv1PjMPI9nneh0WBeJnbAUia11cW', 'ADMIN');