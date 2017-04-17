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

   <tr><s:select cssClass="geaSelect" tooltip="Leave this blank for items other than PE" label="Veda (For PE only)" list="vedaList" listKey="code" listValue="value" name="veda" /></tr>
   
   <tr><s:select cssClass="geaSelect" label="Part of Uniform" list="partOfUniformList" listKey="code" listValue="value" name="partOfUniform" /></tr>
  
   <tr><td colspan=2><s:textfield name="uniformSize" cssClass="geaInput" label="size (e.g. 22)" scope="request" maxlength="3"/></td></tr>
  
   <tr><s:select cssClass="geaSelect" label="Uniform Condition" list="uniformConditionList" listKey="code" listValue="value" name="uniformCondition" /></tr>
    
   <tr><s:textfield label="Comments" name="comments" cssClass="geaInput"  maxlength="400" tooltip="You can describe school Tshirt colour or any problems with the uniform or at what time, buyer can contact you or leave this empty." /></tr>
	
   <tr><s:select cssClass="geaSelect" label="Price" list="uniformPriceList" listKey="code" listValue="value" name="price" tooltip="Enter the price you are expecting from buyer."  /></tr>

   <tr><td></td><td><s:submit value="Submit"  cssClass="geaSubmitButton"  theme="simple" /></td></tr>
  	
</table>

</s:form>
