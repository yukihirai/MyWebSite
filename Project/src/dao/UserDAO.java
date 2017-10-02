package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

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
}