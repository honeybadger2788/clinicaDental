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
        document.getElementById("patient").innerHTML += element
    }
  })
  .catch(error => console.log('error', error));

  fetch(urlDentist, requestOptions)
    .then(response => response.json())
    .then(data => {
      for( dentist of data){
          const element =  '<option id="o'+dentist.id+'" value=\"'+dentist.id+'\">'+dentist.licence+' - '+dentist.lastName+', '+dentist.firstName+'</option>'
          document.getElementById("dentist").innerHTML += element
      }
    })
    .catch(error => console.log('error', error));
})

