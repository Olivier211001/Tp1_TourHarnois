package laboratoire_4_2;

import laboratoire_4_2.Anneau;

public class Tour {

    private Anneau[] tableau_anneaux;

    private char nomTour;

    public Tour(int nbAnneaux, char tour) {
        this.tableau_anneaux = new Anneau[nbAnneaux];
        this.nomTour = tour;
    }

    // fonction pour afficher l'alias
    public char getNomTour() {
        return this.nomTour;
    }

    public Anneau[] getTableau() {
        return this.tableau_anneaux;
    }

    private boolean isEmpty() {
        return false;
    }

    private boolean isFull() {
        return false;
    }

    public void push() {
    }

    public void pop() {

    }

    public void peek() {

    }

    public void clear() {
        for (int i = 0; i < this.tableau_anneaux.length; i++) {
            this.tableau_anneaux[i] = null;
        }
    }
}
