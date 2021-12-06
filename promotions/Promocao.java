package promotions;

import data.Date;
import products.Produto;

import java.io.Serializable;

public abstract class Promocao implements Serializable {
    protected Produto produto;
    protected Date dataExp;
    protected Date dataInc;

    public Promocao(){};

    public Promocao(Date dataExp,Date dataInc){
        this.dataExp=dataExp;
        this.dataInc=dataInc;


    }

    public Promocao(Produto produto,Date dataExp){
        this.dataExp=dataExp;
        this.produto=produto;
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
        return "Promocao{" +
                "produto=" + produto +
                ", dataExp=" + dataExp +
                '}';
    }


    public abstract float getDesontoProm(Produto prod);
}
