import java.util.ArrayList;

interface Player {
  // the current board
  // 1 as O, 2 as X, 0 as none.
  public int[][] board = new int[3][3];

  // returns the name of AI (e.g. AI1, AI2)
  public String getName(int num);

  // returns coordinate, [0,0] [0,1] [0,2]
  // [1,0] [1,1] [1,2]
  // [2,0] [2,1] [2,2]
  public int[] getChoice();

  // returns current board with 1 as O, 2 as X, 0 as none.
  public int[][] getBoard();

  // input the choices of players into each player's board.
  public void inputChoice(int row, int column, int player);
}

// AI1, same code as AI2.
class AI1 implements Player {
  // the current board
  // 1 as O, 2 as X, 0 as none.
  public int[][] board = new int[][] { { 0, 0, 0 },
      { 0, 0, 0 },
      { 0, 0, 0 } };

  // input the choices of players into the board.
  public void inputChoice(int row, int column, int player) {
    board[row][column] = player;
  }

  // receives the current board
  public int[][] getBoard() {
    return board;
  }

  // returns the name of the student
  public String getName(int num) {
    if (num == 1) {
      return "AI1";
    } else {
      return "AI2";
    }

  }

  // ***********************************************************************************************************************//
  // ****************************************Below is where you should put your
  // code****************************************//
  // ***********************************************************************************************************************//
  // returns coordinate, [0,0] [0,1] [0,2]
  // [1,0] [1,1] [1,2]
  // [2,0] [2,1] [2,2]
  // public int[] getChoice() {
  // int i = (int) (Math.random() * 3);
  // int j = (int) (Math.random() * 3);
  // int[] temp = { i, j };
  // return temp;
  // }

  // Important: Must set comparitor to self index
  final int selfIndex = 1;
  final int opponentIndex = 3 - selfIndex;

  public int[] getChoice() {
    // int i = (int) (Math.random() * 3);
    // int j = (int) (Math.random() * 3);
    // int[] temp = { i, j };
    // return temp;

    Integer[] bestMove = null;
    int bestScore = -1000;
    for (Integer[] position : getAvailablePositions()) {
      inputChoice(position[0], position[1], selfIndex);
      int score = minimax();
      inputChoice(position[0], position[1], 0);
      if (score > bestScore) {
        bestScore = score;
        bestMove = position;
      }
    }
    int[] result = { bestMove[0], bestMove[1] };
    return result;
  }

  public int checkWin() {
    // check for wins
    // if top left is not empty
    int end = 0;
    if (getBoard()[0][0] != 0) {
      // top row
      if (getBoard()[0][0] == getBoard()[0][1] && getBoard()[0][1] == getBoard()[0][2]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[0][0];
      }
      // left column
      if (getBoard()[0][0] == getBoard()[1][0] && getBoard()[1][0] == getBoard()[2][0]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[0][0];
      }
    }
    // if bottom right is not empty
    if (getBoard()[2][2] != 0) {
      // bottom row
      if (getBoard()[2][2] == getBoard()[2][1] && getBoard()[2][1] == getBoard()[2][0]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[2][2];
      }
      // right column
      if (getBoard()[2][2] == getBoard()[1][2] && getBoard()[1][2] == getBoard()[0][2]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[2][2];
      }
    }
    // if center is not empty
    if (getBoard()[1][1] != 0) {
      // top left, middle middle, bottom right
      if (getBoard()[0][0] == getBoard()[1][1] && getBoard()[1][1] == getBoard()[2][2]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[1][1];
      }
      // top right, middle middle, bottom left
      if (getBoard()[0][2] == getBoard()[1][1] && getBoard()[1][1] == getBoard()[2][0]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[1][1];
      }
      // middle column
      if (getBoard()[0][1] == getBoard()[1][1] && getBoard()[1][1] == getBoard()[2][1]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[1][1];
      }
      // middle row
      if (getBoard()[1][0] == getBoard()[1][1] && getBoard()[1][1] == getBoard()[1][2]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[1][1];
      }
    }

    // someone won
    if (end != 0) {
      return end;
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (getBoard()[i][j] == 0) {
          return -1;
        }
      }
    }

