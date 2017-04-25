<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   	
<table width=90% id=geaContentTable><tr><td colspan=2><label class="geaFormSubHeading">Gea Parents Library</label></td></tr></table>

	<table class=alternateColor width=90% align=center>
    <tr>
	    <th>Book_id</th>
	    <th>Title</th>
	    <th>ISBN</th>
	    <th>Author</th>
	    <th>Category</th>
	    <th>Total Pages</th>
	    <th>Parents Details</th>
    </tr>
    <s:if test="%{(getLibraryBooks()==null)||getLibraryBooks().isEmpty()}"><tr><td colspan=7 align=center>No Records Found</td></tr></s:if>
	<s:iterator value="libraryBooks">
	  <tr>
	  	<td><s:property value="Book_id" /></td>
	    <td><s:property value="bookTitle"/></td>
	    <td><s:property value="bookISBN" /></td>
	    <td><s:property value="bookAuthor"/></td>
	    <td><s:property value="bookCategory"/></td>
	    <td align=center><s:property value="bookTotalPages"/></td>
	    <td><s:property value="parentDetails"/></td>	    
	  </tr>
	</s:iterator>
	</table>  

