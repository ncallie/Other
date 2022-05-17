import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Program {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        int nice = 1;
        StringBuilder res = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numbTests = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numbTests; ++i) {
            int numTasks = Integer.parseInt(reader.readLine());
            List<Integer> data = new ArrayList<>(numTasks);
            int[] dataCopy = new int[numTasks];
            int[] result = new int[numTasks];
            String[] s = reader.readLine().split(" ");
            for (int j = 0; j < numTasks; ++j) {
                dataCopy[j] = Integer.parseInt(s[j]);
                data.add(dataCopy[j]);
            }
            while (!data.isEmpty()) {
                Integer max = data.stream().max(Integer::compareTo).get();
                for (int g = 0; g < dataCopy.length; ++g) {
                    if (dataCopy[g] == max || dataCopy[g] == (max - 1)) {
                        result[g] = nice;
                    }
                }
                data.removeIf(value -> (int)value == max || (value == (max - 1)));
                ++nice;
            }
            nice = 1;
            for (int c : result) {
                res.append(c).append(" ");
            }
            System.out.print(res + "\n");
            res.setLength(0);
        }
    }
}

// B. Приоритизация заданий (10 баллов)
// ограничение по времени на тест3 секунды
// ограничение по памяти на тест256 мегабайт
// вводстандартный ввод
// выводстандартный вывод
// Вам надо разработать подсистему простой приоритизации заданий.

// В системе есть 𝑛 заданий, 𝑖-е задание имеет важность 𝑟𝑖 (1≤𝑟𝑖≤109).

// Каждому заданию надо назначить nice-значение — целое число от 1 и более. Чем ниже это число, тем выше приоритет у задания.

// Пусть максимальное значение важности среди всех заданий равно 𝑚𝑎𝑥𝑟, тогда nice-значение равное 1 получат все задания с важностью 𝑚𝑎𝑥𝑟 и те, важность которых на 1 меньше.

// После этого удалим из рассмотрения все задания с назначенным nice-значением и назначим nice-значение 2, повторив описанную выше процедуру.

// После этого удалим из рассмотрения все задания с назначенным nice-значением и назначим nice-значение 3, повторив описанную выше процедуру.

// И так далее до тех пор, пока есть хотя бы одно задание без nice-значения.

// Для каждого задания выведите его nice-значение.

// Входные данные
// В первой строке записано целое число 𝑡 (1≤𝑡≤104) — количество наборов входных данных в тесте.

// Далее следуют описания наборов, каждый набор задается двумя строками.

// Первая из них содержит целое число 𝑛 (1≤𝑛≤2⋅105) — количество заданий.

// Вторая строка содержит 𝑛 целых чисел 𝑟1,𝑟2,…,𝑟𝑛 (1≤𝑟𝑖≤109) — важности заданий.

// Гарантируется, что сумма значений 𝑛 в тесте не превосходит 2⋅105.

// Неполные решения этой задачи могут быть оценены частичным баллом.

// Выходные данные
// Для каждого набора входных данных выведите одну строку, которая содержит 𝑛 чисел 𝑣1,𝑣2,…,𝑣𝑛, где 𝑣𝑖 — nice-значение, которое получило задание 𝑖.