package exercises.chapter2

//Implement isSorted , which checks whether an Array[A] is sorted according to a
//given comparison function:
//def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean

object Ex2_isSorted extends App {
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    for (i <- 0 until as.length - 1) {
      if (!ordered(as(i), as(i + 1))) return false
    }
    true
  }

  assert(isSorted(Array(), (a: Int, b: Int) => a < b))
  assert(isSorted(Array(1), (a: Int, b: Int) => a > b))
  assert(isSorted(Array(1, 2), (a: Int, b: Int) => a < b))
  //assert(isSorted(Array(2, 1), (a: Int, b: Int) => a < b)) // unordered
  assert(isSorted(Array("a", "b"), (a: String, b: String) => a < b))
}