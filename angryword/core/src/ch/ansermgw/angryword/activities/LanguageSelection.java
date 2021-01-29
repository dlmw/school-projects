package ch.ansermgw.angryword.activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import ch.ansermgw.angryword.AngrywordMain;
import ch.ansermgw.angryword.models.Button;
import ch.ansermgw.angryword.models.Language;
import ch.ansermgw.angryword.models.LanguageSelectionButton;
import ch.ansermgw.angryword.provider.LanguageProvider;
import ch.ansermgw.angryword.test.SemanticWordTest;

public class LanguageSelection extends Activity {
    private List<Language> sourceLanguages;
    private List<Language> targetLanguages;

    private static final float SPACE_BETWEEN_BUTTONS = WORLD_HEIGHT / 8;

    private List<LanguageSelectionButton> sourceLanguagesButtons;
    private List<LanguageSelectionButton> targetLanguagesButtons;

    BitmapFont bitmapFont;
    private String languageSelectionSummary = "Exercice de {0} en {1}";

    private Button playButton;

    @Override
    public void create() {
        super.create();

        SemanticWordTest.addTranslationTest();
        SemanticWordTest.getValueTest();

        bitmapFont = new BitmapFont();
        bitmapFont.getData().setScale(5);
        bitmapFont.setColor(Color.BLUE);

        sourceLanguages = LanguageProvider.getInstance().getLanguages();
        targetLanguages = LanguageProvider.getInstance().getLanguages();

        sourceLanguagesButtons = createLanguagesButton(sourceLanguages, 200);
        targetLanguagesButtons = createLanguagesButton(targetLanguages, 400);

    }

    public List<LanguageSelectionButton> createLanguagesButton(List<Language> languages, float xPosition) {
        List<LanguageSelectionButton> buttons = new ArrayList<>();
        int loopIndex = 0;
        for (Language language : languages) {
            float yPosition = (loopIndex + 4) * SPACE_BETWEEN_BUTTONS;
            Vector2 buttonPosition = new Vector2(xPosition, yPosition);
            LanguageSelectionButton button = new LanguageSelectionButton(buttonPosition, language.getDisplayName(), language);
            buttons.add(button);
            loopIndex++;
        }
        return buttons;
    }

    @Override
    public void render() {
        super.render();
        for (Button button : sourceLanguagesButtons) {
            button.draw(super.batch);
        }
        for (Button button : targetLanguagesButtons) {
            button.draw(super.batch);
        }

        if (playButton != null) {
            playButton.draw(super.batch);
        }

        Language sourceLanguage = AngrywordMain.getInstance().getSourceLanguage();
        Language targetLanguage = AngrywordMain.getInstance().getTargetLanguage();
        String source = sourceLanguage != null ? sourceLanguage.getDisplayName() : "(choisir)";
        String target = targetLanguage != null ? targetLanguage.getDisplayName() : "(choisir)";

        if (sourceLanguage != null && targetLanguage != null) {
            playButton = new Button(new Vector2(WORLD_WIDTH / 2, WORLD_HEIGHT / 3), "Play");
        }

        String textToDisplay = MessageFormat.format(languageSelectionSummary, new String[]{source, target});
        bitmapFont.draw(super.batch, textToDisplay, WORLD_WIDTH / 8, WORLD_HEIGHT / 5);
        super.batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 touchPosition = super.getAbsolutePosition(screenX, screenY);
        for (LanguageSelectionButton b : sourceLanguagesButtons) {
            if (hasClicked(b, touchPosition)) {
                AngrywordMain.getInstance().setSourceLanguage(b.getLanguage());
                sourceLanguagesButtons = new ArrayList<>();
                return true;
            }
        }

        for (LanguageSelectionButton b : targetLanguagesButtons) {
            if (hasClicked(b, touchPosition)) {
                AngrywordMain.getInstance().setTargetLanguage(b.getLanguage());
                targetLanguagesButtons = new ArrayList<>();
                return true;
            }
        }

        if (playButton != null && hasClicked(playButton, touchPosition)) {
            Activity play = new Play();
            play.create();
            AngrywordMain.getInstance().push(play);
        }

        return false;
    }

    private boolean hasClicked(Button button, Vector2 touchPosition) {
        if (super.isPhysicalObjectContainingVector(button, touchPosition)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
