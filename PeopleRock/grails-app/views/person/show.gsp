
<%@ page import="peoplerock.Person" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-person" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list person">
			
				<g:if test="${personInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="person.firstName.label" default="First Name" /></span>
					
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${personInstance}" field="firstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="person.lastName.label" default="Last Name" /></span>
					
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${personInstance}" field="lastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.nickName}">
				<li class="fieldcontain">
					<span id="nickName-label" class="property-label"><g:message code="person.nickName.label" default="Nick Name" /></span>
					
						<span class="property-value" aria-labelledby="nickName-label"><g:fieldValue bean="${personInstance}" field="nickName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.competencies}">
				<li class="fieldcontain">
					<span id="competencies-label" class="property-label"><g:message code="person.competencies.label" default="Competencies" /></span>
					
						<g:each in="${personInstance.competencies}" var="c">
						<span class="property-value" aria-labelledby="competencies-label"><g:link controller="personCompetency" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.skills}">
				<li class="fieldcontain">
					<span id="skills-label" class="property-label"><g:message code="person.skills.label" default="Skills" /></span>
					
						<g:each in="${personInstance.skills}" var="s">
						<span class="property-value" aria-labelledby="skills-label"><g:link controller="skill" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.trainingcourses}">
				<li class="fieldcontain">
					<span id="trainingcourses-label" class="property-label"><g:message code="person.trainingcourses.label" default="Trainingcourses" /></span>
					
						<g:each in="${personInstance.trainingcourses}" var="t">
						<span class="property-value" aria-labelledby="trainingcourses-label"><g:link controller="training" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${personInstance?.id}" />
					<g:link class="edit" action="edit" id="${personInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
