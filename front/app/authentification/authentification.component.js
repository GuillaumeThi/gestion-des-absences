
class controller {
  constructor (LoginService, $location, $scope) {
    //console.log('constructor')
    this.LoginService = LoginService
    this.$location = $location
    this.utilisateur=""

   $scope.$on('$routeChangeStart', (angularEvent, newUrl) => {
      this.utilisateur = this.LoginService.loadCookies()
      //console.log('authentif utilisateur', this.utilisateur)
      if (newUrl.requireAuth) {
        if (this.utilisateur === undefined || !newUrl.autoriseRole.includes(this.utilisateur.role)) {
          //console.log('Et non!')
          $location.path('login')
        }
      } else {
        //console.log('cest bon !')
      }
    })
  }
}

export let AuthentifComponent = {
  controller,
  bindings: {
  }
}
