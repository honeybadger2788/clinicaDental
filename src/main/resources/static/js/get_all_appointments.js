window.addEventListener('load',() => {
const url = '/appointments'

const requestOptions = {
  method: 'GET'
};

fetch(url, requestOptions)
  .then(response => response.json())
  .then(data => {
    for( appointment of data){
        const element =  '<tr>'+
                             '<td>'+appointment.dateAppointment+' '+appointment.timeAppointment+'</th>'+
                             '<td>'+appointment.patient.dni+' - '+appointment.patient.lastName+', '+appointment.patient.firstName+'</th>'+
                             '<td>'+appointment.dentist.licence+' - '+appointment.dentist.lastName+', '+appointment.dentist.firstName+'</th>'+
                             '<td><button type="button" class="btn btn-light" onclick="getAppointment('+appointment.id+')"><i class="bi bi-pencil-square"></i></button></td>'+
                             '<td><button type="submit" class="btn btn-light" onclick="deleteAppointment('+appointment.id+')"><i class="bi bi-trash3"></i></button></td>'+
                         '</tr>'
        document.getElementById("appointments").innerHTML += element
    }
  })
  .catch(error => console.log('error', error));
})

