<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   	
<table width=90%  id=geaContentTable><tr><td colspan=2><label class="geaFormSubHeading">Textbooks You want to Sell</label></td></tr></table>

<table class=alternateColor width=90% align=center>
  	<tr>
	    <th>Class</th>
	    <th>Book</th>
	    <th>Condition</th>
	    <th>Price</th>
	    <th></th>
  	</tr>
  
  	<s:if test="%{(getST_Ads()==null) || getST_Ads().isEmpty()}"><tr><td colspan=6 align=center>No Records Found</td></tr></s:if>

	<s:iterator value="ST_Ads" >
		<tr>
	    <td align=center><s:property value="childsClass"/></td>
	    <td><s:property value="bookType" /></td>
	    <td><s:property value="condition"/></td>
	    <td><s:property value="price"/></td>
	    <td  align=center>
		    <s:url var="url" action="DeleteAd">
		           <s:param name="actionCode">ST</s:param>
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

<table width=90% id=geaContentTable><tr><td colspan=2><label class="geaFormSubHeading">Matching Ads - Parents who want to buy Books that you want to sell</label></td></tr></table>

<table class=alternateColor width=70% align=center>
    <tr>
	    <th>Class</th>
	    <th>Book</th>
	    <th>Parent Details</th>
    </tr>
	
	<s:if test="%{(getSearchResultsFor_ST_Ads()==null)||getSearchResultsFor_ST_Ads().isEmpty()}"><tr><td colspan=6 align=center>No Records Found</td></tr></s:if>
	
	<s:iterator value="searchResultsFor_ST_Ads" >
	<tr>
	    <td align=center><s:property value="childsClass"/></td>
	    <td><s:property value="bookType" /></td>
	    <td><s:property value="adOwnerNamePhoneEmail"/></td>	    
	</tr>
	</s:iterator>
</table>    