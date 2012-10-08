
<%@ page import="peoplerock.KnowledgeProfile" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'knowledgeProfile.label', default: 'KnowledgeProfile')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-knowledgeProfile" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-knowledgeProfile" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list knowledgeProfile">
			
				<g:if test="${knowledgeProfileInstance?.employee}">
				<li class="fieldcontain">
					<span id="employee-label" class="property-label"><g:message code="knowledgeProfile.employee.label" default="Employee" /></span>
					
						<span class="property-value" aria-labelledby="employee-label"><g:link controller="employee" action="show" id="${knowledgeProfileInstance?.employee?.id}">${knowledgeProfileInstance?.employee?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${knowledgeProfileInstance?.skill}">
				<li class="fieldcontain">
					<span id="skill-label" class="property-label"><g:message code="knowledgeProfile.skill.label" default="Skill" /></span>
					
						<span class="property-value" aria-labelledby="skill-label"><g:link controller="skill" action="show" id="${knowledgeProfileInstance?.skill?.id}">${knowledgeProfileInstance?.skill?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${knowledgeProfileInstance?.level}">
				<li class="fieldcontain">
					<span id="level-label" class="property-label"><g:message code="knowledgeProfile.level.label" default="Level" /></span>
					
						<span class="property-value" aria-labelledby="level-label"><g:fieldValue bean="${knowledgeProfileInstance}" field="level"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${knowledgeProfileInstance?.note}">
				<li class="fieldcontain">
					<span id="note-label" class="property-label"><g:message code="knowledgeProfile.note.label" default="Note" /></span>
					
						<span class="property-value" aria-labelledby="note-label"><g:fieldValue bean="${knowledgeProfileInstance}" field="note"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${knowledgeProfileInstance?.id}" />
					<g:link class="edit" action="edit" id="${knowledgeProfileInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
