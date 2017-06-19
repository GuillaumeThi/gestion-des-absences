export class LoginService {
  constructor ($http, $q, API_URL, $cookies, publicPath) {
    this.$http = $http
    this.$q = $q
    this.$API_URL = API_URL + publicPath
    this.$cookies = $cookies
  }

  connexion (email, password) {
    return this.$http.get(this.$API_URL + 'login?email=' + email + '&password=' + password)
        .then(
        rep => {
          return rep.data
        },
        err => {
          return this.$q.reject(err)
        }
        )
  }
  getId (utilisateur) {
    return utilisateur.id
  }
  loadCookies () {
    if (!this.utilisateur) { this.utilisateur = this.$cookies.getObject('utilisateur') }
      console.log(this.utilisateur)
    return this.utilisateur
  }

  saveCookies (utilisateur) {
    this.$cookies.putObject('utilisateur', utilisateur)
    this.utilisateur = utilisateur
    //console.log(this.utilisateur)
  }

  deleteCookies () {
    //console.log('delete cookie')
    this.utilisateur = undefined
    this.$cookies.remove('utilisateur')
  }
}
