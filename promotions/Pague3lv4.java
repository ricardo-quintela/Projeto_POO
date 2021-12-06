package promotions;

import data.Date;
import products.Produto;

public class Pague3lv4 extends Promocao {

    /**
     * Default constructor
     */
    public Pague3lv4() {
    }


    /**
     * Constructor
     *
     * @param dataExp the end date
     * @param dataInc the start date
     */
    public Pague3lv4(Date dataExp, Date dataInc) {
        super(dataExp, dataInc);
    }


    /**
     * Constructor
     *
     * @param produto the product
     * @param dataExp the end date
     * @param dataInc the start date
     */
    public Pague3lv4(Produto produto, Date dataExp, Date dataInc) {
        super(produto, dataExp, dataInc);
    }

    //fiz esta funcao para calcular o preco atendendo a promocao


    @Override
    public float getDescontoProm(Produto prod) {

        int num = prod.getStock() / 4;
        return (prod.getStock() - num) * prod.getPrecoUnit();
    }


    @Override
    public String toString() {
        return "pague 3 leve 4" + super.toString();
    }

}