    return 0;
  }

  public ArrayList<Integer[]> getAvailablePositions() {
    ArrayList<Integer[]> positions = new ArrayList<Integer[]>();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (getBoard()[i][j] == 0) {
          Integer[] pos = { i, j };
          positions.add(pos);
        }
      }
    }

    return positions;
  }

  public int minimax() {
    int winner = checkWin();
    int score;

    if (winner != -1) {
      if (winner == selfIndex) {
        score = 1;
      } else if (winner == 0) {
        score = 0;
      } else {
        score = -1;
      }

      return score;
    }

    int selfCount = 0;
    int opponentCount = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (getBoard()[i][j] == selfIndex) {
          selfCount++;
        } else if (getBoard()[i][j] == opponentIndex) {
          opponentCount++;
        }
      }
    }

    int bestScore;
    if (opponentCount > selfCount) {
      bestScore = -1;
    } else {
      bestScore = 1;
    }

    for (Integer[] position : getAvailablePositions()) {
      inputChoice(position[0], position[1], opponentCount > selfCount ? selfIndex : opponentIndex);
      int currentScore = minimax();
      inputChoice(position[0], position[1], 0);
      if (opponentCount > selfCount ? currentScore > bestScore : currentScore < bestScore) {
        bestScore = currentScore;
      }
    }
    return bestScore;
  }

}

// AI2, same code as AI1
class AI2 implements Player {
  // the current board
  // 1 as O, 2 as X, 0 as none.
  public int[][] board = new int[][] { { 0, 0, 0 },
      { 0, 0, 0 },
      { 0, 0, 0 } };

  // input the choices of players into the board.
  public void inputChoice(int row, int column, int player) {
    board[row][column] = player;
  }

  // receives the current board
  public int[][] getBoard() {
    return board;
  }

  // returns the name of the student
  public String getName(int num) {
    if (num == 1) {
      return "AI1";
    } else {
      return "AI2";
    }
  }

  // ***********************************************************************************************************************//
  // ****************************************Below is where you should put your
  // code****************************************//
  // ***********************************************************************************************************************//
  // returns coordinate, [0,0] [0,1] [0,2]
  // [1,0] [1,1] [1,2]
  // [2,0] [2,1] [2,2]

  // Important: Must set comparitor to self index
  final int selfIndex = 2;
  final int opponentIndex = 3 - selfIndex;

  public int[] getChoice() {
    // int i = (int) (Math.random() * 3);
    // int j = (int) (Math.random() * 3);
    // int[] temp = { i, j };
    // return temp;

    Integer[] bestMove = null;
    int bestScore = -1000;
    for (Integer[] position : getAvailablePositions()) {
      inputChoice(position[0], position[1], selfIndex);
      int score = minimax();
      inputChoice(position[0], position[1], 0);
      if (score > bestScore) {
        bestScore = score;
        bestMove = position;
      }
    }
    int[] result = { bestMove[0], bestMove[1] };
    return result;
  }

  public int checkWin() {
    // check for wins
    // if top left is not empty
    int end = 0;
    if (getBoard()[0][0] != 0) {
      // top row
      if (getBoard()[0][0] == getBoard()[0][1] && getBoard()[0][1] == getBoard()[0][2]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[0][0];
      }
      // left column
      if (getBoard()[0][0] == getBoard()[1][0] && getBoard()[1][0] == getBoard()[2][0]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[0][0];
      }
    }
    // if bottom right is not empty
    if (getBoard()[2][2] != 0) {
      // bottom row
      if (getBoard()[2][2] == getBoard()[2][1] && getBoard()[2][1] == getBoard()[2][0]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[2][2];
      }
      // right column
      if (getBoard()[2][2] == getBoard()[1][2] && getBoard()[1][2] == getBoard()[0][2]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[2][2];
      }
    }
    // if center is not empty
    if (getBoard()[1][1] != 0) {
      // top left, middle middle, bottom right
      if (getBoard()[0][0] == getBoard()[1][1] && getBoard()[1][1] == getBoard()[2][2]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[1][1];
      }
      // top right, middle middle, bottom left
      if (getBoard()[0][2] == getBoard()[1][1] && getBoard()[1][1] == getBoard()[2][0]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[1][1];
      }
      // middle column
      if (getBoard()[0][1] == getBoard()[1][1] && getBoard()[1][1] == getBoard()[2][1]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[1][1];
      }
      // middle row
      if (getBoard()[1][0] == getBoard()[1][1] && getBoard()[1][1] == getBoard()[1][2]) {
        // whether the winner is player1 or player2. end is either 1 or 2
        end = getBoard()[1][1];
      }
    }

    // someone won
    if (end != 0) {
      return end;
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (getBoard()[i][j] == 0) {
          return -1;
        }
      }
    }

