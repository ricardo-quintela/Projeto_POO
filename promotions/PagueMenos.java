package promotions;

import data.Date;
import products.Produto;

public class PagueMenos extends Promocao {

    /**
     * Default constructor
     */
    public PagueMenos(){}


    /**
     * Constructor
     *
     * @param dataExp end date
     * @param dataInc start date
     */
    public PagueMenos(Date dataExp, Date dataInc) {
        super(dataExp, dataInc);
    }


    /**
     * Constructor
     * @param produto the product
     * @param dataExp the end date
     * @param dataInc the start date
     */
    public PagueMenos(Produto produto, Date dataExp, Date dataInc) {
        super(produto, dataExp, dataInc);
    }


    @Override
    public float getDescontoProm(Produto prod) {

        if (prod.getStock() < 11) {
            return (float) ((prod.getStock() * prod.getPrecoUnit()) * (1 - (prod.getStock() - 1) * 0.05));
        } else {
            return (prod.getStock() * prod.getPrecoUnit()) * (0.5F);
        }
    }


    @Override
    public String toString() {
        return "pague menos" + super.toString();
    }
}
