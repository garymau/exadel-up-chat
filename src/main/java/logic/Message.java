package logic;

/**
 * Created by Diman on 21.04.2015.
 */
public class Message
{
    private String chatterNickName = null;
    private String messageText = null;
    private String timeStamp;

    public Message(String name, String messageText, String timeStamp)
    {
        this.chatterNickName = name;
        this.messageText = messageText;
        this.timeStamp = timeStamp;
    }

    public void setChatterNickName(String chatterNickName) {
        this.chatterNickName = chatterNickName;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getChatterName()
    {
        return chatterNickName;
    }

    public String getMessageText()
    {
        return messageText;
    }

    public String getTimeStamp()
    {
        return timeStamp;
    }
}
