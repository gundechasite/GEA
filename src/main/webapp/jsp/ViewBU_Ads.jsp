<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   	
<table width=90%  id=geaContentTable><tr><td colspan=2><label class="geaFormSubHeading">Uniform Items You want to Buy</label></td></tr></table>

<table class=alternateColor width=60% align=center>
  	<tr>
	    <th width=30%>Item</th>
	    <th>Size</th>
	    <th></th>
  	</tr>
  
    <s:if test="%{(getBU_Ads()==null) || getBU_Ads().isEmpty()}"><tr><td colspan=3 align=center> No Records Found  </td></tr></s:if>

	<s:iterator value="BU_Ads" >
	<tr>
	    <td WIDTH="50%"><s:property value="veda" />  <s:property value="partOfUniform"/></td>
	    <td align=center><s:property value="size"/></td>
	    <td align=center>
		    <s:url var="url" action="DeleteAd">
		           <s:param name="actionCode">BU</s:param>
		           <s:param name="veda"><s:property value='veda'/></s:param>
		           <s:param name="vedaDBCode"><s:property value='vedaDBCode'/></s:param>
		           <s:param name="size"><s:property value='size'/></s:param>
		           <s:param name="partOfUniform"><s:property value='partOfUniform'/></s:param>
		           <s:param name="partOfUniformDBCode"><s:property value='partOfUniformDBCode'/></s:param>
	        </s:url>
	        <s:a href="%{url}">Delete</s:a>
	    </td>
	</tr>
	</s:iterator>
</table>

<br><br> 

<table width=90% id=geaContentTable><tr><td colspan=2><label class="geaFormSubHeading">Matching Ads - Parents selling Uniform Items you need</label></td></tr></table>
    
<table class=alternateColor width=90%  align=center>
	<tr>
	    <th>Item</th>
	    <th>Size</th>
	    <th>Condition</th>
	    <th>Price</th>
	    <th>Comments</th>
	    <th>Parents Details</th>
	</tr>
	  
	<s:if test="%{(getSearchResultsFor_BU_Ads()==null)||getSearchResultsFor_BU_Ads().isEmpty()}"><tr><td colspan=6 align=center>No Records Found</td></tr></s:if>

	<s:iterator value="searchResultsFor_BU_Ads" >
		<tr>
		    <td><s:property value="veda" />  <s:property value="partOfUniform"/></td>
		    <td align=center><s:property value="size"/></td>
		    <td><s:property value="uniformCondition"/></td>
		    <td><s:property value="price"/></td>
		     <td><s:property value="comments"/></td>
		    <td><s:property value="adOwnerNamePhoneEmail"/></td>
		</tr>
	</s:iterator>
</table>