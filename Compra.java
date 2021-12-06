import data.Date;
import products.Produto;

import java.util.ArrayList;


public class Compra {
    private ArrayList<Produto> listaProdutos = new ArrayList<>();
    private Cliente cliente;
    private float precoTrans;
    private float custoTotal;

    /**
     * Default constructor
     */
    public Compra() {
        listaProdutos = new ArrayList<>();
    }

    /**
     * Constructor
     *
     * @param cliente the client that made the purchase
     */
    public Compra(Cliente cliente) {
        this();
        this.cliente = cliente;
    }


    /**
     * Constructor
     *
     * @param listaProdutos the list of products
     * @param cliente       the client that made the purchase
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

    /**
     * Adds a new product to the list
     *
     * @param product the product to be added
     */
    public void addProduto(Produto product) {
        listaProdutos.add(product);
    }


    /**
     * Access a product from the list
     *
     * @param index the index of the product
     * @return the product from the list
     */
    public Produto getProduto(int index) {
        return listaProdutos.get(index);
    }

    /**
     * Removes a product from the list
     *
     * @param index the index of the product to be removed
     */
    public void removeProduto(int index) {
        listaProdutos.remove(index);
    }

    /**
     * Clear products list
     */
    public void clearListaProdutos() {
        listaProdutos.clear();
    }

    public float getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(float custoTotal) {
        this.custoTotal = custoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getPrecoTrans() {
        return precoTrans;
    }

    public void setPrecoTrans(float precoTrans) {
        this.precoTrans = precoTrans;
    }


    /**
     * Calculates the final cost of the entire purchase
     *
     * @param clientesFreq the database with the frequent clients
     */
    public void calcCustoFinal(ArrayList<Cliente> clientesFreq, Date data) {
        boolean isFreq = clientesFreq.contains(cliente);
        float custoFinal = 0;
        float custoProd;

        //calculates the final cost of each product of the list
        for (Produto p : listaProdutos) {

            // calculate the cost with the promotion if there is one
            if (p.getPromo() != null && data.between(p.getPromo().getDataInc(), p.getPromo().getDataExp())){
                custoProd = p.getPromo().getDescontoProm(p);
            }
            //if not the price is normal
            else{
                custoProd = p.getPrecoUnit() * p.getStock();
            }

            custoFinal += custoProd;
        }

        //adds an aditional cost for the trasportation of the products
        if (isFreq && custoFinal <= 40) {
            custoFinal += 15;
        } else if (!isFreq) {
            custoFinal += 20;
        }

        this.custoTotal = custoFinal;

    }

    @Override
    public String toString() {
        String produtos = "";

        for (int i = 0; i < listaProdutos.size(); ++i) {
            produtos = produtos.concat("\n" + getProduto(i).getNome() + " -> " + getProduto(i).getStock() + " - " + (getProduto(i).getStock() * getProduto(i).getPrecoUnit()));
        }

        return "Produtos:\n" + produtos +
                "\nCliente:\n" + cliente +
                "\n\nTOTAL: " + custoTotal + "\n";
    }

}
