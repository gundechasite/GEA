<%@page import="gea.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 

<table  width=90% align=center border=1>
  	<tr>
	    <th colspan="2" style="padding-top:20px;padding-bottom:20px;"><label class="geaFormHeading"><s:property value="qn.question" /></label> </th>
  	</tr>
  
  <tr>
	<td width="50%" style="padding-top:20px;padding-bottom:20px;">  
		<a href="/GEA/Test?actionCode=ShowAns" style="text-decoration:none;">
		    <div style="height:100%;width:100%;">
		      <label class="geaFormHeading">
				<s:property value="qn.optionA" />
				</label>
		    </div>
	  	</a>
  	</td>
	<td>  
		<a href="/GEA/Test?actionCode=ShowAns" style="text-decoration:none;">
		    <div style="height:100%;width:100%">
		      <label class="geaFormHeading"><s:property value="qn.optionB" /></label>
		    </div>
	  	</a>
  	</td>
	</tr>
	
	<tr>
	<td  width="50%" style="padding-top:20px;padding-bottom:20px;">  
	   <a href="/GEA/Test?actionCode=ShowAns" style="text-decoration:none;">
		   <div style="height:100%;width:100%">
		     <label class="geaFormHeading">
		     <s:property value="qn.optionC" />
		     </label>
		   </div>
		</a>
	</td>
	<td>  
		<a href="/GEA/Test?actionCode=ShowAns" style="text-decoration:none;">
		    <div style="height:100%;width:100%">
		      <label class="geaFormHeading">
		      <s:property value="qn.optionD" />
		      </label>
		    </div>
	  	</a>
  	</td>
	</tr>
	
</table>  
<br><br>

