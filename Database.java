import java.util.ArrayList;

import data.Date;
import data.Email;
import products.*;
import files.*;
import promotions.Pague3lv4;
import promotions.PagueMenos;


/**
 * <p>Stores the information about clients, frequent clients and products</p>
 * <p>Allows the programmer to save that information in an object file and also load it from the same object file</p>
 * <p>The information can also be loaded from a text file. If the file can be parsed the object will be added to the list in memory.</p>
 *
 * @author Ricardo Quintela
 */
public class Database {
    private ArrayList<Cliente> clientesFrequentes;
    private ArrayList<Cliente> clientesRegulares;
    private ArrayList<Produto> produtos;


    /**
     * Default constructor
     */
    public Database() {
        clientesFrequentes = new ArrayList<>();
        clientesRegulares = new ArrayList<>();
        produtos = new ArrayList<>();
    }


    //GETTERS AND SETTERS

    //CLIENTES FREQUENTES

    /**
     * Access the frequent clients list
     *
     * @return the frequent clients list
     */
    public ArrayList<Cliente> getClientesFrequentes() {
        return clientesFrequentes;
    }

    /**
     * Define the frequent clients list
     *
     * @param clientesFrequentes the frequent clients list
     */
    public void setClientesFrequentes(ArrayList<Cliente> clientesFrequentes) {
        this.clientesFrequentes = clientesFrequentes;
    }

    /**
     * Get a frequent client from the list on the given index
     *
     * @param index the index of the client
     * @return the frequent client
     */
    public Cliente getClienteF(int index) {
        return clientesFrequentes.get(index);
    }

    /**
     * Add a frequent client to the list
     *
     * @param cliente the client on the list
     */
    public void addClienteF(Cliente cliente) {
        clientesFrequentes.add(cliente);
    }

    /**
     * Remove a frequent client from the list on the given index
     *
     * @param index the index of the client
     */
    public void removeClienteF(int index) {
        clientesFrequentes.remove(index);
    }

    /**
     * Clear the frequent clients list
     */
    public void clearClienteF() {
        clientesFrequentes.clear();
    }


    //CLIENTES REGULARES


    /**
     * Get a regular client from the list
     *
     * @return the regular client
     */
    public ArrayList<Cliente> getClientesRegulares() {
        return clientesRegulares;
    }

    /**
     * Define the regular clients list
     *
     * @param clientesRegulares the regular clients list
     */
    public void setClientesRegulares(ArrayList<Cliente> clientesRegulares) {
        this.clientesRegulares = clientesRegulares;
    }


    /**
     * Get a regular client from the list on the given index
     *
     * @param index the index of the client
     * @return the regular client
     */
    public Cliente getClienteR(int index) {
        return clientesRegulares.get(index);
    }

    /**
     * Adds a client to the list
     *
     * @param cliente the client
     */
    public void addClienteR(Cliente cliente) {
        clientesRegulares.add(cliente);
    }

    /**
     * Remmoves a client from the list on the given index
     *
     * @param index the index of the client
     */
    public void removeClienteR(int index) {
        clientesRegulares.remove(index);
    }

    /**
     * Clears the clients list
     */
    public void clearClienteR() {
        clientesRegulares.clear();
    }


    //PRODUTOS

    /**
     * Access the products list
     *
     * @return the products list
     */
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Define the products list
     *
     * @param produtos the list of products
     */
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    /**
     * Get the product from the list on the given index
     *
     * @param index the index of the product
     * @return the product
     */
    public Produto getProduto(int index) {
        return produtos.get(index);
    }

    /**
     * Adds a product to the list
     *
     * @param produto the product
     */
    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    /**
     * Removes a product from the list on the given index
     *
     * @param index the index of the product to remove
     */
    public void removeProduto(int index) {
        produtos.remove(index);
    }

    /**
     * Clears the products list
     */
    public void clearProdutos() {
        produtos.clear();
    }


    /**
     * Saves the contents of the database to a file
     *
     * @param clientesR the path of the clients file
     * @param clientesF the path of the frequent clients file
     * @param produtos  the path of the products file
     */
    public void saveToFile(String clientesR, String clientesF, String produtos) {
        ObjFileWorker regularSaveFile = new ObjFileWorker(clientesR);
        ObjFileWorker frequentSaveFile = new ObjFileWorker(clientesF);
        ObjFileWorker productSaveFile = new ObjFileWorker(produtos);

        regularSaveFile.write(this.clientesRegulares);
        frequentSaveFile.write(this.clientesFrequentes);
        productSaveFile.write(this.produtos);
    }

