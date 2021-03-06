<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form name="LoginForm" namespace="/" action="processLogin" method="post" validate="true">
<table width=90% id=geaContentTable>
  
  <tr><td colspan=2><label class="geaFormHeading">Login</label></td></tr>
  
  <tr>
  	<td colspan=2>
  		  <div style="border-top:1px solid gray;clear:both;">
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
  		<td width=20%><label class="geaFormlabel">LoginId </label><label class="redStar">*</label></td>
   		<td><s:textfield  cssClass="geaInput" name="loginId" scope="request" theme="simple" maxlength="15"/></td>
  </tr>

  <tr>
    <td><label class="geaFormlabel">  Password</label><label class="redStar">*</label></td>
    <td><s:password  cssClass="geaInput"  name="password"  theme="simple"  maxlength="9"/></td>
  </tr>
  
  <tr>
    <td></td>
    <td><s:submit value="Submit"  cssClass="geaSubmitButton"  theme="simple" /></td>
  </tr>

  <tr>
	  <td colspan=2>
		  <label class="geaFormSmallText">
		  Your mobile phone no. is your login Id. If you have forgotten your password, please email me at gundecha.parents.portal@gmail.com with subject Forgot Password.
		  If you have not signed up, please signup first. 
		  </label><a href="/GEA/Signup">Signup</a>
	  </td>
  </tr>

</table>
</s:form>