import List.Cons
import List.Nil

object Main {
    @JvmStatic
    fun main(args: Array<String>) {

        val intList: List<Int> = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
        val doubleList: List<Double> = Cons(1.0, Cons(2.0, Cons(3.0, Cons(4.0, Nil))))

        require(List.sum(intList) == 10) {
            "invalid sum Expect : 10, Actual : ${List.sum(intList)}"
        }
        require(List.product(doubleList) == 24.0) {
            "invalid product Expect : 24.0, Actual : ${List.product(doubleList)}"
        }

        require(List.getHead(intList) == 1) {
            "Ainvalid head Expect : 1, Actual : ${List.getHead(intList)}"
        }

        require(List.getTail(intList) == Cons(2, Cons(3, Cons(4, Nil)))) {
            "Ainvalid head Expect : Cons(2, Cons(3, Cons(4, Nil))), Actual : ${List.getTail(intList)}"
        }
    }
}