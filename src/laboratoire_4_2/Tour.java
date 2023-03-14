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

    // retourne le tableau d'anneaux d'une tour
    public Anneau[] getTableau() {
        return this.tableau_anneaux;
    }

    // retourne si la tour est vide ou non
    public boolean isEmpty() {
        boolean flag = false;
        for (Anneau a : this.tableau_anneaux) {
            if (a == null) {
                flag = true;
            }
        }
        return flag;
    }

    // return si la tour est pleine ou non
    public boolean isFull() {
        boolean flag = false;
        for (Anneau a : this.tableau_anneaux) {
            if (a != null) {
                flag = true;
            }
        }
        return flag;
    }

    // ajoute l'élément (anneau) dans la tour)
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

    // retire l'élément peek de la tour
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

    // retourne le peek d'une tour
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

    // clear la tour
    public void clear() {
        for (int i = 0; i < this.tableau_anneaux.length; i++) {
            this.tableau_anneaux[i] = null;
        }
    }

}
