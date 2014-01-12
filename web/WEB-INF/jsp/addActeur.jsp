<%-- 
    Document   : addDvd
    Created on : Mar 13, 2013, 4:12:38 PM
    Author     : wouter
--%>

<%@page import="domain.Acteur"%>
<%@page import="domain.Dvd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
                 <link href="bootstrap/img/favicon.ico" rel="shortcut icon" type="image/x-icon" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css" />
        <title><spring:message code="acteur.add"/></title>
    </head>
    <body>


        <div id="container" class="well">

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
            <h1><spring:message code="name.film"/>: ${dvd.naam}</h1>

            <div class='addActeur well'>

                <form:form action="AddActeur.htm" commandName="acteur"  modelAttribute="acteur" method="POST">
                    <div id="errorMessage">
                        <form:errors path="*" cssClass="error"/>
                    </div>
                    <h2><spring:message code="addActeur.new"/></h2>
                    <table>	
                        <tr>
                            <td><label for="naam" ><spring:message code="name"/>: </label></td>
                            <td><form:input path="naam" /></td>
                        <input type="hidden" name="movieId"value="${dvd.id}"/>
                        </tr>
                        <tr>
                            <td><input class="btn btn-primary"type="submit" value="Add Acteur" />
                                <a href="acteurOverzicht.htm?id=${dvd.id}" class="btn btn-inverse">cancel</a>
                            </td>
                        </tr>
                    </table>

                </form:form>
            </div>
            <div class='addActeur well'>
                <form:form action="AddExistingActeur.htm" commandName="acteur"  modelAttribute="acteur" method="POST"> 
                    <h2><spring:message code="addActeur.existing"/></h2>
                     <div id="errorMessage">
                    </div>
                    <table>
                        <tr> <td><label for="naam"><spring:message code="name"/>: </label></td>
                            <td>
                                <form:select path="naam">
                                    <form:options items="${acteurs}" itemValue="naam" itemLabel="naam" />
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td><input class="btn btn-primary"type="submit" value="Add Acteur" />
                                <a href="acteurOverzicht.htm?id=${dvd.id}" class="btn btn-inverse">cancel</a>
                                <input type="hidden" name="movieId"value="${dvd.id}"/></td>
                        </tr>
                    </table>
                </form:form>
            </div>
        </div>
    </body>
</html>
