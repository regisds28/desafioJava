<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt_br">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Desafio Java - cadastrar projeto</title>

  <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
  <link href="<c:url value="/static/main.css"/>" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Potifólio de Projetos</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/projetos">Início</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/projetos/listarProjetos">Lista de projetos</a>
        </li>

      </ul>
    </div>
  </div>
</nav>
<c:if test="${editarProjeto}">
  <div class="alert alert-success alert-dismissible" id="alertEditar" style="display: block;">
    <strong>Item alterado com sucesso!</strong>
  </div>
</c:if>
<c:if test="${cadastrarProjeto}">
  <div class="alert alert-success alert-dismissible" id="alertCadastrar" style="display: block;">
    <strong>Item criado com sucesso!</strong>
  </div>
</c:if>
<c:if test="${excluirProjeto}">
  <div class="alert alert-success alert-dismissible" id="alertExcluir" style="display: block;">
    <strong>Item excluído com sucesso!</strong>
  </div>
</c:if>
</body>
</html>
