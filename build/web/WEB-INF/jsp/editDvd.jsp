<%-- 
    Document   : editDvd
    Created on : Mar 15, 2013, 8:05:13 PM
    Author     : wouter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="domain.*" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
                 <link href="bootstrap/img/favicon.ico" rel="shortcut icon" type="image/x-icon" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css" />
        <title><spring:message code="dvd.change"/></title>
    </head>
    <body>


        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a class="brand" href="index.htm">DvdManager</a>
                    <div class="nav-collapse collapse">

                        <ul class="nav">
                            <li><a href="Dvdoverzicht.htm"><spring:message code="dvd.titel"/><i class="icon-align-justify icon-white"></i></a></li>

                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div id ="container" class="well">
            <h1><spring:message code="dvd.change"/></h1>                
            <form:form action="editDvd.htm" commandName="dvd">
                <div id="errorMessage">
                    <form:errors path="*" cssClass="error"/>
                </div>

                <table>	
                    <tr>
                        <td><label for="name" ><spring:message code="name"/>: </label></td>
                        <td><form:input path="naam"  value="${dvd.naam}"/></td>
                    </tr>
                    <tr>
                        <td><label for="name" ><spring:message code="regisseur"/>: </label></td>
                        <td><form:input path="regisseur"  value="${dvd.regisseur}"/></td>
                    </tr>
                    <tr>
                        <td><label for="name" ><spring:message code="rating"/>: </label></td>
                        <td><form:input path="rating"  value="${dvd.rating}"/></td>
                    </tr>
                    <tr>
                        <td><label for="name" ><spring:message code="speelduur"/>: </label></td>
                        <td><form:input path="speelduur" value="${dvd.speelduur}" /></td>
                    </tr>


                    <tr>
                        <td></td><td><input class="btn btn-primary"type="submit" value="edit" />
                            <input type="hidden" name="id"value="${dvd.id}"/>

                            <a href="Dvdoverzicht.htm" class="btn btn-inverse">cancel</a></td>
                    </tr>


                </table>	

            </form:form>


        </div>
    </body>
</html>
