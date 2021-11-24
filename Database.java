import java.util.ArrayList;

public class Database {
    private ArrayList<Cliente> clientesFrequentes;
    private ArrayList<Produto> produtos;
    private ArrayList<Promocao> promocoes;


    /**
     * Default constructor
     */
    public Database() {
        clientesFrequentes = new ArrayList<>();
        produtos = new ArrayList<>();
        promocoes = new ArrayList<>();
    }


    public Cliente getClienteF(int index){
        return clientesFrequentes.get(index);
    }


    public void addClienteF(Cliente cliente){
        clientesFrequentes.add(cliente);

    }

}
