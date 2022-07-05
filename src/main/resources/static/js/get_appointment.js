function getAppointment (id) {
    const url = '/appointments/'+id

    const requestOptions = {
        method: 'GET',
    };

    fetch(url, requestOptions)
        .then(response => response.json())
        .then(result => {
            document.getElementById("form").classList.toggle("d-none")
            document.querySelector('#dateAppointment').value = result.dateAppointment
            document.querySelector('#timeAppointment').value = result.timeAppointment
            document.querySelector('#p'+result.patient.id).selected = true
            document.querySelector('#o'+result.dentist.id).selected = true
            document.querySelector('div #myBtn').innerHTML = '<button class="btn btn-primary" type="submit" onclick="save('+id+')">GUARDAR</button>'
        })
        .catch(error => console.log(error));
}