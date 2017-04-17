<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form name="SellUniformForm"  namespace="/" action="processSellUniform" method="post" validate="true">


<table width=90% id=geaContentTable>
   
   <tr><td colspan=2><label class="geaFormHeading">Sell Uniform</label></td></tr>
   
   <tr>
	   <td colspan=2><div style="border-top:1px solid gray;clear:both;">
		   <s:if test="hasActionErrors()">
			<div style="color:red;" class="geaErrorMessage">
				<s:actionerror/>
			</div>
		   </s:if>
	   </td>
   </tr>

    <tr>
	<td colspan=2>
		<table class="lightGreenTable" id="POITable" width=100% align=center border=1>
		<tr align=center><td>Veda (PE only)</td><td>Uniform Item</td><td>Size</td><td>Condition</td><td>Price</td><td></td></tr> 
		<tr align=center>
			<td><s:select list="vedaList" listKey="code" listValue="value" name="veda" theme="simple"/></td>
			<td><s:select  list="partOfUniformList" listKey="code" listValue="value" name="partOfUniform" theme="simple"/></td> 
			<td><s:textfield name="uniformSize" style="width:30px;" scope="request"  theme="simple"  maxlength="3"/></td>
			<td><s:select list="uniformConditionList" listKey="code" listValue="value" name="uniformCondition" theme="simple" /></td> 
	    	<td><s:select list="uniformPriceList" listKey="code" listValue="value" name="price" theme="simple" /> </td>
			<td><input type="button" id="delPOIbutton" value="Delete" onclick="deleteRow(this)" /></td>
    	</tr>
		</table>
	</td>
	</tr>

    <tr><td colspan=2> <input type="button" id="Sell More Books" value="Sell More Items" onclick="insRow()"/></td></tr>
  	
  	<tr><td></td><td><s:submit value="Submit"  cssClass="geaSubmitButton"  theme="simple" /></td></tr>
  	 
</table>

</s:form>