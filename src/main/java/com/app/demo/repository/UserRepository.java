package com.app.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.app.demo.springboot.dto.SpringBoot;

@Repository
public class UserRepository {

	private static Connection connection;

	public static Connection getConnection() throws SQLException {

		if (ObjectUtils.isEmpty(connection)) {

		}
		Connection connection = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/mysql_demo_tnj",
				"mysql_demo_tnj", "Ebrain@20");

		return connection;

	}

	public void save(SpringBoot user) throws SQLException {

		Connection connection = getConnection();

		PreparedStatement st = connection
				.prepareStatement("insert into  tb_desapriyan_Springboot values(?, ?, ?, ?,?)");
		// set values into the query
		st.setInt(1, Integer.valueOf(user.getId()));
		st.setString(2, user.getFirstName());
		st.setString(3, user.getLastName());
		st.setString(4, user.getEmail());
		st.setString(5, user.getMessage());
		st.executeUpdate();

	}

	public void deleteById(SpringBoot user) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		String insertQuery = "delete from tb_desapriyan_Springboot where id = ?";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		ps.setInt(1, user.getId());
		ps.executeUpdate();
		ps.close();
		con.close();
	}

	public void updateUser(SpringBoot user) throws SQLException {

		Connection connection = getConnection();
		String insertQuery = "update  tb_desapriyan_Springboot set firstName=?,lastName=?,email=?,message=? where id =?";
		PreparedStatement st = connection.prepareStatement(insertQuery);
		st.setString(1, user.getFirstName());
		st.setString(2, user.getLastName());
		st.setString(3, user.getEmail());
		st.setString(4, user.getMessage());
		st.setInt(5, user.getId());
		st.executeUpdate();

	}

	public SpringBoot getById(Integer id) throws SQLException {
		Connection con = getConnection();
		String insertQuery = "select * from tb_desapriyan_Springboot where id = ?";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		ps.setInt(1, id);
	 ResultSet resultSet = ps.executeQuery();
	 SpringBoot obj=null;
	   while (resultSet.next()) {
		   obj = new SpringBoot();
		   obj.setId(resultSet.getInt(1));
		   obj.setFirstName(resultSet.getString(2));
		   obj.setLastName(resultSet.getString(3));
		   obj.setEmail(resultSet.getString(4));
		   obj.setMessage(resultSet.getString(5));
		  
       }
       return obj;
	   }
		
	

	public List<SpringBoot> getAll() throws SQLException {
	        Connection con = getConnection();
	        String selectQuery = "select * from tb_desapriyan_Springboot";
	        PreparedStatement ps = con.prepareStatement(selectQuery);
	        ResultSet resultSet = ps.executeQuery();
	        List<SpringBoot> obj = new ArrayList<SpringBoot>();
	        SpringBoot user = null;
	        while (resultSet.next()) {
	            user = new SpringBoot();
	            user.setId(resultSet.getInt(1));
	            user.setFirstName(resultSet.getString(2));
	            user.setLastName(resultSet.getString(3));
	            user.setEmail(resultSet.getString(4));
	            user.setMessage(resultSet.getString(5));
	            obj.add(user);
	        }
	        return obj;
	    }
	}
