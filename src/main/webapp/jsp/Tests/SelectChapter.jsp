<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form namespace="/" action="Test" method="post" validate="true">
<s:hidden name="actionCode" value="StartTest"/>
<table width=90% id=geaContentTable>

   <tr><td colspan=2><label class="geaFormHeading"><s:property value="ClassSubject" /> </label></td></tr>
   
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
		<table class="lightGreenTable" id="POITable"  width=100% align=center>
		<tr>
		<td style="padding-top:20px;padding-bottom:20px;padding-right:20px;" align=right> Select Chapter</td>
			<td style="padding-top:20px;padding-bottom:20px;" width="50%"><s:select style="padding-top:5px;padding-bottom:5px;" cssClass="geaSelect" list="chapterList" listKey="code" listValue="value" name="Chapter_id" theme="simple"  /></td>
		</tr>
		<s:set name="VARhasUserLogged" value="hasUserLogged"/>
		<s:if test="%{#VARhasUserLogged==false}">
		<tr>
			<td style="padding-top:20px;padding-bottom:20px;padding-right:20px;" align=right> Enter Email to receive Test Report</td>
			<td><s:textfield  cssClass="geaInput" name="emailFromScreen" scope="request" theme="simple" maxlength="25"/></td> 
		</tr>
		</s:if>
		
		<tr>
			<td align=center></td>
			<td   style="padding-top:20px;padding-bottom:20px;"><s:submit value="Start Test"  cssClass="geaSubmitButton"  theme="simple" /></td> 
		</tr>
		</table>
	</td>
   </tr>
</table>
</s:form>