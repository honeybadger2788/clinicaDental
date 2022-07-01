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
                             '<td><button type="button" class="btn btn-light" onclick="getOdontologo('+odontologo.id+')"><i class="bi bi-pencil-square"></i></button></td>'+
                             '<td><button type="submit" class="btn btn-light" onclick="deleteOdontologo('+odontologo.id+')"><i class="bi bi-trash3"></i></button></td>'+
                         '</tr>'
        document.getElementById("odontologos").innerHTML += element
    }
  })
  .catch(error => console.log('error', error));
})

