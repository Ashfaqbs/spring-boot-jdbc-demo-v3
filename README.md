# spring-boot-jdbc-demo-v3
Spring Boot JDBC CRUD - A complete demonstration of CRUD operations  demonstrated on car table (c_id, c_name, cost are the columns ) using Spring Boot and JDBC for database access and management.

#  Note : 
we have two dependencies 

1 spring-boot-starter-data-jdbc
        
      <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jdbc</artifactId>
    </dependency>

2 spring-boot-starter-jdbc  
    
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency> 


## The difference between spring-boot-starter-data-jdbc and spring-boot-starter-jdbc lies in their level of abstraction and the features they offer for database access:

spring-boot-starter-jdbc: This starter includes the core JDBC functionality provided by Spring Framework, such as JdbcTemplate, which simplifies database access by handling resource management and exception translation. It's a lower-level approach that gives you direct control over SQL queries and manual object mapping. This starter is suitable for projects where you need fine-grained control over database operations and prefer to write SQL queries manually 4.
spring-boot-starter-data-jdbc: Part of the Spring Data family, this starter provides a higher level of abstraction for JDBC-based data access layers. It supports entity objects and repositories, reducing the complexity of data access code. Unlike JPA, it omits features like lazy loading and caching, focusing on straightforward JDBC operations. This starter is ideal for projects that benefit from the simplicity and directness of JDBC operations without the overhead of JPA's additional features 23

## When to use which:

Use spring-boot-starter-jdbc if you require direct control over SQL queries and prefer a lower-level approach to database access. This is suitable for applications where performance is critical, and you have specific SQL requirements that cannot be easily mapped to JPA entities.
Use spring-boot-starter-data-jdbc for projects that can benefit from the simplicity and abstraction provided by Spring Data JDBC. This is a good choice for applications that need a straightforward data access layer without the overhead of JPA's additional features, such as lazy loading and caching.







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

Add these dependencies to your `pom.xml` file.




# Must Know

Spring JDBC provides several alternatives to JdbcTemplate for interacting with databases, each catering to different needs and preferences:

JdbcTemplate: The core class for JDBC operations, offering a low-level API for executing SQL queries and handling database connections. It's suitable for applications requiring fine-grained control over database operations 24.
NamedParameterJdbcTemplate: An extension of JdbcTemplate that supports named parameters instead of traditional JDBC "?" placeholders, improving readability and ease of use 2.
SimpleJdbcTemplate: A simplified version of JdbcTemplate that combines the most frequently used operations, reducing boilerplate code for common tasks 2.
JdbcOperations: An interface that defines basic JDBC operations, such as executing queries and updates. It's a more flexible alternative to JdbcTemplate that allows for custom implementations 2.
JdbcCallback: A functional interface that allows you to execute a single JDBC operation in a callback manner. It's useful for executing a single operation without the overhead of creating a full JdbcTemplate instance 2.
The reason for having multiple alternatives is to cater to different levels of abstraction and use cases:

JdbcTemplate and its derivatives (NamedParameterJdbcTemplate, SimpleJdbcTemplate) offer a balance between low-level control and convenience, suitable for most JDBC operations.
JdbcOperations and JdbcCallback provide more flexibility and are useful for scenarios where you need to customize the JDBC operations beyond what JdbcTemplate offers.



## Diff between JdbcTemplate and JdbcClient
The presence of both JdbcTemplate and JdbcClient in Spring JDBC reflects an evolution in the framework's approach to database access, aiming to simplify and enhance developer experience.

JdbcTemplate: Introduced earlier, it abstracts away much of the boilerplate code required for JDBC operations, such as opening and closing connections, handling exceptions, and translating SQL queries into Java objects. It provides a low-level API for executing SQL queries and updates, offering complete control over SQL statements. However, it can become verbose for simple CRUD operations and requires a deeper understanding of JDBC concepts like row mappers and column-to-field mapping 3.
JdbcClient: Added in Spring Framework 6.1 and Spring Boot 3.2, JdbcClient offers a more modern, fluent API for database operations. It acts as a unified facade for JdbcTemplate and NamedParameterJdbcTemplate, supporting both named and positional parameters. This new client simplifies JDBC operations by allowing developers to chain operations like defining the query, setting parameters, and performing the database operation in a more readable and intuitive manner. It aims to make JDBC operations more accessible and easier to understand, especially for developers new to JDBC or those looking for a more streamlined approach to database access 5.
The introduction of JdbcClient alongside JdbcTemplate is part of Spring's ongoing efforts to provide developers with flexible and powerful tools for database access. While JdbcTemplate remains a robust choice for applications requiring detailed control over database operations, JdbcClient offers a more modern, fluent API that enhances readability and ease of use. Developers can choose the tool that best fits their project's needs and their personal preference for working with databases.




    
    
    
### Contributions
Feel free to fork the repository and make any changes that you see fit. Pull requests are always welcome!
