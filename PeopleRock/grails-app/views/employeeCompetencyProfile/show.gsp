
<%@ page import="peoplerock.EmployeeCompetencyProfile" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employeeCompetencyProfile.label', default: 'EmployeeCompetencyProfile')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-employeeCompetencyProfile" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-employeeCompetencyProfile" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list employeeCompetencyProfile">
			
				<g:if test="${employeeCompetencyProfileInstance?.competency}">
				<li class="fieldcontain">
					<span id="competency-label" class="property-label"><g:message code="employeeCompetencyProfile.competency.label" default="Competency" /></span>
					
						<span class="property-value" aria-labelledby="competency-label"><g:link controller="competency" action="show" id="${employeeCompetencyProfileInstance?.competency?.id}">${employeeCompetencyProfileInstance?.competency?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeCompetencyProfileInstance?.competencyRate}">
				<li class="fieldcontain">
					<span id="competencyRate-label" class="property-label"><g:message code="employeeCompetencyProfile.competencyRate.label" default="Competency Rate" /></span>
					
						<span class="property-value" aria-labelledby="competencyRate-label"><g:link controller="competencyRate" action="show" id="${employeeCompetencyProfileInstance?.competencyRate?.id}">${employeeCompetencyProfileInstance?.competencyRate?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${employeeCompetencyProfileInstance?.id}" />
					<g:link class="edit" action="edit" id="${employeeCompetencyProfileInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
