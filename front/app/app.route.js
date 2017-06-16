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
    .when('/login', {
    template: '<login></login>'
    })
    .when('/absences', {
      template: '<gda-lister-absences></gda-lister-absences>'
    })
    .when('/absences/nouvelle-demande', {
      template: '<gda-ajouter-absence></gda-ajouter-absence>'
    })
    .otherwise({
      redirectTo: '/'
    })
}

