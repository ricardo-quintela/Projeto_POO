import java.util.ArrayList;
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
    public ArrayList<Cliente> getClientesFrequentes(){
        return clientesFrequentes;
    }

    public void setClientesFrequentes(ArrayList<Cliente> clientesFrequentes){this.clientesFrequentes = clientesFrequentes;}



    public Cliente getClienteF(int index){
        return clientesFrequentes.get(index);
    }

    public void addClienteF(Cliente cliente){clientesFrequentes.add(cliente);}

    public void removeClienteF(int index){
        clientesFrequentes.remove(index);
    }

    public void clearClienteF(){
        clientesFrequentes.clear();
    }



    //CLIENTES REGULARES


    public ArrayList<Cliente> getClientesRegulares(){return clientesRegulares;}

    public void setClientesRegulares(ArrayList<Cliente> clientesRegulares){this.clientesRegulares = clientesRegulares;}



    public Cliente getClienteR(int index){
        return clientesRegulares.get(index);
    }

    public void addClienteR(Cliente cliente){clientesRegulares.add(cliente);}

    public void removeClienteR(int index){clientesRegulares.remove(index);}

    public void clearClienteR(){
        clientesRegulares.clear();
    }


    //PRODUTOS

    public ArrayList<Produto> getProdutos(){
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    

    public Produto getProduto(int index){
        return produtos.get(index);
    }

    public void addProduto(Produto produto){
        produtos.add(produto);
    }

    public void removeProduto(int index){
        produtos.remove(index);
    }

    public void clearProdutos(){
        produtos.clear();
    }


/**
     * Saves the contents of the database to a file
     *
     * @param clientesR the path of the clients file
     * @param clientesF the path of the frequent clients file
     * @param produtos the path of the products file
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
     * @param produtos the path of the products file
     */
    public void loadFromFile(String clientesR, String clientesF, String produtos) {
        ObjFileWorker regularSaveFile = new ObjFileWorker(clientesR);
        ObjFileWorker frequentSaveFile = new ObjFileWorker(clientesF);
        ObjFileWorker productSaveFile = new ObjFileWorker(produtos);

        ArrayList<Cliente> c = (ArrayList<Cliente>) regularSaveFile.read();
        ArrayList<Cliente> cf = (ArrayList<Cliente>) frequentSaveFile.read();
        ArrayList<Produto> p = (ArrayList<Produto>) productSaveFile.read();

        this.clientesRegulares = c == null ? new ArrayList<>() : c;
        this.clientesFrequentes = cf == null ? new ArrayList<>() : cf;
        this.produtos = p == null ? new ArrayList<>() : p;


    }

}

