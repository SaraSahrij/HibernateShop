


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
        // TODO Auto-generated method stub
		/*
		Spiel s = new Spiel(new Date(1234121321321L), new Time(2344L), "robin@gmail.com");
		spielEinfuegen(s);

		Staff s = getDatei(1L);
	    System.out.println(s);
		 */
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
        return datei;
    }

    public static <T> void dateiLöschen(T object) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(object) ? object : em.merge(object));
        em.getTransaction().commit();
        em.close();
    }

    private static void showMenu() {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        do {
            System.out.println("Was möchten sie tun? \n 1. Dateien Anzeigen \n 2. Dateien Einfügen \n 3. Dateien Löschen \n 4. Dateien ändern ");
            int actionNummer = scan.nextInt();  // Read user input
            System.out.println("Auf welche Tabelle? \n 1. Spiel \n 2. Stadion \n 3. Zuschauer \n 4. Verein \n 5. Spieler \n 6. Staff");
            int tabelleNummer = scan.nextInt();  // Read user input
            Entitaet entity = null;
            switch (tabelleNummer) {
                case 1:
                case 7:
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
            switch (actionNummer) {
                case 1:
                    System.out.println("Geben sie der Datei id ein");
                    long id = scan.nextLong();  // Read user input
                    getDatei(id, tabelleNummer).describeSelf();

                    break;
                case 2:
                    Entitaet datei = entity.createInstance();
                    dateiEinfuegen(datei);
                    break;
                case 3:
                    System.out.println("Geben sie der Datei id ein");
                    long id2 = scan.nextLong();  // Read user input
                    dateiLöschen(getDatei(id2, tabelleNummer));
                    break;
                case 4:
                    System.out.println("Geben sie der Datei id ein");
                    long id3 = scan.nextLong();  // Read user input
                    Entitaet neuDatei = entity.createInstance();
                    dateiEinfuegen(neuDatei);

                    break;
            }
        } while (true);
    }


}