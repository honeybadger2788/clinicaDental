function save() {
event.preventDefault()
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

const url = '/turnos/crear'

const formData = {
    fechaTurno: document.querySelector('#fechaTurno').value,
    horaTurno: document.querySelector('#horaTurno').value,
    paciente: { id: document.querySelector('#paciente').value },
    odontologo: { id: document.querySelector('#odontologo').value },
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

