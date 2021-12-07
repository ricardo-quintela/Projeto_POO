package data;

import java.io.Serializable;
import java.util.InputMismatchException;

/**
 * <p>This class stores information about an email address</p>
 * <p>An email is considered to be a string of any character followed by the @ symbol and then another string of characters representing the domain</p>
 *
 * @author Ricardo Quintela
 */
public class Email implements Serializable {

    private String endereco;
    private String domain;


    /**
     * Default constructor
     */
    public Email() {
    }


    /**
     * Constructor
     *
     * @param endereco the e-mail address
     */
    public Email(String endereco) throws InputMismatchException {
        this.endereco = endereco;
        this.domain = genDomain(endereco);
    }


    /**
     * Constructor
     *
     * @param endereco the e-mail address
     * @param domain   the domain name
     */
    public Email(String endereco, String domain) {
        this.endereco = endereco;
        this.domain = domain;
    }


    /**
     * Generates the domain of an email address
     *
     * @param endereco the email address
     * @return the domain of the email address
     */
    public String genDomain(String endereco) throws InputMismatchException {
        int i = endereco.indexOf('@');

        if (i == -1) {
            System.out.println("Erro! Endereço de Email invalido!");
            throw new InputMismatchException();
        }

        return endereco.substring(i);
    }


    /**
     * Access the address
     *
     * @return the address
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define the address
     *
     * @param endereco the address
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Access the domain
     *
     * @return the domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Define the domain
     *
     * @param domain the domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }


    @Override
    public String toString() {
        return endereco;
    }
}
