export class AbsenceService {
  constructor ($http, API_URL) {
    this.$http = $http
    this.apiUrl = API_URL + "/absences"
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