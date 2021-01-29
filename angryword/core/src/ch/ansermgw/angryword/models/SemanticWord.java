package ch.ansermgw.angryword.models;

import java.util.HashMap;
import java.util.Map;

import ch.ansermgw.angryword.exception.TranslationDoesNotExistException;
import ch.ansermgw.angryword.exception.TranslationExistsException;

public class SemanticWord {
    private final Map<Language, String> values;
    private boolean isUsed;

    public SemanticWord() {
        this.values = new HashMap<>();
        this.isUsed = false;
    }

    public void addTranslation(Language language, String value) throws TranslationExistsException {
        if (this.values.get(language) != null) {
            throw new TranslationExistsException(language.getDisplayName() + " " + value);
        }

        this.values.put(language, value);
    }

    public String getValue(Language language) throws TranslationDoesNotExistException {
        String value = values.get(language);

        if (value == null) {
            throw new TranslationDoesNotExistException(language.getDisplayName());
        }

        return value;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
