package laboratoire_4_2;

import laboratoire_4_2.Anneau;
import java.util.Arrays;

public class Tour {

    private Anneau[] tableau_anneaux;

    private char nomTour;

    public Tour() {
    };

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

    public void push(int e) {
        int count = 0;
        // System.out.println(count);

        boolean flag = true;
        while (flag) {
            if (tableau_anneaux[count] == null) {
                tableau_anneaux[count] = new Anneau(e);
                flag = false;
            }
            count++;
        }
        // System.out.println(tableau_anneaux.length);
    }

    public void pop() {
        int count = (tableau_anneaux.length - 1);
        // System.out.println(count);

        boolean flag = true;
        while (flag && count >= 0) {
            if (tableau_anneaux[count] != null) {
                tableau_anneaux[count] = null;
                flag = false;
            }
            count--;
        }
        // System.out.println(tableau_anneaux.length);
    }

    public int peek() {
        int count = (tableau_anneaux.length - 1);
        // System.out.println(count);

        while (count >= 0) {
            if (tableau_anneaux[count] != null) {
                return tableau_anneaux[count].getDiametre();
            }
            count--;
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < this.tableau_anneaux.length; i++) {
            this.tableau_anneaux[i] = null;
        }
    }

}
