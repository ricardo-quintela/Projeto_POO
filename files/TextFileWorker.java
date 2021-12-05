package Files;

import java.io.*;

public class TextFileWorker {
    private File f;

    /**
     * Default constructor
     */
    public TextFileWorker() {
    }


    /**
     * Constructor
     *
     * @param path the path to the file
     */
    public TextFileWorker(String path) {
        this.f = new File(path);

        if (!f.exists()) {
            System.out.println("Erro! Ficheiro nao existe!");
            this.f = null;
        }
    }


    public File getF() {
        return f;
    }

    public void setF(String path) {
        this.f = new File(path);
    }


    @Override
    public String toString() {
        return "Ficheiro em" + f;
    }


    /**
     * Write on the file if it exists
     *
     * @param text the text to write on the file
     */
    public void write(String text) {
        //only write if the file exists
        if (this.f == null) {
            System.out.println("Erro! Ficheiro nao existe!");
            return;
        }

        //open buffers and write on the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.f))) {
            //write the text on the file
            bw.write(text);

        } catch (IOException e) {
            System.out.println("Erro! Ocorreu um erro ao escrever no ficheiro");
        }
    }

    /**
     * Reads the contents of the file
     * @return the file contents
     */
    public String read(){
        //only read if the file exists
        if (this.f == null) {
            System.out.println("Erro! Ficheiro nao existe!");
            return null;
        }

        String text = null;
        //open buffers and read the file
        try (BufferedReader br = new BufferedReader(new FileReader(this.f))) {
            //write the text on the file
            text = br.readLine();

        } catch (IOException e) {
            text = null;
            System.out.println("Erro! Ocorreu um erro ao ler o ficheiro");
        }

        return text;
    }

}
