package laboratoire_4_2;

import laboratoire_4_2.Tour;

public class ToursHanoi {
    private int nbAnneaux;
    private int nbDeplacements;

    private Tour[] tours = new Tour[3];

    public ToursHanoi(int nbAnneaux) {
        tours[0] = new Tour(nbAnneaux, 'A');
        tours[1] = new Tour(nbAnneaux, 'B');
        tours[2] = new Tour(nbAnneaux, 'C');
        reinitialiser(nbAnneaux);
    }

    public void resoudre() {
        this.nbDeplacements = 0;
        deplacer(this.nbAnneaux, 'A', 'B', 'C');
    }

    private void deplacer(int disque, char de, char inter, char vers) {
        if (disque == 1) // disque 1: disque le plus petit: cas de base
        {
            this.nbDeplacements++;
            System.out.println("Déplacement #" + this.nbDeplacements + ": du disque 1 de " + de + " vers " + vers);
        } else {
            deplacer(disque - 1, de, vers, inter);
            this.nbDeplacements++;
            System.out.println(
                    "Déplacement #" + this.nbDeplacements + ": du disque " + disque + " de " + de + " vers " + vers);
            deplacer(disque - 1, inter, de, vers);
        }
    }

    public void afficherTours(Tour tour) {
        System.out.println(tour.getNomTour());
        System.out.println("-------");
        for (int i = 0; i < tour.getTableau().length; i++) {
            if (tour.getTableau()[i] == null) {
                System.out.println("-");
            } else {
                System.out.println(tour.getTableau()[i].getDiametre());
            }
            System.out.println("-------");
        }
        System.out.println("\n");
    }

    public void reinitialiser(int nbAnneaux) {
        tours[0].clear();
        tours[1].clear();
        tours[2].clear();
        for (int i = 0; i < nbAnneaux; i++) {
            tours[0].getTableau()[i] = new Anneau(i + 1);
        }
        System.out.println("------------------------Les tours--------------------------\n");
        afficherTours(tours[0]);
        afficherTours(tours[1]);
        afficherTours(tours[2]);
        System.out.println("-----------------------------------------------------------\n");
    }
}
