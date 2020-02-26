package examples.chapter1

/**
 * Created by Jesse 26 Feb 2020
 */
object ReferentialTransparency extends App {
  def buyCoffee(cc: CreditCard): Coffee = {
    val cup = new Coffee()
    cc.charge(cup.price)
    cup
  }

  val myCC = new CreditCard()
  val cup = buyCoffee(myCC)
  println("Purchased cup at price " + cup.price)
}

class CreditCard {
  def charge(price: Double): Unit = {
    println("Charging " + price)
  }
}

class Coffee {
  val price: Double = 1.50
}



