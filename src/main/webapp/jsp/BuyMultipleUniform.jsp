<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form name="BuyUniformForm"  namespace="/" action="processBuyMultipleUniform" method="post" validate="true">

<table width=90% id=geaContentTable>
   
   <tr><td colspan=2><label class="geaFormHeading">Buy Uniform</label></td></tr>
   
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
		<table class="lightGreenTable" id="POITable"  width=100% align=center border=1>
		<tr align=center><td>Veda (For PE only)</td><td>Uniform Part </td><td>Size</td><td></td></tr>
		<tr align=center>
			<td><s:select label="Veda (For PE only)" list="vedaList" listKey="code" listValue="value" name="veda" theme="simple" /></td> 
			<td><s:select label="Part of Uniform" list="partOfUniformList" listKey="code" listValue="value" name="partOfUniform"  theme="simple"/> </td> 
			<td><s:textfield name="uniformSize" style="width:40px" label="size" scope="request" theme="simple" maxlength="3"/></td> 
			<td><input type="button" id="delPOIbutton" value="Delete" onclick="deleteRow(this)" /></td>
		</tr>
		</table>
	</td>
   </tr>
   
  <tr>
   <td colspan=2>
   		<label class="geaFormSmallText"> 
		Try searching for bigger size if you do not find size you are looking for. 
	    </label>
   </td>
  </tr>
 
   <tr><td colspan=2> <input type="button" id="More" value="Buy More Items" onclick="insRow()"/></td></tr>
    
   <tr><td></td><td><s:submit value="Submit" cssClass="geaSubmitButton" theme="simple" /></td></tr>

</table>

</s:form>