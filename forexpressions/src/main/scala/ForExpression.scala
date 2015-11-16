
case class Person(name: String, isMale: Boolean, children: Person*)

object ForExpression {

  def main(args: Array[String]) {
    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)

    //If I wanted to create pairs of mothers and each of their children, filters
    //and flatmaps are quite useful

    val list1 = persons filter (p => !p.isMale) flatMap (p =>
      p.children map (c => (p.name, c.name)))

    list1.foreach{println}

    //This isn't very easy to read, however. For expressions can help with that.

    val list2 = for (p <- persons; if !p.isMale; c <- p.children) yield (p.name, c.name)

    list2.foreach{println}

  }
}
