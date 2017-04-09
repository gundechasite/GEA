<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form name="BuyUniformForm"  namespace="/" action="processBuyUniform" method="post" validate="true">

<s:hidden name="hideContactDetails"  value="false"/>

<table width=80% id=geaContentTable>
   
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

  <tr><s:select cssClass="geaSelect" label="Veda (For PE only)" list="vedaList" listKey="code" listValue="value" name="veda" tooltip="Leave this blank for items other than PE"  /></tr>
   
  <tr><s:select cssClass="geaSelect" label="Part of Uniform" list="partOfUniformList" listKey="code" listValue="value" name="partOfUniform" /></tr>
  
  <tr><td colspan=2><s:textfield name="uniformSize" cssClass="geaInput" label="size (e.g. 22)" scope="request"  maxlength="3"/></td></tr>
 
  <tr><td></td><td><s:submit value="Submit" cssClass="geaSubmitButton" theme="simple" /></td></tr>
</table>

</s:form>