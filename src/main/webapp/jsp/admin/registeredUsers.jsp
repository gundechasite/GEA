<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   	
<table width=90% id=geaContentTable><tr><td colspan=2><label class="geaFormSubHeading">Registered Users</label></td></tr></table>

<table class=alternateColor width=90% align=center>
    <tr>
	    <th>Creation Date</th>
	    <th>LoginId</th>
	    <th>Name</th>
	    <th>Phone</th>
	    <th>Email</th>
    </tr>

    <s:if test="%{(getResisteredUsers()==null)||getResisteredUsers().isEmpty()}"><tr><td colspan=5 align=center>No Records Found</td></tr></s:if>

	<s:iterator value="resisteredUsers">
	<tr>
	    <td><s:property value="creationDate"/></td>
	    <td><s:property value="loginId" /></td>
	    <td><s:property value="name"/></td>
	    <td><s:property value="phone"/></td>
	    <td><s:property value="email"/></td>
	</tr>
	</s:iterator>
</table>