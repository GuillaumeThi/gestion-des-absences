import template from './login.view.html'

class controller {
  constructor (LoginService, $location) {
    this.LoginService = LoginService
    this.$location = $location
  }
  connexion (form) {
    this.LoginService.connexion(this.username, this.password)
        .then(utilisateur => this.LoginService.saveCookies(utilisateur),
        this.$location.path('/'))
  }
}

export let LoginComponent = {
  template,
  controller,
  bindings: {}
}
