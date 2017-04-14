<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form namespace="/" action="selectChapter" method="post" validate="true">

<table width=90% id=geaContentTable>

   <tr><td colspan=2><label class="geaFormHeading">Select test which your child would like to take </label></td></tr>
   
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
	    Note: I have only demonstrated 1 test. (Class 2 Maths) Only if parents like this idea, then I would like to proceed further to other subjects/Class.
	    Also, I would need volunteers to do the typing of the question banks for various class/subjects. 
	    Let me know if you can volunteer to help setup the questions bank. 
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