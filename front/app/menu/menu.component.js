import './menu.component.css'
import template from './menu.component.html'

class controller {
  constructor (LoginService, $location) {
    this.titre = 'Menu'
    this.$location = $location
    this.LoginService = LoginService
    this.utilisateur = LoginService.loadCookies()
  }
  deconnexion () {
    this.LoginService.deleteCookies()
    this.utilisateur = undefined
    this.$location.path('login')
  }
}

export let MenuComponent = {
  template,
  controller,
  bindings: {}

}
