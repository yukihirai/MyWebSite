package beans;

public class ItemDataBeans {
	private int id;
	private String name;
	private String detail;
	private int price;
	private String film_name;
	private int value;

	public ItemDataBeans(int id, String name, String detail, int price, String film_name,int value) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.film_name = film_name;
		this.value = value;

	}
	public ItemDataBeans() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFilm_name() {
		return film_name;
	}
	public void setFilm_name(String film_name) {
		this.film_name = film_name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
