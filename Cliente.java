import data.Email;
import data.Date;

import java.io.Serializable;
import java.util.ArrayList;

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
     * @param nome the name of the client
     * @param morada the client's address
     * @param email the client's e-mail address
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


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public void addCompra(Compra compra){
        this.compras.add(compra);
    }

    public void removeCompra(int index){
        this.compras.remove(index);
    }

    public void clearCompras(){
        this.compras.clear();
    }

    @Override
    public String toString() {
        return  "Nome: " + nome +
                "\nMorada: " + morada +
                "\nEmail: " + email +
                "\nTelefone: " + telefone +
                "\nData de nascimento: " + dataNasc;
    }
}
