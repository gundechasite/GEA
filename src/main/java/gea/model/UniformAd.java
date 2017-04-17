package gea.model;

public class UniformAd {

/* If new field is added, also update getScreenValueFromDatabaseCodes() */
	
	/* Below 2 were needed for DeleteAction, 
	 * screen values were populated in UniformAd for screen, delete link needed codes for delete query 
	 * hence below 2 retained db codes */
	private String vedaDBCode;
	private String partOfUniformDBCode;
	
	private String veda;
	private String partOfUniform;
	private String size;
	private String uniformCondition;
	private String price;
	private String comments;
	private String loginId;
	private String sellerOrBuyer;
	private String adOwnerNamePhoneEmail;
	private String adOwnerName;
	private String adOwnerPhone;
	private String adOwnerEmail;
	
	private String submissionDate;
	

	/* Constructors */
	public UniformAd() {}
	public UniformAd(
			String veda, String size, String partOfUniform,
			String uniformCondition, String price, String comments, String loginId,
			String sellerOrBuyer) {
		
		this.veda = veda;
		this.size = size;
		this.partOfUniform = partOfUniform;
		this.uniformCondition = uniformCondition;
		this.price = price;
		this.comments = comments;
		this.loginId = loginId;
		this.sellerOrBuyer = sellerOrBuyer;
	}
	
	public UniformAd(
			String veda,String vedaDBCode, String size, String partOfUniform,
			String uniformCondition, String price, String comments, String loginId,
			 String sellerOrBuyer) {
		
		this.veda = veda;
		this.vedaDBCode = vedaDBCode;
		this.size = size;
		this.partOfUniform = partOfUniform;
		this.uniformCondition = uniformCondition;
		this.price = price;
		this.comments = comments;
		this.loginId = loginId;
		this.sellerOrBuyer = sellerOrBuyer;
	}
	
	/* Getters and Setters */
	public String getAdOwnerNamePhoneEmail() {
		return adOwnerNamePhoneEmail;
	}
	public void setAdOwnerNamePhoneEmail(String adOwnerNamePhoneEmail) {
		this.adOwnerNamePhoneEmail = adOwnerNamePhoneEmail;
	}
	public String getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}
	public String getVeda() {
		return veda;
	}
	public void setVeda(String veda) {
		this.veda = veda;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPartOfUniform() {
		return partOfUniform;
	}
	public void setPartOfUniform(String partOfUniform) {
		this.partOfUniform = partOfUniform;
	}
	public String getUniformCondition() {
		return uniformCondition;
	}
	public void setUniformCondition(String uniformCondition) {
		this.uniformCondition = uniformCondition;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
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
	public String getVedaDBCode() {
		return vedaDBCode;
	}
	public void setVedaDBCode(String vedaDBCode) {
		this.vedaDBCode = vedaDBCode;
	}
	public String getPartOfUniformDBCode() {
		return partOfUniformDBCode;
	}
	public void setPartOfUniformDBCode(String partOfUniformDBCode) {
		this.partOfUniformDBCode = partOfUniformDBCode;
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