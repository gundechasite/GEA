<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<table width=90% id=geaContentTable><tr><td colspan=2><label class="geaFormSubHeading">Textbooks You want to Buy</label></td></tr></table>

<table class=alternateColor width=60% align=center>
   <tr>
	    <th>Class</th>
	    <th>Book</th>
	    <th></th>
   </tr>
  
   <s:if test="%{(getBT_Ads()==null) || getBT_Ads().isEmpty()}"><tr><td colspan=3 align=center> No Records Found  </td></tr></s:if>

   <s:iterator value="BT_Ads" >
	<tr>
	    <td align=center><s:property value="childsClass"/></td>
	    <td><s:property value="bookType" /></td>
	    <td align=center>
		    <s:url var="url" action="DeleteAd">
		           <s:param name="actionCode">BT</s:param>
		           <s:param name="childsClass"><s:property value='childsClass'/></s:param>
		           <s:param name="bookTypeDBCode"><s:property value='bookTypeDBCode'/></s:param>
		           <s:param name="bookType"><s:property value='bookType'/></s:param>
	        </s:url>
	        <s:a href="%{url}">Delete</s:a>
		</td>
	</tr>
   </s:iterator>
</table>

<br><br>  

<table width=90% id=geaContentTable><tr><td colspan=2><label class="geaFormSubHeading">Matching Ads - Parents selling Books you need</label></td></tr></table>
  
<table class=alternateColor width=90% align=center>
    <tr>
	    <th>Class</th>
	    <th>Book</th>
	    <th>Condition</th>
	    <th>Price</th>
	    <th>Comments</th>
	    <th>Parents Details</th>
    </tr>

    <s:if test="%{(getSearchResultsFor_BT_Ads()==null)||getSearchResultsFor_BT_Ads().isEmpty()}"><tr><td colspan=6 align=center>No Records Found</td></tr></s:if>
	
	<s:iterator value="searchResultsFor_BT_Ads">
	  <tr>
	    <td align=center><s:property value="childsClass"/></td>
	    <td><s:property value="bookType" /></td>
	    <td><s:property value="condition"/></td>
	    <td><s:property value="price"/></td>
	    <td><s:property value="comments"/></td>
	    <td><s:property value="adOwnerNamePhoneEmail"/></td>	    
	  </tr>
	</s:iterator>
</table>  