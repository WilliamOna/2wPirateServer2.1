package com.revature.pirate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pirate.model.Role;
import com.revature.pirate.util.JDBCUtility;

public class DatabaseRoleDAO {

	public Role findRoleByName(String name) {
		
		try (Connection connection = JDBCUtility.getConnection()) {
			String sqlQuery = "SELECT * "
					+ "FROM role r "
					+ "WHERE r.role = ? ";
			
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt(1);
				String role = rs.getString(2);
				return new Role(id, role);
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
