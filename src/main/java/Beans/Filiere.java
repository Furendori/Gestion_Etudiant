package Beans;

public class Filiere {

    private int id_Filiere;
    private String nom_Filiere;


    public Filiere(int id_Filiere, String nom_Filiere) {
        this.id_Filiere = id_Filiere;
        this.nom_Filiere = nom_Filiere;
    }

    public int getId_Filiere() {
        return id_Filiere;
    }

    public void setId_Filiere(int id_Filiere) {
        this.id_Filiere = id_Filiere;
    }

    public String getNom_Filiere() {
        return nom_Filiere;
    }

    public void setNom_Filiere(String nom_Filiere) {
        this.nom_Filiere = nom_Filiere;
    }
}
