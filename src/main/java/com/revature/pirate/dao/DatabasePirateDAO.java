package com.revature.pirate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.pirate.model.Pirate;
import com.revature.pirate.model.Role;
import com.revature.pirate.util.JDBCUtility;

public class DatabasePirateDAO {

	public ArrayList<Pirate> getAllPirates() {
		
		String sqlQuery = "SELECT * "
				+ "FROM pirate p "
				+ "INNER JOIN role r "
				+ "ON p.role_id = r.id";
		
		ArrayList<Pirate> pirates = new ArrayList<>();
		
		try (Connection connection = JDBCUtility.getConnection()) {
			Statement stmt = connection.createStatement(); // Simple Statement, not to be confused Prepared Statement
			ResultSet rs = stmt.executeQuery(sqlQuery);
			
			// A ResultSet is basically an object representing the rows of data returned from a query
			// it maintains a cursor that points to the current row of data
			// Initially, the cursor is placed before the very first row of data
			
			// | row 1 _ row 2 _ row 3 
			// if you call the next() method on a ResultSet, it will move it forward
			// row 1 | row 2 _ row 3
			// row 1 _ row 2 | row 3
			// row 1 _ row 2 _ row 3 |
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int roleId = rs.getInt(4);
				String role = rs.getString(5);
				
				Role roleObj = new Role(roleId, role);
				Pirate pirate = new Pirate(id, name, roleObj);
				
				pirates.add(pirate);
			}
			
			return pirates;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pirates;
	}
	
	/**
	 * @return Pirate or null
	 */
	public Pirate insertPirate(String pirateName, Role role) {
		
		try (Connection connection = JDBCUtility.getConnection()) {
			connection.setAutoCommit(false); // Committing it goes into the whole idea of transactions. By default, Postgres is set to
			// Automatically commit any changes you make to the database. Sometimes this is not ideal, especially if you want to 
			// make sure all operations are successful before persisting changes (committing). 
			// Bank transfers might be a good example. For example you will have to withdraw money from one account and deposit to another
			// If you have autocommit set to true, if you withdraw from the first account, and then somehow your database loses power,
			// the withdraw from the first account would already have been committed
			
			// This is not ideal, because we would only want to commit once the withdraw from one account and the deposit to another account
			// Has successfully been completed
			
			// ACID properties of transactions, Atomicity, Consistency, Isolation, Durability
			String sqlQuery = "INSERT INTO pirate "
					+ "(name, role_id) "
					+ "VALUES "
					+ "(?, ?)";
			
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, pirateName);
			pstmt.setInt(2, role.getId());
			
			if (pstmt.executeUpdate() != 1) {
				throw new SQLException("Inserting pirate failed, no rows were affected");
			}
			
			int autoId = 0;
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				autoId = generatedKeys.getInt(1);
			} else {
				throw new SQLException("Inserting pirate failed, no ID generated");
			}
			
			connection.commit();
			
			return new Pirate(autoId, pirateName, role);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
		
}
