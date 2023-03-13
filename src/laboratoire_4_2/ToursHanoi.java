package laboratoire_4_2;

import laboratoire_4_2.Tour;

public class ToursHanoi {
    private int nbAnneaux;

    private Tour[] tours = new Tour[3];

    private boolean flagIsUp = false;
    private boolean isPair = false;

    private int count = 0;

    public ToursHanoi(int nbAnneaux) {
        tours[0] = new Tour(nbAnneaux, 'A');
        tours[1] = new Tour(nbAnneaux, 'B');
        tours[2] = new Tour(nbAnneaux, 'C');
        reinitialiser(nbAnneaux);
    }

    public void resoudre() {
        int nb = tours[0].getTableau().length;
        if (nb % 2 == 0) {
            isPair = true;
            deplacerAuto(nb - 1, 'a', 'c', 'b');

        } else {
            isPair = false;
            deplacerAuto(nb - 1, 'a', 'c', 'b');
        }
    }

    public void deplacer(char de, char vers) {
        int peekDe = findPeek(findIndex(de));
        tours[findIndex(de)].pop();
        tours[findIndex(vers)].push(peekDe);
        System.out.println("-----------------------------------------");
        afficherTours(tours[0]);
        afficherTours(tours[1]);
        afficherTours(tours[2]);
    }

    public void afficherTours(Tour tour) {
        System.out.print(tour.getNomTour() + " :");
        for (int i = 0; i < tour.getTableau().length; i++) {
            if (tour.getTableau()[i] == null || tour.getTableau()[i].getDiametre() == -1) {
                System.out.print("-");
            } else {
                System.out.print(tour.getTableau()[i].getDiametre());
            }
        }
        System.out.println("\n");
    }

    // déplacment récursif utilisé par la fonction resoudre()
    public void deplacerAuto(int n, char de, char entre, char vers) {
        if (!flagIsUp) {
            int peekDe = findPeek(findIndex(de));
            int peekVers = findPeek(findIndex(vers));
            if (isPair) {
                if (peekVers == (tours[0].getTableau().length)) {
                    vers = 'c';
                }
                if (peekVers == (tours[0].getTableau().length)) {
                    de = 'b';
                }
            }
            if (peekDe == tours[0].getTableau().length) {
                vers = 'c';
            }
            if (tours[0].isEmpty()) {
                deplacer(de, vers);
                de = 'b';
            }
            if (n == 1) {
                deplacer(de, vers);
                if (tours[2].isFull() && count == 0) {
                    deplacer(de, vers);
                    count++;
                }
                if (count == 1) {
                    flagIsUp = true;
                }
            } else {
                deplacerAuto(n - 1, de, entre, vers);
                deplacer(de, vers);
                deplacerAuto(n - 1, de, entre, vers);
            }
        }
    }

    public int findIndex(char c) {
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
