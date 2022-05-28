


import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;

/**
 * @author Fontchastick
 * warum column name
 */

public class Main {
    @PersistenceUnit
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    @PersistenceContext
    static EntityManager em;

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public static void main(String[] args) {
        showMenu();
    }


    @Transactional
    public static <T> void dateiEinfuegen(T object) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.close();
    }
    public static Entitaet getDatei(Long id, int type) {
        EntityManager em = getEntityManager();
        Entitaet datei = null;
        switch (type) {
            case 1:
                datei = em.find(Spiel.class, id);
                break;
            case 2:
                datei = em.find(Stadion.class, id);
                break;
            case 3:
                datei = em.find(Zuschauer.class, id);
                break;
            case 4:
                datei = em.find(Verein.class, id);
                break;
            case 5:
                datei = em.find(Spieler.class, id);
                break;
            case 6:
                datei = em.find(Staff.class, id);
                break;
            case 7:
                datei = em.find(Spiel.class, id);
                break;
        }
        if (datei != null) {
            datei.getClass().getDeclaredFields();
        }
        return datei;
    }
    public static <T> void dateiLöschen(T object) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(object) ? object : em.merge(object));
        em.getTransaction().commit();
        em.close();
    }
    public static <T> void dateiändern(long id,  int type) {
        Entitaet newObj = getDatei(id, type);
        if(newObj == null){
            System.out.println("Es wurde keine Datei mit der Id "+ id +" gefunden!");
        }else{
            dateiLöschen(newObj);
            em = getEntityManager();
            em.getTransaction().begin();

            em.merge(newObj.modifyData());
            em.getTransaction().commit();
        }

    }
    private static void showMenu() {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        do {
            System.out.println("\nWas möchten sie tun? \n 1. Dateien Anzeigen \n 2. Dateien Einfügen \n 3. Dateien Löschen \n 4. Dateien ändern ");
            int actionNummer = scan.nextInt();  // Read user input
            System.out.println("\nAuf welche Tabelle? \n 1. Spiel \n 2. Stadion \n 3. Zuschauer \n 4. Verein \n 5. Spieler \n 6. Staff");
            int tabelleNummer = scan.nextInt();  // Read user input
            Entitaet entity = null;
            switch (tabelleNummer) {
                case 1:
                    entity = new Spiel();
                    break;
                case 2:
                    entity = new Stadion();
                    break;
                case 3:
                    entity = new Zuschauer();
                    break;
                case 4:
                    entity = new Verein();
                    break;
                case 5:
                    entity = new Spieler();
                    break;
                case 6:
                    entity = new Staff();
                    break;
            }
            Entitaet datei;
            switch (actionNummer) {
                case 1:
                    System.out.println("Geben sie der Datei id ein");
                    long id = scan.nextLong();  // Read user input
                    datei =  getDatei(id, tabelleNummer);
                    if(datei != null){
                        datei.describeSelf();
                    }else{
                        System.out.println("Es gibt keine Daten!\n");
                    }

                    break;
                case 2:
                    datei = entity.createInstance();
                    dateiEinfuegen(datei);
                    break;
                case 3:
                    System.out.println("Geben sie der Datei id ein");
                    long id2 = scan.nextLong();  // Read user input
                    datei = getDatei(id2, tabelleNummer);
                    if(datei != null){
                        dateiLöschen(datei);
                    }else{
                        System.out.println("Es wurde keine Datei mit der " + id2 +" gefunden!");
                    }

                    break;
                case 4:
                    System.out.println("Geben sie der Datei id ein");
                    long id3 = scan.nextLong();  // Read user input
                    dateiändern(id3, tabelleNummer);
                    break;
            }
        } while (true);
    }


}