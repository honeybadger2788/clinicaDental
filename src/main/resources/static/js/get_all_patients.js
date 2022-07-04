window.addEventListener('load',() => {
const url = '/patients'

const requestOptions = {
  method: 'GET'
};

fetch(url, requestOptions)
  .then(response => response.json())
  .then(data => {
    for( patient of data){
        const element =  '<tr>'+
                             '<td>'+patient.lastName+'</th>'+
                             '<td>'+patient.firstName+'</td>'+
                             '<td>'+patient.dni+'</td>'+
                             '<td>'+patient.email+'</td>'+
                             '<td>'+patient.admissionDate+'</td>'+
                             '<td>'+patient.address.street+
                                ' '+patient.address.number+
                                ', '+patient.address.city+
                                ', '+patient.address.province+'</td>'+
                             '<td><button type="button" class="btn btn-light" onclick="getPatient('+patient.id+')"><i class="bi bi-pencil-square"></i></button></td>'+
                             '<td><button type="submit" class="btn btn-light" onclick="deletePatient('+patient.id+')"><i class="bi bi-trash3"></i></button></td>'+
                         '</tr>'
        document.getElementById("patients").innerHTML += element
    }
  })
  .catch(error => console.log('error', error));
})

