
import message.Message;

/**
 * This is our abstract "creator".
 * The abstract method createMessage() has to be implemented by
 * its subclasses.
 */
public abstract class MessageCreator {

    public Message getMessage() {
        Message msg = createMessage();
        // some processing msg
        msg.addDefaultHeaders();
        msg.encrypt();

        return msg;
    }

    // abstract Factory Method (creator method)
    public abstract Message createMessage();

}
