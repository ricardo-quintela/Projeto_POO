import java.util.ArrayList;
import products.*;

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

    public void setClientesFrequentes(ArrayList<Cliente> clientesFrequentes){
        this.clientesFrequentes = clientesFrequentes;
    }

    public Cliente getClienteF(int index){
        return clientesFrequentes.get(index);
    }


    public void addClienteF(Cliente cliente){
        clientesFrequentes.add(cliente);

    }

    public void removeClienteF(int index){
        clientesFrequentes.remove(index);
    }

    public void clearClienteF(){
        clientesFrequentes.clear();
    }



    //CLIENTES REGULARES


    public ArrayList<Cliente> getClientesRegulares(){return clientesRegulares;}

    public void setClientesRegulares(ArrayList<Cliente> clientesRegulares){
        this.clientesRegulares = clientesRegulares;
    }

    public Cliente getClienteR(int index){
        return clientesRegulares.get(index);
    }


    public void addClienteR(Cliente cliente){
        clientesRegulares.add(cliente);

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



}
