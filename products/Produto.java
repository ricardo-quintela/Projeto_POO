package products;

import promotions.Promocao;

import java.io.Serializable;

public class Produto implements Serializable {
    protected int id;
    protected String nome;
    protected float precoUnit;
    protected int stock;
    protected Promocao promo;

    public Produto() {
    }

    /**
     * Constructor
     *
     * @param id the id
     * @param nome the name of the product
     * @param precoUnit the price of each unit
     * @param stock the units in stock
     */
    public Produto(int id, String nome, float precoUnit, int stock /*,Promocao promo*/) {
        this.id = id;
        this.nome = nome;
        this.precoUnit = precoUnit;
        this.stock = stock;
        this.promo = null;
        /* this.promo=promo;*/
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(float precoUnit) {
        this.precoUnit = precoUnit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Promocao getPromo() {
        return promo;
    }

    public void setPromo(Promocao promo) {
        this.promo = promo;
    }


    @Override
    public String toString() {
        String ret = nome +
                "tem codigo " + id +
                ", preco unidade " + precoUnit +
                ", existe " + stock + nome + "s ";

        if (promo != null) {
            return ret;
        }

        return ret + ", aplicada a promocao " + promo;
    }
}