<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Desafio Java - cadastrar projeto</title>

    <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>"
          rel="stylesheet">

    <style>
        .row button, .row a{
            width: auto;
            float: left;
            margin-left: 10px;
        }
    </style>

</head>
<body>

    <%@ include file="/WEB-INF/jsp/components/header.jsp"%>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Cadastrar Projeto</h5>
            <form:form action="salvarProjeto" method="post" modelAttribute="novoProjeto">
                <div class="row">
                    <div class="col">
                        <form:label path="nome">Nome</form:label>
                        <form:input type="text" class="form-control" required="required" path="nome"/>
                    </div>
                    <div class="col">
                        <form:label path="dataInicio">Data de início</form:label>
                        <form:input type="date" class="form-control" required="required" path="dataInicio"/>
                    </div>
                    <div class="col">
                        <form:label path="previsaoTermino">Previsão de término</form:label>
                        <form:input type="date" class="form-control" required="required" path="previsaoTermino"/>
                    </div>
                    <div class="col">
                        <form:label path="dataRealTermino">Data real de término</form:label>
                        <form:input type="date" class="form-control" required="required" path="dataRealTermino"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <form:label path="gerente">Gerente responsável</form:label>
                        <form:input type="text" path="gerente" required="required" class="form-control"/>
                    </div>
                    <div class="col">
                        <form:label path="orcamento">Orçamento total</form:label>
                        <form:input type="text" class="form-control" required="required" path="orcamento"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <form:label path="descricao">Descrição</form:label>
                        <form:input type="textarea" path="descricao" class="form-control"/>
                    </div>
                </div>
                <br>
                <div class="row">
                    <button class="btn btn-primary" type="submit">Cadastrar</button>
                    <a class="btn btn-secondary" href="/projetos/listarProjetos" type="submit">Voltar</a>
                </div>
            </form:form>
        </div>
    </div>

</div>


</body>

<script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
</html>