package controller.file_handlers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigHandler {

    // TODO: исправить абсолютную ссылку на относительную!

    private final String FILE_NAME = "E:\\repository\\Java-Calculator\\src\\resources\\config.txt";
    private Double memoryData;

    public double getMemoryData(){
        return memoryData;
    }

    public void setMemoryData(Double memoryData){
        this.memoryData = memoryData;
    }

    public void readConfig(){
        // Пометка: конструкция try-with-resources для автоматического закрытия обработки файла.
        try (BufferedReader memoryReader = new BufferedReader(new FileReader(FILE_NAME))){
            String line = memoryReader.readLine();
            if (line == null || line.length() < 7) System.err.println("Неверный формат данных!");
            try{
                memoryData = Double.parseDouble(line.substring(7));
            }
            catch (NumberFormatException numberFormatException){
                System.err.println("Ошибка конвертации: " + numberFormatException.getMessage());
            }
        }
        catch(IOException exception){
            System.err.println("Ошибка чтения файла: " + exception.getMessage());
        }
    }

    public void saveConfig(){
        
    }
}
