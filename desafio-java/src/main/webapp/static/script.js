function onEditar(){
    const alert = document.getElementById("alertEditar");
    setTimeout(function(){
        if(alert){
            alert.style.display= "none";
        }
    }, 4000);
}

function onCadastrar(){
    const alert = document.getElementById("alertCadastrar");
    setTimeout(function(){
        if(alert){
            alert.style.display= "none";
        }
    }, 4000);
}

function onExcluir(){
    const alert = document.getElementById("alertExcluir");
    setTimeout(function(){
        if(alert){
            alert.style.display= "none";
        }
    }, 4000);
}

onEditar();
onCadastrar();
onExcluir();

function modalConfirm(id){

    $("#btn-confirm-"+id).on("click", function(){
        $("#mi-modal-"+id).modal('show');
        return true;
    });

    $("#modal-btn-no-"+id).on("click", function(){
        $("#mi-modal-"+id).modal('hide');
    });
};
