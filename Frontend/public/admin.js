// Api-nyckeln skickas via header i restanrop. Detta header-objekt "förkockas".
const apikeyHeaderObj = {
    method: 'GET',
    headers: {
        'API-KEY': sessionStorage.getItem("apinyckel"),
    },
}

// Utloggning manifesteras genom att api-nyckeln raderas från sessionstorage
const logout = () => {
    sessionStorage.removeItem("apinyckel");
}

// Visa lista med bokningar genom att först hämta en lista över stugor och för varje stuga hämta dess bokningar. Lägg 
// Anropet för att hämta bokningar kräver api-nyckel. Är api-nyckeln felaktig eller saknas helt så visas detta i en bootstrap-alert.
// Observera att antagandet görs att api-nyckeln som existerar (i sessionstorage) är korrekt. Ingen koll görs "i förväg" utan man får hantera detta i de undantagsfall det händer.
// Avhjälpningen är består i att logga ut (trycka på knappen).
const listaStugor = async() => {
    let bokningarPlaceholder = document.getElementById("bokningarPlaceholder")
 
    let responseStuga = await fetch( properties.basePath + '/stuga')
    let resStugaJson = await responseStuga.json()

    // Då "async" och "foreach" inte är så bra kompisar (det får lite lustiga biverkningar) så används en for-of-loop.
    for(stugaElement of resStugaJson){

        let stuga = document.createElement('div')
        stuga.innerHTML = "<h2>" + stugaElement.name + "</h2>"
        
        let responseBokningar = await fetch(  properties.basePath +  '/bokning/stuga/' + stugaElement.id, apikeyHeaderObj)
        
        if(responseBokningar.status == 401){
            let resBokningarJson = await responseBokningar.json()
            let alertDiv = document.getElementById("coonfirmationPlaceholder")
            alertDiv.style.display = 'block'
            alertDiv.innerText = resBokningarJson.message;
        }
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