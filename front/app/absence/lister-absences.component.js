import template from './lister-absences.component.html'
import './lister-absences.component.css'

class controller {
    constructor (AbsenceService, $location) {
        this.AbsenceService = AbsenceService
        this.$location = $location
    }

    $onInit () {
        this.AbsenceService.listerAbsencesUtilisateurCourant()
            .then(donnees => { 
                donnees.absences.forEach(absence => {
                    absence.dateDebut = this.AbsenceService.parser(absence.dateDebut)
                    absence.dateFin = this.AbsenceService.parser(absence.dateFin)
                })
                
                return this.donnees = donnees
            })
    }
}

export let ListerAbsencesComponent = {
    controller,
    template,
    bindings: {
        donnees: '<'
    }
}
