case class Cell(x: Int, y: Int) extends Ordered[Cell] {
  def neighbours: Set[Cell] = {
    val nbrs = for {
      _x <- x - 1 to x + 1
      _y <- y - 1 to y + 1
      if _x != x || _y != y
    } yield Cell(_x, _y)

    nbrs.toSet
  }

  override def toString: String = s"$x,$y"
  override def compare(other: Cell): Int = if (x == other.x) y - other.y else x - other.x
}
