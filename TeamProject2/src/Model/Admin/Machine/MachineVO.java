package Model.Admin.Machine;

public class MachineVO {
	private String machine_code;  // 기기코드
	private String company_name;  // 회사명
	private String game_name;	  // 게임명
	private String machine_model; // 기기모델명
	private String renter_chk;    // 렌터여부
	private String tuning_chk;	  // 튜닝여부
	private String broken_chk;	  // 고장여부
	private int play_fee;		  // 사용료
	
	public String getMachine_code() {
		return machine_code;
	}
	public void setMachine_code(String machine_code) {
		this.machine_code = machine_code;
	}
	public String getMachine_model() {
		return machine_model;
	}
	public void setMachine_model(String machine_model) {
		this.machine_model = machine_model;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public String getRenter_chk() {
		return renter_chk;
	}
	public void setRenter_chk(String renter_chk) {
		this.renter_chk = renter_chk;
	}
	public String getBroken_chk() {
		return broken_chk;
	}
	public void setBroken_chk(String broken_chk) {
		this.broken_chk = broken_chk;
	}
	public String getTuning_chk() {
		return tuning_chk;
	}
	public void setTuning_chk(String tuning_chk) {
		this.tuning_chk = tuning_chk;
	}
	public int getPlay_fee() {
		return play_fee;
	}
	public void setPlay_fee(int play_fee) {
		this.play_fee = play_fee;
	}
}
