function getPatient(id) {
    const url = '/patients/'+id

    const requestOptions = {
        method: 'GET',
    };

    fetch(url, requestOptions)
        .then(response => response.json())
        .then(result => {
            document.getElementById("form").classList.toggle("d-none")
            document.querySelector('#nombre').value = result.firstName
            document.querySelector('#apellido').value = result.lastName
            document.querySelector('#dni').value = result.dni
            document.querySelector('#email').value = result.email
            document.querySelector('#calle').value = result.address.street
            document.querySelector('#numero').value = result.address.number
            document.querySelector('#localidad').value = result.address.city
            document.querySelector('#provincia').value = result.address.province
            document.querySelector('#myBtn').innerHTML ='<button class="btn btn-primary" type="submit" onclick="save('+id+')">GUARDAR</button>'
        })
        .catch(error => console.log(error));
}