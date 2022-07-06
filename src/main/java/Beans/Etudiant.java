package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Etudiant {

    Scanner sc = new Scanner(System.in);

    public void affichageEtudiant() {
        try {
            //étape 1: charger la classe de driver
            Class.forName("org.postgresql.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Gestion_Etudiant", "postgres", "Kara59");
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

            public void CreateTable() {

                try {
                    //étape 1: charger la classe driver
                    Class.forName("org.postgresql.Driver");
                    //étape 2: créer l'objet de connexion
                    Connection conn = DriverManager.getConnection(
                            "jdbc:postgresql://localhost:5432/Gestion_Etudiant", "postgres", "Kara59");
                    //étape 3: créer l'objet statement
                    Statement stmt = conn.createStatement();
                    //étape 4: exécuter la requéte
                    String sql = "CREATE TABLE etudiant2 " +
                            "(numEtud NUMERIC not NULL, " +
                            " nomEtud VARCHAR(50), " +
                            " prenomEtud VARCHAR(50), " +
                            " filiereEtud NUMERIC not null);";
                    stmt.executeUpdate(sql);
                    //étape 5: fermez l'objet de connexion
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

    public void AjoutEtudiant() {
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

            String sql = "INSERT INTO etudiant2 " +
                    "VALUES (1, 'Grande', 'Ariana', '1')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO etudiant2 " +
                    "VALUES (2, 'Smith', 'Will', '1')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO etudiant2 " +
                    "VALUES (3, 'Black', 'Jack', '1')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO etudiant2 " +
                    "VALUES (4, 'Brasseur', 'Julian', '1')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO etudiant2 " +
                    "VALUES (5, 'Delecroix', 'Alexis', '2')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO etudiant2 " +
                    "VALUES (6, 'Grande', 'Sylvain', '2')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO etudiant2 " +
                    "VALUES (7, 'Riessfeld', 'Julis-Alexia', '2')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO etudiant2 " +
                    "VALUES (8, 'Rollins', 'Seth', '2')";
            stmt.executeUpdate(sql);


            System.out.println("Données insérés dans la table...");
            //étape 5: fermez l'objet de connexion
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }





}
