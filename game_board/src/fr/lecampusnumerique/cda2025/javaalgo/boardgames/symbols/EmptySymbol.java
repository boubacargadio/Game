package fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols;

public enum EmptySymbol implements Symbols {
    EMPTY(" ");

    private String representation;

    public String getRepresentation() {
        return representation;
    }

  EmptySymbol(String representation) { this.representation = representation;}
}
