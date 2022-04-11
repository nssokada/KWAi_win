package com.example.kwai_win;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class KWAiUser {

    public String name;
    private int valence;
    private int arousal;
    private int uid;

    public void setName(String name) {
        this.name = name;
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        String getUID = "SELECT count(1) FROM User WHERE username = '" + name + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult  = statement.executeQuery(getUID);
            while(queryResult.next()) {
                uid = queryResult.getInt(1);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getName() { return name;}

    public void setUID(int uid) { this.uid = uid; }

    public int getUID() {return uid;}

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
