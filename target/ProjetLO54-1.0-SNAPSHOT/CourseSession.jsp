<%-- 
    Document   : CourseSession
    Created on : 4 déc. 2018, 10:27:24
    Author     : Toaxyx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sessions</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/one-page-wonder.min.css" rel="stylesheet">

    </head>


    <body>

        <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">Poudlard</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Inscription</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Cours</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Sessions</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <header class="masthead text-center text-white">
            <div class="masthead-content">
                <div class="container">
                    <h1 class="masthead-heading mb-0">Poudlard</h1>
                    <h2 class="masthead-subheading mb-0">Cours réservés aux élèves de Gryffondor</h2>
                </div>
            </div>
        </header>

        <section id="list_session">
            <div class="container_session">
                All Sessions <br> 
                <c:forEach var="session" items="${Sessions}">
                    Session ID: ${session.id} <br>
                    Session Start date: ${session.startDate} <br>
                    Session End date: ${session.endDate} <br>
                    Session max: ${session.max} <br>
                    Session location: ${session.location.city} <br>
                    Session Course: ${session.course.title} <br>

                    <form action="CourseSession" method="POST">

                        <table>
                            <tr>
                                <td> Lastname: </td>
                                <td><input type="text" name="lastname"></td>
                            </tr>
                            <tr>
                                <td> Firstname: </td>
                                <td><input type="text" name="firstname"></td>
                            </tr>
                            <tr>
                                <td> email: </td>
                                <td><input type="text" name="email"></td>
                            </tr>
                            <tr>
                                <td> Phone: </td>
                                <td><input type="text" name="phone"></td>
                            </tr>
                            <tr>
                                <td> Adress: </td>
                                <td><input type="text" name="address"></td>
                            </tr>
                            <tr>
                                <td> Session: </td>
                                <td><input type="text" name="session" value="${session.id}"></td>
                            </tr>
                        </table>

                        <input type="submit" name="addClient" value="Subscribe">
                    </form>

                    -------------------------------------<br>
                </c:forEach>
            </div>
        </section>

        <footer class="py-5 bg-black">
            <div class="container">
                <p class="m-0 text-center text-white small">Copyright &copy; Valentine Moniz, Esther Meyer</p>
            </div>
            <!-- /.container -->
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>
</html>