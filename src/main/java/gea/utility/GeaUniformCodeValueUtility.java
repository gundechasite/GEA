package gea.utility;

import gea.bean.GeaCodeValueBean;
import gea.model.UniformAd;

import java.util.ArrayList;
/* Changes here should be reflected in getScreenValueFromDatabaseCodes below and DBUtility_TextBookUniform select , orderby ... */
/* This class populates drop down lists for Buy/Sell Uniforms screen */
public class GeaUniformCodeValueUtility {
	
	public static  ArrayList<GeaCodeValueBean> populateVedaList() {
		ArrayList<GeaCodeValueBean> vedaList = new ArrayList<GeaCodeValueBean>();
		vedaList.add(new GeaCodeValueBean("", ""));
		vedaList.add(new GeaCodeValueBean("Y", "Yajurveda"));
		vedaList.add(new GeaCodeValueBean("R", "RigVeda"));
		vedaList.add(new GeaCodeValueBean("S", "SamaVeda"));
		vedaList.add(new GeaCodeValueBean("A", "AtharvaVeda"));
		return vedaList;
	}

	public static  ArrayList<GeaCodeValueBean> populatePartOfUniformList() {
		ArrayList<GeaCodeValueBean> partOfUniformList = new ArrayList<GeaCodeValueBean>();
		partOfUniformList.add(new GeaCodeValueBean("", "Select part of Uniform"));
		partOfUniformList.add(new GeaCodeValueBean("PT", "PE Uniform T-Shirt"));
		partOfUniformList.add(new GeaCodeValueBean("PS", "PE Uniform Shorts"));
		partOfUniformList.add(new GeaCodeValueBean("PP", "PE Uniform Full Pant"));
		partOfUniformList.add(new GeaCodeValueBean("ST", "School Uniform T-Shirt"));
		partOfUniformList.add(new GeaCodeValueBean("SS", "School Uniform Shorts"));
		partOfUniformList.add(new GeaCodeValueBean("SP", "School Uniform Full Pant"));
		partOfUniformList.add(new GeaCodeValueBean("GF", "Girls frock"));
		partOfUniformList.add(new GeaCodeValueBean("HO", "Hoody"));
		partOfUniformList.add(new GeaCodeValueBean("SH", "Shoes"));
		partOfUniformList.add(new GeaCodeValueBean("BZ", "Blazer"));
		partOfUniformList.add(new GeaCodeValueBean("IS", "IGCSE Shirt"));
		partOfUniformList.add(new GeaCodeValueBean("IP", "IGCSE Pant"));
		return partOfUniformList;
	}

	public static  ArrayList<GeaCodeValueBean> populateUniformConditionList () {
		ArrayList<GeaCodeValueBean> uniformConditionList = new ArrayList<GeaCodeValueBean>();
		uniformConditionList.add(new GeaCodeValueBean("", "Condition"));
		uniformConditionList.add(new GeaCodeValueBean("N", "Like New"));
		uniformConditionList.add(new GeaCodeValueBean("VG", "Very Good"));
		uniformConditionList.add(new GeaCodeValueBean("G", "Good"));
		uniformConditionList.add(new GeaCodeValueBean("O", "OK"));
		return uniformConditionList;
	}

	public static  ArrayList<GeaCodeValueBean> populatePriceList() {
		ArrayList<GeaCodeValueBean> uniformPriceList = new ArrayList<GeaCodeValueBean>();
		uniformPriceList.add(new GeaCodeValueBean("", "Select Uniform Price"));
		uniformPriceList.add(new GeaCodeValueBean("F", "Free"));
		uniformPriceList.add(new GeaCodeValueBean("100", "Rs. 100"));
		uniformPriceList.add(new GeaCodeValueBean("200", "Rs. 200"));
		uniformPriceList.add(new GeaCodeValueBean("1/4", "1/4th of New Price"));
		uniformPriceList.add(new GeaCodeValueBean("1/2", "1/2 of New Price"));
		return uniformPriceList;
	}
	
	

