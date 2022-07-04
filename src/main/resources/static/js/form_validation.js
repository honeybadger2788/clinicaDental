window.addEventListener('load',() => {
    const form = document.querySelector("form")
    form.addEventListener('submit', event => {
    Array.from(form).forEach(field => {
            if (!field.value) {
                event.preventDefault()
                document.getElementById(field.id+"Error").classList.toggle("d-none")
                event.stopPropagation()
            }
      })
    })
})