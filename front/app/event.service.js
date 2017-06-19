const API_URL = 'http://localhost:8080/gestion-des-absences/jourFerie'
const API_URL2 = 'http://localhost:8080/gestion-des-absences/absences'
export class EventService {
  constructor ($http, $q) {
    this.$http = $http
    this.$q = $q
    this.jourFeries = []
    this.absences = []
  }

    // return promise of jourFeries
  getjourFeries () {
    if (this.jourFeries.length !== 0) {
      return this.$q.resolve(this.jourFeries)
    }

    return this.$http.get(API_URL)
        .then(response => response.data)
  }
  // return promise of absences
  getAbs () {
    if (this.absences.length !== 0) {
      return this.$q.resolve(this.absences)
    }

    return this.$http.get(API_URL2)
        .then(response => response.data)
  }
}
