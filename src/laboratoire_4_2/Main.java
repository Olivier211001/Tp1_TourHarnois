
package laboratoire_4_2;

import java.util.Scanner;
import laboratoire_4_2.Tour;

public class Main {
    public static void main(String[] args) {
        String commande = "";
        Scanner input = new Scanner(System.in);
        boolean isFinish = false;
        ToursHanoi tours = new ToursHanoi(3);
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
                    // case 1 pour changer le nombre d'anneaux souhaité
                    case "1":
                        System.out.println("Entrer le nombre d'anneaux désiré : ");
                        input = new Scanner(System.in);
                        String number = input.nextLine();
                        int nb = 0;
                        boolean isGood = true;
                        // vérifier si c'est un caracther autre qu'un chiffre, et si c'est un chiffre,
                        // il converti le input en number
                        try {
                            nb = Integer.parseInt(number);
                        } catch (NumberFormatException error) {
                            isGood = false;
                            System.out.println("Erreur! ce que vous avez entré n'est pas un nombre entre 1 et 9.");
                        }
                        // vérifie que c'est un nombre entre 3 et 9 et que la variable nb est bien un
                        // nombre
                        if (nb >= 3 && nb < 10 && isGood) {
                            tours = new ToursHanoi(nb);
                        } else {
                            System.out.println("Votre nombre n'est pas entre 3 et 9.");
                        }
                        break;
                    case "2":
                        // réinitialise le jeu
                        tours = new ToursHanoi(3);
                        break;
                    case "3":
                        tours.setAuto(false); // se mets en mode manuel
                        String s = "";
                        char de = '0';
                        System.out.println("À partir de quelle tour souhaitez-vous déplacer une anneau ?");
                        s = input.next();
                        de = s.charAt(0);
                        s = "";
                        char vers = '2';
                        System.out.println("Vers quelle tour?");
                        s = input.next();
                        vers = s.charAt(0);
                        // gestion des erreur
                        if ((vers == de)) {
                            System.out.println("Erreur! déplacment impossible.");
                        } else {
                            tours.deplacer(de, vers); // déplacement
                        }
                        break;
                    case "4":
                        tours.setAuto(true); // se mets en mode automatique
                        tours.resoudre(); // appelle la fonction resoudre()
                        System.out.println("Nombre de déplacments :" + tours.getNbDeplacements()); // affichage du
                                                                                                   // nombre de
                                                                                                   // déplacements
                        tours.reinitializeNbDeplacments(); // réinitialise les déplacments
                        break;
                    case "5":
                        System.out.println("GOOD BYE !!");
                        isFinish = true; // termine le jeu
                        break;
                }
            }
        }

    }
}
