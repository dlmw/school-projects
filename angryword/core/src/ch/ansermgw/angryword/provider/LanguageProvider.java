package ch.ansermgw.angryword.provider;

import java.util.ArrayList;
import java.util.List;

import ch.ansermgw.angryword.models.Language;

public class LanguageProvider {
    private List<Language> languages;
    private static LanguageProvider instance;

    private LanguageProvider() {

    }

    public static LanguageProvider getInstance() {
        if (instance == null) {
            instance = new LanguageProvider();
            Language frenchLanguage = new Language("Français", "fr");
            Language englishLanguage = new Language("Anglais", "en");
            Language spanishLanguage = new Language("Espagnol", "es");

            List<Language> languageList = new ArrayList<>();
            languageList.add(frenchLanguage);
            languageList.add(englishLanguage);
            languageList.add(spanishLanguage);
            instance.setLanguages(languageList);
        }
        return instance;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public Language getLanguage(String iso) throws LanguageNonExistentException {
        Language language = null;
        for (Language l : languages) {
            if (l.getIso_639_1().equalsIgnoreCase(iso)) {
                return l;
            }
        }
        throw new LanguageNonExistentException("No " + iso + " trans");
    }

    private void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
}
