package promotions;

import data.Date;
import products.Produto;

public class PagueMenos extends Promocao{
    public PagueMenos(Date dataExp){
        super(dataExp);
    }
    public PagueMenos(Produto produto,Date dataExp){
        super(produto,dataExp);
    }

    @Override
    public float getDesontoProm(Produto prod) {

        if(prod.getStock()<11){
            return (float) ((prod.getStock()*prod.getPrecoUnit())*(1-(prod.getStock()-1)*0.05));
        }else{
            return  (prod.getStock()*prod.getPrecoUnit())*(0.5F);
        }
    }

}
