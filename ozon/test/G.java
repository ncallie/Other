import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Program {
    public static final String EmptyVar = "...";
    public static final String xVar = "XXX";
    public static final String oVar = "000";
 
    public static int[] count(String all) {
        int[] arr = new int[2];
        for (char a : all.toCharArray()) {
            if (a == 'X')
                arr[0]++;
            else if (a == '0')
                arr[1]++;
        }
        return arr;
    }
 
 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countTests = Integer.parseInt(reader.readLine());
        for (int i = 0; i < countTests; ++i) {
            reader.readLine();
            String hor1 = reader.readLine();
            String hor2 = reader.readLine();
            String hor3 = reader.readLine();
 
            String all = hor1 + hor2 + hor3;
 
            int[] count = count(all); //0 -X 1 - O
 
 
            String ver1 = new StringBuilder().append(hor1.charAt(0)).append(hor2.charAt(0)).append(hor3.charAt(0)).toString();
            String ver2 = new StringBuilder().append(hor1.charAt(1)).append(hor2.charAt(1)).append(hor3.charAt(1)).toString();
            String ver3 = new StringBuilder().append(hor1.charAt(2)).append(hor2.charAt(2)).append(hor3.charAt(2)).toString();
 
            String diag1 = new StringBuilder().append(hor1.charAt(0)).append(hor2.charAt(1)).append(hor3.charAt(2)).toString();
            String diag2 = new StringBuilder().append(hor1.charAt(2)).append(hor2.charAt(1)).append(hor3.charAt(0)).toString();
 
 
 
 
            if (hor1.equals(EmptyVar) && hor2.equals(EmptyVar) && hor3.equals(EmptyVar)) {
                System.out.println("YES");
            }
            else if (hor1.equals(xVar) || hor2.equals(xVar) || hor3.equals(xVar) ||
                    ver1.equals(xVar) || ver2.equals(xVar) || ver3.equals(xVar))
            {
                if ((hor1.equals(oVar) || hor2.equals(oVar) || hor3.equals(oVar) ||
                        ver1.equals(oVar) || ver2.equals(oVar) || ver3.equals(oVar)))
                    System.out.println("NO");
                else if ((count[0] == 3 && count[1] == 2) ||
                        (count[0] == 4 && count[1] == 3) ||
                        (count[0] == 5 && count[1] == 4)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if (hor1.equals(oVar) || hor2.equals(oVar) || hor3.equals(oVar) ||
                    ver1.equals(oVar) || ver2.equals(oVar) || ver3.equals(oVar))
            {
                if ((count[0] == 3 && count[1] == 3) || (count[0] == 4 && count[1] == 4)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
 
            } else if (diag1.equals(xVar) || diag2.equals(xVar)) {
                if ((count[0] == 3 && count[1] == 2) ||
                        (count[0] == 5 && count[1] == 4) ||
                        (count[0] == 4 && count[1] == 3))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            } else if (diag1.equals(oVar) || diag2.equals(oVar)) {
                if ((count[0] == 3 && count[1] == 3) ||
                        (count[0] == 4 && count[1] == 4))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            else if (count[0] == count[1] + 1 || count[0] == count[1]) {
                System.out.println("YES");
            } else
                System.out.println("NO");
        }
 
    }
}
// G. Крестики-нолики (25 баллов)
// ограничение по времени на тест3 секунды
// ограничение по памяти на тест256 мегабайт
// вводстандартный ввод
// выводстандартный вывод
// Алиса и Боб играют в крестики-нолики 3×3. Алиса ходит первой и играет за крестики. Задано состояние поля в некоторый момент в виде матрицы из символов 3×3 (три строки, каждая длины три):

// символ '.' обозначает пустую клетку поля;
// символ 'X' обозначает клетку с крестиком;
// символ '0' обозначает клетку с ноликом.
// Напишите программу, которая проверит заданное поле, что оно могло быть состоянием некоторой корректной игры в какой-либо игровой момент.

// Помните, что в случае победы одного из игроков игра завершается.

// Входные данные
// Первая строка содержит целое число 𝑡 (1≤𝑡≤1000) — количество наборов входных данных в тесте.

// Далее следуют описания наборов, перед каждым из них в тесте содержится пустая строка.

// Каждый набор входных данных состоит из 3 строк длины 3. Допустимые символы строк: '.', 'X', '0'. Никаких больше ограничений на заданное поле нет.

// Неполные решения этой задачи могут быть оценены частичным баллом.

// Выходные данные
// Для каждого набора входных данных в отдельной строке выведите:

// YES, если заданное поле может быть корректным состоянием игры в любой её момент времени;
// NO в противном случае.
// Вы можете выводить YES и NO в любом регистре (например, строки yEs, yes, Yes и YES будут распознаны как положительный ответ).