function save(id) {
event.preventDefault()
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

const url = '/appointments/edit'

const formData = {
    id,
    dateAppointment: document.querySelector('#dateAppointment').value,
    timeAppointment: document.querySelector('#timeAppointment').value,
    patient: { id: document.querySelector('#patient').value },
    dentist: { id: document.querySelector('#dentist').value },
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
