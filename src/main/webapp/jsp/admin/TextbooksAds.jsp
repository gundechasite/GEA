<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   	
<table width=100% id=geaContentTable><tr><td colspan=2><label class="geaFormSubHeading">Textbooks Ads</label></td></tr></table>
  
<table class=alternateColor width=96% align=center>

	<tr>
	    <th>Date</th>
	    <th>Parent</th>
	    <th>S/B</th>
	    <th>class</th>
	    <th>book</th>
	    <th>price</th>
	</tr>
  
    <s:if test="%{(getTextbookAdList()==null)||getTextbookAdList().isEmpty()}"><tr><td colspan=6 align=center>No Records Found</td></tr></s:if>

	<s:iterator value="textbookAdList" >
	<tr>
	    <td><s:property value="adOwnerNamePhoneEmail" /></td>
	    <td><s:property value="sellerOrBuyer"/></td>
	    <td><s:property value="childsClass"/></td>
	    <td><s:property value="bookType"/></td>
	    <td><s:property value="price"/></td>
	</tr>
	</s:iterator>

</table>