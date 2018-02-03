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

        fun <T> getHead(list: List<T>): T = when (list) {
            Nil -> throw NullPointerException("list is empty")
            is Cons -> list.head
        }

        fun <T> getTail(list: List<T>): List<T> = when (list) {
            Nil-> throw NullPointerException("list is empty")
            is Cons -> list.tail
        }

        fun <T> appendTail(list: List<T>, tail: T): List<T> = when (list) {
            Nil -> Cons(tail, Nil)
            is Cons -> Cons(list.head, appendTail(list.tail, tail))
        }

        fun <T> addHead(list: List<T>, head: T): List<T> = when(list){
            Nil -> Cons(head, Nil)
            is Cons-> Cons(head, list)
        }

        tailrec fun <T> drop(list: List<T>, n: Int): List<T> = when(list){
            Nil -> Nil
            is Cons -> if(n == 0){
                list
            } else {
                drop(list.tail, n-1)
            }
        }

        tailrec fun <T> filter(list: List<T>, f: (T) -> Boolean, acc: List<T> = Nil): List<T> = when(list){
            Nil -> acc
            is Cons -> if(f(list.head)){
                filter(list.tail, f, appendTail(acc, list.head))
            } else {
                filter(list.tail, f, acc)
            }
        }

        tailrec fun <T, R> map(list: List<T>, f: (T) -> R, acc: List<R> = Nil): List<R> = when(list){
            Nil -> acc
            is Cons -> map(list.tail, f, appendTail(acc, f(list.head)))
        }
    }
}

fun <T, R> List<T>.map(f:(T) -> R, acc: List<R> = List.Nil) : List<R> = when(this){
    List.Nil -> acc
    is List.Cons -> tail.map(f, List.appendTail(acc, f(head)))
}