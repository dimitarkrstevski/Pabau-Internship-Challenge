import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the matrix size:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        char [][]grid = new char [rows][cols];
        System.out.println("Enter the path:"); // "," for space
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = line.charAt(0);
            }
        }
        List<Character> L = new ArrayList<>();
        int row = 0;
        int col = 0;
        StringBuilder path = new StringBuilder();
        while (grid[row][col] != 's') {
            char current = grid[row][col];
            if (current != ',' && current != '+' && current != '|' && Character.isLetter(current)) {
                if(Character.isUpperCase(current)){
                    L.add(current);
                }
            }
            path.append("(").append(row).append(",").append(col).append(") -> ");

            // Moving next position
            if (current == '>') {
                col++;
            } else if (current == '+' || current == '-') {
                if (row > 0 && grid[row - 1][col] != ',') {
                    row--;
                } else if (row < grid.length - 1 && grid[row + 1][col] != ',') {
                    row++;
                } else if (col > 0 && grid[row][col - 1] != ',') {
                    col--;
                } else if (col < grid[0].length - 1 && grid[row][col + 1] != ',') {
                    col++;
                }
            }
            if (grid[row][col] == 's') {
                path.append("(").append(row).append(",").append(col).append(")");
                break;
            }
        }
        System.out.println("Path: " + path.toString());
        System.out.println("Letters in the path: " + L);
        scanner.close();
    }
}