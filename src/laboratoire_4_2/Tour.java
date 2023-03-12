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

    public boolean isEmpty() {
        boolean flag = false;
        for (Anneau a : this.tableau_anneaux) {
            if (a == null) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isFull() {
        boolean flag = false;
        for (Anneau a : this.tableau_anneaux) {
            if (a != null) {
                flag = true;
            }
        }
        return flag;
    }

    public void push(int e) {
        int count = 0;

        boolean flag = true;
        while (flag) {
            try {
                if (tableau_anneaux[count] == null) {
                    tableau_anneaux[count] = new Anneau(e);
                    flag = false;
                }
            } catch (Error er) {
                System.out.println("--déplacement refusé--");
            }
            count++;
        }
    }

    public void pop() {
        int count = (tableau_anneaux.length - 1);

        boolean flag = true;
        while (flag && count >= 0) {
            if (tableau_anneaux[count] != null) {
                tableau_anneaux[count] = null;
                flag = false;
            }
            count--;
        }
    }

    public int peek() {
        int count = (tableau_anneaux.length - 1);

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
