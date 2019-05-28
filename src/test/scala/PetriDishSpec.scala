import org.scalatest.{FlatSpec, Matchers}

class PetriDishSpec extends FlatSpec with Matchers {
  "PetriDish" should "kill off a living cell if it has no living neighbours" in {
    // given
    val aliveCells = Set(Cell(2,2))
    val dish = new PetriDish(aliveCells)

    // when
    val result = dish.nextGeneration

    // then
    result.cells shouldBe empty
  }

  it should "kill off a living cell if it has 1 living neighbour" in {
    // given
    val aliveCells = Set(Cell(2,2), Cell(1,2))
    val dish = new PetriDish(aliveCells)

    // when
    val result = dish.nextGeneration

    // then
    result.cells shouldBe empty
  }

  it should "keep a living cell alive if it has 2 living neighbours" in {
    // given
    val aliveCells = Set(Cell(2,2), Cell(1,2), Cell(2,3))
    val dish = new PetriDish(aliveCells)

    // when
    val result = dish.nextGeneration

    // then
    result.cells should contain (Cell(2,2))
  }

  it should "keep a living cell alive if it has 3 living neighbours" in {
    // given
    val aliveCells = Set(Cell(2,2), Cell(1,2), Cell(2,3), Cell(3,1))
    val dish = new PetriDish(aliveCells)

    // when
    val result = dish.nextGeneration

    // then
    result.cells should contain (Cell(2,2))
  }

  it should "kill off a cell if it has 4 living neighbours" in {
    // given
    val aliveCells = Set(Cell(2,2), Cell(1,2), Cell(2,3), Cell(3,1), Cell(3,2))
    val dish = new PetriDish(aliveCells)

    // when
    val result = dish.nextGeneration

    // then
    result.cells should not contain Cell(2,2)
  }

  it should "rebirth a dead cell with 3 living neighbours" in {
    // given
    val aliveCells = Set(Cell(1,2), Cell(2,3), Cell(3,1))
    val dish = new PetriDish(aliveCells)

    // when
    val result = dish.nextGeneration

    // then
    result.cells should contain (Cell(2,2))
  }
}
