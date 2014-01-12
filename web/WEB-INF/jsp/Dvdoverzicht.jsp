<%-- 
    Document   : Dvdoverzicht
    Created on : Mar 12, 2013, 2:55:08 PM
    Author     : wouter
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="domain.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css" />
        <title><spring:message code="dvd.titel"/></title>
        <link href="bootstrap/img/favicon.ico" rel="shortcut icon" type="image/x-icon" />

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
                        <p class="navbar-text pull-right">
                           
                          
                        </p>
                        <ul class="nav">
                            <li><a href="NewDvd.htm"><spring:message code="dvd.new"/><i class="icon-plus icon-white"></i></a></li>

                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <div id="container" class="well">
            <h1><spring:message code="dvd.titel"/></h1>

            <table class= "table table-striped">
                <tr>
                    <td><spring:message code="name"/></td>
                    <td><spring:message code="regisseur"/></td>
                    <td><spring:message code="rating"/></td>
                    <td><spring:message code="speelduur"/></td>
                    <td><spring:message code="wijzig"/></td>
                    <td><spring:message code="verwijder"/></td>
                </tr>

                <c:forEach var="dvd" items="${dvds}">
                    <tr>
                        <td><a href="acteurOverzicht.htm?id=${dvd.id}" title="klik hier om de acteurs te zien">${dvd.naam}</a></td>
                        <td>${dvd.regisseur}</td>
                        <td>${dvd.rating}</td>
                        <td>${dvd.speelduur}</td>
                        <td><a href="editFormDvd.htm?id=${dvd.id}" title="wijzig de dvd"><i class="icon-pencil"></i></a></td>
                        <td><a href="RemoveDvd.htm?id=${dvd.id}" title="verwijder de dvd"><i class="icon-remove"></i></a></td>
                    </tr>
                </c:forEach>

        </div>

    </body>

</html>
