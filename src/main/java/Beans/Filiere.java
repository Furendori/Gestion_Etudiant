package Beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public class Filiere {

    public static String getDBInfo(String s) {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            if (prop.getProperty(s) == null) {System.out.println("La valeur " + s + " n'existe pas !");}
            return prop.getProperty(s);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    Scanner sc = new Scanner(System.in);

    public void CreateTableFiliere() {

        try {
            //étape 1: charger la classe driver
            Class.forName("org.postgresql.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    Objects.requireNonNull(getDBInfo("DB_URL")),
                    Objects.requireNonNull(getDBInfo("DB_USER")),
                    Objects.requireNonNull(getDBInfo("DB_PASSWORD")));
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            //étape 4: exécuter la requéte
            String sql = "CREATE TABLE IF NOT EXISTS Filiere2 "  +
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
                    Objects.requireNonNull(getDBInfo("DB_URL")),
                    Objects.requireNonNull(getDBInfo("DB_USER")),
                    Objects.requireNonNull(getDBInfo("DB_PASSWORD")));
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
                    Objects.requireNonNull(getDBInfo("DB_URL")),
                    Objects.requireNonNull(getDBInfo("DB_USER")),
                    Objects.requireNonNull(getDBInfo("DB_PASSWORD")));
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


    public void AjoutFilièretSaisie() {
        try {
            //étape 1: charger la classe driver
            Class.forName("org.postgresql.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    Objects.requireNonNull(getDBInfo("DB_URL")),
                    Objects.requireNonNull(getDBInfo("DB_USER")),
                    Objects.requireNonNull(getDBInfo("DB_PASSWORD")));
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
                    "VALUES (" + id_Filiere + "  , '" + nomFiliere + "')";
            stmt.executeUpdate(sql);


            System.out.println("Données insérés dans la table...");
            //étape 5: fermez l'objet de connexion
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void suppressionFiliere() {
        try {
            //étape 1: charger la classe de driver
            Class.forName("org.postgresql.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    Objects.requireNonNull(getDBInfo("DB_URL")),
                    Objects.requireNonNull(getDBInfo("DB_USER")),
                    Objects.requireNonNull(getDBInfo("DB_PASSWORD")));
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            //étape 4: exécuter la requête
            System.out.println("Choisissez l'id de la filière que vous voulez supprimer");
            int id = sc.nextInt();
            String sql = "DELETE FROM filiere2 WHERE numfiliere =" +
                    "(" + id + ")";
            stmt.executeUpdate(sql);
            System.out.println("Données supprimées de la table...");
            //étape 5: fermez l'objet de connexion
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
        }



