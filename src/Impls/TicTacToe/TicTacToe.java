package Impls.TicTacToe;

public class TicTacToe {
    private String[][] board;
    private TicTacToePlayer xPlayer;
    private TicTacToePlayer oPlayer;
    int currentPlayerTurn;
    boolean endOfGame;

    public TicTacToe() {
        board = new String[3][3];
        xPlayer = new TicTacToePlayer(XOEnum.X);
        oPlayer = new TicTacToePlayer(XOEnum.O);
        currentPlayerTurn = 0;
        endOfGame = false;
    }

    public void play() throws PositionAlreadyUsedException, InvalidPositionException {
        while (!endOfGame) {
            xPlayer.play(this.board, 1, 2);
            checkForEndOfGame();
            oPlayer.play(this.board, 0, 2);
            checkForEndOfGame();
        }

    }

    private void checkForEndOfGame() {

    }


}
