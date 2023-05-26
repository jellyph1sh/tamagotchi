package com.ynov.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static void main(String[] args) {
        Menu NMenu = new Menu();
        int choice = -1;
        do {
            choice = NMenu.MenuChoice();
            switch(choice){
                case 1:
                    System.out.println("choix 1");
                    break;
                case 2:
                    System.out.println("choix 2");
                    break;
                case 3:
                    System.out.println("choix 3");
                    break;
                case 4:
                    System.out.println("choix 4");
                    break;
            }
        } while (choice != 0);
    }

    public int MenuChoice(){
        System.out.println("Veuillez choisir une option : ");
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("0. ");
        return promptRangeNumber("Faites un choix :",0,4);
    }

    public String prompt(String question){
        System.out.println(question + " ");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);
        try{
            return buffer.readLine();
        } catch (IOException e){
            System.out.println("La réponse n'est pas valide");
            return prompt(question);
        }
    }

    public int promptRangeNumber(String question, int rangeMin, int rangeMax){
        String answer = prompt(question);
        try{
            int intAnswers = Integer.parseInt(answer);
            if (intAnswers >= rangeMin & intAnswers <= rangeMax){
                return intAnswers;
            } else{
                System.out.println("Ce nombre n'est pas valide");
                return promptRangeNumber(question, rangeMin, rangeMax);
            }
        } catch (NumberFormatException e){
            System.out.println("Ce nombre n'est pas valide");
            return promptRangeNumber(question, rangeMin, rangeMax);
        }
    }
}
