package products;

public class Limpeza extends Produto{
    private int grauTox;
    public Limpeza(int id,String nome, float precoUnit,int stock /*,Promocao promo*/,int grauTox){

        super(id, nome, precoUnit, stock/*, promo*/);

        if(0<=grauTox && grauTox < 11){
        this.grauTox=grauTox;}
    }

    public int getGrauTox() {
        return grauTox;
    }

    public void setGrauTox(int grauTox) {
        this.grauTox = grauTox;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "e tem grau de toxicidade" + grauTox;
    }
}

