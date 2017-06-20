import template from './ajouter-absence.component.html'

class controller {
  constructor (AbsenceService, $location, $scope) {
    this.AbsenceService = AbsenceService
    this.$location = $location
    this.$scope = $scope
  }

  $onInit () {
    this.AbsenceService.listerTypesAbsence()
            .then(types => this.types = types)
  }
}

export let AjouterAbsenceComponent = {
  controller,
  template,
  bindings: {
    types: '<'
  }
}
