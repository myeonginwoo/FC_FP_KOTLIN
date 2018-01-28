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

        fun <T> appendTail(list: List<T>, tail: T): List<T> = when (list) {
            Nil -> Cons(tail, Nil)
            is Cons -> Cons(list.head, appendTail(list.tail, tail))
        }

        fun <T> addHead(list: List<T>, head: T): List<T> = TODO()

        tailrec fun <T> drop(list: List<T>, n: Int): List<T> = TODO()

        tailrec fun <T> filter(list: List<T>, f: (T) -> Boolean, acc: List<T> = Nil): List<T> = TODO()

        tailrec fun <T, R> map(list: List<T>, f: (T) -> R, acc: List<R> = Nil): List<R> = TODO()
    }
}