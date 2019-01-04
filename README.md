# SpringRestThreadSafe
This is a task round question.


Task description:

The task is to consistently increment a number in a database when parallel threads are racing to increment the number.

Create a table Number in MySQL database with one integer type field.

Create a RESTful API using Spring MVC architecture that increments this number.

Use Jmeter (Do not use postman because it does not send parallel requests) to call this API with 1000 users so that a lot of parallel requests are sent to server to increment the number.

Now set the initial value of Number to 0.

After the execution of Jmeter, the value of the number in the database shall be 1000.

The API should be scalable i.e. if deployed on multiple machines with same database, the result should be consistent.
