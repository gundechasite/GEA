<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 

<s:form name="SiteFeedbackForm" action="/processSiteFeedback" method="post" validate="true">


<table width=95%  id="geaContentTable">
  
  <tr><td colspan=2><label class="geaFormHeading">Feedback on this Website</label></td></tr>
  
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
	  <td width=40%><label class="geaFormlabel">Do you think, this website will be useful? </label></td>
	  <td>   
			<input type="radio" name="siteUsefullness"  value="NO"/><label> Not Much helpful</label>
			<input type="radio" name="siteUsefullness"  value="MAY"/><label> Might be helpful</label>
			<br><input type="radio" name="siteUsefullness"  value="HLP"/><label> Will be very helpful</label>
			<input type="radio" name="siteUsefullness"  value="CHG"/><label> Will be helpful after changes</label>
	  </td>
  </tr>

   <tr>
	  <td><label class="geaFormlabel">Are prices of textbooks, uniforms ok? </label></td>
	  <td><s:textarea  name="pricesOk" scope="request" cols="60" rows="1" theme="simple"/></td>
   </tr>
   
   <tr>
	  <td width=20%><label class="geaFormlabel">How can this website be improved? </label></td>
	  <td><s:textarea  name="howToImprove" scope="request" cols="60" rows="1" theme="simple"/></td>
   </tr>
  
   <tr>
	  <td width=20%><label class="geaFormlabel">Which other items should parents sell/buy on this website? </label></td>
	  <td><s:textarea  name="whichOtherItems" scope="request" cols="60" rows="1" theme="simple"/></td>
   </tr>
  
   <tr>
   	  <td width=20%><label class="geaFormlabel">Which website should be developed which will help Gundecha parents or school? </label></td>
   	  <td><s:textarea  name="whichOtherSites" scope="request" cols="60" rows="1" theme="simple"/></td>
   </tr>

   <tr>
	  <td width=20%><label class="geaFormlabel">Should this site start an option where parents can exchange story books for few days? </label></td>
	  <td><s:textarea  name="exchange" scope="request" cols="60" rows="1" theme="simple"/></td>
   </tr>
 
  <tr>
      <td></td>
      <td><s:submit value="Submit"  cssClass="geaSubmitButton"  theme="simple" /></td>
  </tr>

</table>
</s:form>