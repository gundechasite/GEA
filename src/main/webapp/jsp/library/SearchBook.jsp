<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form name="SearchBookForm"  namespace="/" action="processSearchBook" method="post" validate="true">

<table width=90% id=geaContentTable>

   <tr><td colspan=2><label class="geaFormHeading">Search Book</label></td></tr>
   
   <tr>
	   <td colspan=2><div style="border-top:1px solid gray;clear:both;">
	   <s:if test="hasActionErrors()">
			<div style="color:red;" class="geaErrorMessage">
				<s:actionerror/>
			</div>
	   </s:if>
	   </td>
   </tr>

   <tr><s:textfield name="bookTitle" theme="simple" style="width:200px;" maxlength="100" /></tr>
   
   <tr><s:textfield name="bookISBN" theme="simple"  maxlength="15" style="width:60px;" /></tr>

   <tr><s:textfield name="bookAuthor" theme="simple"  maxlength="60" /></tr>

   <tr><td></td><td><s:submit value="Submit"  cssClass="geaSubmitButton"  theme="simple" /></td></tr>

</table>
</s:form>