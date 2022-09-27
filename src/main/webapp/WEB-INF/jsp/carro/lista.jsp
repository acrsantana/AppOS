<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="ISO-8859-1">
    <title>AppPedido</title>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>

<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container mt-3">

    <div class="jumbotron">
        <div class="row">
            <div class="col-10">
                <h1 class="display-4">Oficina Poster na Parede</h1>
                <p class="lead">Lista dos carros que estão atualmente sendo atendidos na oficina.</p>

            </div>
            <div class="col-2">
                <a href="carro/cadastro" type="button" class="btn btn-primary m-5">Cadastrar</a>
            </div>
            <hr class="my-4">
        </div>
    </div>

    <table class="table table-striped mt-3">
        <thead>
        <tr>
            <th>Id</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Ano Fabricação</th>
            <th>Tipo</th>
            <th>Ar Condicionado</th>
            <th>Portas</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="carro" items="${listagem}">
                <tr>
                    <td>${carro.id}</td>
                    <td>${carro.marca}</td>
                    <td>${carro.modelo}</td>
                    <td>${carro.anoFabricacao}</td>
                    <td>${carro.tipo}</td>

                    <c:choose>
                        <c:when test="${carro.arCondicionado}">
                            <td>Sim</td>
                        </c:when>
                        <c:otherwise>
                            <td>Não</td>
                        </c:otherwise>
                    </c:choose>

                    <td>${carro.portas}</td>
                    <td><a href="/carro/${carro.id}/excluir">Excluir</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
