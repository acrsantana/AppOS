<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <form class="bg-light p-5 mt-3" method="post" action="${pageContext.request.contextPath}/carro/cadastro">
        <h3>Cadastro de carros</h3>
        <div class="row">
            <div class="col">
                <div class="form-group mt-3">
                    <label for="marca">Marca</label>
                    <input type="text" class="form-control" name="marca" id="marca" placeholder="Marca do carro">
                </div>
            </div>
            <div class="col">
                <div class="form-group mt-3">
                    <label for="modelo">Modelo</label>
                    <input type="text" class="form-control" name="modelo" id="modelo" placeholder="Modelo do carro">
                </div>
            </div>
            <div class="col">
                <div class="form-group mt-3">
                    <label for="anoFabricacao">Ano Fabricação</label>
                    <input type="text" class="form-control" name="anoFabricacao" id="anoFabricacao" placeholder="Ano de fabricação">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group mt-3">
                    <label for="tipo">Tipo</label>
                    <input type="text" class="form-control" name="tipo" id="tipo" placeholder="Tipo de carro">
                </div>
            </div>
            <div class="col">
                <div class="form-group mt-3">
                    <label for="arCondicionado">Ar Condicionado</label>
                        <select class="form-control" name="arCondicionado" id="arCondicionado">
                            <option value="true">Sim</option>
                            <option value="false">Não</option>
                        </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group mt-3">
                    <label for="portas">Portas</label>
                    <input type="text" class="form-control" name="portas" id="portas" placeholder="portas">
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary mt-3">Enviar</button>
    </form>
</div>
</body>
