# spring-boot-jdbc-demo
Spring Boot JDBC CRUD - A complete demonstration of CRUD operations  demonstrated on car table (c_id, c_name, cost are the columns ) using Spring Boot and JDBC for database access and management.

# JDBC Template Class

A concise guide to the JDBC Template class in Spring framework.

## What is JDBC Template

The JDBC Template is a utility class in the Spring framework that provides a simplified way to perform JDBC operations, such as executing SQL statements, mapping results to objects, and more. It eliminates the need for manual, low-level code and provides a more elegant way to interact with databases.

## Key Features

- Simplifies database access by providing high-level methods for common database operations
- Automatically manages database connections and resource cleanup
- Supports working with transactions
- Provides exception handling and error reporting
- Supports connection pooling to improve performance

## Usage

To use the JDBC Template class, you will need to instantiate an instance of it and provide a DataSource object that represents the database to which you want to connect. Once you have an instance of JDBC Template, you can use its methods to perform various database operations.



 ## Dependencies
    	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		 </dependency>
     
  Other dependencies
  - MySQL Driver
 -  Spring Boot Starter Web

Add these dependencies to your `pom.xml` file:
    
    
    
### Contributions
Feel free to fork the repository and make any changes that you see fit. Pull requests are always welcome!
