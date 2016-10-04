<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home</title>
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.0.js"/>"></script>
    <link href="<c:url value="/resources/css/common.css"/>" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<c:url value="/resources/js/home.js"/>"></script>
	</head>
	<body>
    	<div class="header">
        	<span><img id="user_photo" width="50" height="50"/></span>
            <span id="user_welcome">Welcome Visitor</span>
            <span id="user_logout">[ LOGOUT ]</span>
        </div>
        <form:form>
		<table class="block">
        	<tr>
            	<th colspan="2">Login</th>
            </tr>
        	<tr>
            	<td>Username</td>
                <td><input type="text"></td>
            </tr>
            <tr>
            	<td>Password</td>
                <td><input type="password"></td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
                	<input type="reset" value="Reset">
                    <input type="submit" value="Login Now!">
                </td>
            </tr>
        </table>
        </form:form>
        
        
        <form:form commandName="user" method="post" id="registration">
        <table class="block">
        	<tr>
            	<th colspan="2">Registration</th>
            </tr>
            <tr>
            	<td colspan="2" style="text-align: right;">***All fields are mandatory</td>
            </tr>
        	<tr>
            	<td><form:label path="name">Full Name</form:label></td>
                <td>
                	<form:input path="name" type="text" id="name"/>
                </td>
            </tr>
            <tr>
            	<td><form:label path="dob">Date of Birth</form:label></td>
                <td>
                	<form:input path="dob" type="date" id="dob"/>
                </td>
            </tr>
            <tr>
            	<td>Your Age</td>
            	<td id="showage">First select your DOB</td>
            </tr>
            <tr>
            	<td>
            		<form:label path="gender">Gender</form:label>
            	</td>
                <td>
                	<form:radiobuttons path="gender" items="${genderList}" itemLabel="name" itemValue="id"/>
                </td>
            </tr>
            <tr>
            	<td>Country</td>
                <td>
                 	<select id="country">
                 		<option value="-1">--SELECT--</option>
                		<c:forEach var="country" items="${countryList}">
                			<option value="${country.id}">${country.name}</option> 
                		</c:forEach>
                 	</select>
                </td>
            </tr>
            <tr>
            	<td>State</td>
                <td>
	                <select id="state">
	                	<option value="-1">None</option>
	                </select>
                </td>
            </tr>
            <tr>
            	<td><form:label path="city">City</form:label></td>
                <td>
                	<form:select path="city" id="city">
                		<form:option value="-1">None</form:option>
                	</form:select>
                </td>
            </tr>
            <tr>
            	<td>Passport Photo</td>
                <td>
                	<form:input path="photo" id="photoupload" type="file" name="photoupload"/>
                </td>
            </tr>
            <tr>
            	<td>Selected Photo</td>
           	  <td>
                	<img height="50" width="50" id="photopreview"/>
                </td>
            </tr>
            <tr>
            	<td>
            		<form:label path="username">Username</form:label>
            	</td>
                <td>
                	<form:input path="username" type="text" id="username"/>
                </td>
            </tr>
            <tr>
            	<td>
            		<form:label path="password">Password</form:label>
				</td>
                <td>
                	<form:input path="password" type="text" id="pass1" class="password"/>
                </td>
            </tr>
            <tr>
            	<td>
            		Password Verify
				</td>
                <td>
                	<input type="text" id="pass2" class="password"/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
                	<input type="reset" value="Reset">
                    <input type="button" id="submit" value="Register Now!">
                </td>
            </tr>
        </table>
        </form:form>
	</body>
</html>
