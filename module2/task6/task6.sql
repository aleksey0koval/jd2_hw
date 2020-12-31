select test.receivers.receive as 'получатель платежей', sum(test.expenses.sum) as сумма from test.receivers, test.expenses where test.receivers.id_receive=test.expenses.receive group by test.receivers.id_receive;

select test.expenses.paydate as 'день наибольшего платежа', sum(test.expenses.sum) as 'сумма платежей за этот день' from test.expenses where test.expenses.paydate = 
(select distinct test.expenses.paydate from test.expenses where test.expenses.sum = 
(select max(test.expenses.sum) from test.expenses)) group by test.expenses.paydate;

select raz.maks as 'максимальная сумма платежа' 
from (
	select paydate, sum(test.expenses.sum) as summ, max(test.expenses.sum) as maks from test.expenses group by paydate
) raz 
where raz.summ=(
	select max(summ) from (
		select sum(test.expenses.sum) as summ from test.expenses group by paydate
	) maxSum
);