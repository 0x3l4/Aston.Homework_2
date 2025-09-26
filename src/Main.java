import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    // В параметрах задал test.txt
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Трубется имя файла.");
            return;
        }

        String fileName = args[0];

        if (!isValidFileName(fileName)) {
            System.out.println("Заданы неверные параметры.");
            return;
        }

        try {
            String text = "Вы просили не добавлять лишнего кода.\n" +
                    "Реализация метода isValidFileName была упрощена.";

            // Вызов метода ниже вызывает исключение FileReadException:
            // readFromFile(fileName);

            System.out.println("Начинаю запись в файл...");
            writeToFile(fileName, text);

            System.out.println("Начинаю чтение файла...");
            String fileText = readFromFile(fileName);
            System.out.println(fileText);
        }
        catch (FileWriteException | FileReadException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isValidFileName(String fileName) {
        return !fileName.isBlank();
    }

    public static void writeToFile(String fileName, String text) throws FileWriteException {
        try(FileWriter fileWriter = new FileWriter(fileName, false)) {
            fileWriter.write(text);
        } catch (IOException e) {
            throw new FileWriteException("Ошибка при записи в файл.", fileName);
        }
    }

    public static String readFromFile(String fileName) throws FileReadException {
        StringBuilder stringBuilder = new StringBuilder();

        try(FileReader fileReader = new FileReader(fileName)) {
            int c;
            while((c=fileReader.read())!=-1){
                stringBuilder.append((char)c);
            }
        } catch (IOException e) {
            throw new FileReadException("Ошибка при чтении из файла.", fileName);
        }

        return stringBuilder.toString();
    }
}