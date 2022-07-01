window.addEventListener('load',() => {
const url = '/turnos'

const requestOptions = {
  method: 'GET'
};

fetch(url, requestOptions)
  .then(response => response.json())
  .then(data => {
    for( turno of data){
        const element =  '<tr>'+
                             '<td>'+turno.fechaTurno+' '+turno.horaTurno+'</th>'+
                             '<td>'+turno.paciente.dni+' - '+turno.paciente.apellido+', '+turno.paciente.nombre+'</th>'+
                             '<td>'+turno.odontologo.matricula+' - '+turno.odontologo.apellido+', '+turno.odontologo.nombre+'</th>'+
                             '<td><button type="button" class="btn btn-light" onclick="getTurno('+turno.id+')"><i class="bi bi-pencil-square"></i></button></td>'+
                             '<td><button type="submit" class="btn btn-light" onclick="deleteTurno('+turno.id+')"><i class="bi bi-trash3"></i></button></td>'+
                         '</tr>'
        document.getElementById("turnos").innerHTML += element
    }
  })
  .catch(error => console.log('error', error));
})

