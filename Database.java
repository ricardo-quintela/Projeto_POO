import java.util.ArrayList;

import data.Date;
import data.Email;
import products.*;
import files.*;

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
    public ArrayList<Cliente> getClientesFrequentes() {
        return clientesFrequentes;
    }

    public void setClientesFrequentes(ArrayList<Cliente> clientesFrequentes) {
        this.clientesFrequentes = clientesFrequentes;
    }


    public Cliente getClienteF(int index) {
        return clientesFrequentes.get(index);
    }

    public void addClienteF(Cliente cliente) {
        clientesFrequentes.add(cliente);
    }

    public void removeClienteF(int index) {
        clientesFrequentes.remove(index);
    }

    public void clearClienteF() {
        clientesFrequentes.clear();
    }


    //CLIENTES REGULARES


    public ArrayList<Cliente> getClientesRegulares() {
        return clientesRegulares;
    }

    public void setClientesRegulares(ArrayList<Cliente> clientesRegulares) {
        this.clientesRegulares = clientesRegulares;
    }


    public Cliente getClienteR(int index) {
        return clientesRegulares.get(index);
    }

    public void addClienteR(Cliente cliente) {
        clientesRegulares.add(cliente);
    }

    public void removeClienteR(int index) {
        clientesRegulares.remove(index);
    }

    public void clearClienteR() {
        clientesRegulares.clear();
    }


    //PRODUTOS

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }


    public Produto getProduto(int index) {
        return produtos.get(index);
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removeProduto(int index) {
        produtos.remove(index);
    }

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
        if (! (regularSaveFile.getF().exists() && frequentSaveFile.getF().exists() && productSaveFile.getF().exists())){
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
                }
            } catch (Exception e) {
                System.out.println("Erro! Occoreu um erro ao ler o ficheiro!");
                return;
            }
        }

    }

}

