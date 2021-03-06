// C. Дельта-кодирование (15 баллов)
// ограничение по времени на тест3 секунды
// ограничение по памяти на тест256 мегабайт
// вводстандартный ввод
// выводстандартный вывод
// Дельта-кодирование (англ. Delta encoding) — способ представления данных в виде разницы (дельты) между последовательными данными вместо самих данных.

// В этой задаче для последовательности 𝑎=[𝑎1,𝑎2,…,𝑎𝑛] результатом её дельта-кодирования будет последовательность разностей соседних элементов: [𝑎2−𝑎1,𝑎3−𝑎2,…,𝑎𝑛−𝑎𝑛−1]. Длина результата кодирования на единицу меньше длины кодируемой последовательности.

// Например, если 𝑎=[3,1,4,1,6,0], то в результате дельта-кодирования получится [−2,3,−3,5,−6].

// Ваша задача произвести обратное преобразование, если известно, что элементы кодируемой последовательности были неотрицательными целыми числами (𝑎𝑖≥0) и среди них встречалось значение 0.

// Входные данные
// Входные данные состоят из двух строк.

// Первая строка содержит целое число 𝑘 (1≤𝑘≤100) — длину результата дельта-кодирования.

// Вторая строка содержит 𝑘 целых чисел 𝑏1,𝑏2,…,𝑏𝑘 (−100≤𝑏𝑖≤100) — последовательность после дельта-кодирования.

// Выходные данные
// Выведите 𝑘+1 неотрицательное целое число — исходную последовательность до дельта-кодирования. Среди выведенных чисел должен быть хотя бы один 0.

