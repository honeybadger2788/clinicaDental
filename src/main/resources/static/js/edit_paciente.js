function save(id) {
event.preventDefault() // para que no recargue la página
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

const url = '/pacientes/editar'

const formData = {
    id,
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
            // document.getElementById("form").classList.toggle("d-none")
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
