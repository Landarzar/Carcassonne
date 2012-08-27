package net.game.carcassonne;

import com.jme3.asset.AssetManager;
import com.jme3.texture.Texture;
import java.util.Random;

/**
 *
 * @author Landarzar
 */
public class CardFactory
{

    static void Init(AssetManager assetManager)
    {
        City1Street2 = assetManager.loadTexture("Textures/Cards/City1Street2.png");

        City1Street2Gerade = assetManager.loadTexture("Textures/Cards/City1Street2Gerade.png");

        City1Street2Right = assetManager.loadTexture("Textures/Cards/City1Street2Right.png");

        City1Street3 = assetManager.loadTexture("Textures/Cards/City1Street3.png");

        City1Wiese = assetManager.loadTexture("Textures/Cards/City1Wiese.png");

        City2Conn = assetManager.loadTexture("Textures/Cards/City2Conn.png");

        City2SplitWiese = assetManager.loadTexture("Textures/Cards/City2SplitWiese.png");

        City2SplitWiese2 = assetManager.loadTexture("Textures/Cards/City2SplitWiese2.png");

        City2Street2 = assetManager.loadTexture("Textures/Cards/City2Street2.png");

        City2WappenConn = assetManager.loadTexture("Textures/Cards/City2WappenConn.png");

        City2WappenStreet2 = assetManager.loadTexture("Textures/Cards/City2WappenStreet2.png");

        City2WappenWiese = assetManager.loadTexture("Textures/Cards/City2WappenWiese.png");

        City2Wiese = assetManager.loadTexture("Textures/Cards/City2Wiese.png");

        City3Street = assetManager.loadTexture("Textures/Cards/City3Street.png");

        City3WappenStreet = assetManager.loadTexture("Textures/Cards/City3WappenStreet.png");

        City3Wiese = assetManager.loadTexture("Textures/Cards/City3Wiese.png");

        City3WappenWiese = assetManager.loadTexture("Textures/Cards/City3WappenWiese.png");

        City4Wappen = assetManager.loadTexture("Textures/Cards/City4Wappen.png");

        Kloster = assetManager.loadTexture("Textures/Cards/Kloster.png");

        KlosterStreet = assetManager.loadTexture("Textures/Cards/KlosterStreet.png");

        Street2 = assetManager.loadTexture("Textures/Cards/Street2.png");

        Street2Left = assetManager.loadTexture("Textures/Cards/Street2Left.png");

        Street3 = assetManager.loadTexture("Textures/Cards/Street3.png");

        Street4 = assetManager.loadTexture("Textures/Cards/Street4.png");
    }
    public static Texture City1Street2;
    public static Texture City1Street2Gerade;
    public static Texture City1Street2Right;
    public static Texture City1Street3;
    public static Texture City1Wiese;
    public static Texture City2Conn;
    public static Texture City2SplitWiese;
    public static Texture City2SplitWiese2;
    public static Texture City2Street2;
    public static Texture City2WappenConn;
    public static Texture City2WappenStreet2;
    public static Texture City2WappenWiese;
    public static Texture City2Wiese;
    public static Texture City3Street;
    public static Texture City3WappenStreet;
    public static Texture City3Wiese;
    public static Texture City3WappenWiese;
    public static Texture City4Wappen;
    public static Texture Kloster;
    public static Texture KlosterStreet;
    public static Texture Street2;
    public static Texture Street2Left;
    public static Texture Street3;
    public static Texture Street4;

    static Texture getTexture()
    {
        Random rand = new Random(System.currentTimeMillis());

        int nr = rand.nextInt(24);

        switch (nr) {
            case 0:
                return City1Street2;
            case 1:
                return City1Street2Gerade;
            case 2:
                return City1Street2Right;
            case 3:
                return City1Street3;
            case 4:
                return City1Wiese;
            case 5:
                return City2Conn;
            case 6:
                return City2SplitWiese;
            case 7:
                return City2SplitWiese2;
            case 8:
                return City2Street2;
            case 9:
                return City2WappenConn;
            case 10:
                return City2WappenStreet2;
            case 11:
                return City2WappenWiese;
            case 12:
                return City2Wiese;
            case 13:
                return City3Street;
            case 14:
                return City3WappenStreet;
            case 15:
                return City3Wiese;
            case 16:
                return City3WappenWiese;
            case 17:
                return City4Wappen;
            case 18:
                return Kloster;
            case 19:
                return KlosterStreet;
            case 20:
                return Street2;
            case 21:
                return Street2Left;
            case 22:
                return Street3;
            case 23:
                return Street4;
        }
        
        return null;
    }
}