package examples.chapter2

object MyModule {
  def abs(n: Int): Int = if (n > 0) n else -n

  private def absFormat(n: Int) = {
    val msg = "Abs of %d is %d"
    msg.format(n, abs(n))
  }

  def main(args: Array[String]): Unit = {
    println(absFormat(-5))
    println(absFormat(1))
  }
}
