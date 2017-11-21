package org.eclipse.epsilon.flexmi.xml;
public class Location {

    public static final String ID = "location";

    private final int startLine;
    private final int startColumn;
    private final int endLine;
    private final int endColumn;

    public Location(int startLine,
            int startColumn, int endLine, int endColumn) {
        super();
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    public int getStartLine() {
        return startLine;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public int getEndLine() {
        return endLine;
    }

    public int getEndColumn() {
        return endColumn;
    }

    @Override
    public String toString() {
        return "[line " + startLine + ":"
                + startColumn + " to line " + endLine + ":"
                + endColumn + "]";
    }
}