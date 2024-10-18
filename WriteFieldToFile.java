import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFieldToFile {

    public static void writeFieldToFile(int[] field) {
        if (field.length != 9) {
            throw new IllegalArgumentException("Поле должно содержать 9 элементов.");
        }

        try (FileOutputStream fos = new FileOutputStream("field.dat")) {
            // Преобразуем массив в 3 байта
            byte[] bytes = new byte[3];
            for (int i = 0; i < 9; i++) {
                bytes[i / 3] |= (field[i] & 0x03) << (2 * (i % 3));
            }
            fos.write(bytes);
            System.out.println("Состояние поля записано в field.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] field = {0, 1, 2, 0, 1, 2, 0, 3, 1}; // Пример состояния поля
        writeFieldToFile(field);
    }
}