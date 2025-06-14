import boardgamechecker.BoardGameChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardGameCheckerTest {
  private BoardGameChecker boardGameChecker = new BoardGameChecker();
  @Test
  void solution1() {
    //[E, E, X, E, E, E]
    //[E, E, E, E, E, E]
    //[E, E, E, E, X, E]
    //[E, X, E, E, E, E]
    //[E, E, X, E, X, E]
    //[E, E, E, O, E, E]
    String[] A = {"..X...", "......", "....X.", ".X....", "..X.X.", "...O.."};
    assertEquals(2, boardGameChecker.solution(A));
  }


  @Test
  void solution2() {
    //[X, E, E, E, E]
    //[E, X, E, E, E]
    //[E, E, O, E, E]
    //[E, E, E, E, E]
    String[] A = {"X....", ".X...", "..O..", "....."};
    assertEquals(0, boardGameChecker.solution(A));
  }
}