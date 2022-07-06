import Beans.Etudiant;
import Beans.Filiere;

public class main {
    public static void main(String[] args) {

        Etudiant etude = new Etudiant();
        Filiere filiere = new Filiere();

//        etude.affichageEtudiant();
//        filiere.affichageFilière();
        etude.AjoutEtudiantSaisie();
//        etude.CreateTable();
    }
}
