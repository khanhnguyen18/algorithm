package cave;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaveBFSTest {

  CaveBFS cave = new CaveBFS();

  @Test
  void solution1() {
    String[] A = {"..X.", "...X", "....", "X..."};
    assertEquals(9, cave.solution(A));
  }

  @Test
  void solution2() {
    String[] A = {".X...", ".X...", "...X."};
    assertEquals(-1, cave.solution(A));
  }


  @Test
  void solution3() {
    String[] A = {"......",".XXXX.","...X..","...X.X","......"};
    assertEquals(14, cave.solution(A));
  }
}