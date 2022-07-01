function save(id) {
event.preventDefault()
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

const url = '/odontologos/editar'

const formData = {
    id,
    nombre: document.querySelector('#nombre').value,
    apellido: document.querySelector('#apellido').value,
    matricula: document.querySelector('#matricula').value,
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
