function save() {
event.preventDefault()
var myHeaders = new Headers()
myHeaders.append("Content-Type", "application/json")

const url = '/dentists/add'

const formData = {
    firstName: document.querySelector('#nombre').value,
    lastName: document.querySelector('#apellido').value,
    licence: document.querySelector('#matricula').value,
}

const requestOptions = {
  method: 'POST',
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
        .then(result => location.reload())
  })
  .catch(error =>
    Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: error.message,
    })
  )
}
