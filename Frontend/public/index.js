console.log("Här är jag!")

const listaStugor = async() => {
    let stugorSelect = document.getElementById("stugorSelect")

    let response = await fetch('http://localhost:8081/stuga')
    let resJson = await response.json()
    resJson.forEach(element => {
        let option = new Option(element.name, element.id)
        stugorSelect.add(option)
    });   
}

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

        let response = await fetch('http://localhost:8081/bokning', {
        method: 'POST',
        body: JSON.stringify(bokning),
        headers: {
          'Content-Type': 'application/json'
        }
      });

      let resJson = await response.json()
      document.getElementById("coonfirmationPlaceholder").innerText = "Tack för din bokning av stuga nummer " + resJson.stuga_id
    }
}















// ===============

// App runtime starts here

listaStugor()