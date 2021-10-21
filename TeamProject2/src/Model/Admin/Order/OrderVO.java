package Model.Admin.Order;

public class OrderVO {
	private String order_code;	//발주코드
	private String admin;	//관리자 ID
	private String company_name;	// 회사명
	private String picture;	//제품사진
	private String option; //옵션가능여부 	y/n
	private String color; //색변경여부		y/n
	private String model_name; //모델명
	private String stock; //제품명
	private String order_date; //발주일자
	private String order_state; // 발주상태
	private int amount;	//수량
	private int unit_cost;	//상품금액
	private int tot_cost;	//총 상픔금액
	private int surtax;		//부가세
	private int tot_delivery;	// 총주문 금액
	
	//
	
	private String company;
	private String t_option;
	private int price;
	
	
	private String t_name;
	private String t_model;
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getUnit_cost() {
		return unit_cost;
	}
	public void setUnit_cost(int unit_cost) {
		this.unit_cost = unit_cost;
	}
	public int getTot_cost() {
		return tot_cost;
	}
	public void setTot_cost(int tot_cost) {
		this.tot_cost = tot_cost;
	}
	public int getSurtax() {
		return surtax;
	}
	public void setSurtax(int surtax) {
		this.surtax = surtax;
	}
	public int getTot_delivery() {
		return tot_delivery;
	}
	public void setTot_delivery(int tot_delivery) {
		this.tot_delivery = tot_delivery;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getT_option() {
		return t_option;
	}
	public void setT_option(String t_option) {
		this.t_option = t_option;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_model() {
		return t_model;
	}
	public void setT_model(String t_model) {
		this.t_model = t_model;
	}
	
	
	
	

	
}
