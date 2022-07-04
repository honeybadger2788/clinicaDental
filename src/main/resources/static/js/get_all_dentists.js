window.addEventListener('load',() => {
const url = '/dentists'

const requestOptions = {
  method: 'GET'
};

fetch(url, requestOptions)
  .then(response => response.json())
  .then(data => {
    for( dentist of data){
        const element =  '<tr>'+
                             '<td>'+dentist.lastName+'</th>'+
                             '<td>'+dentist.firstName+'</td>'+
                             '<td>'+dentist.licence+'</td>'+
                             '<td><button type="button" class="btn btn-light" onclick="getDentist('+dentist.id+')"><i class="bi bi-pencil-square"></i></button></td>'+
                             '<td><button type="submit" class="btn btn-light" onclick="deleteDentist('+dentist.id+')"><i class="bi bi-trash3"></i></button></td>'+
                         '</tr>'
        document.getElementById("dentists").innerHTML += element
    }
  })
  .catch(error => console.log('error', error));
})

