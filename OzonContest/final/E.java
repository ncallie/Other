import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Program {
    public static StringBuilder res = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countTests = Integer.parseInt(reader.readLine());
        for (int test = 0; test < countTests; ++test) {
            reader.readLine();
            String[] s = reader.readLine().split(" ");
            int countСoupe = Integer.parseInt(s[0]);
            int requests = Integer.parseInt(s[1]);
            List<Integer[][]> wagon = new ArrayList<>(countСoupe);
            int seat = 1;
            for (int i = 0; i < countСoupe; ++i) {
                Integer[][] coupe = new Integer[2][2];
                coupe[0][0] = seat++;
                coupe[0][1] = 0;
                coupe[1][0] = seat++;
                coupe[1][1] = 0;
                wagon.add(coupe);
            }
            for (int i = 0; i < requests; ++i) {
                String[] s1 = reader.readLine().split(" ");
                int request = Integer.parseInt(s1[0]);
                switch (request) {
                    case 1:
                        buySeat(wagon, Integer.parseInt(s1[1]));
                        break;
                    case 2:
                        returnSeat(wagon, Integer.parseInt(s1[1]));
                        break;
                    case 3:
                        buyCoupe(wagon);
                        break;
                }
            }
            System.out.print(res.append("\n"));
            res.setLength(0);
        }
    }

    private static void buyCoupe(List<Integer[][]> wagon) {

        for (Integer[][] coupe : wagon) {
            if (coupe[0][1] == 0 && coupe[1][1] == 0) {
                coupe[0][1] = 1;
                coupe[1][1] = 1;
                res.append("SUCCESS ").append(coupe[0][0]).append("-").append(coupe[1][0]).append("\n");
                return;
            }
        }
        res.append("FAIL\n");
    }

    private static void returnSeat(List<Integer[][]> wagon, int seat) {
        int numCoupe = seat % 2 == 0 ? (seat / 2) - 1 : (seat / 2);
        Integer[][] integers = wagon.get(numCoupe);
        if (seat % 2 != 0) {
            if (integers[0][1] == 1) {
                integers[0][1] = 0;
                wagon.set(numCoupe, integers);
                res.append("SUCCESS\n");
            }
            else {
                res.append("FAIL\n");
            }
        }
        else {
            if (integers[1][1] == 1) {
                integers[1][1] = 0;
                wagon.set(numCoupe, integers);
                res.append("SUCCESS\n");
            }
            else {
                res.append("FAIL\n");
            }
        }

    }

    private static void buySeat(List<Integer[][]> wagon, int seat) {
        int numCoupe = seat % 2 == 0 ? (seat / 2) - 1 : (seat / 2);
        Integer[][] integers = wagon.get(numCoupe);
        if (seat % 2 != 0) {
            if (integers[0][1] == 0) {
                integers[0][1] = 1;
                wagon.set(numCoupe, integers);
                res.append("SUCCESS\n");
            }
            else {
                res.append("FAIL\n");
            }
        }
        else {
            if (integers[1][1] == 0) {
                integers[1][1] = 1;
                wagon.set(numCoupe, integers);
                res.append("SUCCESS\n");
            }
            else {
                res.append("FAIL\n");
            }
        }
    }
}

// E. Система продажи билетов на поезда (20 баллов)
// ограничение по времени на тест10 секунд
// ограничение по памяти на тест256 мегабайт
// вводстандартный ввод
// выводстандартный вывод
// Есть вагон, в котором 𝑛 купе, каждое купе содержит 2 места (купе типа СВ). Места пронумерованы от 1 до 2𝑛 подряд (места 1-2 — это первое купе, места 3-4 — второе и так далее). Надо обрабатывать три вида запросов:

// купить билет на заданное место (надо ответить SUCCESS или FAIL в зависимости свободно оно сейчас или нет) и пометить это место занятым;
// вернуть билет на заданное место (ответить SUCCESS или FAIL в зависимости удачно завершилась операция или нет) и разметить место, то есть SUCCESS надо выводить, если место было на данный момент занято;
// выкупить целиком купе (ответить либо FAIL, либо вывести SUCCESS X-Y — границу мест в первом полностью свободном купе), пометить все места этого купе занятыми.
// Обработайте все запросы.

// Неполные решения этой задачи (например, недостаточно эффективные) могут быть оценены частичным баллом.

// Входные данные
// В первой строке записано целое число 𝑡 (1≤𝑡≤104) — количество наборов входных данных в тесте.

// Далее следуют описания 𝑡 наборов входных данных. Перед каждым описанием набора входных данных записана пустая строка.

// Описание каждого набора начинается строкой, в которой записаны два целых числа 𝑛 и 𝑞 (1≤𝑛≤3⋅105, 1≤𝑚≤6⋅105) — количество купе в вагоне и количество запросов для обработки.

// Далее следуют сами запросы по одному в строке:

// запрос на покупку конкретного места записан как два числа: «1 p», где 𝑝 — целое число от 1 до 2𝑛 (номер места);
// запрос на сдачу билета по номеру места записан как два числа: «2 p», где 𝑝 — целое число от 1 до 2𝑛 (номер места);
// запрос на то, чтобы выкупить первое полностью свободное купе, записан как строка с одним целым числом 3.
// Гарантируется, что сумма значений 𝑛 по всем наборам входных данных не превосходит 3⋅105. Аналогично, гарантируется, что сумма значений 𝑚 по всем наборам входных данных не превосходит 6⋅105.

// Выходные данные
// Для каждого набора входных данных выведите ответы на него, по одному ответу на запрос в строке:

// для запроса 1-го типа: если место было свободно, то выведите SUCCESS, иначе выведите FAIL;
// для запроса 2-го типа: если место было занято, то выведите SUCCESS, иначе выведите FAIL;
// для запроса 3-го типа: если было хотя бы одно полностью пустое купе, то выведите SUCCESS X-Y (где X-Y — места первого свободного купе, которое нашла ваша программа), иначе выведите FAIL.
// Выведите пустую строку после каждого ответа для набора входных данных.