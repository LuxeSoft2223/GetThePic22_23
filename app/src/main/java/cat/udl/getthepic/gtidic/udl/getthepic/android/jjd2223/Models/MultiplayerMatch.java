package cat.udl.getthepic.gtidic.udl.getthepic.android.jjd2223.Models;

public class MultiplayerMatch {
    public String getUserCreator() {
        return userCreator;
    }

    String userCreator;
    int status = 1;

    public MultiplayerMatch(String user){
        this.userCreator = user;
    }
}