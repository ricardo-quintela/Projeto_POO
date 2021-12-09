import data.Email;
import data.Date;
import products.Alimentar;
import products.Limpeza;
import products.Mobiliario;
import products.Produto;
import promotions.Pague3lv4;
import promotions.PagueMenos;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * <h1>Supermarket</h1>
 * <p>This class allows it's user to buy items from a supermarket</p>
 * <p>The user has a set of tools to manage his purchases</p>
 * <p>This class in specific handles the user as well as interactions with instances of other classes</p>
 *
 * @author Ricardo Quintela
 */
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
        System.out.print("Bem vindo a Supermercado Ricardo e Machado mt. Lda.\n");

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

        //search for clients with the same email
        for (Cliente c : supermercado.getClientesRegulares()) {
            if (c.getEmail().toString().equals(email.toString())) {
                isRegistered = true;
                cliente = c;
                break;
            }
        }

        //search for frequent clients with the same mail
        for (Cliente c : supermercado.getClientesFrequentes()) {
            if (c.getEmail().toString().equals(email.toString())) {
                isRegistered = true;
                cliente = c;
                break;
            }
        }

        //if it doesnt the a new account must be created
        if (!isRegistered) {
            System.out.println("Cliente não existe. Intruduza dados do novo cliente:");

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
    public static Produto genProduct(int type, Database supermercado) {
        int id;
        boolean idExists;

        //get the id
        do {
            idExists = false;

            //get the id
            id = positiveToInt("Id do produto >>>");

            //check if the id exists for every product
            for (Produto p: supermercado.getProdutos()){

                //check if the id already exists
                if (p.getId() == id){
                    idExists = true;
                    System.out.println("Erro! Esse id ja esta registado!");
                    break;
                }
            }

        } while (idExists);

        //get the name
        String nome = getInput("Nome do produto >>>");

        //get the sotck
        int stock = positiveToInt("Unidades em stock >>>");

        //get the price per unit
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
                Alimentar a = (Alimentar) genProduct(productType, supermercado);
                a.setnCal(positiveToInt("Numero de calorias >>>"));
                a.setPerGord(positiveToInt("Percentagem de gordura >>>"));

                supermercado.addProduto(a);
                break;

            //add a cleaning product
            case 2:
                Limpeza l = (Limpeza) genProduct(productType, supermercado);
                l.setGrauTox(positiveToInt("Grau de toxidade >>>"));

                supermercado.addProduto(l);
                break;

            //add a furniture product
            case 3:
                Mobiliario m = (Mobiliario) genProduct(productType, supermercado);
                m.setPeso(positiveToFloat("Peso >>>"));
                m.setDimensao(new float[]{positiveToFloat("Comprimento >>>"), positiveToFloat("Largura >>>"), positiveToFloat("Altura >>>")});

                supermercado.addProduto(m);
                break;
        }

    }


    /**
     * Adds a new product from the products database to the given purchase list
     *
     * @param index        the index of the product to add
     * @param quantity     the quantity of products to buy
     * @param supermercado the database
     * @param p            the purchase list
     */
    public static void buy(int index, int quantity, Database supermercado, Compra p) {
        //product from the database
        Produto prodInStock = supermercado.getProduto(index);

        //requested product
        Produto product = (Produto) prodInStock.clone();

        //quantity bigger than stock handeling
        if (quantity >= prodInStock.getStock()) {
            product.setStock(prodInStock.getStock());
            supermercado.removeProduto(index);
        } else {
            //eliminate product from the database if stock ends
            product.setStock(quantity);
            prodInStock.setStock(prodInStock.getStock() - quantity);
        }

        //add product to the purchase
        p.addProduto(product);

        System.out.println("Comprado: " + product);

    }


    /**
     * Purchase an item from the given products database
     *
     * @param cliente      the client that is going to buy
     * @param supermercado the database
     * @return the purchase
     */
    public static Compra purchase(Cliente cliente, Database supermercado, Date data) {
        Compra p = new Compra(cliente, data);

        int option;
        int quantity;
        int size;

        do {
            //get the size of the products list
            size = supermercado.getProdutos().size();


            //display a list of products
            String products = "";
            for (int i = 0; i < supermercado.getProdutos().size(); ++i) {
                products = products.concat("\n" + (i + 1) + " - " + supermercado.getProduto(i));
            }

            //ask for input
            do {
                option = positiveToInt("Escolha um produto para comprar:\n" + products + "\n" + (supermercado.getProdutos().size() + 1) + " - Finalizar compra\n>>>");

                //wrong value
                if (option > supermercado.getProdutos().size() + 1) {
                    System.out.println("Erro! Entrada Invalida!");
                }

            } while (option > supermercado.getProdutos().size() + 1);

            //continue to buy products
            if (option <= supermercado.getProdutos().size()) {

                quantity = 0;
                //chose the quantity of products to buy
                while (quantity == 0) {

                    quantity = positiveToInt("Quantos deseja comprar >>>");

                    //cant buy 0 products
                    if (quantity == 0) {
                        System.out.println("Entrada Invalida!");
                    }

                }

                //buy thw wanted product
                if (option <= supermercado.getProdutos().size()) {
                    buy(option - 1, quantity, supermercado, p);
                }

            }
        } while (option < size + 1);

        //only purchase if list elements exist
        if (p.getListaProdutos().size() > 0) {

            p.calcCustoFinal(supermercado.getClientesFrequentes(), data);
            System.out.println("Fatura:\n" + p);
        }

        return p;
    }


    /**
     * Adds a promotion to a product in the given database with user input
     *
     * @param supermercado the database
     */
    public static void addPromo(Database supermercado) {
        int option;
        //chose which promo to add
        do {
            option = positiveToInt("Que tipo de promocao deseja adicionar?\n1 - Pague 3, Leve 4\n2 - Pague menos\n>>>");

            if (option < 1 || option > 2) {
                System.out.println("Erro! Entrada invalida!");
            }

        } while (option < 1 || option > 2);


        Produto produto = null;
        int id;

        //chose the product id
        while (produto == null) {
            id = positiveToInt("Escreva o id do produto >>>");

            //find the product
            for (Produto product : supermercado.getProdutos()) {

                if (product.getId() == id) {
                    produto = product;
                }
            }

            //product not found
            if (produto == null) {
                System.out.println("Erro! Esse produto nao esta registado!");
            }
        }

        //create the dates
        System.out.println("Escreva a data de inicio >>>");
        Date inc = new Date(positiveToInt("Dia >>>"), positiveToInt("Mes >>>"), positiveToInt("Ano >>>"));

        System.out.println("Escreva a data de fim >>>");
        Date exp = new Date(positiveToInt("Dia >>>"), positiveToInt("Mes >>>"), positiveToInt("Ano >>>"));


        //add the promotion to the product
        if (option == 1) {
            produto.setPromo(new Pague3lv4(exp, inc));
        } else {
            produto.setPromo(new PagueMenos(exp, inc));
        }

    }


    /**
     * Sets a new date with user input
     *
     * @return the new date
     */
    public static Date setDate() {
        Date novaData = new Date(positiveToInt("Dia >>>"), positiveToInt("Mes >>>"), positiveToInt("Ano >>>"));

        System.out.println("Data definida como " + novaData);

        return novaData;
    }


    /**
     * Main method where all the others are going to be called
     *
     * @param args command line args
     */
    public static void main(String[] args) {

        //database
        Database supermercado = new Database();

        //load from object files
        boolean isData = supermercado.loadFromFile("src/clientes.obj", "src/clientesFreq.obj", "src/produtos.obj");


        //load from text file
        if (!isData) {
            supermercado.initSetup("src/initialSetup.txt");
        }

        //login
        Cliente cliente = login(supermercado);

        //set the date
        System.out.println("Introduza a data:");
        Date data = setDate();

        //select what to do in the program
        int option;
        do {
            option = positiveToInt("O que deseja fazer?\n1 - Comprar\n2 - Adiconar produto\n3 - Adicionar promocao\n4 - Alterar a Data\n5 - Ver catalogo\n6 - Ver compras efetuadas\n7 - Sair\n>>>");

            if (option > 7) {
                System.out.println("Erro! Entrada Invalida!");
            }

            switch (option) {
                case 1:
                    cliente.addCompra(purchase(cliente, supermercado, data));
                    break;

                //add a new product to the database
                case 2:
                    addProduct(supermercado);
                    break;

                //add a new promotion
                case 3:
                    addPromo(supermercado);
                    break;

                //change the date
                case 4:
                    System.out.println("Data antiga: " + data);
                    data = setDate();
                    break;

                //view the catalog
                case 5:
                    System.out.println("Catalogo:\n");
                    for (Produto p : supermercado.getProdutos()) {
                        System.out.println(p);
                    }
                    break;

                //view the purchases of the registered client
                case 6:
                    System.out.println("Compras efetuadas por " + cliente.getNome() + ":\n");
                    for (Compra c : cliente.getCompras()) {
                        System.out.println(c);
                    }
                    break;
            }

        } while (option != 7);


        System.out.println("Programa terminado!");


        //save the data on the database savefile
        supermercado.saveToFile("src/clientes.obj", "src/clientesFreq.obj", "src/produtos.obj");

    }
}
