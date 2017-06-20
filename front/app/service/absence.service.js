export class AbsenceService {
  constructor ($http, API_URL, publicPath, LoginService) {
    this.$http = $http
    this.apiUrl = API_URL + publicPath + 'absences'
    this.loginService = LoginService

    this.user = this.loginService.loadCookies()
  }

  listerAbsencesUtilisateurCourant () {

    let absences = this.$http.get(this.apiUrl + "?matricule=" + this.user.matriculeCollab)
      .then(response => {
      	return response.data.absences
      		.filter(absence => absence.utilisateur.id === this.loginService.getId(this.user))
      		/*.map(absence => {
      			absence.dateDebut = toLongFrenchFormat(absence.dateDebut)
      			absence.dateFin = toLongFrenchFormat(absence.dateFin)
      			return absence
      		})*/
      })

      return absences;
  }

  getCompteurCongesPayes () {
  	return this.$http.get(this.apiUrl + "?matricule=" + this.user.matriculeCollab)
  	.then(response => response.data.congesPayes)
  }

  getCompteurRTT () {
  	return this.$http.get(this.apiUrl + "?matricule=" + this.user.matriculeCollab)
  	.then(response => response.data.RTT)
  }

  listerTypesAbsence () {
    return this.$http.get(this.apiUrl + '/nouvelle-demande')
      .then(response => response.data)
  }

  parser (date) {
    return date.dayOfMonth + ' ' + date.month + ' ' + date.year
  }
}
