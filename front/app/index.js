import angular from 'angular'
import RouteModule from 'angular-route'
import 'bootstrap/dist/css/bootstrap.css'
import 'angular-ui-bootstrap'
import 'angular-bootstrap-calendar'
import 'angular-bootstrap-calendar/dist/css/angular-bootstrap-calendar.min.css'

import { route } from './app.route'

import { AccueilComponent } from './accueil/accueil.component'
import { LoginComponent } from './login/login.view'
import { PlanningComponent } from './planning/planning.component'
import { ModalComponent } from './modal/modal.component'
import { MenuComponent } from './menu/menu.component'
import { ListerAbsencesComponent } from './absence/lister-absences.component'
import { AjouterAbsenceComponent } from './absence/ajouter-absence.component'

import { planning } from './planning.controller'

import { EventService } from './event.service'
import { AbsenceService } from './service/absence.service'

import { moment } from 'moment'

angular.module('app', [RouteModule, 'mwl.calendar' , 'ui.bootstrap'])

.value('API_URL', API_URL)
.value('moment', moment)

.service('EventService', EventService)
.service('AbsenceService', AbsenceService)

.component('menu', MenuComponent)
.component('accueil', AccueilComponent)
.component('planning', PlanningComponent)
.component('modal', ModalComponent)
.component('login', LoginComponent)
.component('gdaListerAbsences', ListerAbsencesComponent)
.component('gdaAjouterAbsence', AjouterAbsenceComponent)

.config(route, ['calendarConfig', function (calendarConfig) {
  console.log(calendarConfig)
  calendarConfig.templates.calendarMonthView = 'path/to/custom/template.html'
  calendarConfig.dateFormatter = 'moment'
  calendarConfig.allDateFormats.moment.date.hour = 'HH:mm'
  calendarConfig.allDateFormats.moment.title.day = 'ddd D MMM'
  calendarConfig.i18nStrings.weekNumber = 'Week {week}'
  calendarConfig.displayAllMonthEvents = true
  calendarConfig.showTimesOnWeekView = true
}])

.controller('KitchenSinkCtrl', planning)

.factory('alert', function ($uibModal) {
  function show (action, event) {
    return $uibModal.open({
      template: '<modal></modal>',
      controller: function () {
        var vm = this
        vm.action = action
        vm.event = event
      },
      controllerAs: 'vm'
    })
  }
  return {
    show: show
  }
})