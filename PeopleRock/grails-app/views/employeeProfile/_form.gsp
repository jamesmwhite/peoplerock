<%@ page import="peoplerock.EmployeeProfile" %>



<div class="fieldcontain ${hasErrors(bean: employeeProfileInstance, field: 'employee', 'error')} required">
	<label for="employee">
		<g:message code="employeeProfile.employee.label" default="Employee" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="employee" name="employee.id" from="${peoplerock.Employee.list()}" optionKey="id" required="" value="${employeeProfileInstance?.employee?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeProfileInstance, field: 'jobPosition', 'error')} required">
	<label for="jobPosition">
		<g:message code="employeeProfile.jobPosition.label" default="Job Position" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="jobPosition" name="jobPosition.id" from="${peoplerock.JobPosition.list()}" optionKey="id" required="" value="${employeeProfileInstance?.jobPosition?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeProfileInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="employeeProfile.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${employeeProfileInstance?.startDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: employeeProfileInstance, field: 'endDate', 'error')} required">
	<label for="endDate">
		<g:message code="employeeProfile.endDate.label" default="End Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="endDate" precision="day"  value="${employeeProfileInstance?.endDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: employeeProfileInstance, field: 'competencyProfile', 'error')} required">
	<label for="competencyProfile">
		<g:message code="employeeProfile.competencyProfile.label" default="Competency Profile" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="competencyProfile" name="competencyProfile.id" from="${peoplerock.EmployeeCompetencyProfile.list()}" optionKey="id" required="" value="${employeeProfileInstance?.competencyProfile?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeProfileInstance, field: 'careerTrack', 'error')} ">
	<label for="careerTrack">
		<g:message code="employeeProfile.careerTrack.label" default="Career Track" />
		
	</label>
	<g:textField name="careerTrack" value="${employeeProfileInstance?.careerTrack}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeProfileInstance, field: 'ladderRung', 'error')} required">
	<label for="ladderRung">
		<g:message code="employeeProfile.ladderRung.label" default="Ladder Rung" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ladderRung" type="number" value="${employeeProfileInstance.ladderRung}" required=""/>
</div>

