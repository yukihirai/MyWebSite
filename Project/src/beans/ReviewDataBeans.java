package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReviewDataBeans {
	private int id;
	private int user_id;
	private String user_name;
	private int item_id;
	private String head_comment;
	private String review;
	private int item_value;
	private Date create_date;

	private double all_value;

	public ReviewDataBeans(int id, int user_id,String user_name, int item_id, String head_comment, int item_value, String review,Date create_date) {
		this.id = id;
		this.user_id = user_id;
		this.user_name = user_name;
		this.item_id = item_id;
		this.head_comment = head_comment;
		this.item_value = item_value;
		this.review = review;
		this.create_date = create_date;
	}
	public ReviewDataBeans() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getHead_comment() {
		return head_comment;
	}
	public void setHead_comment(String head_comment) {
		this.head_comment = head_comment;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getItem_value() {
		return item_value;
	}
	public void setItem_value(int item_value) {
		this.item_value = item_value;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getFormatCreate_date() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(create_date);
	}
	public double getAll_value() {
		return all_value;
	}
	public void setAll_value(double all_value) {
		this.all_value = all_value;
	}
}
