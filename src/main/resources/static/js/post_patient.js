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

async function save() {
if(await validateForm()) {
event.preventDefault() // para que no recargue la página
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

const url = '/patients/add'

const formData = {
    firstName: document.querySelector('#firstName').value,
    lastName: document.querySelector('#lastName').value,
    dni: document.querySelector('#dni').value,
    email: document.querySelector('#email').value,
    address: {
        street: document.querySelector('#street').value,
        number: document.querySelector('#number').value,
        city: document.querySelector('#city').value,
        province: document.querySelector('#province').value,
    }
}

const requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: JSON.stringify(formData),
}

fetch(url, requestOptions)
  .then(response => response.text())
  .then(result => {
        // para capturar el error de paciente ya cargado
        if(result.status != 201)
            throw new Error(result)
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
    }))
  }
}


