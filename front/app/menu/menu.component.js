import './menu.component.css'
import template from './menu.component.html'

class controller {
  constructor (LoginService) {
    this.titre = 'Menu'
    this.utilisateur = LoginService.loadCookies()
  }
}

export let MenuComponent = {
  template,
  controller,
  bindings: {
    utilisateur: '<'
  }
}
