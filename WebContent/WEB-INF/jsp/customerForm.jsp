<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
    <h1><spring:message code="label.addcontact"/></h1>
    <form:form method="post" action="add" modelAttribute="customer">
    <table>
        <tr>
        	<td><form:errors path="firstName" cssClass="error"/></td>
            <td><form:label path="firstName"><spring:message code="label.firstName"/></form:label></td>
            <td><form:input path="firstName" /> </td>
        </tr>
        <tr>
        	<td><form:errors path="lastName" cssClass="error"/></td>
            <td><form:label path="lastName"><spring:message code="label.lastName"/></form:label></td>
            <td><form:input path="lastName" /> </td>
        </tr>
        <tr>
        	<td><form:errors path="age" cssClass="error"/></td>
            <td><form:label path="age"><spring:message code="label.age"/></form:label></td>
            <td><form:input path="age" /> </td>
        </tr>
        <tr>
        	<td><form:errors path="email" cssClass="error"/></td>
            <td><form:label path="email"><spring:message code="label.email"/></form:label>
            <td><form:input path="email" /> </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="<spring:message code="label.addcontact"/>" />
            </td>
        </tr>
    </table>
    </form:form>
Handling time: <c:out value="${handlingTime}"/>    
</body>
</html>