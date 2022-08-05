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
    <p>Imagine a cena bebê</p>

    <div class="accordion" id="accordionExample">
        <div class="card">
            <div class="card-header" id="headingOne">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="true" aria-controls="collapseOne">
                        Classe: Ordem de Serviço
                    </button>
                </h5>
            </div>

            <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">
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
        </div>
        <div class="card">
            <div class="card-header" id="headingTwo">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse"
                            data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Classe: Solicitante
                    </button>
                </h5>
            </div>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                <div class="card-body">
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
        </div>
        <div class="card">
            <div class="card-header" id="headingThree">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse"
                            data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Classe: Veículo
                    </button>
                </h5>
            </div>
            <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                <div class="card-body">
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
        </div>
        <div class="card">
            <div class="card-header" id="headingFour">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse"
                            data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                        Classe: Carro
                    </button>
                </h5>
            </div>
            <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
                <div class="card-body">
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
        </div>
        <div class="card">
            <div class="card-header" id="headingFive">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse"
                            data-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                        Classe: Moto
                    </button>
                </h5>
            </div>
            <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordionExample">
                <div class="card-body">
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
        </div>
        <div class="card">
            <div class="card-header" id="headingSix">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse"
                            data-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
                        Classe: Caminhao
                    </button>
                </h5>
            </div>
            <div id="collapseSix" class="collapse" aria-labelledby="headingSix" data-parent="#accordionExample">
                <div class="card-body">
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
</body>
</html>
