window.addEventListener('load',() => {
const url = '/pacientes'

const requestOptions = {
  method: 'GET'
};

fetch(url, requestOptions)
  .then(response => response.json())
  .then(data => {
    for( paciente of data){
        const element =  '<tr>'+
                             '<td>'+paciente.apellido+'</th>'+
                             '<td>'+paciente.nombre+'</td>'+
                             '<td>'+paciente.dni+'</td>'+
                             '<td>'+paciente.email+'</td>'+
                             '<td>'+paciente.fechaIngreso+'</td>'+
                             '<td>'+paciente.domicilio.calle+
                                ' '+paciente.domicilio.numero+
                                ', '+paciente.domicilio.localidad+
                                ', '+paciente.domicilio.provincia+'</td>'+
                             '<td><button type="button" class="btn btn-light" onclick="getPaciente('+paciente.id+')"><i class="bi bi-pencil-square"></i></button></td>'+
                             '<td><button type="submit" class="btn btn-light" onclick="deletePaciente('+paciente.id+')"><i class="bi bi-trash3"></i></button></td>'+
                         '</tr>'
        document.getElementById("pacientes").innerHTML += element
    }
  })
  .catch(error => console.log('error', error));
})

