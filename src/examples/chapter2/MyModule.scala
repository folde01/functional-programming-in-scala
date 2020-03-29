package examples.chapter2

object MyModule {
  def abs(n: Int): Int = if (n > 0) n else -n

  private def absFormat(n: Int) = {
    val msg = "Abs of %d is %d"
    msg.format(n, abs(n))
  }

  import scala.annotation.tailrec

  def factorial(n: Int): Int = {
    @tailrec def go(m: Int, product: Int): Int = {
      if (m <= 1) product
      else go(m - 1, product * m)
    }
    go(n, 1)
  }

  def funcFormat(n: Int, s: String, f: Int => Int): String = {
    val msg = "The " + s + " of %d is %d"
    msg.format(n, f(n))
  }

  def findFirstMonomorphic(ss: Array[String], key: String): Int = {
    @tailrec def loop(n: Int): Int = {
      if (n >= ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)
    }
    loop(0)
  }

  def findFirstPolymorphic[A](as: Array[A], p: A => Boolean): Int = {
    @tailrec def loop(n: Int): Int = {
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n + 1)
    }
    loop(0)
  }

  def main(args: Array[String]): Unit = {
    println(absFormat(-5))
    println(absFormat(1))

    println(factorial(0))
    println(factorial(1))
    println("funcFormat(-5, \"absolute value\", abs): " + funcFormat(-5, "absolute value", abs))
    println(findFirstMonomorphic(Array("a", "b", "b"), "b"))
    println(findFirstPolymorphic(Array(1, "a", 2), (x: Any) => x == 2))
  }
}
