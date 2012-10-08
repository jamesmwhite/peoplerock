
<%@ page import="peoplerock.EmployeeProfile" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employeeProfile.label', default: 'EmployeeProfile')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-employeeProfile" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-employeeProfile" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list employeeProfile">
			
				<g:if test="${employeeProfileInstance?.employee}">
				<li class="fieldcontain">
					<span id="employee-label" class="property-label"><g:message code="employeeProfile.employee.label" default="Employee" /></span>
					
						<span class="property-value" aria-labelledby="employee-label"><g:link controller="employee" action="show" id="${employeeProfileInstance?.employee?.id}">${employeeProfileInstance?.employee?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeProfileInstance?.jobPosition}">
				<li class="fieldcontain">
					<span id="jobPosition-label" class="property-label"><g:message code="employeeProfile.jobPosition.label" default="Job Position" /></span>
					
						<span class="property-value" aria-labelledby="jobPosition-label"><g:link controller="jobPosition" action="show" id="${employeeProfileInstance?.jobPosition?.id}">${employeeProfileInstance?.jobPosition?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeProfileInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="employeeProfile.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate date="${employeeProfileInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeProfileInstance?.endDate}">
				<li class="fieldcontain">
					<span id="endDate-label" class="property-label"><g:message code="employeeProfile.endDate.label" default="End Date" /></span>
					
						<span class="property-value" aria-labelledby="endDate-label"><g:formatDate date="${employeeProfileInstance?.endDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeProfileInstance?.competencyProfile}">
				<li class="fieldcontain">
					<span id="competencyProfile-label" class="property-label"><g:message code="employeeProfile.competencyProfile.label" default="Competency Profile" /></span>
					
						<span class="property-value" aria-labelledby="competencyProfile-label"><g:link controller="employeeCompetencyProfile" action="show" id="${employeeProfileInstance?.competencyProfile?.id}">${employeeProfileInstance?.competencyProfile?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeProfileInstance?.careerTrack}">
				<li class="fieldcontain">
					<span id="careerTrack-label" class="property-label"><g:message code="employeeProfile.careerTrack.label" default="Career Track" /></span>
					
						<span class="property-value" aria-labelledby="careerTrack-label"><g:fieldValue bean="${employeeProfileInstance}" field="careerTrack"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeProfileInstance?.ladderRung}">
				<li class="fieldcontain">
					<span id="ladderRung-label" class="property-label"><g:message code="employeeProfile.ladderRung.label" default="Ladder Rung" /></span>
					
						<span class="property-value" aria-labelledby="ladderRung-label"><g:fieldValue bean="${employeeProfileInstance}" field="ladderRung"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${employeeProfileInstance?.id}" />
					<g:link class="edit" action="edit" id="${employeeProfileInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
