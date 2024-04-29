// Hämta stugor med rest-anrop och lägg till i dropdown ett element per stuga.
// Stugans index blir dropdownens värde
const listaStugor = async() => {
  

    let stugorSelect = document.getElementById("stugorSelect")

    let response = await fetch( properties.basePath + '/stuga')
    let resJson = await response.json()
    resJson.forEach(element => {
        let option = new Option(element.name, element.id)
        stugorSelect.add(option)
    });   
}

// Boka stuga med rest-anrrop. Validera att bokningsuppgifter är ifyllda.
// Resultatet av anropet visas i en bootstrap-alert. Gick anropet bra sätts en ok-klass på denna.
// Gick bokningen inte bra sätts en danger-klass. Tex vid 409 (Conflict), dvs dubbelbokning.
const bokaStuga = async() => {
    let stugorSelect = document.getElementById("stugorSelect")
    
    let bokareNamn = document.getElementById("bokareNamn").value
    let bokareTelefon = document.getElementById("bokareTelefon").value
    let bokareEpost = document.getElementById("bokareEpost").value
    let bokningsdatum = document.getElementById("bokningsdatum").value

    if(bokareNamn== "" || bokareTelefon == "" || bokareEpost == "")
      alert("Fyll i samtliga bokningsuppgifter")
    else{
        let bokning = {
            stuga_id: stugorSelect.selectedIndex,
            namn: bokareNamn,
            telefon: bokareTelefon,
            epost: bokareEpost,
            datum: bokningsdatum
        }

        // Hårdkodad url (basePath) kanske är hållbart i längden
        let response = await fetch( properties.basePath + '/bokning', {
        method: 'POST',
        body: JSON.stringify(bokning),
        headers: {
          'Content-Type': 'application/json'
        }
      });

      let resJson = await response.json()

      let alertDiv = document.getElementById("coonfirmationPlaceholder")
      alertDiv.style.display = 'block'
      
      if(response.status == 409){
        alertDiv.className = "alert alert-danger"
        alertDiv.innerText = resJson.message
      }else{
        alertDiv.className = "alert alert-success"
        alertDiv.innerText = "Tack för din bokning av stuga nummer " + resJson.stuga_id  
      }


  }
}


// ===============

// App runtime starts here

// Tillåt inte att bokningsdatum väljs i dåtiden
let datePicker = document.getElementById('bokningsdatum')
let today = new Date().toISOString().split('T')[0]
datePicker.value = today
datePicker.min = today

// Initiera listan med stugor
listaStugor()