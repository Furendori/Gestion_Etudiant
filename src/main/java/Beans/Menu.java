package Beans;

import java.util.Scanner;

public class Menu {

    Etudiant etude = new Etudiant();
    Filiere filiere = new Filiere();
    public void menuAffiche() {
        int choix;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("**********************************************************************************************");
            System.out.println("*                  Bonjour,                                                                  *");
            System.out.println("*                                                                                            *");
            System.out.println("*  Tapez 1 :  Création des tables étudiants et filières.                                     *");
            System.out.println("*                                                                                            *");
            System.out.println("*  Tapez 2 :  Ajouts de 8 étudiants, et de 2 filières.                                       *");
            System.out.println("*                                                                                            *");
            System.out.println("*  Tapez 3 :  Affichage des étudiants, et des filières.                                      *");
            System.out.println("*                                                                                            *");
            System.out.println("*  Tapez 4 :  Ajouts d'un nouvelle étudiants en entrant ses informations.                    *");
            System.out.println("*                                                                                            *");
            System.out.println("*  Tapez 5 :  Ajouts d'une nouvelle filière en entrant ses informations                      *");
            System.out.println("*                                                                                            *");
            System.out.println("*  Tapez 6 :  Modifier un étudiant                                                           *");
            System.out.println("*                                                                                            *");
            System.out.println("*  Tapez 7 :  Suppression d'un étudiant                                                      *");
            System.out.println("*                                                                                            *");
            System.out.println("*  Tapez 8 :  Suppression d'une filière                                                      *");
            System.out.println("*                                                                                            *");
            System.out.println("*  Tapez 9 : Quitter le programme                                                            *");
            System.out.println("*                                                                                            *");
            System.out.println("**********************************************************************************************");
            System.out.println("Entre votre choix ?");
            choix = sc.nextInt();
            switch (choix) {
                case 1:
                    etude.CreateTable();
                    filiere.CreateTableFiliere();
                    break;
                case 2:
                    etude.AjoutEtudiant();
                    filiere.AjoutFiliere();
                    break;
                case 3:
                    etude.affichageEtudiant();
                    filiere.affichageFiliere();
                    break;
                case 4:
                    etude.AjoutEtudiantSaisie();
                    break;
                case 5:
                    filiere.AjoutFilieretSaisie();
                    break;
                case 6:
                    etude.ModifierEtudiant();
                    break;
                case 7:
                    etude.suppressionEtudiant();
                    break;
                case 8:
                    filiere.suppressionFiliere();
            }
        } while(choix != 9);





    }
}
