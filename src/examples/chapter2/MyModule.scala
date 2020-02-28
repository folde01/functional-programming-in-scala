package examples.chapter2

object MyModule {
  def abs(n: Int): Int = if (n > 0) n else -n

  private def absFormat(n: Int) = {
    val msg = "Abs of %d is %d"
    msg.format(n, abs(n))
  }

  def factorial(n: Int): Int = {
    def go(m: Int, product: Int): Int = {
      if (m == 0 || m == 1) product
      else go(m - 1, product * m)
    }
    go(n, 1)
  }




  def main(args: Array[String]): Unit = {
    println(absFormat(-5))
    println(absFormat(1))

    println(factorial(0))
    println(factorial(1))
    println(factorial(2))
    println(factorial(3))
  }
}
