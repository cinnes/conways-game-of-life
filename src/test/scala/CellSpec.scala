import org.scalatest.{FlatSpec, Matchers}

class CellSpec extends FlatSpec with Matchers {
  "Cell" should "generate a list of all neighbouring cells" in {
    // given
    val cell = Cell(2, 2)

    // when
    val result = cell.neighbours

    // then
    // (1,1)  (2,1)  (3,1)
    // (1,2)  XXXXX  (3,2)
    // (1,3)  (2,3)  (3,3)
    result shouldBe Set(Cell(1,1), Cell(2,1), Cell(3,1), Cell(1,2), Cell(3,2), Cell(1,3), Cell(2,3), Cell(3,3))
  }

  it should "be equal to itself" in {
    Cell(2, 2) should equal (Cell(2, 2))
  }

  it should "not have itself as a neighbour" in {
    Cell(2, 2).neighbours should not contain Cell(2, 2)
  }

  it should "have 8 neighbours" in {
    Cell(2, 2).neighbours.size shouldBe 8
  }

  it should "convert properly to a string" in {
    Cell(2, 2).toString shouldBe "2,2"
  }
}

