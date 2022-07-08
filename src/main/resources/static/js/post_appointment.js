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
event.preventDefault()
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

const url = '/appointments/add'

const formData = {
    dateAppointment: document.querySelector('#dateAppointment').value,
    timeAppointment: document.querySelector('#timeAppointment').value,
    patient: { id: document.querySelector('#patient').value },
    dentist: { id: document.querySelector('#dentist').value },
}

const requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: JSON.stringify(formData),
}

fetch(url, requestOptions)
  .then(response => response.text())
  .then(result => {
        if(result != 'Appointment created')
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

