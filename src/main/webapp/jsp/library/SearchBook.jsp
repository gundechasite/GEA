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
    <tr> 
	   <td colspan=2>
	   <label class="geaFormSmallText"> 
	    Enter below whatever you know about the book you want to search. 
	   </label>
	   </td>
    </tr>
	<tr>
  		<td width=20%><label class="geaFormlabel">Book Title </label></td>
   		<td><s:textfield name="bookTitle" theme="simple"  maxlength="100" cssClass="geaInput" /></td>
  	</tr>
	<tr>
  		<td width=20%><label class="geaFormlabel">Book ISBN</label></td>
   		<td><s:textfield name="bookISBN" theme="simple"  maxlength="15"  cssClass="geaInput" /></td>
  	</tr>
	<tr>
  		<td width=20%><label class="geaFormlabel">Author </label></td>
   		<td><s:textfield name="bookAuthor" theme="simple"  maxlength="60"  cssClass="geaInput" /></td>
  	</tr>

    <tr><td></td><td><s:submit value="Submit"  cssClass="geaSubmitButton"  theme="simple" /></td></tr>

</table>
</s:form>