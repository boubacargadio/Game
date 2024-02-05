package fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.board;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.cell.Cell;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.EmptySymbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.view.View;

import java.util.ArrayList;
import java.util.List;

public class Board {

    // *******
    // ************* ATTRIBUTES
    // *******

    private final int amountOfRows;
    private final int amountOfColumns;
    private final Cell[][] board;
    private boolean isFull;
    private final View view = new View();

    private Cell[] getOneRow() {
        Cell[] row = new Cell[amountOfColumns];

        for (int i = 0; i < amountOfColumns; i++) {
            row[i] = new Cell();
        }
        return row;
    }

    private void createBoard() {
        for (int i = 0; i < amountOfRows; i++) {
            this.board[i] = getOneRow();
        }
    }


    // *******
    // ************* CONSTRUCTOR
    // *******

    public Board(int amountOfRows, int amountOfColumns) {
        this.amountOfColumns = amountOfColumns;
        this.amountOfRows = amountOfRows;
        this.board = new Cell[amountOfRows][amountOfColumns];
        createBoard();
        displayBoard();
    }

    // *******
    // ************* ATTRIBUTES METHODS
    // *******

    public int getAmountOfColumns() {
        return amountOfColumns;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public boolean isFull() {
        return isFull;
    }

    protected boolean setIsFull(boolean isFull) {
        return this.isFull = isFull;
    }


    // *******
    // ************* METHODS
    // *******

    public void displayBoard() {
        view.displayBoardDrawing(getBoard(), getAmountOfColumns());
    }

    public boolean isBoardFull(){
        boolean isFull = true;
       for (Cell[] row : board) {
           for (Cell cell: row) {
               if (cell.getSymbol() == EmptySymbol.EMPTY){
                   isFull = false;
               }
           }
       }
        setIsFull(isFull);
       return isFull;
    }

    public Cell[] getRow(int row) {
        return board[row];
    }

    public Cell[] getColumn(int col) {
        Cell[] column = new Cell[amountOfRows];
        for (int i = 0; i < board.length ; i++) {
            column[i] = board[i][col];
        }

        return column;
    }

    public List<int[]> getCellsAvailable(){
        List<int[]> availableCells = new ArrayList<int[]>();

        for (int i = 0; i < board.length; i++) {
            Cell[] row = board[i];

            for (int j = 0; j < row.length; j++) {
                Cell cell = row[j];

                if(cell.isAvailable()) {
                    int[] move = new int[]{i, j};
                    availableCells.add(move);
                }
            }
        }
        return availableCells;
    }

    public void clean() {
        createBoard();
    }
}
