package products;

public class Alimentar extends Produto{
    private int nCal;
    private int perGord;

    public Alimentar(){}

    public Alimentar(int id,String nome, float precoUnit,int stock /*,Promocao promo*/,int nCal,int perGord){

        super(id, nome, precoUnit, stock/*, promo*/);
        this.nCal=nCal;
        this.perGord=perGord;


    }

    public int getnCal() {
        return nCal;
    }

    public void setnCal(int nCal) {
        this.nCal = nCal;
    }

    public int getPerGord() {
        return perGord;
    }

    public void setPerGord(int perGord) {
        this.perGord = perGord;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", tem por 100 gramas, " + nCal + " calorias "+
                "e a sua percentagem de gordura é " + perGord ;
    }
}
