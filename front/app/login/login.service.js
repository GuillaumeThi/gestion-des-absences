export class LoginService {
    constructor($http, $q, API_URL, $cookies){
        this.$http = $http
        this.$q = $q
        this.$API_URL = API_URL
        this.$cookies = $cookies
    }

    connexion(email, password) { 
        return this.$http.get(this.$API_URL + "/login?email=" + email+ "&password="+ password)
        .then(
        rep => {
            return rep.data
        },
        err => { 
            console.log("Connection impossible", err)
            return this.$q.reject(err)
        }
        )
    }

 loadCookies(){
        if(!this.utilisateur)
            this.utilisateur = this.$cookies.getObject('utilisateur')
        return this.utilisateur
    }

    saveCookies(utilisateur) {
        console.log( 'fghfhfgh', utilisateur)
        console.log( 'cookie', this.$cookies)
        this.$cookies.put('toto','toto')
        this.$cookies.putObject('utilisateur', utilisateur)
        
        console.log( 'fghfhfgh', utilisateur)

        this.utilisateur = utilisateur
    }

  deleteCookies() {
        console.log("delete cookie")
        this.utilisateur = undefined
        this.$cookies.remove('utilisateur')
    }
}
