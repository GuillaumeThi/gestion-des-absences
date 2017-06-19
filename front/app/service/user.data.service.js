export class UserService {
  constructor () {
    this.utilisateur={}
  }


  getUtilisateur () {
    return this.utilisateur
  }

  setUtilisateur (utilisateur) {
    this.utilisateur=utilisateur
  }
}