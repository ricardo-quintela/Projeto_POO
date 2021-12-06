package promotions;

import data.Date;
import products.Produto;

import java.io.Serializable;

public abstract class Promocao implements Serializable {
    protected Produto produto;
    protected Date dataExp;

    public Promocao(){};

    public Promocao(Date dataExp){
        this.dataExp=dataExp;

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

    @Override
    public String toString() {
        return "Promocao{" +
                "produto=" + produto +
                ", dataExp=" + dataExp +
                '}';
    }


    public abstract float getDesontoProm(Produto prod);
}
