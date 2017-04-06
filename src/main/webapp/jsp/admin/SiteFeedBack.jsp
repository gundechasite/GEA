<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<table width=90%  id=geaContentTable>
<tr><td colspan=2><label class="geaFormSubHeading">Site Feedbacks</label></td></tr>
</table>

<table class=alternateColor width=96% align=center>
    <tr>
	    <th>Submission Date</th>
	    <th>Parent</th>
	    <th>Site Usefullness</th>
	    <th>Are Prices Ok?</th>
	    <th>How To Improve?</th>
	    <th>Which Other Items to Sell/Buy?</th>
	    <th>Which Other Sites?</th>
	    <th>Exchange Books?</th>
    </tr>
  
    <s:if test="%{(getSiteFeedbackList()==null)||getSiteFeedbackList().isEmpty()}"><tr><td colspan=8 align=center>No Records Found</td></tr></s:if>

	<s:iterator value="siteFeedbackList">
	<tr>
	    <td><s:property value="submissionDate"/></td>
	    <td><s:property value="parent" /></td>
	    <td><s:property value="siteUsefullness"/></td>
	    <td><s:property value="pricesOk"/></td>
	    <td><s:property value="howToImprove"/></td>
	    <td><s:property value="whichOtherItems"/></td>
	    <td><s:property value="whichOtherSites"/></td>
	    <td><s:property value="exchange"/></td>
	</tr>
	</s:iterator>
</table>  
  