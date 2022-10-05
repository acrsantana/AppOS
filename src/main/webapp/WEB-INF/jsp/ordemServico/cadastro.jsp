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
    <form class="bg-light p-5 mt-3" method="post" action="${pageContext.request.contextPath}/ordemServico/cadastro">
        <h3>Ordem de Serviço</h3>
        <div class="row">
            <div class="col">
                <div class="form-group mt-3">
                    <label for="mecanico">Mecânico</label>
                    <input type="text" class="form-control" name="mecanico" id="mecanico" placeholder="Nome do mecânico">
                </div>
            </div>
            <div class="col">
                <div class="form-group mt-3">
                    <label for="solicitante">Solicitante</label>
                    <select class="form-control" name="solicitante" id="solicitante">
                        <c:forEach var="solicitante" items="${solicitantes}">
                            <option value="${solicitante}">${solicitante.nome}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group mt-3">
                    <label for="veiculo">Veículo</label>
                    <select class="form-control" name="veiculo" id="veiculo">
                        <c:forEach var="veiculo" items="${veiculos}">
                            <option value="${veiculo}">${veiculo.marca} ${veiculo.modelo}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="col">
                <div class="form-group mt-3">
                    <label for="exampleFormControlSelect2">Serviços</label>
                    <select multiple class="form-control" id="exampleFormControlSelect2" name="servicos">
                        <c:forEach var="servico" items="${listaServicos}">
                            <option value="${servico}">${servico.nomeServico}</option>
                        </c:forEach>
                    </select>
                </div>
<%--                <div class="form-group mt-3">--%>
<%--                    <label for="servicos">Serviços</label>--%>
<%--                    <input type="text" class="form-control" name="servicos" id="servicos" placeholder="Serviços">--%>
<%--                </div>--%>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-check mt-3">
                    <input class="form-check-input" type="checkbox" value="true" name="garantia"/>
                    <input class="form-check-input" type="checkbox" hidden value="false" name="garantia"/>
                    <label class="form-check-label">Garantia</label>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary mt-3">Enviar</button>
    </form>
</div>
</body>
