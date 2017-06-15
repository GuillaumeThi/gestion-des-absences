const API_URL_1 = 'http://localhost:8080/sgp/api/departements'
const API_URL_2 = 'http://localhost:8080/sgp/api/collaborateurs'

export class AbsenceService {
  constructor ($http, $q) {
    this.$http = $http
    this.$q = $q
  }


  /*getDepartements () {
    return this.$http.get(API_URL_1)
      .then(response => response.data)
  }

  getCollaborateurs () {
    return this.$http.get(API_URL_2)
      .then(response => response.data)
  }*/
}