
<%@ page import="peoplerock.Training" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'training.label', default: 'Training')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-training" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-training" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list training">
			
				<g:if test="${trainingInstance?.courseName}">
				<li class="fieldcontain">
					<span id="courseName-label" class="property-label"><g:message code="training.courseName.label" default="Course Name" /></span>
					
						<span class="property-value" aria-labelledby="courseName-label"><g:fieldValue bean="${trainingInstance}" field="courseName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trainingInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="training.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate date="${trainingInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${trainingInstance?.finishDate}">
				<li class="fieldcontain">
					<span id="finishDate-label" class="property-label"><g:message code="training.finishDate.label" default="Finish Date" /></span>
					
						<span class="property-value" aria-labelledby="finishDate-label"><g:formatDate date="${trainingInstance?.finishDate}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${trainingInstance?.id}" />
					<g:link class="edit" action="edit" id="${trainingInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
