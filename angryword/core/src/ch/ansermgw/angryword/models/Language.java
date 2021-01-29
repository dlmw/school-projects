package ch.ansermgw.angryword.models;

public class Language {
    private String displayName;
    private String iso_639_1;

    public Language(String displayName, String iso_639_1) {
        this.displayName = displayName;
        this.iso_639_1 = iso_639_1;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }
}
