function getOdontologo (id) {
    const url = '/odontologos/'+id

    const requestOptions = {
        method: 'GET',
    };

    fetch(url, requestOptions)
        .then(response => response.json())
        .then(result => {
            document.getElementById("form").classList.toggle("d-none")
            document.querySelector('#nombre').value = result.nombre
            document.querySelector('#apellido').value = result.apellido
            document.querySelector('#matricula').value = result.matricula
            document.querySelector('#myBtn').innerHTML ='<button class="btn btn-primary" type="submit" onclick="save('+id+')">GUARDAR</button>'
        })
        .catch(error => console.log(error));
}