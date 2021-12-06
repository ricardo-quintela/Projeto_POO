package promotions;

import data.Date;
import products.Produto;

import java.io.Serializable;

public abstract class Promocao implements Serializable {
    protected Produto produto;
    protected Date dataExp;
    protected Date dataInc;


    /**
     * Default constructor
     */
    public Promocao(){};


    /**
     * Constructor
     *
     * @param dataExp end date
     * @param dataInc start date
     */
    public Promocao(Date dataExp,Date dataInc){
        this.dataExp=dataExp;
        this.dataInc=dataInc;
    }


    /**
     * Constructor
     * @param produto the product
     * @param dataExp the end date
     * @param dataInc the start date
     */
    public Promocao(Produto produto,Date dataExp, Date dataInc){
        this.dataExp=dataExp;
        this.produto=produto;
        this.dataInc = dataInc;
    }


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getDataExp() {
        return dataExp;
    }

    public void setDataExp(Date dataExp) {
        this.dataExp = dataExp;
    }

    public Date getDataInc() {return dataInc;}

    public void setDataInc(Date dataInc) {this.dataInc = dataInc;}

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
