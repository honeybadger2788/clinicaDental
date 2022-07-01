function showFormPaciente (id) {
    const url = '/pacientes/'+id

    const requestOptions = {
        method: 'GET',
    };

    fetch(url, requestOptions)
        .then(response => response.json())
        .then(result => {
            document.getElementById("form").classList.toggle("d-none")
            document.querySelector('#nombre').value = result.nombre
            document.querySelector('#apellido').value = result.apellido
            document.querySelector('#dni').value = result.dni
            document.querySelector('#email').value = result.email
            document.querySelector('#calle').value = result.domicilio.calle
            document.querySelector('#numero').value = result.domicilio.numero
            document.querySelector('#localidad').value = result.domicilio.localidad
            document.querySelector('#provincia').value = result.domicilio.provincia
            document.querySelector('#myBtn').innerHTML ='<button class="btn btn-primary" type="submit" onclick="save('+id+')">GUARDAR</button>'
        })
        .catch(error => console.log(error));
}