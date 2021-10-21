package Model.Admin;

public class CardVO {
	private String card_code;
	private String charge_date;
	private int charge_fee;
	private int now_fee;
	public String getCard_code() {
		return card_code;
	}
	public void setCard_code(String card_code) {
		this.card_code = card_code;
	}
	public String getCharge_date() {
		return charge_date;
	}
	public void setCharge_date(String charge_date) {
		this.charge_date = charge_date;
	}
	public int getCharge_fee() {
		return charge_fee;
	}
	public void setCharge_fee(int charge_fee) {
		this.charge_fee = charge_fee;
	}
	public int getNow_fee() {
		return now_fee;
	}
	public void setNow_fee(int now_fee) {
		this.now_fee = now_fee;
	}
	
}
