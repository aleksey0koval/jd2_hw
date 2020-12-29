create schema test default character set utf8;

create table if not exists получатели;

SELECT * FROM test.получатели;

insert into test.получатели values (1, 'Интернет-провайдер "Соло"');
insert into test.получатели values (2, 'Гипермаркет "Корона"');
insert into test.получатели values (3, 'МТС');
