import products.Mobiliario;
import products.Produto;
import java.util.ArrayList;


public class Compra {
    private ArrayList<Produto> listaProdutos = new ArrayList<>();
    private Cliente cliente;
    private int precoTrans;

    /**
     * Default constructor
     */
    public Compra() {}


    /**
     * Constructor
     *
     * @param listaProdutos the list of products
     * @param cliente the client that made the purchase
     */
    public Compra(ArrayList<Produto> listaProdutos, Cliente cliente) {
        this.listaProdutos = listaProdutos;
        this.cliente = cliente;
    }


    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getPrecoTrans() {return precoTrans;}

    public void setPrecoTrans(int precoTrans) {this.precoTrans = precoTrans;}




    public float calcCustoFinal( ArrayList<Cliente> clientesFreq,boolean transDom){
        boolean isFreq= clientesFreq.contains(cliente);
        float custoFinal=0;
        float custoProd;

        for(Produto p: listaProdutos){
            custoProd=p.getPrecoUnit()*p.getStock();
            custoFinal+=custoProd;
        }



        if(isFreq && custoFinal<=40&& transDom){
            custoFinal+=15;
        }else if(!isFreq&&transDom){
            custoFinal+=20;
        }

        return custoFinal;


    }

    @Override
    public String toString() {
        return "Compra{" +
                "listaProdutos=" + listaProdutos +
                ", cliente=" + cliente +
                ",preco de transporte=" + precoTrans +
                '}';
    }

}
