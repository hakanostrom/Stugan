const apikeyHeaderObj = {
    method: 'GET',
    headers: {
        'API-KEY': '4f251971-5bd7-4f33-8aa0-8b9bbc809bb8',
    },
}

const listaStugor = async() => {
    let bokningarPlaceholder = document.getElementById("bokningarPlaceholder")
 
    let responseStuga = await fetch('http://localhost:8081/stuga')
    let resStugaJson = await responseStuga.json()

    for(stugaElement of resStugaJson){

        let stuga = document.createElement('div')
        stuga.innerHTML = "<h2>" + stugaElement.name + "</h2>"
        
        let responseBokningar = await fetch('http://localhost:8081/bokning/stuga/' + stugaElement.id, apikeyHeaderObj)
        let resBokningJson = await responseBokningar.json()

        if(resBokningJson.length == 0){
            let ingaBokningar = document.createElement('span')
            ingaBokningar.innerHTML = "<em>- inga bokningar -</em>"        
            stuga.appendChild(ingaBokningar)
        }

        resBokningJson.forEach(bokningElement => {
            let bokning = document.createElement('div')
            let datum = document.createElement('span')
            datum.innerHTML = "<strong>" + bokningElement.datum + "</strong>"
            let namn = document.createElement('span')
            namn.innerHTML = "<br>Namn: " + bokningElement.namn 
            let telefon = document.createElement('span')
            telefon.innerHTML = "<br>Telefon: " + bokningElement.telefon 
            let epost = document.createElement('span')
            epost.innerHTML = "<br>Epost: " + bokningElement.epost + "<br><br>"

            bokning.appendChild(datum)
            bokning.appendChild(namn)
            bokning.appendChild(telefon)
            bokning.appendChild(epost)

            stuga.appendChild(bokning)
        })
        bokningarPlaceholder.appendChild(stuga)
    }

}

// ===============

// App runtime starts here

listaStugor()