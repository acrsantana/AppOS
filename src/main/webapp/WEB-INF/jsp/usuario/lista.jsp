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
        <h1 class="display-4">Oficina Poster na Parede</h1>
        <p class="lead">Lista dos caminhões que estão atualmente sendo atendidos na oficina.</p>
        <hr class="my-4">
    </div>

    <table class="table table-striped mt-3">
        <thead>
        <tr>
            <th>Id</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Ano Fabricação</th>
            <th>Tipo</th>
            <th>Capacidade (Kg)</th>
            <th>Comprimento (M)</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="caminhao" items="${listagem}">
                <tr>
                    <td>${caminhao.id}</td>
                    <td>${caminhao.marca}</td>
                    <td>${caminhao.modelo}</td>
                    <td>${caminhao.anoFabricacao}</td>
                    <td>${caminhao.tipo}</td>
                    <td>${caminhao.capacidadeCarga}</td>
                    <td>${caminhao.comprimento}</td>
                    <td><a href="/caminhao/${caminhao.id}/excluir">Excluir</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
