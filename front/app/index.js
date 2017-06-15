
import angular from 'angular'
import RouteModule from 'angular-route'
import 'bootstrap/dist/css/bootstrap.css'
import { route } from './app.route'
import { AccueilComponent } from './accueil/accueil.component'
import { LoginComponent } from './login/login.view'
import { PlanningComponent } from './planning/planning.component'
import { ModalComponent } from './modal/modal.component'

//import { UtilisateursService } from './service/utilisateur.service'
import { EventService } from './event.service'
import 'angular-ui-bootstrap'
import 'angular-bootstrap-calendar'
import 'angular-bootstrap-calendar/dist/css/angular-bootstrap-calendar.min.css'
import { moment } from 'moment'

angular.module('app', [RouteModule, 'mwl.calendar', 'ui.bootstrap'])
.value('API_URL', API_URL)
.value('moment', moment)
//.service('UtilisateursService', UtilisateursService)
.service('EventService', EventService)


// import { u1 } from 'angular-bootstrap-calendar'
// import { u2 } from 'angular-ui-bootstrap'
//import {moment} from 'moment'
// import { u3 } from 'mwl.calendar'
// import { u4 } from 'ngAnimate'
// import { u5 } from 'ui-bootstrap'
//, 'mwl.calendar', 'ui.bootstrap', 'ngRoute', 'ngCookies'
angular.module('app', [RouteModule]) //, [require('angular-bootstrap-calendar'), require('angular-ui-bootstrap')], ['mwl.calendar', 'ngAnimate', 'ui.bootstrap', 'colorpicker.module']
//.value('API_URL', API_URL)
//.value('moment', moment)

.component('accueil', AccueilComponent)
.component('planning', PlanningComponent)
.component('modal', ModalComponent)
.component('login', LoginComponent)
.config(route)
//.run(run)
/*.config(route, ['calendarConfig', function (calendarConfig) {
  console.log(calendarConfig)
  calendarConfig.templates.calendarMonthView = 'path/to/custom/template.html'
  calendarConfig.dateFormatter = 'moment'
  calendarConfig.allDateFormats.moment.date.hour = 'HH:mm'
  calendarConfig.allDateFormats.moment.title.day = 'ddd D MMM'
  calendarConfig.i18nStrings.weekNumber = 'Week {week}'
  calendarConfig.displayAllMonthEvents = true
  calendarConfig.showTimesOnWeekView = true
}])
.controller('KitchenSinkCtrl', function (moment, alert, calendarConfig, EventService) {
  var vm = this

    // These variables MUST be set as a minimum for the calendar to work
  vm.calendarView = 'month'
  vm.viewDate = new Date()

  vm.events = []

  EventService.getjourFeries().then(jourFeries => {
    jourFeries.forEach(unJourFerie => {
      if (unJourFerie.type === 'RTT_EMPLOYEUR') {
        vm.events.push({
          title: unJourFerie.type,
          startsAt: moment(unJourFerie.date, 'DD-MM-YYYY'),
          endsAt: moment(unJourFerie.date, 'DD-MM-YYYY'),
          color: calendarConfig.colorTypes.important,
          draggable: false,
          resizable: false
        })
      }
      if (unJourFerie.type === 'FERIE') {
        vm.events.push({
          title: unJourFerie.type,
          startsAt: moment(unJourFerie.date, 'DD-MM-YYYY'),
          endsAt: moment(unJourFerie.date, 'DD-MM-YYYY'),
          color: calendarConfig.colorTypes.sucess,
          draggable: false,
          resizable: false
        })
      }
    })
  })
  EventService.getAbs().then(absences => {
    absences.forEach(uneAbs => {
      if (uneAbs.utilisateur.id === 1) { // modifié 1 par l'id récupérer du cookie authentif
        switch (uneAbs.type) {
          case 'RTT':
            vm.events.push({
              title: uneAbs.type,
              startsAt: moment(uneAbs.dateDebut, 'DD-MM-YYYY'),
              endsAt: moment(uneAbs.dateFin, 'DD-MM-YYYY'),
              color: calendarConfig.colorTypes.special,
              draggable: false,
              resizable: false
            })
            break
          case 'CONGE_PAYE':
            vm.events.push({
              title: uneAbs.type,
              startsAt: moment(uneAbs.dateDebut, 'DD-MM-YYYY'),
              endsAt: moment(uneAbs.dateFin, 'DD-MM-YYYY'),
              color: calendarConfig.colorTypes.warning,
              draggable: false,
              resizable: false
            })
            break
          case 'CONGE_SANS_SOLDE':
            vm.events.push({
              title: uneAbs.type + ' motif: ' + uneAbs.motif,
              startsAt: moment(uneAbs.dateDebut, 'DD-MM-YYYY'),
              endsAt: moment(uneAbs.dateFin, 'DD-MM-YYYY'),
              color: calendarConfig.colorTypes.info,
              draggable: false,
              resizable: false
            })
            break
        }
      }
    })
  })

  // title =  EventService.getjourFeries()[i].type
  // startAt= EventService.getjourFeries().get(i).date
  // endsAt= EventService.getjourFeries().get(i).date

  vm.cellIsOpen = false

  vm.addEvent = function () {
    vm.events.push({
      title: 'New event',
      startsAt: moment().startOf('day').toDate(),
      endsAt: moment().endOf('day').toDate(),
      color: calendarConfig.colorTypes.important,
      draggable: true,
      resizable: true
    })
  }

  vm.eventClicked = function (event) {
    alert.show('Clicked', event)
  }

  vm.eventEdited = function (event) {
    alert.show('Edited', event)
  }

  vm.eventDeleted = function (event) {
    alert.show('Deleted', event)
  }

  vm.eventTimesChanged = function (event) {
    alert.show('Dropped or resized', event)
  }

  vm.toggle = function ($event, field, event) {
    $event.preventDefault()
    $event.stopPropagation()
    event[field] = !event[field]
  }

  vm.timespanClicked = function (date, cell) {
    if (vm.calendarView === 'month') {
      if ((vm.cellIsOpen && moment(date).startOf('day').isSame(moment(vm.viewDate).startOf('day'))) || cell.events.length === 0 || !cell.inMonth) {
        vm.cellIsOpen = false
      } else {
        vm.cellIsOpen = true
        vm.viewDate = date
      }
    } else if (vm.calendarView === 'year') {
      if ((vm.cellIsOpen && moment(date).startOf('month').isSame(moment(vm.viewDate).startOf('month'))) || cell.events.length === 0) {
        vm.cellIsOpen = false
      } else {
        vm.cellIsOpen = true
        vm.viewDate = date
      }
    }
  }
})
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



*/



