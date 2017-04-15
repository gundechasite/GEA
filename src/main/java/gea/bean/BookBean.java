package gea.bean;

public class BookBean {
	private String Book_id;
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
	
	public BookBean(String Book_id, String bookTitle, String bookISBN, String bookAuthor, String bookCategory, String bookTotalPages, String loginId) {
		this(bookTitle, bookISBN, bookAuthor, bookCategory, bookTotalPages, loginId);
		this.Book_id = Book_id;
	}
	
	public BookBean(String Book_id, String bookTitle, String bookISBN, String bookAuthor, String bookCategory, String bookTotalPages,
			String loginId, String parentDetails) {
		this(Book_id, bookTitle, bookISBN, bookAuthor, bookCategory, bookTotalPages, loginId);
		this.parentDetails = parentDetails;
	}

	/* setters and getters */
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
	public String getBook_id() {
		return Book_id;
	}
	public void setBook_id(String book_id) {
		Book_id = book_id;
	}
}