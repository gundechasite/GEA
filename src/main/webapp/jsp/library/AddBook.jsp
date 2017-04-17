<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form name="AddBookForm"  namespace="/" action="processAddBook" method="post" validate="true">

<table width=95% id=geaContentTable>
  
    <tr><td colspan=2><label class="geaFormHeading">Add My Books</label></td></tr>

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

    <tr> 
	   <td colspan=2>
	   <label class="geaFormSmallText"> 
	    Please add books that you would like to exchange with other parents. Please do not add books which you do not want to get damaged even little bit.
	   </label>
	   </td>
    </tr>    

	<tr>
	<td colspan=2> 
		<table class="lightGreenTable"  id="POITable"  width=100% align=center border=1>
		   <tr align=center>
			    <td>Title </td>
			    <td>ISBN</td>
			    <td>Author</td>
			    <td>Category</td>
			    <td>Total Pages</td>
				<td></td>
		   </tr>
		   <tr align=center>
			    <td><s:textfield name="bookTitle" theme="simple" style="width:200px;" maxlength="60" /></td>
			    <td><s:textfield name="bookISBN" theme="simple"  maxlength="15" style="width:60px;" /></td>
			    <td><s:textfield name="bookAuthor" theme="simple"  maxlength="60" /></td>
			    <td><s:select name="bookCategory" headerKey="" headerValue="Select " list="#{'PRE':'Preschool', '1-4':'Class 1-4', '5-9':'Class 5-9'}" theme="simple" /></td>
			    <td><s:textfield name="bookTotalPages" theme="simple"  maxlength="4" style="width:30px;" /></td>
			    <td><input type="button" id="delPOIbutton" value="Delete" onclick="deleteRow(this)" theme="simple"/></td>
			</tr>
		</table>
	</td>
	</tr>
      
    <tr><td colspan=2> <input type="button" id="Add More Books" value="Add More Books" onclick="insRow()"/></td></tr>
  
  	<tr><td></td><td><s:submit value="Submit" cssClass="geaSubmitButton" theme="simple" /></td></tr>
  	
</table>
</s:form>
<script>
window.onload = populateEmptyRowHTML;
</script>