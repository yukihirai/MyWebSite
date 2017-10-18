package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import base.DBManager;
import beans.ReviewDataBeans;

public class ReviewDAO{
	public static ReviewDAO getInstance(){
		return new ReviewDAO();
	}


	public void insertReview(ReviewDataBeans rdb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("INSERT INTO review (user_id,user_name,item_id,head_comment,item_value,review,create_date) VALUES (?,?,?,?,?,?,?)");
			st.setInt(1,rdb.getUser_id());
			st.setString(2,rdb.getUser_name());
			st.setInt(3,rdb.getItem_id());
			st.setString(4,rdb.getHead_comment());
			st.setInt(5,rdb.getItem_value());
			st.setString(6,rdb.getReview());
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

	public static double getItemValue(int itemId) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT item_Value FROM review WHERE item_id = ?");
			st.setInt(1,itemId);
			ResultSet rs = st.executeQuery();

			int ie = 0;
			int count = 0;

			while(rs.next()) {
				ie += rs.getInt("item_value");
				count++;
			}
			double allVa = (double)ie/count;
			double conAllVa = new BigDecimal(String.valueOf(allVa)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

			return conAllVa;

		}catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static List<ReviewDataBeans> getAllReviewData(int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		List<ReviewDataBeans>rdbList = new ArrayList<ReviewDataBeans>();
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM review WHERE item_id=?");
			st.setInt(1,itemId);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				String user_name = rs.getString("user_name");
				int item_id = rs.getInt("item_id");
				String head_comment = rs.getString("head_comment");
				int item_value = rs.getInt("item_value");
				String review = rs.getString("review");
				Date create_date = rs.getTimestamp("create_date");

				ReviewDataBeans rdb = new ReviewDataBeans(id,user_id,user_name,item_id,head_comment,item_value,review,create_date);
				rdbList.add(rdb);
			}
			st.close();

			return rdbList;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ReviewDataBeans getReviewrDataBeansByReviewId(int reviewId) throws SQLException  {
		ReviewDataBeans rdb = new ReviewDataBeans();
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM review WHERE id=?");
			st.setInt(1,reviewId);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				rdb.setId(rs.getInt("id"));
				rdb.setUser_id(rs.getInt("user_id"));
				rdb.setUser_name(rs.getString("user_name"));
				rdb.setItem_id(rs.getInt("item_id"));
				rdb.setHead_comment(rs.getString("head_comment"));
				rdb.setItem_value(rs.getInt("item_value"));
				rdb.setReview(rs.getString("review"));
				rdb.setCreate_date(rs.getTimestamp("create_date"));
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
		return rdb;
	}

	public static void reviewUpdate(ReviewDataBeans rdb) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;
		ReviewDataBeans updateRdb = new ReviewDataBeans();

		try {
			con = DBManager.getConnection();

				st = con.prepareStatement("UPDATE review SET head_comment=?, review=?, item_value=?,create_date=? WHERE id=?");
				st.setString(1,rdb.getHead_comment());
				st.setString(2,rdb.getReview());
				st.setDouble(3,rdb.getItem_value());
				st.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
				st.setInt(5,rdb.getId());
				st.executeUpdate();

			st = con.prepareStatement("SELECT head_comment,review,item_value,create_date FROM review WHERE id=?");
			st.setInt(1,rdb.getId());
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				updateRdb.setHead_comment(rs.getString("head_comment"));
				updateRdb.setReview(rs.getString("review"));
				updateRdb.setItem_value(rs.getInt("item_value"));
				updateRdb.setCreate_date(rs.getTimestamp("create_date"));
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

	public void reviewDelete(int reviewId) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("DELETE FROM review WHERE id=?");
			st.setInt(1,reviewId);
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
