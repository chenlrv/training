package Impls.TicTacToe;

public enum XOEnum {

    X("X"),
    O("O");

    private String type;

    XOEnum(String type) {
        this.type = type;
    }

    public String getStringType() {
        return type;
    }
}
