<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>
<html>
    <head>
        <title>Employees</title>
        <link rel="stylesheet" href="styles/styles.css">
    </head>
    <body>
        <div align="center">
            <a href="./"><input type="submit" value="Go to Home"/></a>
            &nbsp;&nbsp;
            <a href="add"><input type="submit" value="Add Employee"/></a>
        </div>
        <br>
        <div align="center">
            <c:choose>
                <c:when test="${!empty empList}">
                <h2><u>Employees Details</u></h2>
                <table id="dtlstable" border="1" style="background-color:#FFFFE0;">

                    <tr style="background-color:#BDB76B">
                        <th>ID</th>
                        <th>Name</th>
                        <th>Designation</th>
                        <th>Department No.</th>
                        <th>Salary</th>

                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                <c:forEach var="emp" items="${empList}">
                    <tr>
                        <td>${emp.id}</td>
                        <td>${emp.name}</td>
                        <td>${emp.designation}</td>
                        <td>${emp.deptNo}</td>
                        <td>${emp.salary}</td>

                        <td>
                            <a href="updateForm?idNo=${emp.id}"><img src="images/updateIcon.png" width="40px" height="30px"></a>
                        </td>
                        <td>
                            <a href="delete?idNo=${emp.id}" onclick="return confirm('Deleting the employee with ID ${emp.id}. Are you sure?')"><img src="images/deleteIcon.png" width="40px" height="30px"></a>
                        </td>
                    </tr>
                </c:forEach>
                </table>
                </c:when>
                <c:otherwise>
                    <h2>No Employees found.</h2>
                </c:otherwise>
            </c:choose>
            <h2 style="color:green">${message}</h2>
            <h3>Total No. of Employees: ${empCount}<h3>
        </div>
    </body>
</html>