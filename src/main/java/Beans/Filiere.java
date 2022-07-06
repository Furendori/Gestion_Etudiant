package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Filiere {


    Scanner sc = new Scanner(System.in);

    public void CreateTableFiliere() {

        try {
            //étape 1: charger la classe driver
            Class.forName("org.postgresql.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Gestion_Etudiant", "postgres", "Kara59");
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            //étape 4: exécuter la requéte
            String sql = "CREATE TABLE Filiere2 " +
                    "(numFiliere NUMERIC not NULL, " +
                    " nomFiliere VARCHAR(50));";
            stmt.executeUpdate(sql);
            //étape 5: fermez l'objet de connexion
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void affichageFilière() {
        try {
            //étape 1: charger la classe de driver
            Class.forName("org.postgresql.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Gestion_Etudiant", "postgres", "Kara59");
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Filiere2");
            //étape 4: exécuter la requête
            while (res.next())
                System.out.println("L'id de la filière : "+res.getInt(1) +  " Le nom de la filière est :  "+ res.getString(2)
                );
            //étape 5: fermez l'objet de connexion
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void AjoutFilière() {
        try {
            //étape 1: charger la classe driver
            Class.forName("org.postgresql.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Gestion_Etudiant", "postgres", "Kara59");
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            //étape 4: exécuter la requête
            System.out.println("Insertion...");
            String sql = "INSERT INTO Filiere2 " +
                    "VALUES (1 , 'Electronique')";
            stmt.executeUpdate(sql);
             sql = "INSERT INTO Filiere2 " +
                    "VALUES (2 , 'Informatique')";
            stmt.executeUpdate(sql);
            System.out.println("Données insérés dans la table...");
            //étape 5: fermez l'objet de connexion
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void AjoutFilièretSaisie(){
        try {
            //étape 1: charger la classe driver
            Class.forName("org.postgresql.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Gestion_Etudiant", "postgres", "Kara59");
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            //étape 4: exécuter la requête

            int id_Filiere;
            String nomFiliere;

            System.out.println("Choisissez un id");
            id_Filiere = sc.nextInt();
            sc.nextLine();
            System.out.println("Choissisez un nom pour la filière");
            nomFiliere = sc.nextLine();


            String sql = "INSERT INTO Filiere2 " +
                    "VALUES ("+id_Filiere+"  , '"+nomFiliere+"')";
            stmt.executeUpdate(sql);


            System.out.println("Données insérés dans la table...");
            //étape 5: fermez l'objet de connexion
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
