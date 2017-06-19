export class AbsenceService {
  constructor ($http, API_URL, publicPath, LoginService) {
    this.$http = $http
    this.apiUrl = API_URL + publicPath + 'absences'
    this.loginService = LoginService
  }

  listerAbsencesUtilisateurCourant () {
    let absences = this.$http.get(this.apiUrl)
      .then(response => {
        return response.data.filter(absence => absence.utilisateur.id === this.loginService.getId(this.loginService.loadCookies()))
      })

    console.log(absences)
    return absences
  }
  listerTypesAbsence () {
    return this.$http.get(this.apiUrl + '/nouvelle-demande')
      .then(response => response.data)
  }

  parser (date) {
    return date.dayOfMonth + ' ' + date.month + ' ' + date.year
  }
}
