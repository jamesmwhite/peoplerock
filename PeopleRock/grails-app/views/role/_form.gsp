<%@ page import="peoplerock.Role" %>



<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="role.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="name" from="${roleInstance.constraints.name.inList}" required="" value="${roleInstance?.name}" valueMessagePrefix="role.name"/>
</div>

<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="role.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${roleInstance?.description}"/>
</div>

