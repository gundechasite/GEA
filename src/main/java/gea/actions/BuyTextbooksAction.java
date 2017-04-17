package gea.actions;

import gea.model.TextbookAd;
import gea.utility.GeaUtility;

public class BuyTextbooksAction extends GeaBasicAdAction {
	
	 /* Form Fields */
	 private String childsClass;
	 private String[] booksType;
	 
	 
	 /* Execute */
	public String execute(){ 
		/* 1. set uniformOrTextbooks */
		uniformOrTextbooks = 'T';
		
		/* 2. set sellerOrBuyer */
		sellerOrBuyer = "B";
		
		/* 3. set BT ads user has entered on screen */
		for (int i=0;i<booksType.length;i++) {
			BT_Ads.add(new TextbookAd(childsClass, booksType[i], null, null, GeaUtility.getLoggedUserLoginId(sessionMap), sellerOrBuyer));
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
	    	  addActionError("The Child's Class must be selected");
	      }
		  for (int i=0;i<booksType.length;i++) {
		      if (GeaUtility.isFieldEmpty(booksType[i])) {
		    	  addActionError("The Books Type must be selected.");
		      }
		  }
	}

	
	 /* getters and setters of form fields */
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
}