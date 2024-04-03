<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                        <form:label path="dataPrevisaoFim">Previsão de término</form:label>
                        <form:input type="date" class="form-control" required="required" path="dataPrevisaoFim"/>
                    </div>
                    <div class="col">
                        <form:label path="dataFim">Data real de término</form:label>
                        <form:input type="date" class="form-control" required="required" path="dataFim"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <form:label path="id">Gerente responsável</form:label>
                        <form:select class="form-select" path="idGerente" required="required">
                            <form:option value="" label="Selecionar"/>
                            <form:options items="${listaMembros}" itemValue="id" itemLabel="nome"/>
                        </form:select>
                    </div>
                    <div class="col">
                        <form:label path="orcamento">Orçamento total</form:label>
                        <form:input type="text" class="form-control" required="required" path="orcamento"/>
                    </div>
                    <div class="col">
                        <form:label path="status">Status</form:label>
                        <form:select class="form-select" path="status" required="required">
                            <form:option value="" label="Selecionar"/>
                            <form:options items="${status}" itemValue="name" itemLabel="label"/>
                        </form:select>
                    </div>
                    <div class="col">
                        <form:label path="risco">Risco</form:label>
                        <form:select class="form-select" path="risco" required="required">
                            <form:option value="" label="Selecionar"/>
                            <form:options items="${risco}" itemValue="name" itemLabel="label"/>
                        </form:select>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <form:label path="descricao">Descrição</form:label>
                        <form:input type="textarea" path="descricao" class="form-control" required="required"/>
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

<%@ include file="/WEB-INF/jsp/components/footer.jsp"%>