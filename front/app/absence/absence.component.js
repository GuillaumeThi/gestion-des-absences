import template from './absence.component.html'

class controller {

    constructor(AbsenceService, $location) {
        this.AbsenceService = AbsenceService
        this.$location = $location
    }

    /*$onInit () {

        this.BankService.getDepartements()
            .then(departements => this.departements = departements)

        this.BankService.getCollaborateurs()
            .then(collaborateurs => this.collaborateurs = collaborateurs)
    }*/

}

export let AbsenceComponent = {
    controller,
    template,
    bindings: {
        //departements: '<',
        //collaborateurs: '<'
    }
}