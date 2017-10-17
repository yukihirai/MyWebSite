package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import base.DBManager;
import beans.BuyDataBeans;

public class BuyDAO {

	public static BuyDAO getInstance() {
		return new BuyDAO();
	}

	public static int insertBuyData(BuyDataBeans bdb) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;
		int key = -1;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO buy(user_id,total_price,delivery_method_id,create_date) VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

			st.setInt(1,bdb.getUser_id());
			st.setInt(2,bdb.getTotal_price());
			st.setInt(3,bdb.getDelivery_method_id());
			st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()) {
				key = rs.getInt(1);
			}
			return key;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static BuyDataBeans getBuyDataBeansByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM buy"
							+ " JOIN delivery_method"
							+ " ON buy.delivery_method_id = delivery_method.id"
							+ " WHERE buy.id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();

			BuyDataBeans bdb = new BuyDataBeans();
			if (rs.next()) {
				bdb.setId(rs.getInt("id"));
				bdb.setTotal_price(rs.getInt("total_price"));
				bdb.setCreate_date(rs.getTimestamp("create_date"));
				bdb.setDelivery_method_id(rs.getInt("delivery_method_id"));
				bdb.setUser_id(rs.getInt("user_id"));
				bdb.setDelivery_method_price(rs.getInt("price"));
				bdb.setDelivery_method_name(rs.getString("name"));
			}


			return bdb;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ArrayList<BuyDataBeans> getBuyDataBeansByUserId(int userId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM buy"
							+ " JOIN delivery_method"
							+ " ON buy.delivery_method_id = delivery_method.id"
							+ " WHERE user_id = ?");
			st.setInt(1, userId);

			ResultSet rs = st.executeQuery();

			ArrayList<BuyDataBeans> bdbList = new ArrayList<BuyDataBeans>();
			while (rs.next()) {
				BuyDataBeans bdb = new BuyDataBeans();
				bdb.setId(rs.getInt("id"));
				bdb.setTotal_price(rs.getInt("total_price"));
				bdb.setCreate_date(rs.getTimestamp("create_date"));
				bdb.setDelivery_method_id(rs.getInt("delivery_method_id"));
				bdb.setUser_id(rs.getInt("user_id"));
				bdb.setDelivery_method_price(rs.getInt("price"));
				bdb.setDelivery_method_name(rs.getString("name"));
				bdbList.add(bdb);
			}

			return bdbList;
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
