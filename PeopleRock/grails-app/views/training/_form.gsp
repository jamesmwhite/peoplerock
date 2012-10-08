<%@ page import="peoplerock.Training" %>



<div class="fieldcontain ${hasErrors(bean: trainingInstance, field: 'courseName', 'error')} required">
	<label for="courseName">
		<g:message code="training.courseName.label" default="Course Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="courseName" required="" value="${trainingInstance?.courseName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: trainingInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="training.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${trainingInstance?.startDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: trainingInstance, field: 'finishDate', 'error')} required">
	<label for="finishDate">
		<g:message code="training.finishDate.label" default="Finish Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="finishDate" precision="day"  value="${trainingInstance?.finishDate}"  />
</div>

