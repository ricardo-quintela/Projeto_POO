
import products.Produto;

import java.util.ArrayList;

public class Compra {
    private ArrayList<Produto> listaProdutos;
    private Cliente cliente;

    public Compra(){}

    public Compra(ArrayList<Produto> listaProdutos,Cliente cliente){
        this.listaProdutos=listaProdutos;
        this.cliente=cliente ;
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


    @Override
    public String toString() {
        return "Compra{" +
                "listaProdutos=" + listaProdutos +
                "cliente=" + cliente +
                '}';
    }
}
