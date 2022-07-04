function save(id) {
event.preventDefault() // para que no recargue la página
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

const url = '/patients/edit'

const formData = {
    id,
    firstName: document.querySelector('#nombre').value,
    lastName: document.querySelector('#apellido').value,
    dni: document.querySelector('#dni').value,
    email: document.querySelector('#email').value,
    address: {
        street: document.querySelector('#calle').value,
        number: document.querySelector('#numero').value,
        city: document.querySelector('#localidad').value,
        province: document.querySelector('#provincia').value,
    }
}

const requestOptions = {
  method: 'PUT',
  headers: myHeaders,
  body: JSON.stringify(formData),
}

fetch(url, requestOptions)
  .then(response => response.text())
  .then(result => {
        Swal.fire({
            position: 'center',
            icon: 'success',
            title: result,
            showConfirmButton: false,
            timer: 1500
        })
        .then(result => {
            location.reload()
        })
  })
  .catch(error =>
    Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: error.message,
    })
  )
}
