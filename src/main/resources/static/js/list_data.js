window.addEventListener('load',() => {
const urlPacientes = '/pacientes'
const urlOdontologos = '/odontologos'
const urlTurnos = '/turnos/crear'

const requestOptions = {
  method: 'GET'
};

fetch(urlPacientes, requestOptions)
  .then(response => response.json())
  .then(data => {
    for( paciente of data){
        const element =  '<option id="p'+paciente.id+'" value=\"'+paciente.id+'\">'+paciente.dni+' - '+paciente.apellido+', '+paciente.nombre+'</option>'
        document.getElementById("paciente").innerHTML += element
    }
  })
  .catch(error => console.log('error', error));

  fetch(urlOdontologos, requestOptions)
    .then(response => response.json())
    .then(data => {
      for( odontologo of data){
          const element =  '<option id="o'+odontologo.id+'" value=\"'+odontologo.id+'\">'+odontologo.matricula+' - '+odontologo.apellido+', '+odontologo.nombre+'</option>'
          document.getElementById("odontologo").innerHTML += element
      }
    })
    .catch(error => console.log('error', error));
})

