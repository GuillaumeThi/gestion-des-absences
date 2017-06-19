export function route ($routeProvider, $locationProvider) {
  $locationProvider.html5Mode(true)

  $routeProvider
    .when('/', {
      template: '<accueil></accueil>',
      requireAuth: true,
      autoriseRole: ['MANAGER', 'ADMIN', 'COLLABORATEUR']
    })
    .when('/planning', {
      template: '<planning></planning>',
      requireAuth: true,
      autoriseRole: ['MANAGER', 'ADMIN', 'COLLABORATEUR']
    })
    .when('/modalContent.html', {
      templateUrl: '../modalContent.html',
      requireAuth: true,
      autoriseRole: ['MANAGER', 'ADMIN', 'COLLABORATEUR']
    })
    .when('/login', {
      template: '<login></login>'

    })
    .when('/absences', {
      template: '<gda-lister-absences></gda-lister-absences>'
    })
    .when('/absences/nouvelle-demande', {
      template: '<gda-ajouter-absence></gda-ajouter-absence>',
      requireAuth: true,
      autoriseRole: ['MANAGER', 'ADMIN', 'COLLABORATEUR']
    })
    .otherwise({
      redirectTo: '/login'
    })
}
