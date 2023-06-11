<%-- 
    Document   : add
    Created on : Jun 2, 2023, 9:31:18 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body>
        <form action="add" method="POST">
            Name: <input type="text" name="name"/>
            <br>
            Gender: <input type="radio" id="radio1" name="radio_option" value="true" >
                    <label for="radio1">Male</label>
                    <input type="radio" id="radio2" name="radio_option" value="false" >
                    <label for="radio2">Female</label>                    
            <br>
            DOB: <input type="text" name="dob"/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </body>
</html>
