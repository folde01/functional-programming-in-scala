package exercises.chapter2

import scala.annotation.tailrec

/*
Write a recursive function to get the nth Fibonacci number (http://mng.bz/C29s).
The first two Fibonacci numbers are 0 and 1. The nth number is always the sum of the
previous two—the sequence begins 0, 1, 1, 2, 3, 5. Your definition should use a
local tail-recursive function.
def fib(n: Int): Int
*/

object Ex1 extends App {
  def fib(n: Int): Int = {
    if (n < 2) n
    else fib(n - 1) + fib(n - 2)
  }
  println(fib(3))
  println(fib(5))

  def fibTail(n: Int): Int = {
    @tailrec
    def loop(n: Int, sum: Int): Int = {
      if (n <= 2) sum
      else loop(n - 1, sum + (n - 2))
    }
    loop(n, 0)
  }
  println(fibTail(3))
  println(fibTail(5))

  def fibTailUdemy(n: Int): Int = {
    def loop(i: Int, last: Int, nextToLast: Int): Int =
      if(i>= n) last
      else loop(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else loop(2, 1, 1)
  }

  println("fibTailUdemy(8): " + fibTailUdemy(8))
}

