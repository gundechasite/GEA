<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<table width=98% id=geaContentTable>
  <tr>
	  <td colspan=2>
	  <label class="geaFormSubHeading">Search Book Results  
	  </label>
	  </td>
  </tr>
     <tr>
   <td colspan=2><div style="border-top:1px solid gray;clear:both;">
   	   <s:if test="hasActionErrors()">
			<div style="color:red;" class="geaErrorMessage">
				<s:actionerror/>
			</div>
	   </s:if>
   </td>
   </tr>
    <tr> 
	   <td colspan=2>
	   
	    You Searched for
	   <label class="geaFormSmallText"> 
	    <br>Book Title = <s:property value="bookTitle"/> 
	    <br>ISBN = <s:property value="bookISBN"/>  
	    <br>Author = <s:property value="bookAuthor"/>
	   </label>
	   </td>
    </tr>
    
</table>


<div>
	<table class=alternateColor width=90% align=center>
    <tr>
	    <th>Title</th>
	    <th>ISBN</th>
	    <th>Author</th>
	    <th>Total Pages</th>
	    <th>Parents Details</th>
    </tr>
    <s:if test="%{(getBooksListSearchResult()==null)||getBooksListSearchResult().isEmpty()}"><tr><td colspan=5 align=center>No Records Found</td></tr></s:if>
	<s:iterator value="booksListSearchResult">
	  <tr>
	    <td><s:property value="bookTitle"/></td>
	    <td><s:property value="bookISBN" /></td>
	    <td><s:property value="bookAuthor"/></td>
	    <td><s:property value="bookTotalPages"/></td>
	    <td><s:property value="parentDetails"/></td>	    
	  </tr>
	</s:iterator>
	</table>  
</div>
<br>
