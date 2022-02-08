package com.collectionexception.exercice3;

import java.util.Scanner;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 08/02/2022
 * Time: 12:26
 */
public class Mdp {

    static final String USER = "scott";
    static final String MDP = "tiger";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String user;
        String mdp;

        int i = 10;
        while (i > 0) {
            try {
                System.out.println("Quel est le nom d'utilisateur ?");
                user = scan.nextLine();
                analyseLogin(user);
                break;
            } catch (WrongLoginException | WrongInputLength e) {
                System.out.println(e);
            } finally {
                i--;
            }
        }
        i = 10;
        while (i > 0) {
            try {
                System.out.println("Quel est le MDP ?");
                mdp = scan.nextLine();
                analyseMdp(mdp);
                break;
            } catch (WrongPwdException | WrongInputLength e) {
                System.out.println(e);
            } finally {
                i--;
            }
        }

        scan.close();
    }

    public static void analyseLogin(String login) throws WrongLoginException, WrongInputLength {
        if (login.length() > 10) throw new WrongInputLength("Utilisateur trop long");
        if (! login.equals(USER)) throw new WrongLoginException("Utilisateur non existant");
    }

    public static void analyseMdp(String mdp) throws WrongPwdException, WrongInputLength {
        if (mdp.length() > 10) throw new WrongInputLength("Mot de passe trop long");
        if (! mdp.equals(MDP)) throw new WrongPwdException("Mot de passe non existant");
    }

    public static class WrongLoginException extends Exception {
        public WrongLoginException(String message) {
            super(message);
        }
    }

    public static class WrongPwdException extends Exception {
        public WrongPwdException(String message) {
            super(message);
        }
    }

    public static class WrongInputLength extends Exception {
        public WrongInputLength(String message) {
            super(message);
        }
    }
}
