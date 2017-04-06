<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   	

<table width=98%  id=geaContentTable>
  <tr><td colspan=2><label class="geaFormSubHeading">ConTact Me Messages</label></td></tr>
  </table>
<table class=alternateColor width=96% align=center>
  <tr>
    <th width="10%">Submission Date</th>
    <th width="25%">Parent</th>
    <th>Message</th>
  </tr>
  <s:if test="%{(getContactMeMessages()==null) || getContactMeMessages().isEmpty()  }">
  <tr><td colspan=3 align=center> No Records Found  </td></tr>
  </s:if>
<s:iterator value="contactMeMessages" >
<tr>
    <td><s:property value="submissionDate"/></td>
    <td><s:property value="parent" /></td>
    <td><s:property value="message"/></td>
</tr>
</s:iterator>
</table>  
  