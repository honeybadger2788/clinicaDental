function validateForm() {
    let formValidated = true
    const fields = document.querySelectorAll(".form-control")
     Array.from(fields).forEach(field => {
     if (!field.value) {
        formValidated = false
        event.preventDefault()
        document.getElementById(field.id+"Error").classList.remove("d-none")
     }
    })
    return formValidated
}

async function save(id) {
if(await validateForm()) {
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
    }))
  }
}
