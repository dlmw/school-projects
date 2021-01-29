package ch.ansermgw.angryword.test;

import com.badlogic.gdx.Gdx;

import ch.ansermgw.angryword.models.Language;
import ch.ansermgw.angryword.models.SemanticWord;
import ch.ansermgw.angryword.provider.LanguageNonExistentException;
import ch.ansermgw.angryword.provider.LanguageProvider;

public class SemanticWordTest {

    private static SemanticWord sw = new SemanticWord();
    private static Language en;
    private static Language fr;
    private static Language es;

    static {
        try {
            en = LanguageProvider.getInstance().getLanguage("en");
            fr = LanguageProvider.getInstance().getLanguage("fr");
            es = LanguageProvider.getInstance().getLanguage("es");
        } catch (LanguageNonExistentException e) {
            e.printStackTrace();
        }
    }

    public static boolean addTranslationTest() {
        boolean res = true;
        try {
            sw.addTranslation(en, "a chair");
            sw.addTranslation(es, "una silla");
            sw.addTranslation(fr, "une chaise");
            Gdx.app.log("TESTVP", "Add translation test success");
        } catch (Exception e) {
            Gdx.app.log("TESTVP", "Add translation test failed:" + e.getMessage());
            res= false;
        }

        try {
            sw.addTranslation(en, "a chair");
            Gdx.app.log("TESTVP", "Add translation duplicate test failed: duplicate was accepted");
            res = false;
        } catch (Exception e) {
            Gdx.app.log("TESTVP", "Add translation duplicate test success");
        }
        return res;
    }

    public static boolean getValueTest() {
        boolean res = true;
        try {
            if (sw.getValue(en).equals("a chair")) {
                Gdx.app.log("TESTVP", "Get translation test success");
            } else {
                Gdx.app.log("TESTVP", "Get translation test failed: bad value");
                res = false;
            }
        } catch (Exception e) {
            Gdx.app.log("TESTVP", "Get translation test failed: exception " + e.getMessage());
            return false;
        }

        try {
            sw.getValue(LanguageProvider.getInstance().getLanguage("xx"));
            Gdx.app.log("TESTVP", "Get nonexistent translation test failed: no exception raised");
            res = false;
        } catch (Exception e) {
            Gdx.app.log("TESTVP", "Get nonexistent translation test success: " + e.getMessage());
        }
        return res;
    }


}
