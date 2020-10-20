package domain;

public class Account {

	 long accId;
	 String accNo, accType, userId;
	 double balance;
	 
	 public Account(long accId, String accNo, String accType, String userId, double balance) {
		this.accId = accId;
		this.accNo = accNo;
		this.accType = accType;
		this.userId = userId;
		this.balance = balance;
	 }

	public long getAccId() {
		return accId;
	}

	public void setAccId(long accId) {
		this.accId = accId;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	 
	 
}
