class PetriDish(val cells: Set[Cell]) {
  def nextGeneration: PetriDish = {
    val potential: Set[Cell] = cells ++ cells.flatMap(_.neighbours)
    new PetriDish(potential.filter(survives))
  }

  private def survives(cell: Cell): Boolean = {
    val alive = cells.contains(cell)
    val liveNeighbours = cells.intersect(cell.neighbours).size

    (alive, liveNeighbours) match {
      case (true, 2 | 3) | (false, 3) => true
      case _ => false
    }
  }

  override def hashCode(): Int = cells.hashCode()
  override def equals(obj: Any): Boolean = obj match {
    case pd: PetriDish => pd.cells.equals(cells)
    case _ => false
  }
}
