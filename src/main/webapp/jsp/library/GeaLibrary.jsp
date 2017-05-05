<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<table width=90% id=geaContentTable>
  <tr>
	  <td colspan=2>
	  <label class="geaFormSubHeading">Gea Parents Library - 
	  		<s:if test="%{(screenCode.equals('MyBooks'))}">Books I added to Library</s:if>
	  		<s:else>Books added by other parents to Library</s:else>
	  </label>
	  </td>
  </tr>
     <tr>
   <td colspan=2><div style="border-top:1px solid gray;clear:both;"></div>
   	   <s:if test="hasActionErrors()">
			<div style="color:red;" class="geaErrorMessage">
				<s:actionerror/>
			</div>
	   </s:if>
   </td>
   </tr>

</table>

<style>
div.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 10px 16px;
    transition: 0.3s;
    font-size: 17px;
}

/*  on hover */
div.tab button:hover {
    background-color: #e9fdd5;
}

/* active/current tablink */
div.tab button.active {
    background-color: #BCCE98;
}
</style>


<div class="tab">
  <button class="tablinks" onclick="openTab(event, 'Preschool')" id="defaultOpen">Preschool books</button>
  <button class="tablinks" onclick="openTab(event, '1-4')">Class 1 - 4 books</button>
  <button class="tablinks" onclick="openTab(event, '5-9')">Class 5 - 9 books</button>
</div>
<div style="border-top:8px solid #BCCE98;clear:both;"></div>
<div style="border-top:1px solid black;clear:both;"></div>
<br>

<!-- Preschool Tab -->
<div id="Preschool" class="tabcontent">
	<table class=alternateColor width=100% align=center>
    <tr>
	    <th>Title</th>
	    <th>ISBN</th>
	    <th>Author</th>
	    <th>Total Pages</th>
	    <s:if test="%{(!screenCode.equals('MyBooks'))}"><th>Parents Details</th></s:if>
	    <s:if test="%{(screenCode.equals('MyBooks'))}"><th></th></s:if>
    </tr>
    <s:if test="%{(getBooksListPreschool()==null)||getBooksListPreschool().isEmpty()}"><tr><td colspan=6 align=center>No Records Found</td></tr></s:if>
	<s:iterator value="booksListPreschool">
	  <tr>
	    <td><s:property value="bookTitle"/></td>
	    <td><s:property value="bookISBN" /></td>
	    <td><s:property value="bookAuthor"/></td>
	    <td align=center><s:property value="bookTotalPages"/></td>
	    <s:if test="%{(!screenCode.equals('MyBooks'))}"><td><s:property value="parentDetails"/></td></s:if>	    
	    
	    <s:if test="%{(screenCode.equals('MyBooks'))}">
	    <td align=center>
	    	<s:url var="url" action="DeleteMyBook">
		           <s:param name="Book_id"><s:property value='Book_id'/></s:param>
		           <s:param name="bookTitle"><s:property value='bookTitle'/></s:param>
	        </s:url>
	        <s:a href="%{url}">Delete</s:a>
	    </td>
	    </s:if>
	    
	  </tr>
	</s:iterator>
	</table>  
</div>

<!-- 1-4 Tab -->
<div id="1-4" class="tabcontent">
  	<table class=alternateColor width=100% align=center>
    <tr>
	    <th>Title</th>
	    <th>ISBN</th>
	    <th>Author</th>
	    <th>Total Pages</th>
	    <s:if test="%{(!screenCode.equals('MyBooks'))}"><th>Parents Details</th></s:if>
	    <s:if test="%{(screenCode.equals('MyBooks'))}"><th></th></s:if>
    </tr>
    <s:if test="%{(getBooksList1_4()==null)||getBooksList1_4().isEmpty()}"><tr><td colspan=6 align=center>No Records Found</td></tr></s:if>
	<s:iterator value="booksList1_4">
	  <tr>
	    <td><s:property value="bookTitle"/></td>
	    <td><s:property value="bookISBN" /></td>
	    <td><s:property value="bookAuthor"/></td>
	    <td  align=center><s:property value="bookTotalPages"/></td>
	    <s:if test="%{(!screenCode.equals('MyBooks'))}"><td><s:property value="parentDetails"/></td></s:if>		
	    
	    <s:if test="%{(screenCode.equals('MyBooks'))}">
	    <td  align=center>
	    	<s:url var="url" action="DeleteMyBook">
		           <s:param name="Book_id"><s:property value='Book_id'/></s:param>
		           <s:param name="bookTitle"><s:property value='bookTitle'/></s:param>
	        </s:url>
	        <s:a href="%{url}">Delete</s:a>
	    </td>
	    </s:if>
	        
	  </tr>
	</s:iterator>
	</table>  
</div>

<!-- 5-9 Tab -->
<div id="5-9" class="tabcontent" width=100%>
  	<table class=alternateColor width=100% align=center>
    <tr>
	    <th>Title</th>
	    <th>ISBN</th>
	    <th>Author</th>
	    <th>Total Pages</th>
	    <s:if test="%{(!screenCode.equals('MyBooks'))}"><th>Parents Details</th></s:if>
	    <s:if test="%{(screenCode.equals('MyBooks'))}"><th></th></s:if>
    </tr>
    <s:if test="%{(getBooksList5_9()==null)||getBooksList5_9().isEmpty()}"><tr><td colspan=6 align=center>No Records Found</td></tr></s:if>
	<s:iterator value="booksList5_9">
	  <tr>
	    <td><s:property value="bookTitle"/></td>
	    <td><s:property value="bookISBN" /></td>
	    <td><s:property value="bookAuthor"/></td>
	    <td  align=center><s:property value="bookTotalPages"/></td>
	    <s:if test="%{(!screenCode.equals('MyBooks'))}"><td><s:property value="parentDetails"/></td></s:if>
	    
	    <s:if test="%{(screenCode.equals('MyBooks'))}">
	    <td  align=center>
	    	<s:url var="url" action="DeleteMyBook">
		           <s:param name="Book_id"><s:property value='Book_id'/></s:param>
		           <s:param name="bookTitle"><s:property value='bookTitle'/></s:param>
	        </s:url>
	        <s:a href="%{url}">Delete</s:a>
	    </td>
	    </s:if>
	    	    
	  </tr>
	</s:iterator>
	</table>  
</div>


<script>
function openTab(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
<br>    
