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
    <form method="post" action="${pageContext.request.contextPath}/servico/cadastro">
        <div class="form-group">
            <label for="nomeServico">Nome do Serviço</label>
            <input type="text" class="form-control" name="nomeServico" id="nomeServico" placeholder="Digite o nome do serviço">
        </div>
        <div class="form-group">
            <label for="tempoDeExecucao">Tempo de Execução</label>
            <input type="text" class="form-control" name="tempoDeExecucao" id="tempoDeExecucao" placeholder="Tempo de execução">
        </div>
        <div class="form-group">
            <label for="valor">Valor</label>
            <input type="text" class="form-control" name="valor" id="valor" placeholder="Valor do serviço">
        </div>
        <button type="submit" class="btn btn-primary mt-3">Enviar</button>
    </form>
</div>
</body>
