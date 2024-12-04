import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество выпиленных клеток:");
        int n = scanner.nextInt();
        Set<String> cells = new HashSet<>();

        System.out.println("Введите их координаты:");
        // Считываем координаты клеток и сохраняем их в множество
        for (int i = 0; i < n; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            cells.add(row + " " + col);
        }

        // Направления для проверки соседей: вверх, вниз, влево, вправо
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int perimeter = 0;

        // Для каждой клетки проверяем наличие соседей
        for (String cell : cells) {
            String[] parts = cell.split(" ");
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Если соседней клетки нет в множестве, то это граница
                if (!cells.contains(newRow + " " + newCol)) {
                    perimeter++;
                }
            }
        }

        System.out.println(perimeter); // Выводим периметр
    }
}