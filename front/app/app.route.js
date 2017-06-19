export function route ($routeProvider, $locationProvider) {
  $locationProvider.html5Mode(true)

  $routeProvider
    .when('/', {
      template: '<header><menu></menu></header> <accueil></accueil>',
      requireAuth: true,
      autoriseRole: ['MANAGER', 'ADMIN', 'COLLABORATEUR']
    })
    .when('/planning', {
      template: '<header><menu></menu></header> <planning></planning>',
      requireAuth: true,
      autoriseRole: ['MANAGER', 'ADMIN', 'COLLABORATEUR']
    })
    .when('/modalContent.html', {
      templateUrl: '../modalContent.html'
    })
    .when('/login', {
      template: '<login></login>'
    })
    .when('/absences', {
      template: '<header><menu></menu></header> <gda-lister-absences></gda-lister-absences>',
      requireAuth: true,
      autoriseRole: ['MANAGER', 'ADMIN', 'COLLABORATEUR']
    })
    .when('/absences/nouvelle-demande', {
      template: '<header><menu></menu></header> <gda-ajouter-absence></gda-ajouter-absence>',
      requireAuth: true,
      autoriseRole: ['MANAGER', 'ADMIN', 'COLLABORATEUR']
    })
    .otherwise({
      redirectTo: '/'
    })
}
