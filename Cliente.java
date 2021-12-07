import data.Email;
import data.Date;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Stores the information about a client
 *
 * @author Ricardo Quintela
 * @author Miguel Machado
 */
public class Cliente implements Serializable {
    private String nome, morada;
    private Email email;
    private int telefone;
    private Date dataNasc;
    private ArrayList<Compra> compras;


    /**
     * Default constructor
     */
    public Cliente() {
        compras = new ArrayList<>();
    }


    /**
     * Constructor
     *
     * @param nome     the name of the client
     * @param morada   the client's address
     * @param email    the client's e-mail address
     * @param telefone the client's phone number
     * @param dataNasc the client's birthdate
     */
    public Cliente(String nome, String morada, Email email, int telefone, Date dataNasc) {
        this();
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
    }

    /**
     * Access the name
     *
     * @return the name
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define the name
     *
     * @param nome the name
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Access the address
     *
     * @return the address
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Define the address
     *
     * @param morada the address
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Access the email
     *
     * @return the email
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Define the email
     *
     * @param email the email
     */
    public void setEmail(Email email) {
        this.email = email;
    }

    /**
     * Access the phone number
     *
     * @return the phone number
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * Define the phone number
     *
     * @param telefone the phone number
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * Access the birthdate
     *
     * @return the birthdate
     */
    public Date getDataNasc() {
        return dataNasc;
    }

    /**
     * Define the birthdate
     *
     * @param dataNasc the birthdate
     */
    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     * Access the list of purchases
     *
     * @return the list of purchases
     */
    public ArrayList<Compra> getCompras() {
        return compras;
    }

    /**
     * Define the list of purchases
     *
     * @param compras the list of purchases
     */
    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    /**
     * Add a purhcase to the list
     *
     * @param compra the purchase to add to the list
     */
    public void addCompra(Compra compra) {
        this.compras.add(compra);
    }

    /**
     * Remove a purchase to the list on the given index
     *
     * @param index the index of the purchase
     */
    public void removeCompra(int index) {
        this.compras.remove(index);
    }

    /**
     * Clears the purchases list
     */
    public void clearCompras() {
        this.compras.clear();
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nMorada: " + morada +
                "\nEmail: " + email +
                "\nTelefone: " + telefone +
                "\nData de nascimento: " + dataNasc;
    }
}
