import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BackupFiles {

    public static void backupFiles() {
        File backupDir = new File("./backup");
        if (!backupDir.exists()) {
            backupDir.mkdir(); // Создаем директорию ./backup, если она не существует
        }

        File currentDir = new File(".");
        File[] files = currentDir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) { // Проверяем, что это файл
                    try {
                        Path sourcePath = file.toPath();
                        Path destinationPath = backupDir.toPath().resolve(file.getName());
                        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Скопирован: " + file.getName() + " в " + backupDir.getAbsolutePath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        backupFiles();
    }
}