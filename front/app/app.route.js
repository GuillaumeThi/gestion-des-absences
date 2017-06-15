export function route ($routeProvider, $locationProvider) {
  $locationProvider.html5Mode(true)

  $routeProvider
    .when('/', {
      template: '<accueil></accueil>'
    })
    .when('/planning', {
      template: '<planning></planning>'
    })
    .when('/modalContent.html', {
      templateUrl: '../modalContent.html'
    })
    .otherwise({

      redirectTo: '/'
    })
}