    return 0;
  }

  public ArrayList<Integer[]> getAvailablePositions() {
    ArrayList<Integer[]> positions = new ArrayList<Integer[]>();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (getBoard()[i][j] == 0) {
          Integer[] pos = { i, j };
          positions.add(pos);
        }
      }
    }

    return positions;
  }

  public int minimax() {
    int winner = checkWin();
    int score;

    if (winner != -1) {
      if (winner == selfIndex) {
        score = 1;
      } else if (winner == 0) {
        score = 0;
      } else {
        score = -1;
      }

      return score;
    }

    int selfCount = 0;
    int opponentCount = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (getBoard()[i][j] == selfIndex) {
          selfCount++;
        } else if (getBoard()[i][j] == opponentIndex) {
          opponentCount++;
        }
      }
    }

    int bestScore;
    if (opponentCount > selfCount) {
      bestScore = -1;
    } else {
      bestScore = 1;
    }

    for (Integer[] position : getAvailablePositions()) {
      inputChoice(position[0], position[1], opponentCount > selfCount ? selfIndex : opponentIndex);
      int currentScore = minimax();
      inputChoice(position[0], position[1], 0);
      if (opponentCount > selfCount ? currentScore > bestScore : currentScore < bestScore) {
        bestScore = currentScore;
      }
    }
    return bestScore;
  }
}

public class tictactoe {

