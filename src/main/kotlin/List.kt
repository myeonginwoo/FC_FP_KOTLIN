sealed class List<out T> {
    object Nil : List<Nothing>()
    data class Cons<T>(val head: T, val tail: List<T>) : List<T>()

    companion object {
        fun sum(intList: List<Int>): Int = when (intList) {
            Nil -> 0
            is Cons -> intList.head + sum(intList.tail)
        }

        fun product(doubleList: List<Double>): Double = when (doubleList) {
            Nil -> 1.0
            is Cons -> doubleList.head * product(doubleList.tail)
        }

        fun <T> getHead(list: List<T>): T = TODO()

        fun <T> getTail(list: List<T>): List<T> = TODO()
    }
}