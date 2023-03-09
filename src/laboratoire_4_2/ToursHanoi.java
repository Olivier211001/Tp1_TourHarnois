package laboratoire_4_2;

import laboratoire_4_2.Tour;

public class ToursHanoi {
    private int nbAnneaux;

    private Tour[] tours = new Tour[3];

    public ToursHanoi(int nbAnneaux) {
        tours[0] = new Tour(nbAnneaux, 'A');
        tours[1] = new Tour(nbAnneaux, 'B');
        tours[2] = new Tour(nbAnneaux, 'C');
        reinitialiser(nbAnneaux);
    }

    public void resoudre() {
        reinitialiser(nbAnneaux);
        // deplacer('A', 'B', 'C');
    }

    public void deplacer(char de, char vers) {
        int peekDe = findPeek(findIndex(de));
        tours[findIndex(de)].pop();
        tours[findIndex(vers)].push(peekDe);
        afficherTours(tours[0]);
        afficherTours(tours[1]);
        afficherTours(tours[2]);
    }

    public void afficherTours(Tour tour) {
        System.out.println(tour.getNomTour());
        System.out.println("-------");
        for (int i = tour.getTableau().length; i > 0; i--) {
            if (tour.getTableau()[i - 1] == null) {
                System.out.println("-");
            } else {
                System.out.println(tour.getTableau()[i - 1].getDiametre());
            }
            System.out.println("-------");
        }
        System.out.println("\n");
    }

    public void deplacerAuto() {

    }

    public int findIndex(char c) {
        System.out.println(c);
        if (Character.isLowerCase(c)) {
            c = Character.toUpperCase(c);
        }
        for (int i = 0; i < 3; i++) {
            if (tours[i].getNomTour() == c) {
                return i;
            }
        }
        return 0;
    }

    public int findPeek(int index) {
        return tours[index].peek();
    }

    public void reinitialiser(int nbAnneaux) {
        tours[0].clear();
        tours[1].clear();
        tours[2].clear();
        for (int i = nbAnneaux; i > 0; i--) {
            tours[0].getTableau()[nbAnneaux - i] = new Anneau(i);
        }
        System.out.println("Le jeu a été réinitialisé.");
        System.out.println("------------------------Les tours--------------------------\n");
        afficherTours(tours[0]);
        afficherTours(tours[1]);
        afficherTours(tours[2]);
        System.out.println("-----------------------------------------------------------\n");
    }
}
