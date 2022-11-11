<%@ taglib prefix="section"
           uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<html>

<body>

<h3>Meeting View</h3>
<br><br>

<%--onclick send to URL  'href'--%>
<%--add function that hide FIELD of code from User if his Role not 'hasRole'--%>
<section:authorize access="hasRole('HR')">
    <input type="button" value="Salary"
           onclick="window.location.href='hr_info'">
    Only for HR staff
</section:authorize>

<br><br>
<%--onclick send to URL  'href'--%>
<%--add function that hide FIELD of code from User if his Role not 'hasRole'--%>
<section:authorize access="hasRole('MANAGER')">
    <input type="button" value="Performance"
           onclick="window.location.href='manager_info'">
    Only for Managers staff
</section:authorize>


</body>
</html>
