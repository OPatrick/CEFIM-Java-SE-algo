package com.patrick;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static final String INF = "inf";
    private static final String SUP = "sup";
    private static final String NOP = "nop";

    public static void main(String[] args) {

//        exercice2a();
//        exercice2b();
//        exercice3a();
//        exercice3b();
//        exercice3c();
//        exercice3d();
//        exercice3e();
//        exercice4a();
//        exercice4b();
//        exercice4c();
//        exercice4d();
//        exercice5a();
//        exercice5b();
//        exercice5c();
//        exercice5d();
//        exercice5e();
//        exercice5f();
//        exercice5g();
//        exercice5h();
//        exercice5i();
//        exercice5j();
//        exercice6a();
//        exercice6b();
//        exercice7a();
//        exercice7b();
//        exercice7c();
//        exercice8a();
//        exercice8b();
//        bonusTirageOrdreNumerique();
//        bonusTrianglePascale();
//        bonusVerifEmail();
//        bonusJeuDeLaVie();
        bonusSapin();
//        testExpression();

        scan.close();
    }

    public static void exercice2a() {

        System.out.println("\nexercice2a\nEntrez le prix de votre objet");

        float prixHT = scan.nextFloat();
        float prixTTC = prixHT * 1.196f;

        System.out.println("Prix H.T. : " + prixHT);
        System.out.println("Prix T.T.C : " + prixTTC);
    }

    public static void exercice2b() {

        System.out.println("\nexercice2b\nEntrez votre prénom");
        String prenom = scan.next();

        System.out.println("Entrez votre nom");
        String nom = scan.next();

        System.out.println("Bonjour " + prenom + " votre nom est " + nom);
    }

    public static void exercice3a() {
        System.out.println("\nexercice3a\nEntrez un nombre");

        Scanner scan = new Scanner(System.in);

        float prix = scan.nextFloat();

        if (prix < 0) {
            System.out.println(prix + " est négatif");
        } else {
            System.out.println(prix + " est positif");
        }
    }

    public static void exercice3b() {

        System.out.println("\nexercice3b\nEntrez un premier nombre");
        float number1 = scan.nextFloat();

        System.out.println("Entrez un second nombre");
        float number2 = scan.nextFloat();

        float product = number1 * number2;

        if (product < 0) {
            System.out.println("Le produit de " + number1 + " par " + number2 + " est négatif : " + product);
        } else {
            System.out.println("Le produit de " + number1 + " par " + number2 + " est positif : " + product);
        }
    }

    public static void exercice3c() {

        System.out.println("\nexercice3c\nEntrez un nom");
        String nom1 = scan.next();

        System.out.println("Entrez un second nom");
        String nom2 = scan.next();

        System.out.println("Entrez un dernier nom");
        String nom3 = scan.next();

        if (nom1.compareToIgnoreCase(nom2) <= 0 && nom2.compareToIgnoreCase(nom3) <= 0) {
            System.out.println("Les noms ont été donnés par ordre alphabétique");
        } else {
            System.out.println("Les noms n'ont pas été donnés alphabétiquement");
        }
    }

    public static void exercice3d() {

        System.out.println("\nexercice3d\nEntrez un premier nombre");
        float number1 = scan.nextFloat();

        System.out.println("Entrez un second nombre");
        float number2 = scan.nextFloat();

        float product = number1 * number2;

        if (number1 == 0 || number2 == 0) {
            System.out.println("Le produit est nul");
        } else if (product < 0) {
            System.out.println("Le produit de " + number1 + " par " + number2 + " est négatif : " + product);
        } else {
            System.out.println("Le produit de " + number1 + " par " + number2 + " est positif : " + product);
        }
    }

    public static void exercice3e() {

        System.out.println("\nexercice3e\nEntrez un age");
        float number = scan.nextFloat();

        if (number < 6) {
            System.out.println("Trop jeune");
        } else if (number < 8) {
            System.out.println("Poussin");
        } else if (number < 10) {
            System.out.println("Pupille");
        } else if (number < 12) {
            System.out.println("Minime");
        } else {
            System.out.println("Cadet");
        }

        // Alternative algo: use return instead of else??
    }

    public static void exercice4a() {

        System.out.println("\nexercice4a\nEntrez un chiffre entre 0 et 10");
        int number = scan.nextInt();

        while (number < 0 || number > 10) {
            System.out.println("Raté ! Player plays again...");
            number = scan.nextInt();
        }
        System.out.println("Enfin...");
    }

    public static void exercice4b() {

        System.out.println("\nexercice4b\nEntrez un chiffre");
        int number = scan.nextInt();

        while (number >= 0) {
            System.out.print(number + " ");
            number--;
        }
    }

    public static void exercice4c() {

        int toBeGuessed = 14;
        int number = 3;

        System.out.println("\nexercice4c\nDevinez devinez qui je suis... (chiffre)");
        number = scan.nextInt();

        while (number != toBeGuessed) {
            if (number < toBeGuessed) {
                System.out.println("Trop petit o é o é, essayez encore");
            } else {
                System.out.println("Trop gros o é o é, essayez encore");
            }
            number = scan.nextInt();
        }

        System.out.println("Bravo !");
    }

    public static void exercice4d() {

        System.out.println("\nexercice4d\nQuel nombre entier ?");
        int number = scan.nextInt();
        int resultat = 0;
        int i = 1;
        for (; i < number; i++) {

            System.out.print(i + "+");
            resultat += i;
        }
        System.out.print(i);
        resultat += number;

        System.out.println(" = " + resultat);
    }

    public static void exercice5a() {

        int[] chiffres = {10, 15, 20, 15, 14, 8};
        int resultat = 0;

        for (int i = 0; i < chiffres.length; i++) {
            resultat += chiffres[i];
        }

        System.out.println("\nexercice5a\nLa somme du tableau est :" + resultat);

    }

    public static void exercice5b() {

        System.out.println("\nexercice5b\nCombien d'élèves ?");
        int number = scan.nextInt();
        ArrayList<Float> notes = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            System.out.println("Note ?");
            float note = scan.nextFloat();
            notes.add(note);
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Note entrée : " + notes.get(i));
        }

    }

    public static void exercice5c() {

        System.out.println("\nexercice5c\nCombien d'élèves ?");
        int number = scan.nextInt();
        ArrayList<Float> notes = new ArrayList<>();
        float total = 0;
        float moyenne;

        for (int i = 0; i < number; i++) {
            System.out.println("Note ?");
            float note = scan.nextFloat();
            notes.add(note);
            total += note;
        }

        moyenne = total / number;

        System.out.println("Moyenne : " + moyenne);

        for (int i = 0; i < number; i++) {
            float note = notes.get(i);
            if (note > moyenne)
                System.out.println("Note supérieure à la moyenne : " + notes.get(i));
        }
    }

    public static void exercice5d() {

        System.out.println("\nexercice5d\nCombien d'élèves ?");
        int number = scan.nextInt();
        ArrayList<Float> notes = new ArrayList<>();
        float total = 0;
        float moyenne;

        for (int i = 0; i < number; i++) {
            System.out.println("Note ?");
            float note = scan.nextFloat();
            notes.add(note);
            total += note;
        }

        System.out.println("Tableau des notes");
        exercice5d_affiche_tableau(notes, NOP, number, 0);

        System.out.println("Tableau des notes < 8");
        exercice5d_affiche_tableau(notes, INF, number, 8);

        System.out.println("Tableau des notes > 10");
        exercice5d_affiche_tableau(notes, SUP, number, 10);

        System.out.println("Tableau des notes > 15");
        exercice5d_affiche_tableau(notes, SUP, number, 15);

        moyenne = total / number;

        System.out.println("Moyenne : " + moyenne);
    }

    public static void exercice5d_affiche_tableau(ArrayList<Float> notes, String operator, int number, float threshold) {
        for (int i = 0; i < number; i++) {
            float note = notes.get(i);
            if ((operator == INF && note < threshold) || (operator == SUP && note > threshold) || (operator == NOP))
                System.out.println("Note : " + note);
        }
    }

    public static void exercice5e() {

        System.out.println("\nexercice5e");
        int[] tab1 = {4, 8, 7, 9, 1, 5, 4, 6};
        int[] tab2 = {7, 6, 5, 2, 1, 3, 7, 4};

        int[] tab3 = new int[tab1.length];

        for (int i = 0; i < tab1.length; i++) {
            tab3[i] = tab1[i] + tab2[i];
        }

        for (int i = 0; i < tab1.length; i++) {
            System.out.println("Note calculée : " + tab3[i]);
        }
    }

    public static void exercice5f() {

        System.out.println("\nexercice5f");
        int[] tab1 = {2, 5, 8, 4};
        int[] tab2 = {6, 7};

        int resultat = 0;

        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab2.length; j++) {
                resultat += tab1[i] * tab2[j];
            }
        }

        System.out.println("Total : " + resultat);
    }

    public static void exercice5g() {

        System.out.println("\nexercice5g\nVeuillez entrer des nombres. Lorsque vous avez fini, entrez une lettre pour stopper");

        float[] tableau = new float[0];
        float number;
        try {
            while (true) {
                number = scan.nextFloat();
                tableau = Arrays.copyOf(tableau, tableau.length + 1);
                number += 1.0f;
                tableau[tableau.length - 1] = number;
            }
        } catch (InputMismatchException e) {
            System.out.println("Arrêt de saisie.");
            for (int i = 0; i < tableau.length; i++) {
                System.out.print(" " + tableau[i]);
            }
        }
    }

    public static void exercice5h() {

        System.out.println("\nexercice5h\nVeuillez entrer 20 nombres.");

        float number;
        float max = Float.MIN_VALUE;
        try {
            for (int i = 0; i < 20; i++) {
                number = scan.nextFloat();
                if (number > max) max = number;
            }
            System.out.println("Merci de votre saisie, le max est " + max);
        } catch (InputMismatchException e) {
            System.out.println("Saisie inatendue");
        }
    }

    public static void exercice5i() {

        System.out.println("\nexercice5h\nVeuillez entrer 20 nombres.");

        float number;
        float max = Float.MIN_VALUE;
        int pos = 0;
        try {
            for (int i = 0; i < 20; i++) {
                number = scan.nextFloat();
                if (number > max) {
                    max = number;
                    pos = i + 1;
                }
            }
            System.out.println("Merci de votre saisie, le max est " + max + " à la position " + pos);
        } catch (InputMismatchException e) {
            System.out.println("Saisie inatendue");
        }
    }

    public static void exercice5j() {

        System.out.println("\nexercice5i\nVeuillez entrer des nombres non nul. Lorsque vous avez fini, entrez 0");

        float number = 0;
        float max = Float.MIN_VALUE;
        int pos = 0;
        try {
            do {
                number = scan.nextFloat();
                if (number > max) {
                    max = number;
                    pos++;
                }
            }
            while (number != 0);
            System.out.println("Merci de votre saisie, le max est " + max + " à la position " + pos);
        } catch (InputMismatchException e) {
            System.out.println("Saisie inatendue");
        }
    }

    public static void exercice6a() {

        System.out.println("\nexercice6a\n");
        int max = Integer.MIN_VALUE;
        int posX = 0;
        int posY = 0;
        int i = 0;
        int j = 0;

        int[][] nombres = {{0, 18}, {1, 45}, {45, 48}, {-3, 2}};

        for (; i < nombres.length; i++) {
            int[] row = nombres[i];
            for (j = 0; j < row.length; j++) {
                if (row[j] > max) {
                    max = row[j];
                    posX = i;
                    posY = j;
                }
            }
        }
        System.out.println("Le max est " + max + " à la position " + (posX + 1) + "/" + (posY + 1));
    }

    public static void exercice6b() {

        System.out.println("\nexercice6b\n");

        String[][] notes = new String[2][0];
        float note;

        try {
            do {
                System.out.println("Entrez une note");
                int length = notes[0].length;
                note = scan.nextFloat();
                if (note == -1.0) break;
                notes[0] = Arrays.copyOf(notes[0], length + 1);
                notes[0][length] = Float.toString(note);
                System.out.println("Pour quel prénom ?");
                notes[1] = Arrays.copyOf(notes[1], length + 1);
                notes[1][length] = scan.next();
            }
            while (note != -1.0f);
            for (int i = 0; i < notes[0].length; i++) {
                System.out.println(notes[0][i] + " " + notes[1][i]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Saisie inatendue");
        }

    }

    public static void exercice7a() {

        System.out.println("\nexercice7a\n");

        System.out.println("Entrez un mot");
        String str = scan.nextLine();
        System.out.println(str + " a " + str.length() + " caractères");
    }

    public static void exercice7b() {

        Random rand = new Random();
        int toBeGuessed = rand.nextInt(6);
        int number;

        System.out.println("\nexercice7b\nDevinez devinez qui je suis... (chiffre entre 0 et 5)");
        number = scan.nextInt();

        while (number != toBeGuessed) {
            if (number < toBeGuessed) {
                System.out.println("Trop petit, essayez encore");
            } else {
                System.out.println("Trop gros, essayez encore");
            }
            number = scan.nextInt();
        }

        System.out.println("Bravo !");
    }

    public static void exercice7c() {
        String[] valeurs = {"toto", "titi", "tutu"};
        exercice7c_with_args(valeurs);
    }

    public static void exercice7c_with_args(String[] args) {

        System.out.print("\nexercice7c\nValeurs du tableau : [");
        System.out.print(String.join(" - ", args));
        System.out.println("]");
    }

    public static void exercice8a() {

        float prix = 145.12f;
        float tva = 0.2f;

        System.out.print("\nexercice8a");

        exercice8a_with_param(prix, tva);
    }

    public static void exercice8a_with_param(float prix, float tva) {
        System.out.println("Le prix TTC de " + prix + " HT est " + (prix * (1+tva)));
    }

    public static void exercice8b() {
        // See 05D

        System.out.println("\nexercice8b\nCombien d'élèves ?");
        int number = scan.nextInt();
        ArrayList<Float> notes = new ArrayList<>();
        float total = 0;
        float moyenne;

        for (int i = 0; i < number; i++) {
            System.out.println("Note ?");
            float note = scan.nextFloat();
            notes.add(note);
            total += note;
        }

        ArrayList<Float> results;

        System.out.println("Tableau des notes");
        results = exercice8BGet(notes, NOP, number, 0);
        System.out.println(results.toString());

        System.out.println("Tableau des notes < 8");
        results = exercice8BGet(notes, INF, number, 8);
        System.out.println(results.toString());

        System.out.println("Tableau des notes > 10");
        results = exercice8BGet(notes, SUP, number, 10);
        System.out.println(results.toString());

        System.out.println("Tableau des notes > 15");
        results = exercice8BGet(notes, SUP, number, 15);
        System.out.println(results.toString());

        moyenne = total / number;

        System.out.println("Moyenne : " + moyenne);
    }

    public static ArrayList<Float> exercice8BGet(ArrayList<Float> notes, String operator, int number, float threshold) {
        ArrayList<Float> results = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            float note = notes.get(i);
            if ((operator.equals(INF) && note < threshold) || (operator.equals(SUP) && note > threshold) || (operator.equals(NOP)))
                results.add(note);
        }
        return results;
    }

    public static void bonusTirageOrdreNumerique() {

        System.out.println("\nbonus tirage ordre numérique\nEntrez une suite de nombre réels séparés par un espace :");
        String suite = scan.nextLine();
        StringTokenizer st = new StringTokenizer(suite);

        float[] results = new float[st.countTokens()];

        for (int i=0; i<st.countTokens(); i++) {
            String token = st.nextToken();
            results[i] = Float.parseFloat(token);
        }
        Arrays.sort(results);

        System.out.println(Arrays.toString(results));
    }

    public static void bonusTrianglePascale() {

        System.out.println("\nbonus triangle de Pascal\nEntrez un entier naturel non nul :");
        int rang = scan.nextInt();

        for (int line = 1; line <= rang; line++) {
            int spaces = (rang - line) + 1;
            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }
            int c = 1;
            for (int i = 1; i <= line; i++)
            {
                System.out.print(c + " ");
                c = c * (line - i) / i;
            }
            System.out.print("\n");
        }
    }

    public static void bonusVerifEmail() {

        System.out.println("\nbonus vérification email\n");

        String[] tests = {
                "patrick@brouille.net",     // OK
                "2patrick@brouille.net",    // pas de nombre en première lettre
                "pa@brouille.net",          // au moins 3 lettres avant @
                "patrick@br@ouille.net",    // une seule fois @
                "patrick@brouille.n",       // au moins deux lettres aorès point
                "pat.rick@brouille.net",    // un seul point
                "patrick@brou.ill@e.net",   // un seul point et un seul arobase
                "patrick@brou ille.net"     // pas d'espace
        };

        for (String email : tests) {
            bonusVerifEmail_regexp(email);
        }
    }

    public static void bonusVerifEmail_regexp(String email) {

        Pattern pattern = Pattern.compile("^[^\\d@\\.\\s][^@\\.\\s]{2,}@[^@\\.\\s]{3,}\\.[^@\\.\\s]{2,}$");
        Matcher matcher = pattern.matcher(email);

        while(matcher.find()) {
            System.out.println("OK pour " + email);
            return;
        }

        System.out.println("KO pour " + email);
    }

    public static void bonusJeuDeLaVie() {

        // https://www.fil.univ-lille1.fr/~L1S2API/CoursTP/prj_jeu_vie.html
        System.out.println("\nbonus Jeu de la Vie\n");

//        ArrayList<Integer[][]> cellulesInitialesTest = new ArrayList<ArrayList<Integer>>();
        Integer[][] sample1 = {{1,0,0}, {0,0,1}, {0,1,0}};
        Integer[][] sample2 = {{1,0,0}, {0,1,0}, {0,1,0}};
        Integer[][] sample3 = {{1,0,0}, {0,1,0}, {1,1,0}};
        Integer[][] sample4 = {{0,0,0}, {1,1,0}, {0,0,0}};
        Integer[][] sample5 = {{0,0,1}, {1,1,1}, {0,1,0}};
        Integer[][] sample6 = {{0,0,0}, {1,1,1}, {0,0,0}};

        Integer[][] sample1b = {{1,1,1,1,1}, {1,1,0,0,1}, {1,0,0,1,1}, {1,0,1,0,1}, {1,1,1,1,1}};
        Integer[][] sample2b = {{1,1,1,1,1}, {1,1,0,0,1}, {1,0,1,0,1}, {1,0,1,0,1}, {1,1,1,1,1}};
        Integer[][] sample3b = {{1,1,1,1,1}, {1,1,0,0,1}, {1,0,1,0,1}, {1,1,1,0,1}, {1,1,1,1,1}};
        Integer[][] sample4b = {{1,1,1,1,1}, {1,0,0,0,1}, {1,1,1,0,1}, {1,0,0,0,1}, {1,1,1,1,1}};
        Integer[][] sample5b = {{1,1,1,1,1}, {1,0,0,1,1}, {1,1,1,1,1}, {1,0,1,0,1}, {1,1,1,1,1}};

//        cellulesInitialesTest.add(sample);

        System.out.println("sample1 " + bonusJeuDeLaVie_cell(sample1, 1, 1));
        System.out.println("sample2 " + bonusJeuDeLaVie_cell(sample2, 1, 1));
        System.out.println("sample3 " + bonusJeuDeLaVie_cell(sample3, 1, 1));
        System.out.println("sample4 " + bonusJeuDeLaVie_cell(sample4, 1, 1));
        System.out.println("sample5 " + bonusJeuDeLaVie_cell(sample5, 1, 1));
        System.out.println("sample1b " + bonusJeuDeLaVie_cell(sample1b, 2, 2));
        System.out.println("sample2b " + bonusJeuDeLaVie_cell(sample2b, 2, 2));
        System.out.println("sample3b " + bonusJeuDeLaVie_cell(sample3b, 2, 2));
        System.out.println("sample4b " + bonusJeuDeLaVie_cell(sample4b, 2, 2));
        System.out.println("sample5b " + bonusJeuDeLaVie_cell(sample5b, 2, 2));

        bonusJeuDeLaVie_display(sample6);
        bonusJeuDeLaVie_display(bonusJeuDeLaVie_fill(sample6));
        bonusJeuDeLaVie_display(bonusJeuDeLaVie_fill(bonusJeuDeLaVie_fill(sample6)));
    }

    public static int bonusJeuDeLaVie_cell(Integer[][] tableau, int x, int y) {

        int lineNumber = tableau.length;
        int columnNumber = tableau[0].length;

        int xmin = x < 1 ? 0 : x-1;
        int xmax = x > (lineNumber-2) ? (lineNumber-1) : x+1;
        int resultat = 0;

        int ymin = y < 1 ? 0 : y-1;
        int ymax = y > (columnNumber-2) ? (columnNumber-1) : y+1;

        for (int i = xmin; i<= xmax; i++) {
            for (int j = ymin; j <= ymax; j++) {
                if (i == x && j == y) continue;
                resultat += tableau[i][j];
            }
        }
        return (resultat == 3 || (resultat == 2 && tableau[x][y] == 1)) ? 1 : 0;
    }

    public static void bonusJeuDeLaVie_display(Integer[][] tableau) {

        int lineNumber = tableau.length;
        int columnNumber = tableau[0].length;

        for (int i=0; i<lineNumber; i++) {
            for (int j=0; j<columnNumber; j++) {
                System.out.print(tableau[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static Integer[][] bonusJeuDeLaVie_fill(Integer[][] tableau) {

        int lineNumber = tableau.length;
        int columnNumber = tableau[0].length;

        Integer[][] result = new Integer[lineNumber][columnNumber];

        for (int i=0; i<lineNumber; i++) {
            result[i] = Arrays.copyOf(tableau[i], columnNumber);
            for (int j=0; j<columnNumber; j++) {
                result[i][j] = bonusJeuDeLaVie_cell(tableau, i, j);
            }
        }

        return result;
    }

    public static void bonusSapin() {

//        System.out.println("\nbonus sapin de noël\nEntrez un entier naturel non nul :");
//        int rang = scan.nextInt();
        int rang = 7;

//        System.out.println("\nbonus sapin de noël\nEntrez l'orientation (v|h) :");
//        String orientation = scan.next();

//        System.out.println("\nbonus sapin de noël\nDevons-nous remplir ? (o|n) :");
//        boolean shallFill = (scan.next()).equalsIgnoreCase("o");
        boolean shallFill = false;

        String[][] tableau = new String[rang][rang];

        for (int line = 0; line < rang; line++) {
            // Spaces before data
            int spaces = (rang - line -1);
            for (int i = 0; i < spaces; i++) {
                tableau[line][i] = " ";
            }
            // First item in line
            tableau[line][spaces] = "**";
            // Other items in line except last
            for (int i = spaces+1; i < rang; i++)
            {
                tableau[line][i] = shallFill ? "**" : "__";
            }
            // Last char in line
            if (line > 0) {
                tableau[line][rang-1] = "**";
            }
        }
        // Last line
        for (int i = 0; i < rang; i++)
        {
            tableau[rang-1][i] = "**";
        }

        bonusSapin_display(tableau);
//        bonusSapin_displayDown(tableau);
        bonusSapin_displayRight(tableau);
    }

    public static void bonusSapin_display(String[][] tableau) {

        int rang = tableau.length;
        for (int line = 0; line < rang; line++) {
            for (int i = 0; i < rang; i++)
            {
                System.out.print(tableau[line][i]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void bonusSapin_displayDown(String[][] tableau) {

        int rang = tableau.length;
        for (int line = (rang-1); line >= 0; line--) {
            for (int i = 0; i < rang; i++)
            {
                System.out.print(tableau[line][i]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void bonusSapin_displayRight(String[][] tableau) {

        int rang = tableau.length;
//        for (int line = 0; line < rang; line++) {
        for (int line = (rang-1); line >= 0; line--) {
//            for (int i = 0; i < rang; i++)
            for (int i = (rang-1); i >= 0; i--)
            {
                System.out.print(tableau[i][line]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void testExpression() {

        int x = 3;
        int y = ++x * 5 / x-- + --x; // -> y = 7!
        // y = 4 * 5 / 4 + 3 = 8

        System.out.println(y);
    }
}
