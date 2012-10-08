<%@ page import="peoplerock.Platform" %>



<div class="fieldcontain ${hasErrors(bean: platformInstance, field: 'platformName', 'error')} required">
	<label for="platformName">
		<g:message code="platform.platformName.label" default="Platform Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="platformName" required="" value="${platformInstance?.platformName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: platformInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="platform.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${platformInstance?.description}"/>
</div>

