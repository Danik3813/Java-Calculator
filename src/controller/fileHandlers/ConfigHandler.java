package controller.fileHandlers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigHandler {
    private final String FILE_NAME = "resources/config.txt";
    private double memoryData;

    public double getMemoryData(){
        return memoryData;
    }

    public void setMemoryData(double memoryData){
        this.memoryData = memoryData;
    }

    public void readConfig(){
        // Пометка: конструкция try-with-resources для автоматического закрытия обработки файла.
        try (BufferedReader memoryReader = new BufferedReader(new FileReader(FILE_NAME))){
            String line = memoryReader.readLine();
            if (line == null || line.length() < 5) System.err.println("Неверный формат данных!");
            try{
                memoryData = Double.parseDouble(line.substring(5));
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
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))){
            bufferedWriter.write("data:" + memoryData);
        }
        catch(IOException exception){
            System.err.println("Ошибка чтения файла: " + exception.getMessage());
        }
    }
}
