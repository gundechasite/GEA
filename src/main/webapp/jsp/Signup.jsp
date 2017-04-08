<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<s:form name="SignupForm" namespace="/" action="processSignup" method="post" validate="true">
<table width=90% id=geaContentTable >

  <tr><td colspan=2><label class="geaFormHeading">Signup</label></td></tr>

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
	   <td width=30%><label class="geaFormlabel">Mobile Phone No.</label><label class="redStar">*</label></td>
	   <td><s:textfield  cssClass="geaInput" name="phone" scope="request" theme="simple"/></td>
   </tr>

  <tr>
	   <td><label class="geaFormlabel"> Select Password</label><label class="redStar">*</label></td>
	   <td><s:password  cssClass="geaInput"  name="password"  theme="simple"/></td>
  </tr>
  
  <tr>
	   <td><label class="geaFormlabel"> Enter password again</label><label class="redStar">*</label></td>
	   <td><s:password  cssClass="geaInput"  name="password2"  theme="simple"/></td>
  </tr>
  
  <tr>
  		<td><label class="geaFormlabel">Name of Parent</label><label class="redStar">*</label></td>
    	<td><s:textfield  cssClass="geaInput"  name="name"  theme="simple" /></td>
  </tr>
  
  <tr>
  	<td><label class="geaFormlabel">E-mail of Parent</label></td>
    <td><s:textfield  cssClass="geaInput"  name="email"  theme="simple" /></td>
  </tr>
  
  <tr>
    <td></td>
    <td><s:submit value="Submit"  cssClass="geaSubmitButton"  theme="simple" /></td>
  </tr>
</table>

</s:form>