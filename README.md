# Point-of-Sales-System
Suppose you were hired to develop a Point of Sales (POS) system for the Super-Saving
supermarket chain. The cashier enters the item code to add a grocery item to the bill. Given the
item code, information such as price, weight/size of the product, date of manufacturing and expiry,
and manufacturer name is fetched from the database (You do not have to implement a database
connection for this, but can simply hardcode for this exercise). In addition, from time to time, each
item is given a discount which varies from 0-75%. The bill produced by this POS system should
contain the cashier’s name, branch, customer name (if a registered customer), item list (unit price,
quantity, discount, net price), total discount, total price, date, and time. The date and time should
indicate when the bill was printed.
In addition to the typical functionalities, this POS system is required to handle pending bills. For
example, suppose a customer brings a cart full of groceries to the cashier but forgets to weigh some
vegetables and fruits. He realizes this only after the cashier has entered half of the items into the
system. While this customer goes and weighs the vegetables and fruits, he purchased, the cashier
wants to keep his bill as a pending one and deal with the billing for other customers.
