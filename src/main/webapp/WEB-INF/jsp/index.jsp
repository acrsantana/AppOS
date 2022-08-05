<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
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
    <p>Clique na classe para obter uma breve descrição</p>

    <div class="row">
        <div class="col bg-primary border border-white">
            <button type="button" class="btn btn-block btn-primary w-100" data-toggle="collapse" href="#ordemDeServico" aria-expanded="false" aria-controls="collapseExample">
                Ordem de Serviço
            </button>
        </div>

        <div class="col bg-primary border border-white">
            <button type="button" class="btn btn-primary btn-block w-100" data-toggle="collapse" href="#solicitante" aria-expanded="false" aria-controls="collapseExample">
                Solicitante
            </button>
        </div>
        <div class="col bg-primary border border-white">
            <button type="button" class="btn btn-primary btn-block w-100" data-toggle="collapse" href="#veiculo" aria-expanded="false" aria-controls="collapseExample">
                Veículo
            </button>
        </div>
        <div class="col bg-primary border border-white">
            <button type="button" class="btn btn-primary btn-block w-100" data-toggle="collapse" href="#carro" aria-expanded="false" aria-controls="collapseExample">
                Carro
            </button>
        </div>
        <div class="col bg-primary border border-white">
            <button type="button" class="btn btn-primary btn-block w-100" data-toggle="collapse" href="#moto" aria-expanded="false" aria-controls="collapseExample">
                Moto
            </button>
        </div>
        <div class="col bg-primary border border-white">
            <button type="button" class="btn btn-primary btn-block w-100" data-toggle="collapse" href="#caminhao" aria-expanded="false" aria-controls="collapseExample">
                Caminhão
            </button>
        </div>
    </div>

    <div class="container mt-3">
    <div class="collapse mt-3" id="ordemDeServico">
        <div class="card card-body">
            <h5>Classe: OrdemServico</h5>
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
    </div>

    <div class="collapse mt-3" id="solicitante">
        <div class="card card-body">
            <h5>Classe: Solicitante</h5>
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
                    <td>nome</td>
                    <td>String</td>
                    <td>Nome do cliente que contratou o serviço</td>
                </tr>
                <tr>
                    <td>telefone</td>
                    <td>String</td>
                    <td>Telefone de contato do solicitante</td>
                </tr>
                <tr>
                    <td>vip</td>
                    <td>boolean</td>
                    <td>Indica se o solicitante é um cliente vip</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="collapse mt-3" id="veiculo">
        <div class="card card-body">
            <h5>Classe: Veiculo</h5>
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
                    <td>marca</td>
                    <td>String</td>
                    <td>Marca do veículo deixado para realização do serviço</td>
                </tr>
                <tr>
                    <td>modelo</td>
                    <td>String</td>
                    <td>Modelo do veículo deixado para realização do serviço</td>
                </tr>
                <tr>
                    <td>anoFabricacao</td>
                    <td>int</td>
                    <td>Ano de fabricação do veículo</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="collapse mt-3" id="carro">
        <div class="card card-body">
            <h5>Classe: Carro</h5>
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
                    <td>tipo</td>
                    <td>String</td>
                    <td>Indica se o carro é hatch, sedan, coupe, suv, etc</td>
                </tr>
                <tr>
                    <td>arCondicionado</td>
                    <td>boolean</td>
                    <td>Indica se o carro possui ar condicionado</td>
                </tr>
                <tr>
                    <td>portas</td>
                    <td>int</td>
                    <td>Indica a quantidade de portas do carro</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="collapse mt-3" id="moto">
        <div class="card card-body">
            <h5>Classe: Moto</h5>
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
                    <td>cilindrada</td>
                    <td>int</td>
                    <td>Indica a potencia da moto</td>
                </tr>
                <tr>
                    <td>modelo</td>
                    <td>String</td>
                    <td>Indica o modelo da moto, scooter, café racer, naked, etc</td>
                </tr>
                <tr>
                    <td>quantidadeDePassageiros</td>
                    <td>int</td>
                    <td>Capacidade total de passageiros da moto</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="collapse mt-3" id="caminhao">
        <div class="card card-body">
            <h5>Classe: Caminhao</h5>
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
                    <td>tipo</td>
                    <td>String</td>
                    <td>Indica o tipo do caminhão como Vuc, Truck, Bitrem, Carreta...</td>
                </tr>
                <tr>
                    <td>capacidadeCarga</td>
                    <td>float</td>
                    <td>Indica a capacidade total de carga do caminhão</td>
                </tr>
                <tr>
                    <td>comprimento</td>
                    <td>float</td>
                    <td>Indica o comprimento total do caminhão</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    </div>

</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
