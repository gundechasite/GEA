<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form name="SelectChapterForm"  namespace="/" action="processSelectChapter" method="post" validate="true">

<table width=90% id=geaContentTable>

   <tr><td colspan=2><label class="geaFormHeading">Select which test would your child like to take: </label></td></tr>
   
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
	    Note:  
	   </label>
	   </td>
    </tr>
  <tr>
	<td colspan=2> 
		<table class="lightGreenTable" id="POITable"  width=100% align=center>
		<tr>
			<td align=center  style="padding-top:20px;padding-bottom:20px;"><s:select list="chapterList" listKey="code" listValue="value" name="chapter" theme="simple"  /></td>
			<td   style="padding-top:20px;padding-bottom:20px;"><s:submit value="Submit"  cssClass="geaSubmitButton"  theme="simple" /></td> 
		</tr>
		</table>
	</td>
   </tr>
</table>
</s:form>