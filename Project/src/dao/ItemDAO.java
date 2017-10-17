package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.ItemDataBeans;

public class ItemDAO {
	public static ItemDAO getInstance(){
		return new ItemDAO();
	}

	public void insertItem(ItemDataBeans idb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("INSERT INTO item (name,detail,price,film_name) VALUES (?,?,?,?)");
			st.setString(1,idb.getName());
			st.setString(2,idb.getDetail());
			st.setInt(3,idb.getPrice());
			st.setString(4,idb.getFilm_name());
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

	public static List<ItemDataBeans> getAllItemData() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		List<ItemDataBeans>idbList = new ArrayList<ItemDataBeans>();
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM item");

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				int price = rs.getInt("price");
				String film_name = rs.getString("film_name");
				int value = rs.getInt("value");

				ItemDataBeans idb = new ItemDataBeans(id,name,detail,price,film_name,value);
				idbList.add(idb);
			}
			st.close();

			return idbList;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ItemDataBeans getItemDataBeansByUserId(int itemId) throws SQLException  {
		ItemDataBeans idb = new ItemDataBeans();
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM item WHERE id=?");
			st.setInt(1,itemId);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				idb.setId(rs.getInt("id"));
				idb.setName(rs.getString("name"));
				idb.setDetail(rs.getString("detail"));
				idb.setPrice(rs.getInt("price"));
				idb.setFilm_name(rs.getString("film_name"));
				idb.setValue(rs.getDouble("value"));
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
		return idb;
	}

	public static List<ItemDataBeans> getSearchItemDate(String searchWord) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		List<ItemDataBeans>idbList = new ArrayList<ItemDataBeans>();
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM item WHERE name LIKE ?");
			st.setString(1,"%"+ searchWord + "%");

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				int price = rs.getInt("price");
				String film_name = rs.getString("film_name");
				double value = rs.getDouble("value");

				ItemDataBeans idb = new ItemDataBeans(id,name,detail,price,film_name,value);
				idbList.add(idb);
			}
			st.close();

			return idbList;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static void itemUpdate(ItemDataBeans idb) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;
		ItemDataBeans updateIdb = new ItemDataBeans();

		try {
			con = DBManager.getConnection();

				st = con.prepareStatement("UPDATE item SET name=?, detail=?, price=?, film_name=? WHERE id=?");
				st.setString(1,idb.getName());
				st.setString(2,idb.getDetail());
				st.setInt(3,idb.getPrice());
				st.setString(4,idb.getFilm_name());
				st.setInt(5,idb.getId());
				st.executeUpdate();

			st = con.prepareStatement("SELECT name,detail,price,film_name FROM item WHERE id=?");
			st.setInt(1,idb.getId());
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				updateIdb.setName(rs.getString("name"));
				updateIdb.setDetail(rs.getString("detail"));
				updateIdb.setPrice(rs.getInt("price"));
				updateIdb.setFilm_name(rs.getString("film_name"));
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
	}

	public void itemDelete(int itemId) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("DELETE FROM item WHERE id=?");
			st.setInt(1,itemId);
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

	public static ArrayList<ItemDataBeans> getRandomItem(int limit) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM item ORDER BY RAND() LIMIT ? ");
			st.setInt(1,limit);

			ResultSet rs = st.executeQuery();

			ArrayList<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();
			while(rs.next()) {
				ItemDataBeans idb = new ItemDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setName(rs.getString("name"));
				idb.setDetail(rs.getString("detail"));
				idb.setPrice(rs.getInt("price"));
				idb.setFilm_name(rs.getString("film_name"));
				idb.setValue(rs.getDouble("value"));
				itemList.add(idb);
			}
			return itemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public void insertValue(double allVa,int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("UPDATE item SET value=? WHERE id=?");
			st.setDouble(1,allVa);
			st.setInt(2,itemId);
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
