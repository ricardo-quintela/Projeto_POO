package products;

import promotions.Promocao;

import java.io.Serializable;

/**
 * Stores the information about a product
 *
 * @author Miguel Machado
 */
public class Produto implements Serializable, Cloneable {
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
     * @param id        the id
     * @param nome      the name of the product
     * @param precoUnit the price of each unit
     * @param stock     the units in stock
     */
    public Produto(int id, String nome, float precoUnit, int stock, Promocao promo) {
        this.id = id;
        this.nome = nome;
        this.precoUnit = precoUnit;
        this.stock = stock;
        this.promo = promo;
    }


    /**
     * Constructor w/ out promotion
     *
     * @param id        the id
     * @param nome      the name of the product
     * @param precoUnit the price of each unit
     * @param stock     the units in stock
     */
    public Produto(int id, String nome, float precoUnit, int stock) {
        this.id = id;
        this.nome = nome;
        this.precoUnit = precoUnit;
        this.stock = stock;
    }

    /**
     * Get the weight of the product
     *
     * @return the weight of the product
     */
    public float getPeso() {
        return 0;
    }

    /**
     * Access the id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Define the id
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Access the name of the product
     *
     * @return the name of the product
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define the name of the product
     *
     * @param nome the name of the product
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Access the price of the product
     *
     * @return the price of the product
     */
    public float getPrecoUnit() {
        return precoUnit;
    }

    /**
     * Define the price of the product
     *
     * @param precoUnit the price of the product
     */
    public void setPrecoUnit(float precoUnit) {
        this.precoUnit = precoUnit;
    }

    /**
     * Access the stock of the product
     *
     * @return the stock of the product
     */
    public int getStock() {
        return stock;
    }

    /**
     * Define the stock
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Access the promotion
     *
     * @return the promotion
     */
    public Promocao getPromo() {
        return promo;
    }

    /**
     * Define the promotion
     *
     * @param promo the promotion
     */
    public void setPromo(Promocao promo) {
        this.promo = promo;
    }


    @Override
    public String toString() {
        String ret = nome +
                " tem codigo " + id +
                ", preco unidade " + precoUnit +
                "€, " + stock + " unidades";

        if (promo == null) {
            return ret;
        }

        return ret + ", aplicada a promocao " + promo;
    }


    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Erro! Impossivel clonar produto!");
            return null;
        }
    }
}
