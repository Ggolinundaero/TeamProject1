package Model.Admin;

public class ReturnVO {
	private String order_code;
	private String stock_amount;
	private String return_day;
	private int return_amount;
	private int return_fee;
	private String return_state;
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getStock_amount() {
		return stock_amount;
	}
	public void setStock_amount(String stock_amount) {
		this.stock_amount = stock_amount;
	}
	public String getReturn_day() {
		return return_day;
	}
	public void setReturn_day(String return_day) {
		this.return_day = return_day;
	}
	public int getReturn_amount() {
		return return_amount;
	}
	public void setReturn_amount(int return_amount) {
		this.return_amount = return_amount;
	}
	public int getReturn_fee() {
		return return_fee;
	}
	public void setReturn_fee(int return_fee) {
		this.return_fee = return_fee;
	}
	public String getReturn_state() {
		return return_state;
	}
	public void setReturn_state(String return_state) {
		this.return_state = return_state;
	}
	
}
