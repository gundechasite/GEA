<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form  namespace="/" action="Test" method="post" validate="true">
<s:hidden name="actionCode" value="NextQn"/>
<table  width=90% align=center border=1>
  	<tr>
	    <th colspan="2" style="padding-top:20px;padding-bottom:20px;"><label class="geaFormHeading"><s:property value="qn.question" /></label> </th>
  	</tr>
  
  <tr>
	<td width="50%" style="padding-top:20px;padding-bottom:20px;background-color: #FF4500;">  
		<a href="http://example.com" style="text-decoration:none;">
		    <div style="height:100%;width:100%;">
		      <label class="geaFormHeading">
				<s:property value="qn.optionA" />
				</label>
		    </div>
	  	</a>
  	</td>
	<td style="background-color: #DAE9BC;">  
		<a href="http://example.com" style="text-decoration:none;">
		    <div style="height:100%;width:100%">
		      <label class="geaFormHeading"><s:property value="qn.optionB" /></label>
		    </div>
	  	</a>
  	</td>
	</tr>
	
	<tr>
	<td  width="50%" style="padding-top:20px;padding-bottom:20px;">  
	   <a href="http://example.com" style="text-decoration:none;">
		   <div style="height:100%;width:100%">
		     <label class="geaFormHeading">
		     <s:property value="qn.optionC" />
		     </label>
		   </div>
		</a>
	</td>
	<td>  
		<a href="http://example.com" style="text-decoration:none;">
		    <div style="height:100%;width:100%">
		      <label class="geaFormHeading">
		      <s:property value="qn.optionD" />
		      </label>
		    </div>
	  	</a>
  	</td>
	</tr>
	
</table>  
<br><br>

<table  width=90% align=center border=1>
  	<tr>
	    <td colspan="2" style="padding-top:20px;padding-bottom:20px;"><label class="geaFormHeading"><s:property value="qn.correctOptionDesc" /></label> </td>
  	</tr>
  	</table>
  	<br><br>
  	  	
<table  width=90%>
<tr>
<td  align=right>
<s:if test="%{(getLast()==null) || getLast().isEmpty()}">
	<s:submit value="Next Question"  cssClass="geaSubmitButton"  theme="simple" />
</s:if>
<s:else>
	<s:submit value="End Test"  cssClass="geaSubmitButton"  theme="simple" />

</s:else>
</td>
</tr>
</table>
</s:form>