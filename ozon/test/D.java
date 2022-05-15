import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Program {
    private static final char Green = 'G';
    private static final char Yellow = 'Y';
    private static final char Grey = '.';
    private static final char Empty = '0';
    private static final char Empty1 = '1';
 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        char[] s1 = reader.readLine().toCharArray();
        char[] s2 = reader.readLine().toCharArray();
 
        char [] res = new char[s1.length];
        Arrays.fill(res, Grey);
 
        if (s1.equals(s2)) {
            Arrays.fill(res, Green);
        }
 
        for (int i = 0; i < s1.length; ++i) {
            if (s2[i] == s1[i]) {
                res[i] = Green;
                s1[i] = Empty;
                s2[i] = Empty1;
            }
        }
 
        for (int i = 0; i < s1.length; ++i) {
            if (s1[i] == '0')
                continue;
            for (int j = 0; j <s1.length; ++j) {
                if (s2[j] == '1')
                    continue;
                if (s2[j] == s1[i]) {
                    res[j] = Yellow;
                    s1[i] = Empty;
                    s2[j] = Empty1;
                }
            }
            s1[i] = Empty;
        }
        System.out.println(res);
    }
}
// D. Wordle (25 баллов)
// ограничение по времени на тест3 секунды
// ограничение по памяти на тест256 мегабайт
// вводстандартный ввод
// выводстандартный вывод
// Wordle — браузерная игра в слова, разработанная программистом Джошем Уордлом.

// Вам предстоит написать часть реализации этой игры. По заданным двум словам 𝑠 и 𝑡 (они имеют одинаковые длины, состоят из прописных букв латинского алфавита) требуется вывести цветовой результат, если 𝑠 — загаданное слово, а 𝑡 — попытка угадать 𝑠.

// Пусть длины обоих слов равны 𝑛. Тогда цветовой результат состоит из 𝑛 цветов, соответствующих индексам. Цвет зелёный, если в этом индексе совпадают буквы в 𝑠 и 𝑡. Цвет жёлтый, если 𝑡𝑖 встречается где-то ещё в 𝑠. Иначе цвет серый. Обратите внимание, что каждая буква из 𝑠 применяется для окраски лишь единожды. Сначала назначаются все зелёные цвета, потом желтые в порядке слева направо.

// Например:

// если 𝑠=«ABBEY» и 𝑡=«ALGAE», то результат имеет вид: «зелёный-серый-серый-серый-жёлтый»;
// если 𝑠=«ABABAB» и 𝑡=«BABAAА», то результат имеет вид: «жёлтый-жёлтый-жёлтый-жёлтый-зелёный-серый».
// Напишите программу, которая по двум заданным словам 𝑠 и 𝑡 возвращает цветовой результат попытки хода.

// Входные данные
// В первой строке записано слово 𝑠. Во второй строке записано слово 𝑡. Они имеют одинаковые длины от 1 до 106, состоят из прописных букв латинского алфавита.

// Неполные решения этой задачи (например, недостаточно эффективные) могут быть оценены частичным баллом.

// Выходные данные
// Выведите цветовой результат в виде строки из символов:

// 'G' — зелёный цвет;
// 'Y' — жёлтый цвет;
// '.' — серый цвет.