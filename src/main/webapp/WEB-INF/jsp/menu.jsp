<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Poster na parede</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <c:if test="${not empty usuario.nome}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/usuario">Usuario</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/ordemServico">Ordem de Serviço</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/solicitante">Solicitante</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/carro">Carro</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/moto">Moto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/caminhao">Caminhão</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/veiculo">Veículo</a>
                    </li>
                </c:if>
            </ul>
            <ul class="navbar-nav">
                <c:if test="${empty usuario.nome}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/usuario/cadastro">Cadastro</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                    </li>
                </c:if>
                <c:if test="${not empty usuario.nome}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout - ${usuario.nome}</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
