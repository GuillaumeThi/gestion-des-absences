import template from './lister-absences.component.html'

class controller {

    constructor(AbsenceService, $location, $scope) {
        this.AbsenceService = AbsenceService
        this.$location = $location
        this.$scope = $scope
    }

    $onInit () {

        this.AbsenceService.listerAbsences()
            .then(absences => this.absences = absences)
    }

}

export let ListerAbsencesComponent = {
    controller,
    template,
    bindings: {
        absences: '<',
    }
}

