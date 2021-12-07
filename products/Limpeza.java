package products;

/**
 * Stores the information about a cleaning product
 *
 * @author Miguel machado
 */
public class Limpeza extends Produto {
    private int grauTox;

    /**
     * Default constructor
     */
    public Limpeza() {
    }

    /**
     * Product Constructor
     *
     * @param id        the id
     * @param nome      the name of the product
     * @param precoUnit the price of each unit
     * @param stock     the units in stock
     */
    public Limpeza(int id, String nome, float precoUnit, int stock /*,Promocao promo*/) {
        super(id, nome, precoUnit, stock);
    }

    /**
     * Constructor
     *
     * @param id        the id
     * @param nome      the name of the product
     * @param precoUnit the price of each unit
     * @param stock     the units in stock
     * @param grauTox   the degree of toxicity
     */
    public Limpeza(int id, String nome, float precoUnit, int stock /*,Promocao promo*/, int grauTox) {

        super(id, nome, precoUnit, stock/*, promo*/);

        if (0 <= grauTox && grauTox < 11) {
            this.grauTox = grauTox;
        }
    }

    /**
     * Access the degree of toxicity
     *
     * @return the degree of toxicity
     */
    public int getGrauTox() {
        return grauTox;
    }

    /**
     * Define the degree of toxicity
     *
     * @param grauTox the degree of toxicity
     */
    public void setGrauTox(int grauTox) {
        this.grauTox = grauTox;
    }

    @Override
    public String toString() {
        return super.toString() +
                " e tem grau de toxicidade " + grauTox;
    }
}