	public static UniformAd getScreenValueFromDatabaseCodes(UniformAd uniformAdFromDatabaseWithCodes) {
		UniformAd uniformAdForScreen;
		if (uniformAdFromDatabaseWithCodes != null) {
			uniformAdForScreen = new UniformAd();
			
			String veda = uniformAdFromDatabaseWithCodes.getVeda();
			if (veda != null) {
				if("Y".equals(veda)) {
					uniformAdForScreen.setVeda("Yajurveda");
				} else if("R".equals(veda)) {
					uniformAdForScreen.setVeda("RigVeda");
				} else if("S".equals(veda)) {
					uniformAdForScreen.setVeda("SamaVeda"); 
				} else if("A".equals(veda)) {
					uniformAdForScreen.setVeda("AtharvaVeda");
				} 
			}

			String uniformPart = uniformAdFromDatabaseWithCodes.getPartOfUniform();
			if (uniformPart != null) {
				 if ("PT".equals(uniformPart)) {
					 uniformAdForScreen.setPartOfUniform("PE Uniform T-Shirt"); 
				 } else if ("PS".equals(uniformPart)) {
		        	 uniformAdForScreen.setPartOfUniform("PE Uniform Shorts"); 
				 } else if ("PP".equals(uniformPart)) {
		        	 uniformAdForScreen.setPartOfUniform("PE Uniform Full Pant"); 
				 } else if ("ST".equals(uniformPart)) {
		        	 uniformAdForScreen.setPartOfUniform("School Uniform T-Shirt"); 
				 } else if ("SS".equals(uniformPart)) {
		        	 uniformAdForScreen.setPartOfUniform("School Uniform Shorts"); 
				 } else if ("SP".equals(uniformPart)) {
		        	 uniformAdForScreen.setPartOfUniform("School Uniform Full Pant"); 
				 } else if ("GF".equals(uniformPart)) {
		        	 uniformAdForScreen.setPartOfUniform("Girls frock"); 
				 } else if ("HO".equals(uniformPart)) {
					 uniformAdForScreen.setPartOfUniform("Hoody"); 
				 } else if ("SH".equals(uniformPart)) {
		        	 uniformAdForScreen.setPartOfUniform("Shoes"); 
				 } else if ("BZ".equals(uniformPart)) {
		        	 uniformAdForScreen.setPartOfUniform("Blazer"); 
				 } else if ("IS".equals(uniformPart)) {
		        	 uniformAdForScreen.setPartOfUniform("IGCSE Shirt"); 
				 } else if ("IP".equals(uniformPart)) {
		        	 uniformAdForScreen.setPartOfUniform("IGCSE Pant"); 
		         }
			}
			
			String condition = uniformAdFromDatabaseWithCodes.getUniformCondition();
			if (condition != null) {
				if ("N".equals(condition)) {
					uniformAdForScreen.setUniformCondition("Like New");
				} else if ("VG".equals(condition)) {
					uniformAdForScreen.setUniformCondition("Very Good");
				} else if ("G".equals(condition)) {
					uniformAdForScreen.setUniformCondition("Good");
				} else if ("O".equals(condition)) {
					uniformAdForScreen.setUniformCondition("OK");
				}
			}
			
			String price = uniformAdFromDatabaseWithCodes.getPrice();
			if (price != null) {
				/* Changes here should be reflected in searchUniformAdResponses order by */
				if ("F".equals(price)) {
					uniformAdForScreen.setPrice("Free");
				} else if ("100".equals(price)) {
					uniformAdForScreen.setPrice("Rs. 100"); 
				} else if ("200".equals(price)) {
					uniformAdForScreen.setPrice("Rs. 200");
				} else if ("1/4".equals(price)) {
					uniformAdForScreen.setPrice("1/4th of New Price");
				} else if ("1/2".equals(price)) {
					uniformAdForScreen.setPrice("1/2 of New Price"); 
				} 
			}
		
			uniformAdForScreen.setSellerOrBuyer(uniformAdFromDatabaseWithCodes.getSellerOrBuyer());
			uniformAdForScreen.setLoginId(uniformAdFromDatabaseWithCodes.getLoginId());
			uniformAdForScreen.setComments(uniformAdFromDatabaseWithCodes.getComments());
			uniformAdForScreen.setSize(uniformAdFromDatabaseWithCodes.getSize());
			uniformAdForScreen.setSubmissionDate(uniformAdFromDatabaseWithCodes.getSubmissionDate());
			uniformAdForScreen.setPartOfUniformDBCode(uniformAdFromDatabaseWithCodes.getPartOfUniform());
			uniformAdForScreen.setVedaDBCode(uniformAdFromDatabaseWithCodes.getVedaDBCode());
			uniformAdForScreen.setAdOwnerNamePhoneEmail(uniformAdFromDatabaseWithCodes.getAdOwnerNamePhoneEmail());
			uniformAdForScreen.setAdOwnerName(uniformAdFromDatabaseWithCodes.getAdOwnerName());
			uniformAdForScreen.setAdOwnerPhone(uniformAdFromDatabaseWithCodes.getAdOwnerPhone());
			uniformAdForScreen.setAdOwnerEmail(uniformAdFromDatabaseWithCodes.getAdOwnerEmail());
			
			return uniformAdForScreen;
		} else {
			return null;
		}
	}	
}
