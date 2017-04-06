<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form name="BuyTextbooksForm" action="/processBuyTextbooks" method="post" validate="true">

<s:hidden name="hideContactDetails"  value="false"/>

<table width=90% id=geaContentTable>

   <tr><td colspan=2><label class="geaFormHeading">Buy Textbook</label></td></tr>
   
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

   <tr><s:select cssClass="geaSelect" label="Books type" list="booksTypeList"  listKey="code" listValue="value" name="booksType" /></tr>

   <tr><td></td><td><s:submit value="Submit"  cssClass="geaSubmitButton"  theme="simple" /></td></tr>

</table>
</s:form>