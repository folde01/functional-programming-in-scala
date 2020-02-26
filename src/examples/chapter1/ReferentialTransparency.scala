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

  val myCafe = new Cafe()
  val (myCup, myCharge) = myCafe.buyCoffee(myCC)
  println("myCafe charged " + myCup.price)

  def coalesce(charges: List[Charge]): List[Charge] =
    charges.groupBy(_.cc).values.map(_.reduce(_ combine _)).toList

  val cc1 = new CreditCard()
  val (cup1, charge1) = myCafe.buyCoffee(cc1)

  val cc2 = new CreditCard()
  val (cup2, charge2) = myCafe.buyCoffee(cc2)
  val (cup3, charge3) = myCafe.buyCoffee(cc2)

  val coalesce1 = coalesce(List(charge1, charge2, charge3)))
  println("coalesce: " + coalesce(List(charge1, charge2, charge3)))
}

class CreditCard {
  def charge(price: Double): Unit = {
    println("Charging " + price)
  }
}

class Coffee {
  val price: Double = 1.50
}

class Cafe {
  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee()
    (cup, Charge(cc, cup.price))
  }
}

case class Charge(cc: CreditCard, amount: Double) {
  def combine(other: Charge): Charge =
    if (cc == other.cc)
      Charge(cc, amount + other.amount)
    else
      throw new Exception("Can't combine charges to different cards")
}

