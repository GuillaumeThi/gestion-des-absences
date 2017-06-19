export class AbsenceService {
  constructor ($http, API_URL, publicPath, LoginService) {
    this.$http = $http
    this.apiUrl = API_URL + publicPath + 'absences'
    this.loginService = LoginService
  }

  listerAbsencesUtilisateurCourant () {

  	let user = this.loginService.loadCookies()
    let absences = this.$http.get(this.apiUrl + "?matricule=" + user.matriculeCollab)
      .then(response => {
      	console.log(response.data)
      	return response.data.absences.filter(absence => absence.utilisateur.id === this.loginService.getId(user))
      })

      return absences;
  }

/*  getCompteursConges () {
  	return this.$http.get(this.apiUrl + "/compteur?matricule=" + this.LoginService.loadCookies().matriculeCollab)
  	.then(response => response.data)
  }*/

  listerTypesAbsence () {
    return this.$http.get(this.apiUrl + '/nouvelle-demande')
      .then(response => response.data)
  }

  parser (date) {
    return date.dayOfMonth + ' ' + date.month + ' ' + date.year
  }
}
