<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
 
 <table width=90% id=geaContentTable>
  <tr><td colspan=2><label class="geaFormHeading">Contact Me</label></td></tr>
  <tr>
  <td colspan=2><div style="border-top:1px solid gray;clear:both;">
  </td>
  </tr>
   <tr>
	   <td colspan=2>
		  <label class="geaFormSmallText">
		  You may contact me at gundecha.parents.portal@gmail.com. Thank You.
		  </label>
	   </td>
  </tr>
</table>
 
 <!-- 
<s:form name="ContactMeForm" namespace="/" action="processContactMe" method="post" validate="true">
<table width=90% id=geaContentTable>
  
  <tr><td colspan=2><label class="geaFormHeading">Contact Me</label></td></tr>
  
  <tr>
  <td colspan=2><div style="border-top:1px solid gray;clear:both;">
	  <s:if test="hasActionErrors()">
		<div style="color:red;" class="geaErrorMessage">
			<s:actionerror/>
		</div>
	  </s:if>
	  <s:if test="hasActionMessages()">
		<div class=geaMessage  style="list-style: none;" >
	      <s:actionmessage/>
	    </div>
	  </s:if>
  </td>
  </tr>
  
  <tr>
	   <td width=20%><label class="geaFormlabel">Your comments: </label><label class="redStar">*</label></td>
	   <td><s:textarea  name="message" scope="request" cols="60" rows="7" theme="simple"  maxlength="600"/></td>
  </tr>

  <tr>
       <td></td>
       <td><s:submit value="Submit"  cssClass="geaSubmitButton"  theme="simple" /></td>
  </tr>

  <tr>
	   <td colspan=2>
		  <label class="geaFormSmallText">
		  Feel free to give me all your suggestions to improve this website. Let me know any question you may have. 
		  Let me know, which other features may be developed on this site (or any other site) that may help parents or school.
		  </label>
	   </td>
  </tr>

</table>
</s:form>
 -->