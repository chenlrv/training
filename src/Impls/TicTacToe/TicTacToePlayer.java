package Impls.TicTacToe;

public class TicTacToePlayer {
    private XOEnum type;

    public TicTacToePlayer(XOEnum type) {
        this.type = type;
    }

    public void play(String[][] board, int x, int y) throws PositionAlreadyUsedException, InvalidPositionException {
        if ((x < 0 || x > 2) || (y < 0) || (y > 2)){
            throw new InvalidPositionException();
        }

        if (board[x][y] != null){
            throw new PositionAlreadyUsedException();

        }

        board[x][y] = type.getStringType();
    }

}
