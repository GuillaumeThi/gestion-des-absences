import template from './login.view.html'

class controller {
  constructor (LoginService) {
    this.LoginService = LoginService

  }
  connexion (form) {

        this.LoginService.connexion(this.username, this.password)
        .then(utilisateur => this.LoginService.saveCookies(utilisateur))
    }
}

export let LoginComponent = {
  template,
  controller,
  bindings:   {}
}

