import data.Date;
import products.Produto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <p>Stores the information about a purchase</p>
 *
 * @author Miguel Machado
 */
public class Compra implements Serializable {
    private ArrayList<Produto> listaProdutos = new ArrayList<>();
    private Cliente cliente;
    private float precoTrans;
    private float custoTotal;
    private Date data;

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
    public Compra(Cliente cliente, Date data) {
        this();
        this.cliente = cliente;
        this.data = data;
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

    /**
     * Access the list of products
     *
     * @return the list of products
     */
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

    /**
     * Access the total cost
     *
     * @return the total cost
     */
    public float getCustoTotal() {
        return custoTotal;
    }

    /**
     * Define the total cost of
     *
     * @param custoTotal the total cost
     */
    public void setCustoTotal(float custoTotal) {
        this.custoTotal = custoTotal;
    }

    /**
     * Access the client
     *
     * @return the client
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define the client
     *
     * @param cliente the client
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Access the transportation price
     *
     * @return the transportation price
     */
    public float getPrecoTrans() {
        return precoTrans;
    }

    /**
     * Define the transportation price
     *
     * @param precoTrans the transportation price
     */
    public void setPrecoTrans(float precoTrans) {
        this.precoTrans = precoTrans;
    }

    /**
     * Access the date
     *
     * @return the date
     */
    public Date getData() {
        return data;
    }

    /**
     * Define the date
     *
     * @param data the date
     */
    public void setData(Date data) {
        this.data = data;
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
        boolean isHeavy = false;

        //calculates the final cost of each product of the list
        for (Produto p : listaProdutos) {

            // calculate the cost with the promotion if there is one
            if (p.getPromo() != null && data.between(p.getPromo().getDataInc(), p.getPromo().getDataExp())) {
                custoProd = p.getPromo().getDescontoProm(p);
            }
            //if not the price is normal
            else {
                custoProd = p.getPrecoUnit() * p.getStock();
            }

            //if the product is furniture it has weigth above 0
            //if that product's weight is above 15 the transportation cost add 10
            if (p.getPeso() > 15){
                isHeavy = true;
            }

            custoFinal += custoProd;
        }

        //adds an aditional cost for the trasportation of the products
        if (isFreq && custoFinal <= 40) {
            custoFinal += 15;
        } else if (!isFreq) {
            custoFinal += 20;
        }

        //add the extra cost for an heavy product
        if (isHeavy){
            custoFinal += 10;
        }

        this.custoTotal = custoFinal;

    }

    @Override
    public String toString() {
        String produtos = "";

        for (int i = 0; i < listaProdutos.size(); ++i) {
            produtos = produtos.concat("\n" + getProduto(i).getNome() + " -> " + getProduto(i).getStock() + " - " + (getProduto(i).getStock() * getProduto(i).getPrecoUnit()));
        }

        return "Compra efetuada em " + data + "\n" + produtos +
                "\nCliente:\n" + cliente +
                "\n\nTOTAL: " + custoTotal + "\n";
    }

}
