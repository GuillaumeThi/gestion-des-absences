import './menu.component.css'
import template from './menu.component.html'

class controller {
  constructor (LoginService) {
    this.titre = 'Menu'
  }
}

export let MenuComponent = {
  template,
  controller,
  bindings: {}
}
