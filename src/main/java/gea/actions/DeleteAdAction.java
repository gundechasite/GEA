package gea.actions;

import gea.utility.DBUtility_TextBookUniform;
import gea.utility.GeaUtility;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteAdAction  extends ActionSupport implements SessionAware {
	/* All below are request parameters */
	
	/* actionCode will be ST/BT/SU/BU */
	private String actionCode;
	
	/* Needed for Delete Uniform Ad */
	private String veda;		/* Value to be used in successful delete message */
	private String vedaDBCode;  /* Code to be used in delete query */ 
	private String size;				/* to be used in both places - delete query and message */
	private String partOfUniform; 	    /* Value to be used in successful delete message */ 
	private String partOfUniformDBCode; /* Code to be used in delete query */
	
	/* Needed for Delete Textbook Ad */
	private String childsClass;			/* to be used in both places - delete query and message */
	private String bookType;			/* Value to be used in successful delete message */ 
	private String bookTypeDBCode;		/* Code to be used in delete query */
	
	public String execute() {
		String buyOrSell = ""; /* To be used in successful delete message */
		
		try {
							
			/* actionCode will be ST/BT/SU/BU */
			if (actionCode.startsWith("B")) {
				buyOrSell= "Buy";
			} else {
				buyOrSell= "Sell";
			}
			
			if (actionCode.contains("T")) {
				/* Delete Textbook Ad */
				DBUtility_TextBookUniform.deleteTextbookAd(
					GeaUtility.getLoggedUserLoginId(sessionMap), childsClass, bookTypeDBCode);
				addActionMessage("You Ad ("+buyOrSell+" class "+childsClass+" : "+bookType+") has been deleted");
			} else {
				/* Delete Uniform Ad */
				DBUtility_TextBookUniform.deleteUniformAd(
					GeaUtility.getLoggedUserLoginId(sessionMap), vedaDBCode, size, partOfUniformDBCode);
				addActionMessage("You Ad ("+buyOrSell+" "+veda+" "+partOfUniform+" of size "+size+") has been deleted");
			}
		
		} catch (Exception e) {
			System.out.println("Error while deleting your "+buyOrSell+" ad "+e);
			addActionError("Error while deleting your "+buyOrSell+" ad");
			return "error";
		}
		
		return "success";	 
	}
	
	/* Required since implements SessionAware */
	protected Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
       this.sessionMap = sessionMap;
    }

    /* getters and setters */
    public String getActionCode() {
		return actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
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
	public String getBookTypeDBCode() {
		return bookTypeDBCode;
	}
	public void setBookTypeDBCode(String bookTypeDBCode) {
		this.bookTypeDBCode = bookTypeDBCode;
	}
}