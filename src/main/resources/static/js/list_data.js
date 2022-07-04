window.addEventListener('load',() => {
const urlPatient = '/patients'
const urlDentist = '/dentists'

const requestOptions = {
  method: 'GET'
};

fetch(urlPatient, requestOptions)
  .then(response => response.json())
  .then(data => {
    for( patient of data){
        const element =  '<option id="p'+patient.id+'" value=\"'+patient.id+'\">'+patient.dni+' - '+patient.lastName+', '+patient.firstName+'</option>'
        document.getElementById("paciente").innerHTML += element
    }
  })
  .catch(error => console.log('error', error));

  fetch(urlDentist, requestOptions)
    .then(response => response.json())
    .then(data => {
      for( dentist of data){
          const element =  '<option id="o'+odontologo.id+'" value=\"'+odontologo.id+'\">'+odontologo.licence+' - '+odontologo.lastName+', '+odontologo.firstName+'</option>'
          document.getElementById("odontologo").innerHTML += element
      }
    })
    .catch(error => console.log('error', error));
})

