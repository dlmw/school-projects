package ch.ansermgw.angryword.resource;

import ch.ansermgw.angryword.AngrywordMain;
import ch.ansermgw.angryword.activities.Play;
import ch.ansermgw.angryword.models.SemanticWord;

import java.util.ArrayList;
import java.util.List;

public class VocabularyResource {
    private final List<SemanticWord> words;
    private final String name;

    public VocabularyResource(ArrayList<SemanticWord> words, String name) {
        this.words = words;
        this.name = name;
    }

    public VocabularyResource(String name) {
        words = new ArrayList<>();
        this.name = name;
    }

    public void addSemanticWord(SemanticWord sw) {
        words.add(sw);
    }

    public SemanticWord getRandomUsedWordResource() {
        List<SemanticWord> usedWord = new ArrayList<>();

        for (SemanticWord word : words) {
            if (word.isUsed()) {
                usedWord.add(word);
            }
        }

        return getRandomWordResourceFromList(usedWord);
    }

    public SemanticWord getRandomUnusedWordResource() {
        List<SemanticWord> unusedWord = new ArrayList<>();

        for (SemanticWord word : words) {
            if (!word.isUsed()) {
                unusedWord.add(word);
            }
        }

        return getRandomWordResourceFromList(unusedWord);
    }

    private SemanticWord getRandomWordResourceFromList(List<SemanticWord> wordResources) {
        if (wordResources.size() < 1) {
            return null;
        }

        return wordResources.get(AngrywordMain.getInstance().getRand().nextInt(wordResources.size()));
    }
}
