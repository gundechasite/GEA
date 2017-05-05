<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form namespace="/" action="selectChapter" method="post" validate="true">

<table width=90% id=geaContentTable>

   <tr><td colspan=2><label class="geaFormHeading">Select test which your child would like to take </label></td></tr>
   
   <tr>
	   <td colspan=2><div style="border-top:1px solid gray;clear:both;"></div>
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
	    <u>Note</u>: I have demonstrated only few sample questions here. I would like to set question bank of other subjects/Classes maybe later.
	   </label>
	   </td>
    </tr>
  <tr>
	<td colspan=2> 
		<table class="lightGreenTable" id="POITable"  width=100% align=center>
		<tr>
		<td align=center style="padding-top:20px;padding-bottom:20px;"><s:select list="classSubjectList" listKey="code" listValue="value" name="ClassSubject_id" theme="simple"  /></td>
		<td style="padding-top:20px;padding-bottom:20px;"><s:submit value="Submit"  cssClass="geaSubmitButton"  theme="simple" /></td> 
		</tr>
		</table>
	</td>
   </tr>
</table>
</s:form>