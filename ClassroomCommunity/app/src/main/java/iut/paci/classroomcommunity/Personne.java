package iut.paci.classroomcommunity;

import java.util.ArrayList;

/**
 * Created by julie on 22/02/2018.
 */

public class Personne {

    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private ArrayList<Personne> amis = new ArrayList<Personne>() ;
    private static ArrayList<Personne> personnes = new ArrayList<Personne>();

    public Personne(String nom, String prenom, String login, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public ArrayList<Personne> getAmis() {
        return amis;
    }

    public void setAmis(ArrayList<Personne> amis) {
        this.amis = amis;
    }

    public static ArrayList<Personne> getPersonnes() {
        return personnes;
    }

    public static void setPersonnes(ArrayList<Personne> personnes) {
        Personne.personnes = personnes;
    }

    public static void addPersonne(){
        personnes.add(new Personne("Duboit", "Quentin", "dquentin", "azerty"));
        personnes.add(new Personne("Bellard", "Timothé", "btimy", "azerty"));
        personnes.add(new Personne("Manart", "Lucie", "mlucie", "azerty"));
        personnes.add(new Personne("Courgette", "Patate", "cpatate", "azerty"));

    }
}
