<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   	
<table width=100% id=geaContentTable><tr><td colspan=2><label class="geaFormSubHeading">Uniform Ads</label></td></tr></table>

<table class=alternateColor width=96% align=center>

    <tr>
	    <th>Date</th>
	    <th>Parent</th>
	    <th>S/B</th>
	    <th>Item</th>
	    <th>Size</th>
	    <th>Condition</th>
	    <th>Price</th>
    </tr>

    <s:if test="%{(getUniformAdList()==null)||getUniformAdList().isEmpty()}"><tr><td colspan=6 align=center>No Records Found</td></tr></s:if>

	<s:iterator value="uniformAdList" >
	<tr>
		<td><s:property value="submissionDate"/></td>
	    <td><s:property value="adOwnerNamePhoneEmail" /></td>
	    <td><s:property value="sellerOrBuyer"/></td>
	    <td><s:property value="veda" /> <s:property value="partOfUniform"/></td>
	    <td><s:property value="size"/></td>
	    <td><s:property value="uniformCondition"/></td>
	    <td><s:property value="price"/></td>
	</tr>
	</s:iterator>

</table>