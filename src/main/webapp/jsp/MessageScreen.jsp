<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<s:if test="hasActionMessages()">
	<div class=geaMessage>
      <s:actionmessage theme="simple"/>
    </div>
</s:if>
<s:if test="hasActionErrors()">
	<div style="color:red;" class="geaErrorMessage">
		<s:actionerror  theme="simple"/>
	</div>
</s:if>