import data.Email;
import data.Date;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    /**
     * Gets input from an user
     *
     * @param message the message to show on the console to instruct thge user
     * @return a string with the input given by the user
     */
    public static String getInput(String message) {
        Scanner sc = new Scanner(System.in);

        String userInput = null;

        do {
            System.out.print(message);
            try {
                userInput = sc.nextLine();
            } catch (NoSuchElementException e) {
                userInput = null;
                System.out.println("Erro! Entrada invalida!");
            }
        } while (userInput == null);

        return userInput;
    }

    public static void main(String[] args) {

        Database supermercado = new Database();

        Email email = null;
        System.out.print("----------------\n");

        //get the email input
        do {
            try {
                email = new Email(getInput("Intruduza o email >>>"));
            } catch (InputMismatchException e){
                email = null;
            }
        } while (email == null);

        System.out.print(email);


        boolean isRegistered = false;
        Cliente cliente;
        for (Cliente c : supermercado.getClientesRegulares()) {
            if (c.getEmail().equals(email)) {
                isRegistered = true;
                cliente = c;
            }
        }
        if (!isRegistered){
            System.out.print("Cliente não existe. Intruduza dados do novo cliente:");

            //name and address
            String nome = getInput("Introduza o seu nome >>>");
            String morada = getInput("Introduza a sua morada >>>");

            //telefone number
            int telefone = Integer.parseInt(getInput("Introduza o seu numero de telefone >>>"));

            //date
            System.out.println("Introduza a sua data de nascimento:");
            int dia = Integer.parseInt(getInput("Dia >>>"));
            int mes = Integer.parseInt(getInput("Mes >>>"));
            int ano = Integer.parseInt(getInput("Ano >>>"));

            //created new client
            cliente = new Cliente(nome, morada, email, telefone, new Date(dia, mes, ano));

            //add the client to the arraylist
            supermercado.addClienteR(cliente);

        }


    }
}
