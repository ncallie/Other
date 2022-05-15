import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countTests = Integer.parseInt(reader.readLine());
        for (int j = 0; j < countTests; ++j) {
            int countProducts = Integer.parseInt(reader.readLine());
            HashMap<Integer, Integer> mapProducts = new HashMap<>();
            String[] s = reader.readLine().split(" ");
            for (String product : s) {
                int price = Integer.parseInt(product);
                if (mapProducts.containsKey(price)) {
                    mapProducts.put(price, (mapProducts.get(price) + 1));
                }
                else
                    mapProducts.put(price, 1);
            }
            int res = 0;
            for (Map.Entry<Integer, Integer> entry : mapProducts.entrySet()) {
                int countFree = entry.getValue() / 3;
                entry.setValue(entry.getValue() - countFree);
                res += entry.getValue() * entry.getKey();
            }
            System.out.print(res + "\n");
        }
    }
}

// A. Сумма к оплате (10 баллов)
// ограничение по времени на тест1 секунда
// ограничение по памяти на тест256 мегабайт
// вводстандартный ввод
// выводстандартный вывод
// В магазине акция: «купи три одинаковых товара и заплати только за два». Конечно, каждый купленный товар может участвовать лишь в одной акции. Акцию можно использовать многократно.

// Например, если будут куплены 7 товаров одного вида по цене 2 за штуку и 5 товаров другого вида по цене 3 за штуку, то вместо 7⋅2+5⋅3 надо будет оплатить 5⋅2+4⋅3=22.

// Считая, что одинаковые цены имеют только одинаковые товары, найдите сумму к оплате.

// Неполные решения этой задачи (например, недостаточно эффективные) могут быть оценены частичным баллом.

// Входные данные
// В первой строке записано целое число 𝑡 (1≤𝑡≤104) — количество наборов входных данных.

// Далее записаны наборы входных данных. Каждый начинается строкой, которая содержит 𝑛 (1≤𝑛≤2⋅105) — количество купленных товаров. Следующая строка содержит их цены 𝑝1,𝑝2,…,𝑝𝑛 (1≤𝑝𝑖≤104). Если цены двух товаров одинаковые, то надо считать, что это один и тот товар.

// Гарантируется, что сумма значений 𝑛 по всем тестам не превосходит 2⋅105.

// Выходные данные
// Выведите 𝑡 целых чисел — суммы к оплате для каждого из наборов входных данных.