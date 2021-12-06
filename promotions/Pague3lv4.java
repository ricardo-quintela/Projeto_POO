package promotions;

import data.Date;
import products.Produto;

public class Pague3lv4 extends Promocao{
    public Pague3lv4(Date dataExp,Date dataInc){
        super(dataExp,dataInc);
    }
    public Pague3lv4(Produto produto,Date dataExp){
        super(produto,dataExp);
    }

    //fiz esta funcao para calcular o preco atendendo a promocao



    @Override
    public float getDesontoProm(Produto prod) {

        int num= prod.getStock() /4;
        return  (prod.getStock()-num)*prod.getPrecoUnit();
    }

}
