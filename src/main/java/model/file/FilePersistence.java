package model.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilePersistence {
    
    private static final Logger LOGGER = Logger.getLogger(FilePersistence.class.getName());
    
    public void saveToFile(String texto, String filePath) {
        try (FileWriter arq = new FileWriter(filePath)) {
            arq.write(texto);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public String loadFromFile(String filePath) {
        garantirArquivoPessoa(filePath);
        
        StringBuilder conteudoLido = new StringBuilder();
        File file = new File(filePath);
        
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                conteudoLido.append(scanner.nextLine()).append(System.lineSeparator());
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return conteudoLido.toString().trim();
    }

    public void garantirArquivoPessoa(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("[]");  // conteúdo JSON vazio
                }
                LOGGER.info("Arquivo criado: " + filePath);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao criar arquivo: " + filePath, e);
        }
    }
}