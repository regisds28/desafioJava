<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="pt_br">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Desafio Java - Lista de projetos</title>

  <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>"
        rel="stylesheet">

  <style>
    .header{
      margin: 10px;
      width: 100%;
    }
    .header h4{
      float: left;
    }
    .header a{
      margin-left: 16px;
    }
    .info{
      width: 100%;
      padding: 2rem 10px;
      height: 100px;
      background: #eee;
      vertical-align: top;
    }
  </style>

</head>
<body>

<%@ include file="/WEB-INF/jsp/components/header.jsp"%>

<div class="row">
  <div class="header">
    <h4>Lista de projetos</h4>
    <a href="/projetos/cadastrarProjeto" class="btn btn-primary">Cadastrar</a>
  </div>


  <div class="col-12">
      <table class="table table-bordered">
        <thead>
        <tr>
          <th scope="col">Nome</th>
          <th scope="col">Data de início</th>
          <th scope="col">Data prevista término</th>
          <th scope="col">Data real de término</th>
          <th scope="col">Gerente responsável</th>
          <th scope="col">Orçamento total</th>
          <th scope="col">Descrição</th>
          <th scope="col">Status</th>
          <th scope="col">Ações</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${projetos}" var="projeto">
          <tr>
            <td>${projeto.nome}</td>
            <td>
                ${projeto.dataInicio}
            </td>
            <td>${projeto.previsaoTermino}</td>
            <td>${projeto.dataRealTermino}</td>
            <td>${projeto.gerente}</td>
            <td>${projeto.orcamento}</td>
            <td>${projeto.descricao}</td>
            <td>${projeto.status.name}</td>
            <td>
              <a href="/projetos/${projeto.id}" class="btn btn-primary">Editar</a>
              <c:choose>
                <c:when test="${projeto.status.name == 'Cancelado' || projeto.status.name == 'Em andamento' || projeto.status.name == 'Encerrado'}">
                  <button disabled type="button" class="btn btn-danger"><i class="bi bi-trash-alt"></i>Excluir</button>
                </c:when>
                <c:when test="${projeto.status.name != 'Cancelado' || projeto.status.name != 'Em andamento' || projeto.status.name != 'Encerrado'}">
                  <a href="/projetos/apagar/${projeto.id}" type="button" class="btn btn-danger">Excluir</a>
                </c:when>
                <c:otherwise></c:otherwise>
              </c:choose>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
  </div>
</div>

</body>

<script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
</html>