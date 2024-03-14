<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>
<html>
    <head>
        <title>Form</title>
        <link rel="stylesheet" href="styles/styles.css">
    </head>
    <body>
            <div align="center">
                <a href="./"><input type="submit" value="Go to Home"/></a>
            </div><br>
        <div align="center">
        <frm:form action="save" modelAttribute="employee">
            <table style="background-color:#FFFFE0;" id="frmtable">
                <h3>Employee Registration</h3>
                <tr>
                    <td>
                        <label>Name:<label><span>*</span>
                    </td>
                    <td>
                        <frm:input path="name"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Designation:<label><span>*</span>
                    </td>
                    <td>
                        <frm:input path="designation"/>
                    </td>
                </tr>

                 <tr>
                     <td>
                         <label>Department Number:<label><span>*</span>
                     </td>
                     <td>
                          <frm:input path="deptNo"/>
                     </td>
                 </tr>
                <tr>
                    <td>
                        <label>Salary:<label><span>*</span>
                    </td>

                    <td>
                        <frm:input path="salary"/>
                    </td>
                </tr>
                <tr>
                    <td>
                    </td>
                    <td align="center">
                        <input type="submit" value="Register"/>
                        <input type="reset" value="Cancel"/>
                    </td>
                </tr>
            </table>
        </frm:form>
        </div>
    </body>
</html>