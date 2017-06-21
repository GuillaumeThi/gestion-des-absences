export class UtilisateurService{
    constructor (API_URL,$http){
        this.API_URL_Collab = API_URL + '/collaborateurs'
        this.API_URL_User = API_URL + '/utilisateurs'
        this.$http = $http
    }
    //Renvoie la list des collaborateurs (Base JSON)
    getListCollaborateur () {
       return this.$http.get(this.API_URL_Collab)
        .then(response => response.data)
    }

    /**
     * Renvoi une liste de matricule des subalternes du manager
     * passé en paramètre
     * 
     * @param {String} matriculeManager
     * @return {String Array} 
     */
    getSubalternByMatricule(matriculeManager){
        return this.$http.get(this.API_URL_Collab+'/subalternes/'+matriculeManager)
        .then(response => response.data)
    }

    /**
     * Renvoi l'utilisateur qui possède le matricule passé
     * en paramètre
     * 
     * @param {String} matriculeUtilisateur 
     */
    getUtilisateurByMatricule(matriculeUtilisateur){
        let utilisateur = this.$http.get(this.API_URL_User)
        .then(response => {
            return response.data.filter(utilisateur => utilisateur.matriculeCollab === matriculeUtilisateur)
      })
      
      return utilisateur

    }
}