package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

public class LanguageSelectionButton extends Button {
    private Language language;

    public LanguageSelectionButton(Vector2 position, String text, Language language) {
        super(position, text);
        this.language = language;
    }

    public Language getLanguage() {
        return language;
    }
}
