/*
 * Piece class for our board games.
 * We are able to set a string value and an int value to the piece.
 */
public class Piece{
    int value;
    String value2;
    public Piece(int value)
    {
        this.value = value;
    }

    public Piece(String value2)
    {
        this.value2 = value2;
    }

    public int getIntValue()
    {
        return value;
    }

    public String getStrValue()
    {
        return value2;
    }

    public void setIntValue(int value)
    {
        this.value = value;
    }

    public void setStrValue(String value)
    {
        this.value2 = value;
    }
}
