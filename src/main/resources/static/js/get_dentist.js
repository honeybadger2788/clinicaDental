function getDentist (id) {
    const url = '/dentists/'+id

    const requestOptions = {
        method: 'GET',
    };

    fetch(url, requestOptions)
        .then(response => response.json())
        .then(result => {
            document.getElementById("form").classList.toggle("d-none")
            document.querySelector('#firstName').value = result.firstName
            document.querySelector('#lastName').value = result.lastName
            document.querySelector('#licence').value = result.licence
            document.querySelector('#myBtn').innerHTML ='<button class="btn btn-primary" type="submit" onclick="save('+id+')">GUARDAR</button>'
        })
        .catch(error => console.log(error));
}