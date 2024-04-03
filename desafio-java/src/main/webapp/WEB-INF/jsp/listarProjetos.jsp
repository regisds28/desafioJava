<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://example.com/functions" prefix="f" %>

<%@ include file="/WEB-INF/jsp/components/header.jsp"%>

<div class="row">
  <div class="header">
    <h4>Lista de projetos</h4>
    <a href="/projetos/cadastrarProjeto" class="btn btn-primary">Cadastrar</a>
  </div>

  <c:if test="${empty projetos}">
    <p class="noContent">Sem projetos cadastrados</p>
  </c:if>

  <c:if test="${not empty projetos}">
    <div class="col-12">
      <table class="table table-bordered">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Nome</th>
          <th scope="col">Data de início</th>
          <th scope="col">Data de Previsão Fim</th>
          <th scope="col">Data Fim</th>
          <th scope="col">Gerente responsável</th>
          <th scope="col">Orçamento total</th>
          <th scope="col">Descrição</th>
          <th scope="col">Status</th>
          <th scope="col">Risco</th>
          <th scope="col">Ações</th>

        </tr>
      </thead>
      <tbody>
        <c:forEach items="${projetos}" var="projeto">
          <tr>
            <td>${projeto.id}</td>
            <td>${projeto.nome}</td>
            <td>
                ${f:formatLocalDateTime(projeto.dataInicio, 'dd/MM/yyyy')}
            </td>
            <td>
                ${f:formatLocalDateTime(projeto.dataPrevisaoFim, 'dd/MM/yyyy')}
            </td>
            <td>
                ${f:formatLocalDateTime(projeto.dataFim, 'dd/MM/yyyy')}
            </td>
            <td>${projeto.gerente.nome}</td>
            <fmt:formatNumber value="${projeto.orcamento}"
                              type="currency"
                              pattern="#,###.##"
                              maxFractionDigits="2"
                              minFractionDigits="2"
                              groupingUsed="true"
                              var="orcamento"
                              scope="request"/>
            <td>R$ ${orcamento}</td>
            <td>${projeto.descricao}</td>
            <td>${projeto.status.label}</td>
            <td>${projeto.risco.label}</td>
            <td>
              <c:set var="linkEditar" value="/projetos/editar/${projeto.id}"/>
              <a href="${linkEditar}" class="btn btn-primary">Editar</a>
              <c:choose>
                <c:when test="${projeto.status.label == 'Iniciado' || projeto.status.label == 'Em andamento' || projeto.status.label == 'Encerrado'}">
                  <button disabled type="button" class="btn btn-danger"><i class="bi bi-trash-alt"></i>Excluir</button>
                </c:when>
                <c:when test="${projeto.status.label != 'Iniciado' || projeto.status.label != 'Em andamento' || projeto.status.label != 'Encerrado'}">
                  <button class="btn btn-danger" onclick="javascript:modalConfirm(${projeto.id})" id="btn-confirm-${projeto.id}">Excluir</button>
                  <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="mi-modal-${projeto.id}">
                    <div class="modal-dialog modal-sm">
                      <div class="modal-content">
                        <div class="modal-header">
                          <p class="modal-title" id="myModalLabel">Tem certeza que deseja excluir o item ${projeto.id}?</p>
                        </div>
                        <div class="modal-footer">
                          <c:set var="linkExcluir" value="/projetos/apagar/${projeto.id}"/>
                          <a href="${linkExcluir}" onclick="onExcluir()" class="btn btn-danger">Sim</a>
                          <button type="button" class="btn btn-primary" id="modal-btn-no-${projeto.id}">Não</button>
                        </div>
                      </div>
                    </div>
                  </div>
                </c:when>
                <c:otherwise></c:otherwise>
              </c:choose>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</c:if>

</div>

<%@ include file="/WEB-INF/jsp/components/footer.jsp"%>