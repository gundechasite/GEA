<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form name="SellTextbooksForm" action="/processSellMultipleTextbooks" method="post" validate="true">

<s:hidden name="hideContactDetails"  value="false"/>

<table width=80% id=geaContentTable>
   <tr><td colspan=2><label class="geaFormHeading">Sell Textbook</label></td></tr>
  
   <tr>
	  <td colspan=2><div style="border-top:1px solid gray;clear:both;">
		   <s:if test="hasActionErrors()">
			<div style="color:red;" class="geaErrorMessage">
				<s:actionerror/>
			</div>
		   </s:if>
	   </td>
   </tr>

   <tr><s:select cssClass="geaSelect" label="Child's Class" list="childsClassList"  listKey="code" listValue="value" name="childsClass" /></tr>
   
   <tr><s:select cssClass="geaSelect" label="Books type"    list="booksTypeList"    listKey="code" listValue="value" name="booksType" /></tr>
   
   <tr><td colspan=2><label class="geaFormSmallText">Contact Me if I have missed out any type of books</label></td></tr>
	
   <tr>
   <td colspan=2>
   		<label class="geaFormSmallText"> 
		Recommended price for Olympiad books is free or Rs. 20 each. 
		Recommended price for School Textbooks is free, Rs. 100 or Rs. 200 for all. 
		Contact Me to let me know your suggestions how I should better this price options.
	    </label>
   </td>
   </tr>

   <tr><s:select cssClass="geaSelect" label="Price" 	list="textbookPriceList" 	 listKey="code" listValue="value" name="price" /></tr>
   
   <tr><s:select cssClass="geaSelect" label="Condition" list="textbookConditionList" listKey="code" listValue="value" name="textbookCondition" /></tr> 

   <tr><s:textfield label="Comments" name="comments" cssClass="geaInput" maxlength="400"/></tr>  	
  
   <tr><td></td><td><s:submit value="Submit" cssClass="geaSubmitButton" theme="simple" /></td></tr>
  	
</table>

</s:form>