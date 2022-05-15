import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countTest = Integer.parseInt(reader.readLine());
        for (int i = 0; i < countTest; ++i) {
            reader.readLine();
            int countTask = Integer.parseInt(reader.readLine());
            TreeMap<Integer, Integer> tasks = new TreeMap<>();
            for (int j = 0; j < countTask; ++j) {
                String[] s = reader.readLine().split(" ");
                tasks.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            }
            int index = 0;
            int [] res = new int[countTask];
            for(Map.Entry<Integer, Integer> entry :tasks.entrySet()) {
                if (index == 0) {
                    res[index] = entry.getKey() + entry.getValue();
                    index++;
                    continue;
                }
                if (res[index - 1] > entry.getKey()) {
                    res[index] = res[index - 1] + entry.getValue();
                    index++;
                }
                else {
                    res[index] = entry.getKey() + entry.getValue();
                    index++;
                }
            }
            for (int re : res) {
                System.out.print(re + " ");
            }
            System.out.println();
        }
    }
}
// E1. Однопоточный сервер (25 баллов)
// ограничение по времени на тест3 секунды
// ограничение по памяти на тест256 мегабайт
// вводстандартный ввод
// выводстандартный вывод
// В этой задаче вам предстоит промоделировать работу простейшего однопоточного сервера.

// Сервер умеет обрабатывать задания. Каждое задание характеризуется двумя величинами 𝑡𝑖 (момент времени, когда оно попало на сервер) и 𝑑𝑖 (длительность выполнения). Если сервер свободен и в момент времени 𝑡𝑖 на него попало задание длительности 𝑑𝑖, то в момент времени 𝑡𝑖+𝑑𝑖 он закончит его выполнение и будет готов начать обработку нового задания.

// Если задание не может быть обработано в момент его поступления в систему, то оно помещается в очередь. После освобождения сервера из очереди будет изъято для обработки первое помещённое туда задание.

// Вам задана последовательность из 𝑛 заданий для обработки. Они заданы в хронологическом порядке, то есть 𝑡𝑖<𝑡𝑖+1 для всех 𝑖 от 1 до 𝑛−1.

// Для каждого задания выведите момент времени окончания его обработки.

// Входные данные
// В первой строке записано целое число 𝑞 (1≤𝑞≤104) — количество наборов входных данных в тесте.

// Далее следуют наборы входных данных. Перед каждым из них в тесте записана пустая строка.

// Каждый набор начинается строкой, содержащей одно целое число 𝑛 (1≤𝑛≤2⋅105) — количество заданий, которые поступят на сервер. Сервер изначально свободен.

// Далее следуют 𝑛 строк, каждая описывает одно задание. Задание задаётся парой целых чисел 𝑡𝑖, 𝑑𝑖 (1≤𝑡𝑖≤106,1≤𝑑𝑖≤104). Гарантируется, что задания отсортированы хронологически, то есть 𝑡𝑖<𝑡𝑖+1 для всех 𝑖 от 1 до 𝑛−1. Никакие два задания не приходят в один момент времени.

// Гарантируется, что сумма значений 𝑛 по всем наборам входных данных в тесте не превосходит 2⋅105.

// Неполные решения этой задачи (например, недостаточно эффективные) могут быть оценены частичным баллом.

// Выходные данные
// Для каждого набора входных данных выведите строку из 𝑛 целых чисел 𝑒1,𝑒2,…,𝑒𝑛, где 𝑒𝑖 — момент времени окончания обработки 𝑖-го задания.