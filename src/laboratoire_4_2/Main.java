
package laboratoire_4_2;

import java.util.Scanner;
import laboratoire_4_2.Tour;

public class Main {
    public static void main(String[] args) {
        // ToursHanoi tours = new ToursHanoi();
        // tours.resoudre();

        String commande = "";
        Scanner input = new Scanner(System.in);
        boolean isFinish = false;
        System.out.println("------------------------Les tours--------------------------\n");
        ToursHanoi tours = new ToursHanoi(3);
        System.out.println("-----------------------------------------------------------\n");
        try (Scanner userInput = new Scanner(System.in)) {
            while (!isFinish) {
                System.out.println("1: Déterminer le nombre d'anneaux (3 par défaut)\n");
                System.out.println("2: Réinitialiser les tours\n");
                System.out.println("3: Jouer un coup\n");
                System.out.println("4: Montrer la solution\n");
                System.out.println("5: Quitter\n");
                System.out.println("-----------------------------------------------------------\n");
                System.out.println("Faites votre choix et appuyez sur ENTER : ");
                commande = userInput.nextLine();

                switch (commande) {

                    case "1":
                        System.out.println("Entrer le nombre d'anneaux désiré : ");
                        String number = input.nextLine();
                        int nb;
                        try {
                            nb = Integer.parseInt(number);
                            if (nb > 0 && nb < 9) {
                                tours = new ToursHanoi(nb);
                            } else {
                                System.out.println("Votre nombre n'est pas entre 1 et 9.");
                            }
                        } catch (Error e) {
                            System.out.println("Erreur ! ce que vous avez entré n'est pas un nombre entre 1 et 9.");
                        }
                        break;
                    case "2":
                        tours = new ToursHanoi(3);
                        break;

                    case "3":

                        break;

                    case "4":

                        break;

                    case "5":
                        isFinish = true;
                        break;

                }
            }
        }

    }
}
