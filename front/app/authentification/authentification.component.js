
class controller {
  constructor (LoginService, $location, $scope) {
    console.log('constructor')
    this.LoginService = LoginService
    this.$location = $location

    $scope.$on('$routeChangeStart', (angularEvent, newUrl) => {
      let utilisateur = this.LoginService.LoadCookie()
      console.log('authentif utilisateur', utilisateur)
      if (newUrl.requireAuth) {
        if (utilisateur === undefined || !newUrl.autoriseRole.includes(utilisateur.type)) {
          console.log('nope!')
          $location.path('login')
        }
      } else {
        console.log('free')
      }
    })
  }
}

export let AuthentifComponent = {
  controller,
  bindings: {
  }
}
