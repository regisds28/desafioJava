function linkDelete(id){
    if (confirm("Tem certeza que deseja excluir o item?")) {
        window.location.href='/projetos/apagar/'+id;
    }
    return false;

}

function confirmarEdicao (f){
    var confirma =alert("Projeto alterado com sucesso!");
    if (confirma==true){
        f.action= '/projetos/listarProjetos'
        window.location.href="/projetos/listarProjetos";
    }
    f.submit;
}