package products;

/**
 * Stores the information about a food product
 *
 * @author Miguel Machado
 */
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
    public Alimentar(int id, String nome, float precoUnit, int stock) {
        super(id, nome, precoUnit, stock);
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
    public Alimentar(int id, String nome, float precoUnit, int stock, int nCal, int perGord) {

        super(id, nome, precoUnit, stock);
        this.nCal = nCal;
        this.perGord = perGord;
    }

    /**
     * Access the number of calories
     *
     * @return the number of calories
     */
    public int getnCal() {
        return nCal;
    }

    /**
     * Define the number of calories
     *
     * @param nCal the number of calories
     */
    public void setnCal(int nCal) {
        this.nCal = nCal;
    }

    /**
     * Access the percentage of fat
     *
     * @return the percentage of fat
     */
    public int getPerGord() {
        return perGord;
    }

    /**
     * Define the percentage of fat
     *
     * @param perGord the percentage of fat
     */
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
