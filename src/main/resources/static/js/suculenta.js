function prepararAgregar() {
    document.getElementById('suculentaModalTitulo').innerText = 'Nueva Suculenta';
    document.getElementById('suculentaBotonGuardar').innerText = 'Agregar';
    document.getElementById('suculentaForm').reset();
    document.getElementById('idSuculenta').value = '';
}

function prepararEditar(boton) {
    document.getElementById('suculentaModalTitulo').innerText = 'Actualizar Suculenta';
    document.getElementById('suculentaBotonGuardar').innerText = 'Actualizar';
    document.getElementById('idSuculenta').value = boton.dataset.id;
    document.getElementById('nombreComun').value = boton.dataset.nombreComun;
    document.getElementById('nombreCientifico').value = boton.dataset.nombreCientifico;
    document.getElementById('familia').value = boton.dataset.familia;
    document.getElementById('colorPrincipal').value = boton.dataset.colorPrincipal;
    document.getElementById('alturaCm').value = boton.dataset.alturaCm;
    document.getElementById('precioEstimado').value = boton.dataset.precioEstimado;
    document.getElementById('nivelRiego').value = boton.dataset.nivelRiego;
    document.getElementById('rutaImagen').value = boton.dataset.rutaImagen;
}

function prepararEliminar(boton) {
    document.getElementById('eliminarIdSuculenta').value = boton.dataset.id;
    document.getElementById('eliminarNombre').innerText = boton.dataset.nombreComun;
}