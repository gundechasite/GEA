<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
 
 
<s:form  namespace="/" action="Test" method="post" validate="true">

<!-- Set action code for TestView Action Class -->
<s:set name="VARthisIsLastQn" value="thisIsLastQn"/>
<s:if test="%{#VARthisIsLastQn==true}">
	<s:hidden name="actionCode" value="EndTest"/>
</s:if>
<s:else>
	<s:hidden name="actionCode" value="NextQn"/>
</s:else>


<table  width=90% align=center border=1>
<tr><th colspan="2" style="padding-top:20px;padding-bottom:20px;"><label class="geaFormHeading"><s:property value="qn.question" /></label> </th></tr>  
<tr>
	<td width="50%" style="padding-top:20px;padding-bottom:20px;<s:property value="qn.optionAcolor" />">  
	    <div style="height:100%;width:100%;">
	         <label class="geaFormHeading"><s:property value="qn.optionA" /></label>
	    </div>  	
  	</td>
	<td  style="padding-top:20px;padding-bottom:20px;<s:property value="qn.optionBcolor" />">  
	    <div style="height:100%;width:100%">
	         <label class="geaFormHeading"><s:property value="qn.optionB" /></label>
	    </div>
  	</td>
</tr>
<tr>
	<td  width="50%"  style="padding-top:20px;padding-bottom:20px;<s:property value="qn.optionCcolor" />">  
	    <div style="height:100%;width:100%">
		     <label class="geaFormHeading"><s:property value="qn.optionC" /></label>
		</div>
	</td>
	<td  style="padding-top:20px;padding-bottom:20px;<s:property value="qn.optionDcolor" />">  
	    <div style="height:100%;width:100%">
	         <label class="geaFormHeading"><s:property value="qn.optionD" /></label>
		</div>
  	</td>
</tr>
</table>  
<br><br>

<table  width=90% align=center border=1>
<tr><td colspan="2" style="padding-top:20px;padding-bottom:20px;"><label class="geaFormHeading"><s:property value="qn.correctOptionDesc" /></label> </td></tr>
</table>

<br><br>
  	  	
<table  width=90%>
<tr><td align=right>
	<s:if test="%{#VARthisIsLastQn==true}">
		<s:submit value=" End Test "  	 cssClass="geaSubmitButton"  theme="simple" />
	</s:if>
	<s:else>
	    <s:submit value="Next Question"  cssClass="geaSubmitButton"  theme="simple" />
	</s:else>
</td>
</tr>
</table>

<s:set name="VARcorrectlyAnswered" value="qn.correctlyAnswered"/>
<!-- If correctly answered, Ovation sound -->
<s:if test="%{#VARcorrectlyAnswered==true}">
	<audio autoplay>
	  <source src="audio/Ovation.mp3" type="audio/mpeg">
	</audio>
</s:if>
<!-- If wrong, No Dear Sound -->
<s:else>
    <audio autoplay>
	  <source src="audio/NoDear.mp3" type="audio/mpeg">
	</audio>
</s:else>

</s:form>
