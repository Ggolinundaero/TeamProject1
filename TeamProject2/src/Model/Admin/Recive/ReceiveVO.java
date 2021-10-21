package Model.Admin.Recive;

public class ReceiveVO {
	private String order_code; //발주코드
	private String admin; // 관리자아이디
	private String company_name; //회사명
	private int amount; // 수량
	private int unit_cost; // 상품금액
	private int surtax; //부가세
	private int receive_cost; //총액
	private String insert_date; //입고일
	private String stock; //제품명
	private String sangse; //상세사항
	private String model_name;
	
	private String company ;
	private String parts ;
	private String l_model ;
	private String color ;
	private String l_name ;
	
	
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
	public String getSangse() {
		return sangse;
	}
	public void setSangse(String sangse) {
		this.sangse = sangse;
	}
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
	public int getSurtax() {
		return surtax;
	}
	public void setSurtax(int surtax) {
		this.surtax = surtax;
	}
	public int getReceive_cost() {
		return receive_cost;
	}
	public void setReceive_cost(int receive_cost) {
		this.receive_cost = receive_cost;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getParts() {
		return parts;
	}
	public void setParts(String parts) {
		this.parts = parts;
	}
	public String getL_model() {
		return l_model;
	}
	public void setL_model(String l_model) {
		this.l_model = l_model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	
	
}
