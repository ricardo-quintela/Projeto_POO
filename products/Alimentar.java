package products;

public class Alimentar extends Produto {
    private int nCal;
    private int perGord;


    /**
     * Default constructor
     */
    public Alimentar() {
    }


    /**
     * Product Constructor
     *
     * @param id        the id
     * @param nome      the name of the product
     * @param precoUnit the price of each unit
     * @param stock     the units in stock
     */
    public Alimentar(int id, String nome, float precoUnit, int stock /*,Promocao promo*/) {
        this.id = id;
        this.nome = nome;
        this.precoUnit = precoUnit;
        this.stock = stock;
        this.promo = null;
        /* this.promo=promo;*/
    }


    /**
     * Constructor
     *
     * @param id        the id
     * @param nome      the name of the product
     * @param precoUnit the price of the product
     * @param stock     the units in stock
     * @param nCal      the number of calories
     * @param perGord   the percentage of fat
     */
    public Alimentar(int id, String nome, float precoUnit, int stock /*,Promocao promo*/, int nCal, int perGord) {

        super(id, nome, precoUnit, stock/*, promo*/);
        this.nCal = nCal;
        this.perGord = perGord;


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
        return super.toString() +
                ", tem por 100 gramas, " + nCal + " calorias " +
                "e a sua percentagem de gordura é " + perGord;
    }
}