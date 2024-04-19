import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DatabaseAutomation {
    private static final Logger logger = LogManager.getLogger(DatabaseAutomation.class);

    public static void main(String[] args) {
        // Database credentials and URLs
        String url1 = "jdbc:mysql://localhost:3306/database1";
        String url2 = "jdbc:mysql://localhost:3306/database2";
        String user = "root";
        String password = "password";

        // Queries for each database
        String query1 = "SELECT * FROM table1";
        String query2 = "SELECT * FROM table2";

        // Establishing connection to the first database
        try (Connection conn1 = DriverManager.getConnection(url1, user, password);
             Statement stmt1 = conn1.createStatement();
             ResultSet rs1 = stmt1.executeQuery(query1)) {

            logger.debug("Connected to Database 1 successfully.");

            // Process results from database 1

        } catch (SQLException e) {
            logger.error("SQL Exception for Database 1: " + e.getMessage());
        }

        // Establishing connection to the second database
        try (Connection conn2 = DriverManager.getConnection(url2, user, password);
             Statement stmt2 = conn2.createStatement();
             ResultSet rs2 = stmt2.executeQuery(query2)) {

            logger.debug("Connected to Database 2 successfully.");

            // Process results from database 2

        } catch (SQLException e) {
            logger.error("SQL Exception for Database 2: " + e.getMessage());
        }

        // Send email with results
        sendEmail("YourEmail@gmail.com", "YourPassword", "RecipientEmail@gmail.com", "Query Results", "Email Body");
    }

    // Method to send email
    public static void sendEmail(String senderEmail, String senderPassword, String recipientEmail, String subject, String body) {
        // Email sending logic here

        logger.debug("Email sent successfully.");
    }
}



// Note: 

// The try-with-resources statement automatically closes the resources at the end of the block, whether an exception occurs or not. 
//   It ensures that the resources are properly released, even if an exception is thrown during the execution of the try block.

// So, in the absence of exceptions, the resources will still be closed after the try block is executed. This is one of the advantages 
//   of using try-with-resources, as it helps to prevent resource leaks and ensures efficient resource management in your code.


//   Connect to the Database: When you establish a connection to the database, resources are allocated for this connection. This includes network resources, memory, and possibly locks on the database server.
// Execute Query and Process Results: Once connected, you execute your query and process the results. This involves retrieving data from the database and possibly performing operations on it.
// Send Email: After processing the results, you send an email containing the relevant information. This operation is independent of the database connection.
// Close Database Connection: Once the email is sent, you close the database connection. This releases the resources associated with the connection, including releasing the network 
//   resources, memory, and any locks held on the database server.
// By closing the database connection after sending the email, you ensure that resources are properly released and that your application is not holding onto 
//   resources it no longer needs. This is important for efficient resource management and to prevent resource leaks over time.
