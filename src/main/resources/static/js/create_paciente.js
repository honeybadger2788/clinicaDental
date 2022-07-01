function save() {
event.preventDefault()
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

const url = '/pacientes/crear'

const formData = {
    nombre: document.querySelector('#nombre').value,
    apellido: document.querySelector('#apellido').value,
    dni: document.querySelector('#dni').value,
    email: document.querySelector('#email').value,
    domicilio: {
        calle: document.querySelector('#calle').value,
        numero: document.querySelector('#numero').value,
        localidad: document.querySelector('#localidad').value,
        provincia: document.querySelector('#provincia').value,
    }
}

const requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: JSON.stringify(formData),
  redirect: 'follow'
}

fetch(url, requestOptions)
  .then(response => response.json())
  .then(data => {
        Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Paciente guardado con exito',
            showConfirmButton: false,
            timer: 1500
        })
        location.reload()
  })
  .catch(error =>
    Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: error.message,
    })
  )
}

