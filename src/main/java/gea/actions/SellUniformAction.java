package gea.actions;

import gea.model.UniformAd;
import gea.utility.GeaUtility;

public class SellUniformAction extends GeaBasicAdAction {
	
	/* Form Fields */
	private String[] veda;
	private String[] uniformSize;
	private String[] partOfUniform;
	private String[] uniformCondition;
	private String[] price;
	private String[] comments;

	
	
	/* Execute */
	public String execute(){ 
		
		/* 1. set uniformOrTextbooks */
		uniformOrTextbooks = 'U';
		
		/* 2. set sellerOrBuyer */
		sellerOrBuyer = "S";
		
		/* 3. set SU ads user has entered on screen */
		String currentComments = null;
		for (int i=0;i<uniformSize.length;i++) {
			if (comments == null) {
				currentComments = null;
			} else {
				currentComments = comments[i];
			}
			SU_Ads.add(new UniformAd(veda[i], uniformSize[i], partOfUniform[i], uniformCondition[i], price[i], currentComments, GeaUtility.getLoggedUserLoginId(sessionMap), getHideContactDetails(), sellerOrBuyer));
		}
		
		/* 4. Call super.execute() */
		return super.execute();
		
	 }
	
	 
	/* 
	 * Validate
	 * Buy Uniform and Sell Uniform will have same validations,
	 * only 1 difference - price will be optional in Buy uniform 
	 */
	 public void validate() {
		  
		  for (int i=0;i<uniformSize.length;i++) {

		      if (GeaUtility.isFieldEmpty(partOfUniform[i])) {
		    	  addActionError("The Part of Uniform must be selected");
		      }
		      if (GeaUtility.isFieldEmpty(uniformSize[i])) {
		    	  addActionError("The size must be entered");
		      }
		      if (GeaUtility.isFieldEmpty(uniformCondition[i])) {
		    	  addActionError("The Uniform Condition must be selected");
		      }
		      if (GeaUtility.isFieldEmpty(price[i])) {
		    	  addActionError("The price must be entered");
		      }
		  }
	 }

	 	/* getters and setters of form fields */
		public String[] getVeda() {
			return veda;
		}
		public void setVeda(String[] veda) {
			this.veda = veda;
		}
		public String[] getUniformSize() {
			return uniformSize;
		}
		public void setUniformSize(String[] uniformSize) {
			this.uniformSize = uniformSize;
		}
		public String[] getPartOfUniform() {
			return partOfUniform;
		}
		public void setPartOfUniform(String[] partOfUniform) {
			this.partOfUniform = partOfUniform;
		}
		public String[] getUniformCondition() {
			return uniformCondition;
		}
		public void setUniformCondition(String[] uniformCondition) {
			this.uniformCondition = uniformCondition;
		}
		public String[] getPrice() {
			return price;
		}
		public void setPrice(String[] price) {
			this.price = price;
		}
		public String[] getComments() {
			return comments;
		}
		public void setComments(String[] comments) {
			this.comments = comments;
		}
}