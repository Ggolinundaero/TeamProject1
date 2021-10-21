package Model.Admin.Stock;

public class StockVO {
	private String order_code;
	private String company_name;
	private String stock;
	private String picture;
	private String stock_amount;
	private String standard;
	private String latest_day;
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getStock_amount() {
		return stock_amount;
	}
	public void setStock_amount(String stock_amount) {
		this.stock_amount = stock_amount;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getLatest_day() {
		return latest_day;
	}
	public void setLatest_day(String latest_day) {
		this.latest_day = latest_day;
	}
	
}
