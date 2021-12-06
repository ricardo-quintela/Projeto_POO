package files;

import java.io.*;
import java.util.ArrayList;

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
    public ArrayList<String> read(){
        //only read if the file exists
        if (! this.f.exists()) {
            System.out.println("Erro! Ocorreu um erro ao ler os dados guardados!");
            return null;
        }

        String line = null;
        ArrayList<String> text = new ArrayList<>();
        //open buffers and read the file
        try (BufferedReader br = new BufferedReader(new FileReader(this.f))) {
            //write the text on the file
            do {
                line = br.readLine();
                if (line != null){
                    text.add(line);
                }
            }while (line != null);

        } catch (IOException e) {
            text = null;
            System.out.println("Erro! Ocorreu um erro ao ler o ficheiro");
        }

        return text;
    }

}
