package data;

import java.io.Serializable;

/**
 * Class to easily store a date (format DD/MM/AAAA)
 *
 * <p>Automatically validates the date if the given numbers cannot form a valid date
 *
 * <p>The programmer can use the "set" and "get" methods for all the attributes to fix a erroneous input
 *
 * <p>The instance of this class can be compared with other instances to check if it's equal or is between a range of 2 other dates</p>
 *
 * @author Ricardo Quintela
 */
public class Date implements Serializable {
    private int dia, mes, ano;

    /**
     * Default constructor
     */
    public Date() {
    }

    /**
     * Constructor of the class data.Data
     *
     * @param dia - the day
     * @param mes - the month
     * @param ano - the year
     */
    public Date(int dia, int mes, int ano) {
        //checks for each argument if they are > 0, sets them to 1 otherwise
        this.mes = mes > 0 && mes <= 12 ? mes : 1;
        this.dia = dayCheck(dia); //checks if the day can belong to the given month
        this.ano = ano > 0 ? ano : 1;
    }

    /**
     * Checks if the given day can belong to the given month
     *
     * @param dia - the day
     * @return the given day if it possible to be in the month; 1 otherwise
     */
    private int dayCheck(int dia) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        //check if the given day can belong to the given month
        if (dia > months[this.mes - 1]) {
            return 1;
        }
        return dia;
    }

    /**
     * Define the attribute dia
     *
     * @param dia - the day
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Access the attribute dia
     *
     * @return the day
     */
    public int getDia() {
        return this.dia;
    }


    /**
     * Define the attribute mes
     *
     * @param mes - the month
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Access the attribute mes
     *
     * @return the month
     */
    public int getMes() {
        return this.mes;
    }


    /**
     * Define the attribute ano
     *
     * @param ano - the year
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Access the attribute ano
     *
     * @return the year
     */
    public int getAno() {
        return this.ano;
    }


    //documentaion already provided
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }


    /**
     * Checks if the given date is the same as the current
     *
     * @param d - the date to be compared
     * @return the truth value of the comparison
     */
    public boolean compare(Date d) {
        return this.dia == d.getDia() && this.mes == d.getMes() && this.ano == d.getAno();
    }

    /**
     * Check if this date is between 2 other dates
     *
     * @param d1 date 1
     * @param d2 date 2
     * @return true if it is in range; false otherwise
     */
    public boolean between(Date d1, Date d2) {
        return d1.dia <= this.dia && this.dia <= d2.dia && d1.mes <= this.mes && this.mes <= d2.mes && d1.ano <= this.ano && this.ano <= d2.ano;
    }

}
