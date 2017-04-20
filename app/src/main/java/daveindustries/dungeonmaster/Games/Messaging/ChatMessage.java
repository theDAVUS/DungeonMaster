package daveindustries.dungeonmaster.Games.Messaging;

/**
 * Created by daver on 4/19/2017.
 */

public class ChatMessage {

    private String sendTo;
    private String message;
    private String from;

    public String getSendTo() {
        return sendTo;
    }

    public String getMessage() {
        return message;
    }



    public void setMessage(String message) {
        this.message = message;
    }


    public ChatMessage(){    }
    public ChatMessage(String sendTo, String message ) {
        this.sendTo = sendTo;
        this.message = message;

    }

}
