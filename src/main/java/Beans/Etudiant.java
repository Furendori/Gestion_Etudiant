package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Etudiant {

    public void affichageEtudiant() {
        try {
            //étape 1: charger la classe de driver
            Class.forName("org.postgresql.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/gestion_Etudiant", "postgres", "Kara59");
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM etudiant");
            //étape 4: exécuter la requête
            while (res.next())
                System.out.println("L'id de l'étudiant : "+res.getInt(1) +  " Le nom de l'étudiant est :  "+ res.getString(2) + " Le prenom de l'étudiant est :  " + res.getString(3) +
                        "   "+ res.getInt(4)
                );
            //étape 5: fermez l'objet de connexion
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
