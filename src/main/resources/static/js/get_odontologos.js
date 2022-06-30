window.addEventListener('load',() => {
const url = '/odontologos'

const requestOptions = {
  method: 'GET'
};

fetch(url, requestOptions)
  .then(response => response.json())
  .then(data => {
    for( odontologo of data){
        const element =  '<tr>'+
                             '<td>'+odontologo.apellido+'</th>'+
                             '<td>'+odontologo.nombre+'</td>'+
                             '<td>'+odontologo.matricula+'</td>'+
                             '<td><button type="button" class="btn btn-light">Editar</button></td>'+
                             '<td><button type="button" class="btn btn-light">Borrar</button></td>'+
                         '</tr>'
        document.getElementById("odontologos").innerHTML += element
    }
  })
  .catch(error => console.log('error', error));
})

