/*
報表->porder,member,employ,product
訂單編號,客戶名,電話,地址,員工名,商品名,數量,金額
*/
select
gjun.porder.porderno,
gjun.member.name,
gjun.member.phone,
gjun.member.address,
gjun.employ.name,
gjun.product.productname,
gjun.porder.amount,
gjun.porder.amount*gjun.product.price 金額
from gjun.porder 
inner join gjun.member on gjun.porder.memberno=gjun.member.memberno
inner join gjun.employ on gjun.porder.employno=gjun.employ.employno
inner join gjun.product on gjun.porder.productno=gjun.product.productno
order by gjun.porder.id;

/*
報表->porder,member,employ,product
訂單編號,客戶名,電話,地址,員工名,商品名,數量,金額
*/
select
shopping.shop_order.shop_order_no,
shopping.consumer.consumer_name,
shopping.consumer.phone,
shopping.consumer.address,
shopping.employee.name as employee_name,
shopping.product.product_name,
shopping.shop_order.amount,
shopping.shop_order.amount*shopping.product.price total_sum
from shopping.shop_order 
inner join shopping.consumer on shopping.shop_order.consumer_no=shopping.consumer.consumer_no
inner join shopping.employee on shopping.shop_order.employee_no=shopping.employee.employee_no
inner join shopping.product on shopping.shop_order.product_no=shopping.product.product_no
order by shopping.shop_order.id;

select
shopping.shop_order.product_no,
shopping.product.product_name,
shopping.shop_order.amount
from shopping.shop_order
inner join shopping.product on shopping.shop_order.product_no = shopping.product.product_no;

SELECT 
    so.product_no, 
    p.product_name, 
    SUM(so.amount) as total
FROM shopping.shop_order AS so
INNER JOIN shopping.product AS p 
    ON so.product_no = p.product_no
GROUP BY so.product_no, p.product_name
ORDER BY SUM(so.amount) DESC;



use shopping;

-- 增加外鍵fk_shop_order_product
ALTER TABLE shopping.shop_order 
ADD CONSTRAINT fk_shop_order_product 
FOREIGN KEY (product_no) 
REFERENCES shopping.product(product_no)
ON DELETE RESTRICT 
ON UPDATE CASCADE;

-- 增加外鍵fk_shop_order_employee
ALTER TABLE shopping.shop_order 
ADD CONSTRAINT fk_shop_order_employee 
FOREIGN KEY (employee_no) 
REFERENCES shopping.employee(employee_no)
ON DELETE RESTRICT 
ON UPDATE CASCADE;

-- 增加外鍵fk_shop_order_consumer
ALTER TABLE shopping.shop_order 
ADD CONSTRAINT fk_shop_order_consumer 
FOREIGN KEY (consumer_no) 
REFERENCES shopping.consumer(consumer_no)
ON DELETE RESTRICT 
ON UPDATE CASCADE;



SELECT * FROM shopping.product;

-- 外鍵測試product
delete from shopping.product where product_no='p024';
update shopping.product set product_no='p033' where product_no='p024';

-- 外鍵測試employee
delete from shopping.employee where employee_no='e013';
update shopping.employee set employee_no='e014' where employee_no='e013';

-- 外鍵測試consumer
delete from shopping.consumer where consumer_no='c026';
update shopping.consumer set consumer_no='c026' where consumer_no='c020';



