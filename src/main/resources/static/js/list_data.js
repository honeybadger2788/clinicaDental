window.addEventListener('load',() => {
const urlPatient = '/patients'
const urlDentist = '/dentists'

const requestOptions = {
  method: 'GET'
};

fetch(urlPatient, requestOptions)
  .then(response => response.json())
  .then(data => {
    const sortedData = data.sort(function(a, b){return a.id-b.id})
    for( patient of sortedData){
        const element =  '<option id="p'+patient.id+'" value=\"'+patient.id+'\">'+patient.dni+' - '+patient.lastName+', '+patient.firstName+'</option>'
        document.getElementById("patient").innerHTML += element
    }
  })
  .catch(error => console.log('error', error));

  fetch(urlDentist, requestOptions)
    .then(response => response.json())
    .then(data => {
      const sortedData = data.sort(function(a, b){return a.id-b.id})
      for( dentist of sortedData){
          const element =  '<option id="o'+dentist.id+'" value=\"'+dentist.id+'\">'+dentist.licence+' - '+dentist.lastName+', '+dentist.firstName+'</option>'
          document.getElementById("dentist").innerHTML += element
      }
    })
    .catch(error => console.log('error', error));
})

