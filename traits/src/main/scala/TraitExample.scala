
trait Brave {
 override def toString = "Brave: I will not back down."
}

trait Smart {
  override def toString = "Smart: I will do it better."
}

trait Creative {
  override def toString = "Creative: I will show the world you have missed."
}

trait Funny {
  override def toString = "Funny: I will leave you laughing."
}

abstract class Human {
  val name: String
  val age: Int
}

case class Soldier(name: String, age: Int, branch: String) extends Human with Brave

case class Mathematician(name: String, age: Int) extends Human with Smart

case class Artist(name: String, age: Int, medium: String) extends Human with Creative

case class Comedian(name: String, age: Int) extends Human with Creative with Funny

case class ComicStripArtist(name: String, age: Int) extends Human with Funny with Creative

object Main {
  def main(args: Array[String]) {
    val spartacus = Soldier("Spartacus", 35, "Rebels")
    val turing = Mathematician("Alan Turing", 50)
    val carlin = Comedian("George Carlin", 60)
    val jerry = ComicStripArtist("Jerry Scott", 42)

    val humans = spartacus :: (turing :: (carlin :: (jerry :: Nil)))

    humans.foreach{println}

    //prints the name of each element of the collection created by the map
    humans.map(_.name).foreach{println}

    //similar functionality, but using foldLeft instead of map
    humans.
      foldLeft(List[Int]())((accumulator, elem) => elem.age :: accumulator).
      foreach{println}
  }
}
