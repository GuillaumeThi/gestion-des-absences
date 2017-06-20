export class AbsenceService {
	constructor ($http, API_URL, publicPath, LoginService) {
		this.$http = $http
		this.apiUrl = API_URL + publicPath + 'absences'
		this.loginService = LoginService

		this.user = this.loginService.loadCookies()
	}

	listerAbsencesUtilisateurCourant () {

		return this.$http.get(this.apiUrl + "?matricule=" + this.loginService.loadCookies().matriculeCollab)
			.then(response => {
				let donnees = {}
				donnees.absences = response.data.absences.filter(absence => absence.utilisateur.id === this.loginService.getId(this.loginService.loadCookies()))
				donnees.congesPayes = response.data.congesPayes
				donnees.RTT = response.data.RTT
				console.log(donnees)
				return donnees
			})
	}

	listerTypesAbsence () {

		return this.$http.get(this.apiUrl + '/nouvelle-demande')
			.then(response => response.data)
	}

	parser (date) {

		let moisFrancais = ["janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "décembre"]

		return date.dayOfMonth + ' ' + moisFrancais[date.monthValue -1] + ' ' + date.year
	}
}
