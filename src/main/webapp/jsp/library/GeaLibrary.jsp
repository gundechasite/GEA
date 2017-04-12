<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<table width=90% id=geaContentTable><tr><td colspan=2><label class="geaFormSubHeading">Gea Parents Library</label></td></tr>
  <tr>
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
    background-color: #DAE9BC;
}
</style>


<div class="tab">
  <button class="tablinks" onclick="openTab(event, 'Preschool')" id="defaultOpen">Preschool books</button>
  <button class="tablinks" onclick="openTab(event, '1-4')">Class 1 - 4 books</button>
  <button class="tablinks" onclick="openTab(event, '5-9')">Class 5 - 9 books</button>
</div>
<div style="border-top:5px solid #DAE9BC;clear:both;"></div>
<br>

<!-- Preschool Tab -->
<div id="Preschool" class="tabcontent">
	<table class=alternateColor width=90% align=center>
    <tr>
	    <th>Title</th>
	    <th>ISBN</th>
	    <th>Author</th>
	    <th>Total Pages</th>
	    <th>Parents Details</th>
    </tr>
    <s:if test="%{(getBooksListPreschool()==null)||getBooksListPreschool().isEmpty()}"><tr><td colspan=5 align=center>No Records Found</td></tr></s:if>
	<s:iterator value="booksListPreschool">
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

<!-- 1-4 Tab -->
<div id="1-4" class="tabcontent">
  	<table class=alternateColor width=90% align=center>
    <tr>
	    <th>Title</th>
	    <th>ISBN</th>
	    <th>Author</th>
	    <th>Total Pages</th>
	    <th>Parents Details</th>
    </tr>
    <s:if test="%{(getBooksList1_4()==null)||getBooksList1_4().isEmpty()}"><tr><td colspan=5 align=center>No Records Found</td></tr></s:if>
	<s:iterator value="booksList1_4">
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

<!-- 5-9 Tab -->
<div id="5-9" class="tabcontent">
  	<table class=alternateColor width=90% align=center>
    <tr>
	    <th>Title</th>
	    <th>ISBN</th>
	    <th>Author</th>
	    <th>Total Pages</th>
	    <th>Parents Details</th>
    </tr>
    <s:if test="%{(getBooksList5_9()==null)||getBooksList5_9().isEmpty()}"><tr><td colspan=5 align=center>No Records Found</td></tr></s:if>
	<s:iterator value="booksList5_9">
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
     
