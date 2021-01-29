package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

public class Pig extends PhysicalObject {

    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;
    private static final String SPRITE_NAME = "pig.png";
    private final SemanticWord semanticWord;

    public Pig(Vector2 position, SemanticWord word) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME);
        semanticWord = word;
    }

    public void kill() {

    }

    public SemanticWord getWord() {
        return semanticWord;
    }
}
