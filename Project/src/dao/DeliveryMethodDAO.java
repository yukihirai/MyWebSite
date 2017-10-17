package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.DeliveryMethodDataBeans;

public class DeliveryMethodDAO {
	public static DeliveryMethodDAO getInstance(){
		return new DeliveryMethodDAO();
	}

	public static List<DeliveryMethodDataBeans> getAllDeliveryMethodData() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		List<DeliveryMethodDataBeans>dmdbList = new ArrayList<DeliveryMethodDataBeans>();
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM delivery_method");

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");

				DeliveryMethodDataBeans dmdb = new DeliveryMethodDataBeans(id,name,price);
				dmdbList.add(dmdb);
			}
			st.close();

			return dmdbList;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static DeliveryMethodDataBeans getDeliveryMethodDataBeansByDeliveryMethodId(int deliveryMethodId) throws SQLException  {
		DeliveryMethodDataBeans dmdb = new DeliveryMethodDataBeans();
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM delivery_method WHERE id=?");
			st.setInt(1,deliveryMethodId);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				dmdb.setId(rs.getInt("id"));
				dmdb.setName(rs.getString("name"));
				dmdb.setPrice(rs.getInt("price"));
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
		return dmdb;
	}

}
