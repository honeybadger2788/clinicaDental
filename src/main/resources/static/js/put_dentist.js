function save(id) {
event.preventDefault()
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

const url = '/dentists/edit'

const formData = {
    id,
    firstName: document.querySelector('#firstName').value,
    lastName: document.querySelector('#lastName').value,
    licence: document.querySelector('#licence').value,
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
