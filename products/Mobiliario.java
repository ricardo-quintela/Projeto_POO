package products;

import java.io.Serializable;

public class Mobiliario extends Produto implements Serializable {
    private float peso;
    private float[] dimensao;

    /**
     * Default constructor
     */
    public Mobiliario() {}


    /**
     * Constructor
     * @param peso the weight of the product
     * @param dimensao the size of the product
     */
    public Mobiliario(int id,String nome, float precoUnit,int stock /*,Promocao promo*/, float peso, float[] dimensao) {
        super(id, nome, precoUnit, stock/*, promo*/);
        this.peso = peso;
        this.dimensao = dimensao;
    }


    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float[] getDimensao() {
        return dimensao;
    }

    public void setDimensao(float[] dimensao) {
        this.dimensao = dimensao;
    }


    @Override
    public String toString() {
        return super.toString() +
                " que pesa " + peso +
                "kg e mede " + dimensao[0] + "m de comprimento, "
                + dimensao[1] + "m de largura e " +
                dimensao[2] + "m de altura";
    }
}
