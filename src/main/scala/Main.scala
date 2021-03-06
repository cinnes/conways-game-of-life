import scala.io.Source
import scala.util.Try

object Main extends App {
  // skips over bad lines, could throw error here instead
  def toCell(line: String): Option[Cell] = line.split(",").toList match {
    case left :: right :: Nil => Try(Cell(left.toInt, right.toInt)).toOption
    case _ => None
  }

  println("Enter cell coords")

  val cells = Source.stdin
    .getLines().takeWhile(_ != "end")
    .flatMap(toCell)
    .toSet

  new PetriDish(cells).nextGeneration.cells.toList.sorted.foreach(println)

  println("end")
}
