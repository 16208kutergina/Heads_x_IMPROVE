fun main() {
    val n = readLine()?.toInt()
    if (n == null || n < 0) {
        println("Incorrect input")
        return
    }
    val arrayOfArrays = initializeAndFillArrays(n)
    arrayOfArrays.sortArraysByRule() //Массивы с четным порядковым номером - по возрастанию, с нечетным порядковым номером - по убыванию.
    arrayOfArrays.print()
}

fun Array<IntArray>.sortArraysByRule() {
    for (i in this.indices) {
        if (i % 2 == 0) {
            this[i].sort()
        } else {
            this[i].sortDescending()
        }
    }
}

fun Array<IntArray>.print() {
    this.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }
}

private fun initializeAndFillArrays(n: Int): Array<IntArray> {
    val sizesOfArrays = HashSet<Int>() //Массив уже существующих размеров массивов

    return Array(n) {
        var randInt = randInt()
        while (sizesOfArrays.contains(randInt)) {
            randInt = randInt()
        }
        sizesOfArrays.add(randInt)
        IntArray(randInt) {           //Создание массивов
            randInt()                 //Заполнение массива
        }
    }
}

private fun randInt() =
    (0..500).random()
