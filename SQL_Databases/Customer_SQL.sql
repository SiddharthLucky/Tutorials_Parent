#1.
SELECT * FROM classicmodels.customers where postalcode = 44000;

#2.
SELECT customerName, contactLastName FROM classicmodels.customers where creditLimit > 1000;

#3.
SELECT customerName, phone FROM customers c, orders o where c.customerNumber = o.customerNumber and o.orderDate = CURDATE();

#4.
SELECT o.* from orders o, customers c where o.orderDate >= '2003-01-01' and o.orderDate <= '2004-12-01' 
and c.postalCode >= 90000 and c.postalCode <= 99999 and c.customerNumber = o.customerNumber; 

#5.
SELECT c.customerName, c.addressLine1 from customers c, orders o where c.customerNumber = o.customerNumber and o.shippedDate >= '2004-01-01' and o.shippedDate <= '2004-06-30'; 

#6.
SELECT c.customerName, c.contactLastName, o.orderNumber, od.quantityOrdered * od.priceEach as 'Total Price' from
customers c, orders o, orderdetails od where c.customerNumber = o.customerNumber and o.orderNumber = od.orderNumber 
and od.quantityOrdered * od.priceEach >= 60000 order by od.quantityOrdered * od.priceEach desc; 

#7.
SELECT c.customerName, e.officeCode, od.quantityOrdered * od.priceEach as 'Total Price' from customers c, employees e, orderdetails od 
where c.salesRepEmployeeNumber = e.employeeNumber order by od.quantityOrdered * od.priceEach desc limit 1; 

#8. Check the query once
SELECT c.customerName, o1.orderDate, o2.orderdate from customers c, orders o1, orders o2 
where c.customerNumber = o1.customerNumber and c.customerNumber = o2.customerNumber;

 
#9.
SELECT c.postalCode, od.quantityOrdered * od.priceEach from customers c, orderdetails od, products p, orders o 
where c.customerNumber = o.customerNumber and od.productCode = p.productCode and p.productLine = 'Motorcycles' 
and od.orderNumber = o.orderNumber and YEAR(o.orderDate) = '2004' order by od.quantityOrdered * od.priceEach desc limit 3; 



#10.
SELECT customerName, contactLastName, phone FROM classicmodels.customers where postalcode REGEXP ('[0-9]');

