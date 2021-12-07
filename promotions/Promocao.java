package promotions;

import data.Date;
import products.Produto;

import java.io.Serializable;

/**
 * <p>Stores the information about a promotion</p>
 * <p>Allows the programmer to calculate the cost of an associated product</p>
 *
 * @author Miguel Machado
 */
public abstract class Promocao implements Serializable {
    protected Produto produto;
    protected Date dataExp;
    protected Date dataInc;


    /**
     * Default constructor
     */
    public Promocao() {
    }

    ;


    /**
     * Constructor
     *
     * @param dataExp end date
     * @param dataInc start date
     */
    public Promocao(Date dataExp, Date dataInc) {
        this.dataExp = dataExp;
        this.dataInc = dataInc;
    }


    /**
     * Constructor
     *
     * @param produto the product
     * @param dataExp the end date
     * @param dataInc the start date
     */
    public Promocao(Produto produto, Date dataExp, Date dataInc) {
        this.dataExp = dataExp;
        this.produto = produto;
        this.dataInc = dataInc;
    }


    /**
     * Access the product
     *
     * @return the product
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Define the product
     *
     * @param produto the product
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Access the expire date
     *
     * @return the expire date
     */
    public Date getDataExp() {
        return dataExp;
    }

    /**
     * Define the expire date
     *
     * @param dataExp the expire date
     */
    public void setDataExp(Date dataExp) {
        this.dataExp = dataExp;
    }

    /**
     * Access the start date
     *
     * @return the start date
     */
    public Date getDataInc() {
        return dataInc;
    }

    /**
     * Define the start date
     *
     * @param dataInc the start date
     */
    public void setDataInc(Date dataInc) {
        this.dataInc = dataInc;
    }

    @Override
    public String toString() {
        return " valida de " + dataInc + " a " + dataExp;
    }


    /**
     * Calculates the price of a product with the promotion
     *
     * @param prod the product
     */
    public abstract float getDescontoProm(Produto prod);
}
