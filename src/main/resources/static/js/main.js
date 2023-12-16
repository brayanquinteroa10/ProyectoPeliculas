function actorSelected(select){
    let index = select.selectedIndex;
    let option = select.options[index];
    let id = option.value;
    let name = option.text;
    let urlImage = option.dataset.url;

    option.disabled = "disabled";
    select.selectedIndex = 0;

    addActor(id, name, urlImage);

    let auxIds = $("#ids");
    let ids = auxIds.val();

    if (ids === ""){
        auxIds.val(id);
    } else {
        auxIds.val(ids + "," + id);
    }
}

function addActor(id, name, urlImage){
    let html = `
    <div class="card col-md-3 m-2" style="width: 10rem">
        <img src="${urlImage}" alt="${name}">
        <div class="card-body">
            <p class="card-text">${name}</p>
            <button class="btn btn-danger" data-id="${id}" onclick="deleteActor(this)">Eliminar</button>
        </div>
    </div>
    `
    $("#protas_container").append(html);
}

function deleteActor(button){
    let auxIds = $("#ids");
    let id = button.dataset.id;
    let node = button.parentElement.parentElement;
    let idsArray = auxIds.val().split(",").filter(idActor => idActor !== id);

    auxIds.val(idsArray.join(","));

    $("#actors option[value='"+id+"']").prop("disabled", false);

    $(node).remove();
}

function validateDate(fieldId) {
    let dateValue = document.getElementById(fieldId).value;
    let isValidDate = !isNaN(Date.parse(dateValue));
    let divError = document.getElementById(fieldId + '_error');
    if (!isValidDate) {
        divError.innerHTML = 'Ingrese una fecha válida.';
        divError.classList.add("d-block");
        divError.style.display = "block";
    } else {
        if (divError.classList.contains("d-block")) {
            divError.classList.remove("d-block");
        }
        divError.style.display = "none";
    }
}

function validateGenre(select){
    console.log("Entré");
    let index = select.selectedIndex;
    console.log("El índice es",index);
    let divError = document.getElementById("genero_error");
    console.log(divError);
    if (index === 0){
        divError.classList.add("d-block");
        divError.style.display = "block";
    }
    else{
        if(divError.classList.contains("d-block")){
            divError.classList.remove("d-block");
        }
            divError.style.display = "none";
    }
}

function validateActors(select){
    let index = select.selectedIndex;
    let divError = document.getElementById("actores_error");
    let auxIds = $("#ids");
    let ids = auxIds.val();
    if (index === 0 && ids === ""){
        if(ids === ""){
            divError.classList.add("d-block");
            divError.style.display = "block";
        }
    } else {
        if(divError.classList.contains("d-block")){
            divError.classList.remove("d-block");
        }
        divError.style.display = "none";
    }
}

function validateName(fieldId){
    let nameValue = document.getElementById(fieldId).value;
    let divError = document.getElementById(fieldId + '_error');
    if (nameValue === "") {
        divError.innerHTML = 'Ingrese un nombre.';
        divError.classList.add("d-block");
        divError.style.display = "block";
    } else {
        if(divError.classList.contains("d-block")){
            divError.classList.remove("d-block");
        }
        divError.style.display = "none";
    }
}

function previsualizar(){
    let reader = new FileReader();

    reader.readAsDataURL(document.getElementById("archivo").files[0]);

    reader.onload = function (e){
        let vp = document.getElementById("vista_previa");
        vp.classList.remove("d-none");
        vp.style.backgroundImage = 'url("' + e.target.result + '")';
    }
}