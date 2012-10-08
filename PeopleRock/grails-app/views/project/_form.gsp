<%@ page import="peoplerock.Project" %>



<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'projectName', 'error')} required">
	<label for="projectName">
		<g:message code="project.projectName.label" default="Project Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="projectName" required="" value="${projectInstance?.projectName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'platform', 'error')} required">
	<label for="platform">
		<g:message code="project.platform.label" default="Platform" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="platform" name="platform.id" from="${peoplerock.Platform.list()}" optionKey="id" required="" value="${projectInstance?.platform?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="project.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${peoplerock.Employee.list()}" optionKey="id" required="" value="${projectInstance?.owner?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="project.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${projectInstance?.startDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'endByDate', 'error')} required">
	<label for="endByDate">
		<g:message code="project.endByDate.label" default="End By Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="endByDate" precision="day"  value="${projectInstance?.endByDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'finishDate', 'error')} required">
	<label for="finishDate">
		<g:message code="project.finishDate.label" default="Finish Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="finishDate" precision="day"  value="${projectInstance?.finishDate}"  />
</div>

