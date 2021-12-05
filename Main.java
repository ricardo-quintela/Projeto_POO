import Files.ObjFileWorker;
import Files.TextFileWorker;
import data.Email;
import data.Date;
import products.Alimentar;
import products.Limpeza;
import products.Mobiliario;
import products.Produto;
import promotions.Promocao;

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


    /**
     * Asks for user input and converts it to a positive integer
     *
     * @param message the message to instruct the user
     * @return the converted integer
     */
    public static int positiveToInt(String message) {
        int num = -1;

        do {
            try {
                num = Integer.parseInt(getInput(message));
            } catch (NumberFormatException e) {
                num = -1;
                System.out.println("Erro! Entrada Inválida!");
            }
        } while (num < 0);

        return num;
    }


    /**
     * Asks for user input and converts it to a positive float
     *
     * @param message the message to instruct the user
     * @return the converted float
     */
    public static float positiveToFloat(String message) {
        float num = -1;

        do {
            try {
                num = Float.parseFloat(getInput(message));
            } catch (NumberFormatException e) {
                num = -1;
                System.out.println("Erro! Entrada Inválida!");
            }
        } while (num < 0);

        return num;
    }


    /**
     * Login interface
     * Used to know who is using the app
     * If the user doesn't exist in the database then they must create a new account
     *
     * @param supermercado the database of the supermarket
     * @return the client that loged in or created an account
     */
    public static Cliente login(Database supermercado) {
        Email email = null;
        System.out.print("----------------\n");

        //get the email input
        do {
            try {
                email = new Email(getInput("Intruduza o email >>>"));
            } catch (InputMismatchException e) {
                email = null;
            }
        } while (email == null);


        //check if account already exists
        boolean isRegistered = false;
        Cliente cliente = null;
        for (Cliente c : supermercado.getClientesRegulares()) {
            if (c.getEmail().toString().equals(email.toString())) {
                isRegistered = true;
                cliente = c;
                break;
            }
        }

        //if it doesnt the a new account must be created
        if (!isRegistered) {
            System.out.print("Cliente não existe. Intruduza dados do novo cliente:");

            //name and address
            String nome = getInput("Introduza o seu nome >>>");
            String morada = getInput("Introduza a sua morada >>>");

            //telefone number
            int telefone = positiveToInt("Introduza o seu numero de telefone >>>");

            //date
            System.out.println("Introduza a sua data de nascimento:");
            int dia = positiveToInt("Dia >>>");
            int mes = positiveToInt("Mes >>>");
            int ano = positiveToInt("Ano >>>");

            //created new client
            cliente = new Cliente(nome, morada, email, telefone, new Date(dia, mes, ano));

            //add the client to the arraylist
            supermercado.addClienteR(cliente);

        }

        System.out.println("Login efetuado com sucesso!");

        return cliente;
    }


    /**
     * Generate a product with user input
     *
     * @param type the type of product to create
     * @return the generated product
     */
    public static Produto genProduct(int type) {
        int id = positiveToInt("Id do produto >>>");
        String nome = getInput("Nome do produto >>>");
        int stock = positiveToInt("Unidades em stock >>>");
        float precoUnit = positiveToFloat("Preco por unidade >>>");

        //create different types of product
        //food
        if (type == 1) {
            return new Alimentar(id, nome, precoUnit, stock);
        }
        //cleaning
        else if (type == 2) {
            return new Limpeza(id, nome, precoUnit, stock);
        }
        //furniture
        else {
            return new Mobiliario(id, nome, precoUnit, stock);
        }
    }


    /**
     * Adds a new product to the given database via user input
     *
     * @param supermercado the database
     */
    public static void addProduct(Database supermercado) {

        //chose which product type to create
        int productType;
        do {
            productType = positiveToInt("Escolha o tipo de produto a adicionar:\n1 - Alimentar\n2 - Limpeza\n3 - Mobiliario\n4 - Sair\n>>>");

            //exit this menu
            if (productType == 4) {
                return;
            }

            //wrong input handeling
            if (productType > 4) {
                System.out.println("Erro! Entrada Invalida!");
            }

        } while (productType > 4);

        //creating the product

        switch (productType) {

            //add a food product
            case 1:
                Alimentar a = (Alimentar) genProduct(productType);
                a.setnCal(positiveToInt("Numero de calorias >>>"));
                a.setPerGord(positiveToInt("Percentagem de gordura >>>"));

                supermercado.addProduto(a);
                break;

                //add a cleaning product
            case 2:
                Limpeza l = (Limpeza) genProduct(productType);
                l.setGrauTox(positiveToInt("Grau de toxidade >>>"));

                supermercado.addProduto(l);
                break;

                //add a furniture product
            case 3:
                Mobiliario m = (Mobiliario) genProduct(productType);
                m.setPeso(positiveToFloat("Peso >>>"));
                m.setDimensao(new float[]{positiveToFloat("Comprimento >>>"), positiveToFloat("Largura >>>"), positiveToFloat("Altura >>>")});

                supermercado.addProduto(m);
                break;
        }

    }


    /**
     * Main method where all the others are going to be called
     *
     * @param args command line args
     */
    public static void main(String[] args) {

        //base de dados
        Database supermercado = new Database();
        supermercado.loadFromFile("src/clientes.txt", "src/clientesFreq.txt", "src/produtos.txt");

        //efetuar login
        Cliente cliente = login(supermercado);

        //select what to do in the program
        int option;
        do {
            option = positiveToInt("O que deseja fazer?\n1 - Comprar\n2 - Adiconar produto\n3 - Sair\n>>>");

            if (option > 3) {
                System.out.println("Erro! Entrada Invalida!");
            }

            switch (option) {
                case 1:
                    System.out.println("Opcao 1");
                    break;

                //add a new product to the database
                case 2:
                    addProduct(supermercado);
                    break;
            }

        } while (option != 3);


        System.out.println("Programa terminado!");

        //save the data on the database savefile
        supermercado.saveToFile("src/clientes.txt", "src/clientesFreq.txt", "src/produtos.txt");

    }
}
