import './validation.component.css'
import template from  './validation.component.html'

class controller{
    constructor (UtilisateurService,LoginService, AbsenceService, $q, API_URL){
        this.UtilisateurService = UtilisateurService
        this.LoginService = LoginService
        this.AbsenceService = AbsenceService
        this.$q = $q
        this.subalternes = ''
        this.path = API_URL + '/validation'
        
    }

    $onInit (){
        console.log(this.path)
       this.UtilisateurService.getListCollaborateur()
        .then(utilisateur => {
            this.utilisateur=utilisateur
        })

       this.UtilisateurService.getSubalternByMatricule(this.LoginService.loadCookies().id)
        .then(subalternes => {
            this.subalternes=subalternes
            for(let indice in this.subalternes){

                this.AbsenceService.listerAbsencesSubalterne(this.subalternes[indice])
                .then(donnees => { 
                    donnees.absences.forEach(absence => {
                    absence.dateDebut = this.AbsenceService.parser(absence.dateDebut)
                    absence.dateFin = this.AbsenceService.parser(absence.dateFin)
                })
                this.donnees = donnees
                }
                
                )
            }
        }
            
        )
    }

}

export let ValidationComponent = {
  template,
  controller,
  bindings: {
    subalternes: '<',
    donnees: '<',
    path: '<'
  }
}