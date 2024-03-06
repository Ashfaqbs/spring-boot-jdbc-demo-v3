package com.ashfaq.dev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcDemoApplication implements CommandLineRunner {
	@Autowired
	private DataSource dataSource;

	@Override
	public void run(String... args) throws Exception {
//		fetchDataFromWorldDatabase();//select
//		executeUpdateQuery(myUpdateQuery);//update
//		executeInsertQuery(myInsertQuery);// insert
//		executeDeleteQuery(myDeleteQuery);

	}

	String myDeleteQuery = "DELETE FROM world.city WHERE CountryCode = 'USA'";

	public void executeDeleteQuery(String deleteQuery) {
	    try (Connection conn = dataSource.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
	        
	        int rowsAffected = pstmt.executeUpdate();
	        System.out.println("Rows affected: " + rowsAffected);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	String myUpdateQuery = "UPDATE world.city SET Population = Population * 1.1 WHERE CountryCode = 'USA'";

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcDemoApplication.class, args);
	}

	String myInsertQuery = "INSERT INTO world.city (Name, CountryCode, District, Population) VALUES ('NewCity', 'USA', 'DistrictX', 100000)";

	public void executeInsertQuery(String insertQuery) {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

			int rowsAffected = pstmt.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//update
	public void executeUpdateQuery(String updateQuery) {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

			int rowsAffected = pstmt.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// select
	public void fetchDataFromWorldDatabase() {
		String query = "SELECT " + "c.ID, c.Name AS City_Name, c.CountryCode, c.District, c.Population, "
				+ "co.Code AS Country_Code, co.Name AS Country_Name, co.Continent, co.Region, "
				+ "co.SurfaceArea, co.IndepYear, co.Population AS Country_Population, "
				+ "co.LifeExpectancy, co.GNP, co.GNPOld, co.LocalName, co.GovernmentForm, "
				+ "co.HeadOfState, co.Capital, co.Code2 AS Country_Code2, "
				+ "cl.Language AS CountryLanguage_Language, cl.IsOfficial, cl.Percentage " + "FROM world.city c "
				+ "INNER JOIN world.country co ON c.CountryCode = co.Code "
				+ "LEFT JOIN world.countrylanguage cl ON co.Code = cl.CountryCode";

		String query1 = "SELECT " + "c.ID, c.Name AS City_Name, c.CountryCode, c.District, c.Population, "
				+ "co.Code AS Country_Code, co.Name AS Country_Name, co.Continent, co.Region, "
				+ "co.SurfaceArea, co.IndepYear, co.Population AS Country_Population, "
				+ "co.LifeExpectancy, co.GNP, co.GNPOld, co.LocalName, co.GovernmentForm, "
				+ "co.HeadOfState, co.Capital, co.Code2 AS Country_Code2, "
				+ "cl.Language AS CountryLanguage_Language, cl.IsOfficial, cl.Percentage, "
				+ "(SELECT COUNT(*) FROM world.city) AS TotalCities, "
				+ "(SELECT AVG(Population) FROM world.city) AS AvgCityPopulation " + "FROM world.city c "
				+ "INNER JOIN world.country co ON c.CountryCode = co.Code "
				+ "LEFT JOIN world.countrylanguage cl ON co.Code = cl.CountryCode " + "WHERE c.Population > 1000000 " + // Example
																														// additional
																														// condition
				"ORDER BY c.Population DESC " + // Example ordering
				"LIMIT 10"; // Example limiting results

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query1);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				int cityId = rs.getInt("ID");
				String cityName = rs.getString("City_Name");
				// Retrieve other columns similarly

				// Process data or return it as needed
				System.out.println("City ID: " + cityId + ", City Name: " + cityName);
				// Print other columns as needed
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
