export class AbsenceService {
  constructor ($http, API_URL, publicPath) {
    this.$http = $http
    this.apiUrl = API_URL + publicPath + "absences"
  }

  listerAbsences () {
    return this.$http.get(this.apiUrl)
      .then(response => response.data)
  }

  listerTypesAbsence () {
    return this.$http.get(this.apiUrl + "/nouvelle-demande")
      .then(response => response.data)
  }
}