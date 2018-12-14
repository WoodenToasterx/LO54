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
        <link type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"/>
        <!-- include the jQuery UI style sheet -->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <!-- include jQuery -->
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <!-- include jQuery UI -->
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <!-- Custom styles for this template -->
        <link href="css/one-page-wonder.css" rel="stylesheet">
        <script type="text/javascript">
            $(function () {
                $("#Datepicker1").datepicker({
                    numberOfMonths: 3
                });
            });

            function FunctionTest(x) {

                $("#sessionId").val(x);
                $('#addBookDialog').modal('show');

            }
            ;
        </script>
    </head>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
            <div class="container">
                <a class="navbar-brand" href="Course">Poudlard</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </nav>

        <header class="masthead text-center text-white">
            <div class="masthead-content">
                <div class="container">
                    <h1 class="masthead-heading mb-0">Poudlard</h1>
                    <h2 class="masthead-subheading mb-0">Ecole de sorcellerie</h2>
                </div>
            </div>
        </header>

        <div class="modal fade" id="addBookDialog" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="Course" method="POST">
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
                            </table>

                            <input type="hidden" name="sessionId" id="sessionId" value=""/>

                            <input class="btn btn-primary" type="submit" name="addClient" value="Subscribe">
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>



        <div class="container_session">
            <h1 style="text-align: center"> Liste des cours dispensés </h1> 


            <div class="container" >
                <div class="row" style="margin-bottom: 100px; margin-top: 100px">
                    <div class="col-sm">
                        <form action="Course" method="GET">
                            <label>Rechercher par nom de cours</label>
                            <input type="text" name="courseName" id="courseName" />
                            <input type="submit" name="FilterCourseName" value="Chercher" />
                        </form>
                    </div>
                    <div class="col-sm">
                        <form action="Course" method="GET">
                            <label>Rechercher par date de session</label>
                            <br/>
                            <input type="date" name="sessionDate" id="Datepicker1" />
                            <input type="submit" name="FilterSessionDate" value="Chercher" />
                        </form>
                    </div>
                    <div class="col-sm"> 
                        <form action="Course" method="GET">
                            <label>Rechercher par lieu d'un cours</label>
                            <select name="courseLocation">
                                <option value="--">--</option>
                                <c:forEach var="location" items="${locations}">
                                    <option value="${location.city}">${location.city}</option>
                                </c:forEach>
                            </select>
                            <input type="submit" name="FilterCourseLocation" value="Chercher" />
                        </form>
                    </div>
                </div>
            </div>

            <div class="container">
                <center>
                    <table class="table table-hover" id="dataTable"  cellspacing="0">
                        <thead>
                            <tr>
                        <th>Nom du cours</th>
                        <th>Sessions de cours</th>
                        <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cour" items="${items}">
                            <tr>
                                <c:forEach var="session" items="${cour.value}">
                                <tr>
                                    <td>
                                        ${cour.key.title}
                                    <td>
                                        Start date: ${session.startDate}<br>
                                        Session End date: ${session.endDate} <br>
                                        Location : ${session.location.city} <br/>
                                    <td>
                                <bouton class="coucou btn btn-primary" id="addEvent" data-id="${session.id}" data-toggle="modal" onclick="FunctionTest(${session.id})">Inscription</bouton>
                            </td>   
                            </td>
                                </td>
                                </tr>
                            </c:forEach>
                            </tr>
                        </c:forEach>
                            </tbody>
                    </table>
                </center>
            </div>

        </div>


            <center>
                <a class="page-link" onclick="location.href = 'Course'"> Revenir à la page d'accueil </a>
                
            </center>
        


        <footer class="py-5 bg-black">
            <div class="container">
                <p class="m-0 text-center text-white small">Copyright &copy; Valentine Moniz, Esther Meyer</p>
            </div>
        </footer>

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>
</html>
