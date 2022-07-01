window.addEventListener('load',() => {
const urlPacientes = '/pacientes'
const urlOdontologos = '/odontologos'

const requestOptions = {
  method: 'GET'
};

fetch(urlPacientes, requestOptions)
  .then(response => response.json())
  .then(data => {
    for( paciente of data){
        const element =  '<option value=\"'+paciente.id+'\">'+paciente.dni+' - '+paciente.apellido+', '+paciente.nombre+'</option>'
        document.getElementById("pacientes").innerHTML += element
    }
  })
  .catch(error => console.log('error', error));

  fetch(urlOdontologos, requestOptions)
    .then(response => response.json())
    .then(data => {
      for( odontologo of data){
          const element =  '<option value=\"'+odontologo.id+'\">'+odontologo.matricula+' - '+odontologo.apellido+', '+odontologo.nombre+'</option>'
          document.getElementById("odontologos").innerHTML += element
      }
    })
    .catch(error => console.log('error', error));
})

