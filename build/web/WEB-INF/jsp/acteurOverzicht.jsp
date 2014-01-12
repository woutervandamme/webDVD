<%-- 
    Document   : Dvdoverzicht
    Created on : Mar 12, 2013, 2:55:08 PM
    Author     : wouter
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="domain.*" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
                 <link href="bootstrap/img/favicon.ico" rel="shortcut icon" type="image/x-icon" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css" />
        <title><spring:message code="acteur.titel"/></title>
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
                                <li><a href="NewActeur.htm?id=${dvd.id}"><spring:message code="acteur.add"/><i class="icon-plus icon-white"></i></a></li>
                                <li><a href="Dvdoverzicht.htm"><spring:message code="dvd.titel"/><i class="icon-align-justify icon-white"></i></a></li>

                            </ul>
                        </div><!--/.nav-collapse -->
                    </div>
                </div>
            </div>

        <div id="container"  class="well">




            <table class= "table table-striped">
                <tr>

                    <td><spring:message code="name"/></td>
                    <td><spring:message code="wijzig"/></td>
                    <td><spring:message code="verwijder"/></td>
                </tr>

                <c:forEach var="acteur" items="${acteurs}">
                    <tr>
                        <td>${acteur.naam}</td>                  
                        <td><a href="editFormActeur.htm?id=${acteur.id}"<i class="icon-pencil"></i></a></td>
                        <td><a href="RemoveActeur.htm?id=${acteur.id}"><i class="icon-remove"></i></a></td>
                    </tr>
                </c:forEach>
        </div>


        <h2><spring:message code="name.film"/>: ${dvd.naam}</h2>

    </body>
</html>
