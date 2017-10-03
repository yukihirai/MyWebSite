package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import EC.EcHelper;
import base.DBManager;
import beans.UserDataBeans;

public class UserDAO{
	public static UserDAO getInstance(){
		return new UserDAO();
	}


	public void insertUser(UserDataBeans udb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("INSERT INTO user (name,address,birth_date,login_id,login_password,create_date,update_date) VALUES (?,?,?,?,?,?,?)");
			st.setString(1,udb.getName());
			st.setString(2,udb.getAddress());
			st.setString(3,udb.getBirth_date());
			st.setString(4,udb.getLogin_id());
			st.setString(5,EcHelper.convertMd5(udb.getPassword()));
			st.setTimestamp(6,new Timestamp(System.currentTimeMillis()));
			st.setTimestamp(7,new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public boolean isOverLapLoginId(String login_id) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;
		boolean result = false;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT name FROM user WHERE login_id=?");

			st.setString(1,login_id);
			ResultSet rs = st.executeQuery();

			if(!rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return result;
	}


	public static int getUserId(String login_id,String login_password) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM user WHERE login_id=?");
			st.setString(1,login_id);

			ResultSet rs = st.executeQuery();

			int userId = 0;
			while(rs.next()) {
				if(EcHelper.convertMd5(login_password).equals(rs.getString("login_password"))) {
					userId = rs.getInt("id");
					break;
				}
			}
			return userId;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static UserDataBeans getUserDataBeansByUserId(int userId) throws SQLException  {
		UserDataBeans udb = new UserDataBeans();
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT id,name,address,birth_date,login_id,create_date FROM user WHERE id=?");
			st.setInt(1,userId);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				udb.setId(rs.getInt("id"));
				udb.setName(rs.getString("name"));
				udb.setAddress(rs.getString("address"));
				udb.setBirth_date(rs.getString("birth_date"));
				udb.setLogin_id(rs.getString("login_id"));
				udb.setCreate_date(rs.getTimestamp("create_date"));
			}
			st.close();

		}catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return udb;
	}

	public static List<UserDataBeans> getAllUserDate() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		List<UserDataBeans>udbList = new ArrayList<UserDataBeans>();
	}
}