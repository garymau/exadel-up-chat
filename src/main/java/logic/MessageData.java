package logic;

import java.util.HashMap;

/**
 * Created by Diman on 02.05.2015.
 */
public class MessageData {
    private HashMap allMessages;

    public HashMap getAllMessages(){
        return allMessages;
    }

    public MessageData(HashMap allMessages){
        allMessages.putAll(allMessages);
    }

    public void addMessage(Message message){

    }
}
