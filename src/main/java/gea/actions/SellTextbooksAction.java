package gea.actions;

import gea.model.TextbookAd;
import gea.utility.GeaUtility;

public class SellTextbooksAction extends GeaBasicAdAction {
	
	 /* Form Fields */
	 private String childsClass;
	 private String[] booksType;
	 private String[] price;
	 private String[] comments;
	 private String[] textbookCondition;
	 
	 
	 /* Execute */
	public String execute(){ 
		
		/* 1. set uniformOrTextbooks */
		uniformOrTextbooks = 'T';
		
		/* 2. set sellerOrBuyer */
		sellerOrBuyer = "S";
		
		/* 3. set ST ads user has entered on screen */
		String currentComments = null;
		for (int i=0;i<booksType.length;i++) {
			if (comments == null) {
				currentComments = null;
			} else {
				currentComments = comments[i];
				System.out.println("textbookCondition[i]"+textbookCondition[i]);
			}
			ST_Ads.add(new TextbookAd(childsClass, booksType[i], price[i], textbookCondition[i], currentComments , GeaUtility.getLoggedUserLoginId(sessionMap), getHideContactDetails(), sellerOrBuyer));
			
		}

		/* 4. Call super.execute() */
		return super.execute();
	 }
	

	
	/* 
	 * Validate
	 * Buy Textbooks and Sell Textbooks will have same validations,
	 * only 1 difference - price will be optional in Buy Textbooks 
	 */
	public void validate() {
		  
		  if (GeaUtility.isFieldEmpty(childsClass)) {
	    	  addActionError("The Child's Class must be selected.");
	      }
		  
		  for (int i=0;i<booksType.length;i++) {
		      if (GeaUtility.isFieldEmpty(booksType[i])) {
		    	  addActionError("The Books Type must be selected.");
		      }			  
		  
		      if (GeaUtility.isFieldEmpty(price[i])) {
		    	  addActionError("The Price must be selected.");
		      }		  
		  
		      if (GeaUtility.isFieldEmpty(textbookCondition[i])) {
		    	  addActionError("The Books Condition must be selected.");
		      }		  
		  }  
	 }

	 /* getters and setters of form fields */
		public String[] getTextbookCondition() {
			return textbookCondition;
		}
		public void setTextbookCondition(String[] textbookCondition) {
			this.textbookCondition = textbookCondition;
		}

		public String[] getComments() {
			return comments;
		}
		public void setComments(String[] comments) {
			this.comments = comments;
		}
		public String getChildsClass() {
			return childsClass;
		}
		public void setChildsClass(String childsClass) {
			this.childsClass = childsClass;
		}
		public String[] getBooksType() {
			return booksType;
		}
		public void setBooksType(String[] booksType) {
			this.booksType = booksType;
		}
		public String[] getPrice() {
			return price;
		}
		public void setPrice(String[] price) {
			this.price = price;
		}
}