const API_URL = 'http://localhost:8080/login'

export class UtilisateursService {
    constructor ($http, $q) {
        this.$http = $http
        this.$q = $q
        this.collaborateurs = []
    }

    // return promise of
    getUtilisateurs () {
        if (this.utilisateurs.length !== 0) {
            return this.$q.resolve(this.utilisateurs)
        }

        return this.$http.get(API_URL)
        .then(response => response.data)
        .then(utilisateurs => {
            this.utilisateurs = utilisateurs
            return utilisateurs
        })
    }
}

