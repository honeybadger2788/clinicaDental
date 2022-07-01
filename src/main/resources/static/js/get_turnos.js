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
                             '<td>'+turno.paciente.apellido+', '+turno.paciente.nombre+'</th>'+
                             '<td>'+turno.odontologo.apellido+', '+turno.odontologo.nombre+'</th>'+
                             '<td><button type="button" class="btn btn-light">Editar</button></td>'+
                             '<td><button type="button" class="btn btn-light">Borrar</button></td>'+
                         '</tr>'
        document.getElementById("turnos").innerHTML += element
    }
  })
  .catch(error => console.log('error', error));
})

