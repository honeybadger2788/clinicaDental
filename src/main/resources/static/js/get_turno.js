function getTurno (id) {
    const url = '/turnos/'+id

    const requestOptions = {
        method: 'GET',
    };

    fetch(url, requestOptions)
        .then(response => response.json())
        .then(result => {
            document.getElementById("form").classList.toggle("d-none")
            document.querySelector('#fechaTurno').value = result.fechaTurno
            document.querySelector('#horaTurno').value = result.horaTurno
            document.querySelector('#p'+result.paciente.id).selected = true
            document.querySelector('#o'+result.odontologo.id).selected = true
            document.querySelector('div #myBtn').innerHTML = '<button class="btn btn-primary" type="submit" onclick="save('+id+')">GUARDAR</button>'
        })
        .catch(error => console.log(error));
}