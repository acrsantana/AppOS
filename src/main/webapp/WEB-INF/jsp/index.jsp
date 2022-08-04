<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="ISO-8859-1">
    <title>AppPedido</title>
</head>
<body>
<div class="container mt-3">
    <h2>Oficina Poster na Parede</h2>
    <p>Imagine a cena bebê</p>

    <h3>Classe: Pedido</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Atributo</th>
            <th>Tipo</th>
            <th>Descrição</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>descricao</td>
            <td>String</td>
            <td>Descriçãoo do serviço a ser realizado no veículo</td>
        </tr>
        <tr>
            <td>data</td>
            <td>LocalDateTime</td>
            <td>Data de entrega do veículo para realização do serviço</td>
        </tr>
        <tr>
            <td>garantia</td>
            <td>boolean</td>
            <td>Indica se o veículo se encontra na garantia</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