  public static void main(String[] args) {
    System.out.println(
        "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    System.out.println(
        "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    System.out.println(
        "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    System.out.println(
        "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    System.out.println(
        "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    System.out.println(
        "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

    // 10 rounds.
    int rounds = 10;

    // results of winner to display after all 10 matches
    int[] summary = new int[rounds];

    // 3x3 board
    int boardsize = 3;

    // 2 players
    Player all[] = new Player[2];
    all[0] = new AI1();
    all[1] = new AI2();

    // winner - 1 pt. tie - 0 pt. loser - 0 pt.
    int scores[] = new int[2];

    // 10 rounds
    for (int x = 0; x < rounds; x++) {
      System.out.println("Round " + (x + 1) + "\n");

      // variable to check whether there is a winner or not.
      int end = 0;

      // 3x3 tictactoe board has 9 chances of inputs. 5 from player1, 4 from player2
      for (int y = 0; y < 9; y++) {
        // if even (including 0), then first player's turn. if odd, then second player's
        // turn
        int[] choices = all[y % 2].getChoice();

        // if the spot chosen already has a O or X.
        if (all[0].getBoard()[choices[0]][choices[1]] != 0) {
          // repeat turn
          y--;
        }
        // empty spot ready to be chosen.
        else {
          System.out.println(all[y % 2].getName(y % 2 + 1) + " has chosen [" + choices[0] + "," + choices[1] + "]");

          // first player is numbered 1. second player is numbered 2.
          // Puts input into the player1's board
          all[0].inputChoice(choices[0], choices[1], (y % 2) + 1);
          // Puts input into the player2's board
          all[1].inputChoice(choices[0], choices[1], (y % 2) + 1);

          // output
          System.out.println("Current board looks like:");
          for (int a = 0; a < boardsize; a++) {
            for (int b = 0; b < boardsize; b++) {
              // Displays board in O and X form
              if (all[0].getBoard()[a][b] == 1) {
                System.out.print("O");
              } else if (all[0].getBoard()[a][b] == 2) {
                System.out.print("X");
              } else {
                System.out.print("-");
              }

              // Displays board in 1 and 2 form
              // System.out.print(all[0].getBoard()[a][b]);
            }
            System.out.println();
          }
          System.out.println();

          // check for wins
          // if top left is not empty
          if (all[0].getBoard()[0][0] != 0) {
            // top row
            if (all[0].getBoard()[0][0] == all[0].getBoard()[0][1]
                && all[0].getBoard()[0][1] == all[0].getBoard()[0][2]) {
              // whether the winner is player1 or player2. end is either 1 or 2
              end = all[0].getBoard()[0][0];
            }
            // left column
            if (all[0].getBoard()[0][0] == all[0].getBoard()[1][0]
                && all[0].getBoard()[1][0] == all[0].getBoard()[2][0]) {
              // whether the winner is player1 or player2. end is either 1 or 2
              end = all[0].getBoard()[0][0];
            }
          }
          // if bottom right is not empty
          if (all[0].getBoard()[2][2] != 0) {
            // bottom row
            if (all[0].getBoard()[2][2] == all[0].getBoard()[2][1]
                && all[0].getBoard()[2][1] == all[0].getBoard()[2][0]) {
              // whether the winner is player1 or player2. end is either 1 or 2
              end = all[0].getBoard()[2][2];
            }
            // right column
            if (all[0].getBoard()[2][2] == all[0].getBoard()[1][2]
                && all[0].getBoard()[1][2] == all[0].getBoard()[0][2]) {
              // whether the winner is player1 or player2. end is either 1 or 2
              end = all[0].getBoard()[2][2];
            }
          }
          // if center is not empty
          if (all[0].getBoard()[1][1] != 0) {
            // top left, middle middle, bottom right
            if (all[0].getBoard()[0][0] == all[0].getBoard()[1][1]
                && all[0].getBoard()[1][1] == all[0].getBoard()[2][2]) {
              // whether the winner is player1 or player2. end is either 1 or 2
              end = all[0].getBoard()[1][1];
            }
            // top right, middle middle, bottom left
            if (all[0].getBoard()[0][2] == all[0].getBoard()[1][1]
                && all[0].getBoard()[1][1] == all[0].getBoard()[2][0]) {
              // whether the winner is player1 or player2. end is either 1 or 2
              end = all[0].getBoard()[1][1];
            }
            // middle column
            if (all[0].getBoard()[0][1] == all[0].getBoard()[1][1]
                && all[0].getBoard()[1][1] == all[0].getBoard()[2][1]) {
              // whether the winner is player1 or player2. end is either 1 or 2
              end = all[0].getBoard()[1][1];
            }
            // middle row
            if (all[0].getBoard()[1][0] == all[0].getBoard()[1][1]
                && all[0].getBoard()[1][1] == all[0].getBoard()[1][2]) {
              // whether the winner is player1 or player2. end is either 1 or 2
              end = all[0].getBoard()[1][1];
            }
          }

          // someone won
          if (end != 0) {
            // score of the player increases
            scores[end - 1]++;

            // the round the player wins in is recorded with 1 or 2
            summary[x] = end;
            System.out.println(all[end - 1].getName(end) + " has won this round!");

            // immediately end this round if someone wins
            break;
          }
        }
      }

      // no one wins
      if (end == 0) {
        // the round where no one won is recorded with 0
        summary[x] = 0;
        System.out.println("It's a tie!");
      }

      // resetting each player's board for next round
      for (int a = 0; a < boardsize; a++) {
        for (int b = 0; b < boardsize; b++) {
          all[0].inputChoice(a, b, 0);
          all[1].inputChoice(a, b, 0);
        }
      }

      System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
      System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
      System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
    }

    // After 10 rounds

    // Results display for player1
    System.out.println("Summary:");
    System.out.print(all[0].getName(1) + " won Rounds ");
    for (int x = 0; x < rounds; x++) {
      if (summary[x] == 1) {
        // add 1 because rounds is recorded from 0 to 9.
        System.out.print((x + 1) + " ");
      }
    }
    System.out.println(" ");
    System.out.println(all[0].getName(1) + " scores " + scores[0] + " points.");

    // Results display for player2
    System.out.print(all[1].getName(2) + " won Rounds ");
    for (int x = 0; x < rounds; x++) {
      if (summary[x] == 2) {
        // add 1 because rounds is recorded from 0 to 9.
        System.out.print((x + 1) + " ");
      }
    }
    System.out.println(" ");
    System.out.println(all[1].getName(2) + " scores " + scores[1] + " points.");

    // final winner
    if (scores[0] < scores[1]) {
      System.out.println(all[1].getName(2) + " won!");
    } else if (scores[0] > scores[1]) {
      System.out.println(all[0].getName(1) + " won!");
    } else {
      System.out.println("It's a tie!");
    }
  }
}