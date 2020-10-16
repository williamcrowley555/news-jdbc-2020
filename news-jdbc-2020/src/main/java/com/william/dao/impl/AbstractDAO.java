package com.william.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.william.dao.GenericDAO;
import com.william.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/newsdb";
			String username = "admin";
			String password = "admin123";
			return DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	public void setParameter(PreparedStatement statement, Object...parameters) {
		try {
			for(int i = 0; i < parameters.length; ++i) {
				Object parameter = parameters[i];
				int index = i + 1;
				if(parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if(parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if(parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if(parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				} else if(parameter == null) {
					statement.setNull(index, Types.NULL);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}

			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

}