    /**
     * Loads the contents of the database saved on a file to memory
     *
     * @param clientesF the path of the clients file
     * @param clientesR the path of the frequent clients file
     * @param produtos  the path of the products file
     */
    public boolean loadFromFile(String clientesR, String clientesF, String produtos) {
        ObjFileWorker regularSaveFile = new ObjFileWorker(clientesR);
        ObjFileWorker frequentSaveFile = new ObjFileWorker(clientesF);
        ObjFileWorker productSaveFile = new ObjFileWorker(produtos);

        // only load if the files exist
        if (!(regularSaveFile.getF().exists() && frequentSaveFile.getF().exists() && productSaveFile.getF().exists())) {
            return false;
        }

        //load the arraylist objects fro the files
        ArrayList<Cliente> c = (ArrayList<Cliente>) regularSaveFile.read();
        ArrayList<Cliente> cf = (ArrayList<Cliente>) frequentSaveFile.read();
        ArrayList<Produto> p = (ArrayList<Produto>) productSaveFile.read();

        this.clientesRegulares = c == null ? new ArrayList<>() : c;
        this.clientesFrequentes = cf == null ? new ArrayList<>() : cf;
        this.produtos = p == null ? new ArrayList<>() : p;

        return true;
    }

    /**
     * Loads the first data from the save file to the program
     *
     * <p><strong>CAN LOAD:</strong></p>
     * <p>Client - (3)</p>
     * <p>Frequent client (4)</p>
     * <p>Product (0, 1, 2)</p>
     * <p>Promotion (5, 6)</p>
     *
     * @param path the path of the save file
     */
    public void initSetup(String path) {
        TextFileWorker saveFile = new TextFileWorker(path);

        ArrayList<String> data = saveFile.read();

        for (String s : data) {
            String[] values = s.split(";");
            try {

                //parse the values in the save file
                switch (Integer.parseInt(values[0])) {


                    //add a food product
                    case 0:
                        produtos.add(new Alimentar(Integer.parseInt(values[1]),
                                values[2], Float.parseFloat(values[3]),
                                Integer.parseInt(values[4]),
                                Integer.parseInt(values[5]),
                                Integer.parseInt(values[5])));
                        break;

                    //add a cleaning product
                    case 1:
                        produtos.add(new Limpeza(Integer.parseInt(values[1]),
                                values[2], Float.parseFloat(values[3]),
                                Integer.parseInt(values[4]),
                                Integer.parseInt(values[5])));
                        break;

                    //add a furniture product
                    case 2:
                        produtos.add(new Mobiliario(Integer.parseInt(values[1]),
                                values[2], Float.parseFloat(values[3]),
                                Integer.parseInt(values[4]),
                                Float.parseFloat(values[5]),
                                new float[]{Float.parseFloat(values[6]),
                                        Float.parseFloat(values[7]),
                                        Float.parseFloat(values[8])}));
                        break;

                    //add a regular client
                    case 3:
                        clientesRegulares.add(new Cliente(values[1],
                                values[2],
                                new Email(values[3]),
                                Integer.parseInt(values[4]),
                                new Date(Integer.parseInt(values[5]),
                                        Integer.parseInt(values[6]),
                                        Integer.parseInt(values[7]))));
                        break;

                    //add a frequent client
                    case 4:
                        clientesFrequentes.add(new Cliente(values[1],
                                values[2],
                                new Email(values[3]),
                                Integer.parseInt(values[4]),
                                new Date(Integer.parseInt(values[5]),
                                        Integer.parseInt(values[6]),
                                        Integer.parseInt(values[7]))));
                        break;

                    //add pague 3 leve 4 promotion
                    case 5:
                        //find the product by the id
                        for (Produto p : produtos) {

                            //add the promo to the product
                            if (p.getId() == Integer.parseInt(values[1])) {

                                p.setPromo(new Pague3lv4(new Date(Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4])),
                                        new Date(Integer.parseInt(values[5]), Integer.parseInt(values[6]), Integer.parseInt(values[7]))));

                                break;
                            }
                        }
                        break;

                    //add pague menos promotion
                    case 6:
                        //find the product by the id
                        for (Produto p : produtos) {

                            //add the promo to the product
                            if (p.getId() == Integer.parseInt(values[1])) {

                                p.setPromo(new PagueMenos(new Date(Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4])),
                                        new Date(Integer.parseInt(values[5]), Integer.parseInt(values[6]), Integer.parseInt(values[7]))));

                                break;
                            }
                        }
                        break;

                }
            } catch (Exception e) {
                System.out.println("Erro! Occoreu um erro ao ler o ficheiro!");
                return;
            }
        }

    }

    @Override
    public String toString() {
        return "Base de Dados{" +
                "clientesFrequentes=" + clientesFrequentes +
                ", clientesRegulares=" + clientesRegulares +
                ", produtos=" + produtos +
                '}';
    }
}

