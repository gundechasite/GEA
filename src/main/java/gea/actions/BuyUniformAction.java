package gea.actions;

import gea.model.UniformAd;
import gea.utility.GeaUtility;

public class BuyUniformAction extends GeaBasicAdAction {
	
	/* Form Fields */
	private String[] veda;
	private String[] uniformSize;
	private String[] partOfUniform;

	
	
		/* Execute */
		public String execute(){ 
			
			/* 1. set uniformOrTextbooks */
			uniformOrTextbooks = 'U';
			
			/* 2. set sellerOrBuyer */
			sellerOrBuyer = "B";
			
			/* 3. set BU ads user has entered on screen */
			String currentVeda;
			for (int i=0;i<uniformSize.length;i++) {
				if (veda == null) {
					currentVeda = null;
				} else {
					currentVeda = veda[i];
				}
				BU_Ads.add(new UniformAd(currentVeda,currentVeda, uniformSize[i], partOfUniform[i], null, null, GeaUtility.getLoggedUserLoginId(sessionMap), sellerOrBuyer));			
			}
			
			/* 4. Call super.execute() */
			return super.execute();
		 }
	 
		/* Validate */
		public void validate() {
	 		  for (int i=0;i<uniformSize.length;i++) {
			      if (GeaUtility.isFieldEmpty(partOfUniform[i])) {
			    	  addActionError("The Part of Uniform must be selected");
			      }
			      if (GeaUtility.isFieldEmpty(uniformSize[i])) {
			    	  addActionError("The size must be entered");
			      }
			      if (!GeaUtility.isFieldNumeric(uniformSize[i])) {
			    	  addActionError("The size entered should be a number");
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

}