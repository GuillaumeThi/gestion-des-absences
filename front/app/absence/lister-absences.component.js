import template from './lister-absences.component.html'
import './lister-absences.component.css'

class controller {
    constructor (AbsenceService, $location) {
        this.AbsenceService = AbsenceService
        this.$location = $location
    }

    $onInit () {
        this.AbsenceService.listerAbsencesUtilisateurCourant()
            .then(absences => { 
                absences.forEach(absence => {
                    absence.dateDebut = this.AbsenceService.parser(absence.dateDebut)
                    absence.dateFin = this.AbsenceService.parser(absence.dateFin)
                })

                return this.absences = absences
            })

        this.AbsenceService.getCompteurCongesPayes()
            .then(congesPayes => this.congesPayes = congesPayes)

        this.AbsenceService.getCompteurRTT()
            .then(RTT => this.RTT = RTT)
    }
}

export let ListerAbsencesComponent = {
    controller,
    template,
    bindings: {
        absences: '<',
        congesPayes: '<',
        RTT: '<'
    }
}
