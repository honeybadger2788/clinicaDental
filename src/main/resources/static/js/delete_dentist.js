function deleteDentist(id) {
    event.preventDefault()
    const url = '/dentists/'+id

    const requestOptions = {
        method: 'DELETE',
    };

    fetch(url, requestOptions)
        .then(response => response.text())
        .then(result => {
            Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: result,
                    showConfirmButton: false,
                    timer: 1500
                })
                .then(result => location.reload())
        })
        .catch(error =>
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: error.message,
            })
        );
}