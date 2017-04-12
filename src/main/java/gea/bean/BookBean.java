package gea.bean;

public class BookBean {

	private String bookTitle;
	private String bookISBN;
	private String bookAuthor;
	private String bookCategory;
	private String bookTotalPages;
	private String loginId;
	private String parentDetails;
	
	
	
	public BookBean(String bookTitle, String bookISBN, String bookAuthor, String bookCategory, String bookTotalPages,
			String loginId) {
		this.bookTitle = bookTitle;
		this.bookISBN = bookISBN;
		this.bookAuthor = bookAuthor;
		this.bookCategory = bookCategory;
		this.bookTotalPages = bookTotalPages;
		this.loginId = loginId;
	}
	
	
	
	public BookBean(String bookTitle, String bookISBN, String bookAuthor, String bookCategory, String bookTotalPages,
			String loginId, String parentDetails) {
		this.bookTitle = bookTitle;
		this.bookISBN = bookISBN;
		this.bookAuthor = bookAuthor;
		this.bookCategory = bookCategory;
		this.bookTotalPages = bookTotalPages;
		this.loginId = loginId;
		this.parentDetails = parentDetails;
	}



	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public String getBookTotalPages() {
		return bookTotalPages;
	}
	public void setBookTotalPages(String bookTotalPages) {
		this.bookTotalPages = bookTotalPages;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getParentDetails() {
		return parentDetails;
	}
	public void setParentDetails(String parentDetails) {
		this.parentDetails = parentDetails;
	}
}