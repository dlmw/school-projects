package ch.ansermgw.angryword;

import ch.ansermgw.angryword.activities.Activity;
import ch.ansermgw.angryword.activities.LanguageSelection;
import ch.ansermgw.angryword.activities.Welcome;
import ch.ansermgw.angryword.models.Language;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import java.util.Enumeration;
import java.util.Random;
import java.util.Stack;

public class AngrywordMain extends Game {
    private static AngrywordMain instance;
    private static Stack<Activity> activities;
    private static Random rand;

    private static Language sourceLanguage;
    private static Language targetLanguage;

    private AngrywordMain() {
        rand = new Random(System.currentTimeMillis());
    }

    public static AngrywordMain getInstance() {
        if (instance == null) {
            instance = new AngrywordMain();
        }

        return instance;
    }

    public static Random getRand() {
        return rand;
    }

    public static Language getSourceLanguage() {
        return sourceLanguage;
    }

    public static void setSourceLanguage(Language sourceLanguage) {
        AngrywordMain.sourceLanguage = sourceLanguage;
    }

    public static Language getTargetLanguage() {
        return targetLanguage;
    }

    public static void setTargetLanguage(Language targetLanguage) {
        AngrywordMain.targetLanguage = targetLanguage;
    }

    private void updateInputProcessor() {
        Gdx.input.setInputProcessor(activities.peek());
    }

    public void push(Activity activity) {
        activities.push(activity);
        updateInputProcessor();
    }

    public void pop() {
        activities.pop();
        updateInputProcessor();
    }

    @Override
    public void create() {
        activities = new Stack<>();

        Activity languageSelection = new LanguageSelection();
        languageSelection.create();

        push(languageSelection);
    }

    @Override
    public void render() {
        activities.peek().render();
    }

    @Override
    public void dispose() {
        Enumeration<Activity> activitiesEnum = activities.elements();

        while (activitiesEnum.hasMoreElements()) {
            Game nextActivity = activitiesEnum.nextElement();
            nextActivity.dispose();
        }
    }
}
