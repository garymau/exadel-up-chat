package logic;

/**
 * Created by Diman on 21.04.2015.
 */
public class Chatter {
    private String nickName=null;
    private String sessionId=null;

    public Chatter(String nickName, String sessionId) {
        this.sessionId = sessionId;
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
