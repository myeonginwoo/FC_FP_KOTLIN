import List.Cons
import List.Nil
import org.junit.Test
import kotlin.test.assertEquals

class KotlinTest {

    private val intList: List<Int> = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
    private val doubleList: List<Double> = Cons(1.0, Cons(2.0, Cons(3.0, Cons(4.0, Nil))))

    @Test
    fun testSum() {
        assertEquals(List.sum(intList), 10)
    }

    @Test
    fun testProduct() {
        assertEquals(List.product(doubleList), 24.0)
    }

    @Test
    fun testGetHead() {
        assertEquals(List.getHead(intList), 1)
        assertEquals(List.getHead(doubleList), 1.0)
    }

    @Test
    fun testGetTail() {
        assertEquals(List.getTail(intList), Cons(2, Cons(3, Cons(4, Nil))))
        assertEquals(List.getTail(doubleList), Cons(2.0, Cons(3.0, Cons(4.0, Nil))))
    }

    @Test
    fun testAppendTail() {
        assertEquals(List.appendTail(intList, 5), Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Nil))))))
        assertEquals(List.appendTail(doubleList, 5.0), Cons(1.0, Cons(2.0, Cons(3.0, Cons(4.0, Cons(5.0, Nil))))))
    }

    @Test
    fun testAddHead() {
        assertEquals(List.addHead(intList, 0), Cons(0, Cons(1, Cons(2, Cons(3, Cons(4, Nil))))))
        assertEquals(List.addHead(doubleList, 0.0), Cons(0.0, Cons(1.0, Cons(2.0, Cons(3.0, Cons(4.0, Nil))))))
    }

    @Test
    fun testDrop() {
        assertEquals(List.drop(intList, 1), Cons(2, Cons(3, Cons(4, Nil))))
        assertEquals(List.drop(doubleList, 1), Cons(2.0, Cons(3.0, Cons(4.0, Nil))))
    }

    @Test
    fun testFilter() {
        assertEquals(List.filter(intList, { it > 2 }), Cons(3, Cons(4, Nil)))
        assertEquals(List.filter(intList, { it % 2 == 0 }), Cons(2, Cons(4, Nil)))
    }

    @Test
    fun testMap() {
        assertEquals(List.map(intList, { it * 2 }), Cons(2, Cons(4, Cons(6, Cons(8, Nil)))))
        assertEquals(List.map(intList, { "kotlin : $it" }), Cons("kotlin : 1", Cons("kotlin : 2", Cons("kotlin : 3", Cons("kotlin : 4", Nil)))))
    }
}

