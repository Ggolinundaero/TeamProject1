package Model.Admin.Stock;

public class StockVO {
	private String company_name;
	private String stock;
	private int stock_amount;
	private String lastest_day;
	private String model_name;
	private int model_price;
	private String option_status;
	private String parts_status;
	private String kinds;
	private String resive_state;
	private String order_code;
	private String latest_day;
	private String oder_code;
	
	public String getOder_code() {
		return oder_code;
	}
	public void setOder_code(String oder_code) {
		this.oder_code = oder_code;
	}
	public String getLatest_day() {
		return latest_day;
	}
	public void setLatest_day(String latest_day) {
		this.latest_day = latest_day;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getResive_state() {
		return resive_state;
	}
	public void setResive_state(String resive_state) {
		this.resive_state = resive_state;
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
	public int getStock_amount() {
		return stock_amount;
	}
	public void setStock_amount(int stock_amount) {
		this.stock_amount = stock_amount;
	}
	public String getLastest_day() {
		return lastest_day;
	}
	public void setLastest_day(String lastest_day) {
		this.lastest_day = lastest_day;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	public int getModel_price() {
		return model_price;
	}
	public void setModel_price(int model_price) {
		this.model_price = model_price;
	}
	public String getOption_status() {
		return option_status;
	}
	public void setOption_status(String option_status) {
		this.option_status = option_status;
	}
	public String getParts_status() {
		return parts_status;
	}
	public void setParts_status(String parts_status) {
		this.parts_status = parts_status;
	}
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
}