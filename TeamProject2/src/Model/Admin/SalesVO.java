package Model.Admin;

public class SalesVO {
	private String insert_date;
	private int start_fee;
	private int cash;
	private int card;
	private int cash_charge;
	private int card_charge;
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public int getStart_fee() {
		return start_fee;
	}
	public void setStart_fee(int start_fee) {
		this.start_fee = start_fee;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getCard() {
		return card;
	}
	public void setCard(int card) {
		this.card = card;
	}
	public int getCash_charge() {
		return cash_charge;
	}
	public void setCash_charge(int cash_charge) {
		this.cash_charge = cash_charge;
	}
	public int getCard_charge() {
		return card_charge;
	}
	public void setCard_charge(int card_charge) {
		this.card_charge = card_charge;
	}
	
}
