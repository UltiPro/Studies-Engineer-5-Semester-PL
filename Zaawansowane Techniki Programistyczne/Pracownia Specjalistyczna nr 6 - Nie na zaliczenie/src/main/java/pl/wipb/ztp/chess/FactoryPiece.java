package pl.wipb.ztp.chess;

import java.util.HashMap;
import java.util.Map;

public class FactoryPiece {
    static Map<Integer, Piece> pieceTypes = new HashMap<>();

    public static Piece getPieceType(int index)
    {
        Piece result = pieceTypes.get(index);
        if(result == null)
        {
            result = new Piece(index);
            pieceTypes.put(index, result);
        }
        return result;
    }
}