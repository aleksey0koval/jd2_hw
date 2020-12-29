SELECT * FROM test.расходы;

delete from test.расходы where `Номер платежа`>0 and Сумма <3000;

insert into test.расходы values (1, '2010-05-10', '1', '20000р.');
insert into test.расходы values (2, '2010-05-10', '2', '94200р.');
insert into test.расходы values (3, '2010-05-11', '3', '10000р.');
insert into test.расходы values (4, '2010-05-11', '2', '12950р.');
insert into test.расходы values (5, '2010-05-12', '2', '1000р.');
insert into test.расходы values (6, '2010-05-20', '3', '6000р.');

