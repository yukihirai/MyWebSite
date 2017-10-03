package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import EC.EcHelper;

public class UserDataBeans {
	private String name;
	private String login_id;
	private String address;
	private String birth_date;
	private String password;
	private Date create_date;
	private int id;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public String getFormatBirth_Date() {
		return EcHelper.convertDate(birth_date);
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getFormatCreate_date() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(create_date);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
