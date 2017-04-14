<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<table width=90% id=geaContentTable>

   <tr><td colspan=2><label class="geaFormHeading">Class 2 Maths Test Report </label></td></tr>
   
   <tr>
	   <td colspan=2><div style="border-top:1px solid gray;clear:both;">
	   Chapter: Addition
	   <br>Total Questions: 10 
	   <br>Correctly answered: 10 <s:if test="hasActionMessages()"><div class=geaMessage  style="list-style: none;padding-top:0px" ><s:actionmessage/></div></s:if></td>
   </tr>
</table>

<s:iterator value="answeredQuestionList">
  
<table  width=90% align=center border=1 cellpadding="0" cellspacing="0" >
  	<tr>
	    <th colspan="2" align=left  style="padding-top:5px;padding-bottom:5px;padding-left:5px;"><label class="geaFormLabel">Question: <s:property value="question" /></label> </th>
  	</tr>
  
  <tr>
	<td width="50%" style="padding-top:5px;padding-bottom:5px;padding-left:5px;<s:property value="optionAcolor" />">  
		    <div style="height:100%;width:100%;">
		      <label class="geaFormLabel">
				A. <s:property value="optionA" />
				</label>
		    </div>  	
  	</td>
	<td  style="padding-top:5px;padding-bottom:5px;padding-left:5px;<s:property value="optionBcolor" />">  
		    <div style="height:100%;width:100%">
		      B. <label class="geaFormLabel"><s:property value='optionB' /></label>
		    </div>
  	</td>
	</tr>
	
	<tr>
	<td  width="50%"  style="padding-top:5px;padding-bottom:5px;padding-left:5px;<s:property value='optionCcolor' />">  
		   <div style="height:100%;width:100%">
		     <label class="geaFormLabel">
		     C. <s:property value="optionC" />
		     </label>
		   </div>
	</td>
	<td  style="padding-top:5px;padding-bottom:5px;padding-left:5px;<s:property value='optionDcolor' />">  
		    <div style="height:100%;width:100%">
		      D. <label class="geaFormLabel">
		      <s:property value="optionD" />
		      </label>
		    </div>
	  	
  	</td>
	</tr>
	<tr>
	    <td colspan="2" style="padding-top:5px;padding-bottom:5px;padding-left:5px;">Exlanation: <label class="geaFormLabel"><s:property value="correctOptionDesc" /></label> </td>
  	</tr>
</table> 
  	<br><br>
  	</s:iterator>