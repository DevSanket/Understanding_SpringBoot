<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
		<div class="container">
			<h1>Enter Todo Details</h1>
			<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-4">
			<form:label path="description" > Description</form:label>
			<form:input type="text" path="description" name="description" required="required" />
			<form:errors cssClass="text-warning" path="description" />
			</fieldset>
			
			<fieldset class="mb-4">
			<form:label path="targetDate" > Target Date </form:label>
			<form:input type="text" path="targetDate"  required="required" />
			<form:errors cssClass="text-warning" path="targetDate" />
			</fieldset>
			
			
			<form:input type="hidden" path="id"  />
			<form:input type="hidden" path="done"  />
			<input type="submit" class="btn btn-success" value="submit" />
			</form:form>
			<h1>${error}</h1>
		</div>
		<%@ include file="common/footer.jspf" %>
		<script type="text/javascript">
$('#targetDate').datepicker({
    format: 'yyyy-mm-dd',
    startDate: '-3d'
});
</script>
</body>
</html>