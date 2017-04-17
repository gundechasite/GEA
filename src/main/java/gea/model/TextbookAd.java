package gea.model;

public class TextbookAd {
	
	/* If new field is added, also update getScreenValueFromDatabaseCodes() */
	
	/* bookTypeDBCode was needed for DeleteAction, 
	 * screen value was populated in TextbookAd.bookType for screen, delete link needed code for delete query 
	 * hence bookTypeDBCode retained DBcode while bookType will have screen value */
	private String bookTypeDBCode;
	
	private String childsClass;
	private String bookType;
	private String condition;
	private String price;
	private String loginId;
	private String sellerOrBuyer;
	private String adOwnerNamePhoneEmail;
	private String adOwnerName;
	private String adOwnerPhone;
	private String adOwnerEmail;
	
	/* Constructors */
	public TextbookAd(){}
	public TextbookAd(String childsClass, String bookType, String price, String condition,
			 String loginId,
			String sellerOrBuyer) {
		this.childsClass = childsClass;
		this.bookType = bookType;
		this.price = price;
		this.condition = condition;
		this.loginId = loginId;
		this.sellerOrBuyer = sellerOrBuyer;
	}
	
	
	/* Getters and Setters */
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getChildsClass() {
		return childsClass;
	}
	public void setChildsClass(String childsClass) {
		this.childsClass = childsClass;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getSellerOrBuyer() {
		return sellerOrBuyer;
	}
	public void setSellerOrBuyer(String sellerOrBuyer) {
		this.sellerOrBuyer = sellerOrBuyer;
	}

	public String getAdOwnerNamePhoneEmail() {
		return adOwnerNamePhoneEmail;
	}

	public void setAdOwnerNamePhoneEmail(String adOwnerNamePhoneEmail) {
		this.adOwnerNamePhoneEmail = adOwnerNamePhoneEmail;
	}
	public String getBookTypeDBCode() {
		return bookTypeDBCode;
	}

	public void setBookTypeDBCode(String bookTypeDBCode) {
		this.bookTypeDBCode = bookTypeDBCode;
	}
	public String getAdOwnerName() {
		return adOwnerName;
	}
	public void setAdOwnerName(String adOwnerName) {
		this.adOwnerName = adOwnerName;
	}
	public String getAdOwnerPhone() {
		return adOwnerPhone;
	}
	public void setAdOwnerPhone(String adOwnerPhone) {
		this.adOwnerPhone = adOwnerPhone;
	}
	public String getAdOwnerEmail() {
		return adOwnerEmail;
	}
	public void setAdOwnerEmail(String adOwnerEmail) {
		this.adOwnerEmail = adOwnerEmail;
	}
}
