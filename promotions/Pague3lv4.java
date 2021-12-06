package promotions;

import data.Date;
import products.Produto;

public class Pague3lv4 extends Promocao{
    public Pague3lv4(Date dataExp){
        super(dataExp);
    }
    public Pague3lv4(Produto produto,Date dataExp){
        super(produto,dataExp);
    }

    //fiz esta funcao para calcular o preco atendendo a promocao



    @Override
    public float getDesontoProm(Produto prod) {

        int numProm= prod.getStock() /4;
        int resto=prod.getStock()%4;
        int newStock=numProm*3+resto;


        return  newStock*prod.getPrecoUnit();
    }

}
