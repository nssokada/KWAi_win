package com.example.kwai_win;

public class KWAiUser {

    public String name;
    private int valence;
    private int arousal;

    public KWAiUser( int valence, int arousal){
        this.valence=valence;
        this.arousal =arousal;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValence(int valence){
        this.valence = valence;
    }

    public void addValence(int valence){this.valence += valence;}

    public int getValence() {
        return valence;
    }

    public void setArousal(int arousal) {
        this.arousal = arousal;
    }
    public void addArousal(int arousal){this.arousal += arousal;}

    public int getArousal() {
        return arousal;
    }

}
