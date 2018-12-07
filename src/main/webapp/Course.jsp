<%-- 
    Document   : Course
    Created on : 4 déc. 2018, 08:34:38
    Author     : Toaxyx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cours</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/one-page-wonder.min.css" rel="stylesheet">

    </head>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">Poudlard</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
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

        <section id="list_courses">
            <div class="container_session">
                All Courses <br> 
                <c:forEach var="cour" items="${courses}">
                    Course ID: ${cour.id} <br>
                    Course Name: ${cour.title} <br>
                    -------------------------------------<br>
                </c:forEach>
                ------------------------------------------------
            </div>
        </section>

        <section id="add-course" style="align-content: center; text-align: center">
            <div class="container_session" >
                <h1> Add Course </h1>
                <form action="Course" method="POST">
                    <table>
                        <tr>
                            <td> Course Name: </td>
                            <td><input type="text" name="courseTitle"></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" name="addCourse" value="Add">
                            </td>
                        </tr>
                    </table>
                </form>
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
