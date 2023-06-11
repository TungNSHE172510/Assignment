<%-- 
    Document   : list
    Created on : Jun 2, 2023, 9:31:47 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Student</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>DOB</th>    
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="stu" items="${list}">
                    <tr>
                    <td>${stu.id}</td>
                    <td>${stu.name}</td>
                    <td>
                        <c:if test="${stu.gender==true}">Male</c:if>
                        <c:if test="${stu.gender==false}">Female</c:if>
                    </td>
                    <td>${stu.dob}</td>
                    <td>
                        <form action="update" method="GET" style="float: left;">
                            <input type="hidden" name="id" value="${stu.id}"/>
                            <input type="submit" value="Update">
                        </form>
                        <form action="delete" method="POST" style="float: left;">
                            <input type="hidden" name="id" value="${stu.id}"/>
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
                </c:forEach>
            
            </tbody>
        </table>
        <a href="add">Create<a/>
    </body>
</html>
