<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form name="SellTextbooksForm"  namespace="/" action="processSellMultipleTextbooks" method="post" validate="true">


<table width=95% id=geaContentTable>
  
    <tr><td colspan=2><label class="geaFormHeading">Sell Textbooks</label></td></tr>

    <tr>
	   <td colspan=2>
	   <div style="border-top:1px solid gray;clear:both;">
		   <s:if test="hasActionErrors()">
				<div style="color:red;" class="geaErrorMessage">
					<s:actionerror/>
				</div>
		   </s:if>
	   </td>
    </tr>

    <tr><s:select cssClass="geaSelect" label="Child's Class" list="childsClassList"  listKey="code" listValue="value" name="childsClass" /></tr>    

    <tr> 
	   <td colspan=2>
	   <label class="geaFormSmallText"> 
	    Recommended price for external exam books is free or Rs. 20 each. 
		Contact Me to let me know your suggestions how I should better price options.
	   </label>
	   </td>
    </tr>    

	<tr>
	<td colspan=2> 
		<table class="lightGreenTable"  id="POITable"  width=100% align=center border=1>
		   <tr align=center>
			    <td>Books type </td>
			    <td>Price</td>
			    <td>Condition</td>
			    <td>Comments</td>
				<td></td>
		   </tr>
		   <tr align=center>
			    <td><s:select cssClass="geaSelect" label="Books type" list="booksTypeList"  listKey="code" listValue="value" name="booksType" theme="simple" /></td>
			    <td><s:select cssClass="geaSelect" label="Price" list="textbookPriceList" listKey="code" listValue="value" name="price" theme="simple" /></td>
				 <td><s:select cssClass="geaSelect" label="Condition" list="textbookConditionList" listKey="code" listValue="value" name="textbookCondition" theme="simple" /></td>
			     <td><s:textfield label="Comments" name="comments" theme="simple"  maxlength="400" /></td>
			     <td><input type="button" id="delPOIbutton" value="Delete" onclick="deleteRow(this)"  theme="simple"/></td>
			</tr>
		</table>
	</td>
	</tr>
      
    <tr><td colspan=2> <input type="button" id="Sell More Books" value="Sell More Books" onclick="insRow()"/></td></tr>
  
  	<tr><td></td><td><s:submit value="Submit" cssClass="geaSubmitButton" theme="simple" /></td></tr>
  	
</table>
</s:form>