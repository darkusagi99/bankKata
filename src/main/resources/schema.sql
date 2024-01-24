create sequence t_account_seq start with 1 increment by 50;
create sequence t_client_seq start with 1 increment by 50;
create sequence t_transaction_seq start with 1 increment by 50;
create sequence t_user_seq start with 1 increment by 50;
create table t_account (current_balance float(24) not null, account_id bigint not null, client_id bigint not null, account_number varchar(255) not null, primary key (account_id));
create table t_client (birthdate date not null, client_id bigint not null, address varchar(255), firstname varchar(255) not null, lastname varchar(255) not null, primary key (client_id));
create table t_transaction (transaction_value float(24) not null, account_id bigint not null, date timestamp(6) not null, transaction_id bigint not null, label varchar(255) not null, primary key (transaction_id));
create table t_user (client_id bigint, user_id bigint not null, password_hash varchar(255) not null, role varchar(255) not null, username varchar(255) not null, primary key (user_id));
