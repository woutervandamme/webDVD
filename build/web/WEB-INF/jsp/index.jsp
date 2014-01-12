<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Dvd manager Home</title>
         <link href="bootstrap/img/favicon.ico" rel="shortcut icon" type="image/x-icon" />

        <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                       
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div id="container" class="well">
            <h1>Dvd Manager</h1>
            <p><spring:message code="intro"/></p>
            <a href="Dvdoverzicht.htm" class="btn btn-info"><spring:message code="dvd.titel"/></a>
            <h2><spring:message code="taal"/></h2>
            <a href="?lang=en" class="btn btn-info">en</a>
            <a href="?lang=nl" class="btn btn-info">nl</a>


            <h2><spring:message code="thema"/></h2>
            <a href="?theme=default" class="btn btn-inverse"><spring:message code="thema.grijs"/></a> 
            <a href="?theme=metro" class="btn btn-inverse">metro</a> 
            <a href="?theme=andia" class="btn btn-inverse">simple</a> 


        </div>
            
    </body>        

</html>
