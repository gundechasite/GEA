<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   
<s:form name="BuyTextbooksForm"  namespace="/" action="processBuyMultipleTextbooks" method="post" validate="true">

<s:hidden name="hideContactDetails"  value="false"/>

<table width=90% id=geaContentTable>

	<tr><td colspan=2><label class="geaFormHeading">Buy Textbooks</label></td></tr>

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
       
	<tr>
		<td colspan=2> 
			<table class="lightGreenTable" id="POITable"  width=50% align=center border=1>
			<tr align=center><td>Books type</td><td></td></tr>
			<tr align=center>
			    <td><s:select cssClass="geaSelect" label="Books type" list="booksTypeList"  listKey="code" listValue="value" name="booksType" theme="simple" /></td> 
				<td><input type="button" id="delPOIbutton" value="Delete" onclick="deleteRow(this)"  theme="simple"/></td>
			</tr>
			</table>
		</td>
	</tr>
      
    <tr><td colspan=2 align=center> <input type="button" id="More" value="Buy More Books" onclick="insRow()"/></td></tr>
    
  	<tr><td></td><td><s:submit value="Submit" cssClass="geaSubmitButton" theme="simple" /></td></tr>
  	
</table>
</s:form>