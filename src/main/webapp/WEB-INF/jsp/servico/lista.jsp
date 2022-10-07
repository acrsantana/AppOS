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
        <div class="row">
            <div class="col-10">
                <h1 class="display-4">Oficina Poster na Parede</h1>
                <p class="lead">Lista dos serviços que podem ser realizados na oficina.</p>
            </div>
            <div class="col-2">
                <a href="servico/cadastro" type="button" class="btn btn-primary m-5">Cadastrar</a>
            </div>
            <hr class="my-4">
        </div>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Tempo de Execução</th>
            <th>Valor</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="servico" items="${listagem}">
                <tr>
                    <td>${servico.id}</td>
                    <td>${servico.nomeServico}</td>
                    <td>${servico.tempoDeExecucao}</td>
                    <td>${servico.valor}</td>
                    <td><a href="/servico/${servico.id}/excluir">Excluir</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${not empty mensagem}">
        <div class="alert ${tipo} alert-dismissible fade show" role="alert">
                ${mensagem}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

</div>

</body>
</html>
