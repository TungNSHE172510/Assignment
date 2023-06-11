<%-- 
    Document   : update
    Created on : Jun 2, 2023, 9:31:59 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student</title>
    </head>
    <body>
        <form action="update" method="POST">
            ID: <input type="text" name="id" value="${student.id}"/>
            <br>
            Name: <input type="text" name="name" value="${student.name}"/>
            <br>
            Gender: <input type="radio" id="radio1" name="radio_option" value="${student.gender}" >
                    <label for="radio1">Male</label>
                    <input type="radio" id="radio2" name="radio_option" value="${student.gender}" >
                    <label for="radio2">Female</label>                    
            <br>
            DOB: <input type="text" name="dob" value="${student.dob}"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </body>
</html>
