<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
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

    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="/">
            <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-tools" viewBox="0 0 16 16">
                <path d="M1 0 0 1l2.2 3.081a1 1 0 0 0 .815.419h.07a1 1 0 0 1 .708.293l2.675 2.675-2.617 2.654A3.003 3.003 0 0 0 0 13a3 3 0 1 0 5.878-.851l2.654-2.617.968.968-.305.914a1 1 0 0 0 .242 1.023l3.27 3.27a.997.997 0 0 0 1.414 0l1.586-1.586a.997.997 0 0 0 0-1.414l-3.27-3.27a1 1 0 0 0-1.023-.242L10.5 9.5l-.96-.96 2.68-2.643A3.005 3.005 0 0 0 16 3c0-.269-.035-.53-.102-.777l-2.14 2.141L12 4l-.364-1.757L13.777.102a3 3 0 0 0-3.675 3.68L7.462 6.46 4.793 3.793a1 1 0 0 1-.293-.707v-.071a1 1 0 0 0-.419-.814L1 0Zm9.646 10.646a.5.5 0 0 1 .708 0l2.914 2.915a.5.5 0 0 1-.707.707l-2.915-2.914a.5.5 0 0 1 0-.708ZM3 11l.471.242.529.026.287.445.445.287.026.529L5 13l-.242.471-.026.529-.445.287-.287.445-.529.026L3 15l-.471-.242L2 14.732l-.287-.445L1.268 14l-.026-.529L1 13l.242-.471.026-.529.445-.287.287-.445.529-.026L3 11Z"></path>
            </svg>
            Poster na Parede
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Alterna navegação">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ordemServico">Ordem de Serviços</a>
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
            </ul>
        </div>
    </nav>

    <div class="container mt-3">
        <div class="jumbotron">
            <h1 class="display-4">Oficina Poster na Parede</h1>
            <p class="lead">Documentação das classes do projeto.</p>
            <hr class="my-4">
            <p>Clique na classe para obter uma breve descrição.</p>
        </div>


        <div class="row">
            <div class="col bg-primary border border-white">
                <button type="button" class="btn btn-block btn-primary w-100" data-toggle="collapse" href="#ordemDeServico" aria-expanded="false"
                        aria-controls="collapseExample">
                    OrdemServico
                </button>
            </div>

            <div class="col bg-primary border border-white">
                <button type="button" class="btn btn-primary btn-block w-100" data-toggle="collapse" href="#solicitante" aria-expanded="false"
                        aria-controls="collapseExample">
                    Solicitante
                </button>
            </div>
            <div class="col bg-primary border border-white">
                <button type="button" class="btn btn-primary btn-block w-100" data-toggle="collapse" href="#veiculo" aria-expanded="false"
                        aria-controls="collapseExample">
                    Veiculo
                </button>
            </div>
            <div class="col bg-primary border border-white">
                <button type="button" class="btn btn-primary btn-block w-100" data-toggle="collapse" href="#carro" aria-expanded="false"
                        aria-controls="collapseExample">
                    Carro
                </button>
            </div>
            <div class="col bg-primary border border-white">
                <button type="button" class="btn btn-primary btn-block w-100" data-toggle="collapse" href="#moto" aria-expanded="false"
                        aria-controls="collapseExample">
                    Moto
                </button>
            </div>
            <div class="col bg-primary border border-white">
                <button type="button" class="btn btn-primary btn-block w-100" data-toggle="collapse" href="#caminhao" aria-expanded="false"
                        aria-controls="collapseExample">
                    Caminhao
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

</body>
</html>
