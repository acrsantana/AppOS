<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <p class="lead">Lista dos serviços contratados na oficina.</p>
        <hr class="my-4">
    </div>

    <table class="table table-striped mt-3">
        <thead>
        <tr>
            <th>Id</th>
            <th>Mecânico</th>
            <th>Data</th>
            <th>Garantia</th>
            <th>Solicitante</th>
            <th>Veículo</th>
            <th>Serviços</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="os" items="${listagem}">
                <tr>
                    <td>${os.id}</td>
                    <td>${os.mecanico}</td>
                    <td>${os.data}</td>
                    <c:choose>
                        <c:when test="${os.garantia}">
                            <td>Sim</td>
                        </c:when>
                        <c:otherwise>
                            <td>Não</td>
                        </c:otherwise>
                    </c:choose>
                    <td>${os.solicitante.nome}</td>
                    <td>${os.veiculo.modelo}</td>
                    <td>${os.servicos}</td>
                    <td><a href="/ordemServico/${os.id}/excluir">Excluir</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
