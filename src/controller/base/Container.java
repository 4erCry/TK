package controller.base;

import controller.keysController.Nkey;
import utils.Receiver;
import utils.Sender;

public class Container
{
    private Receiver receiver_;
    private Sender sender_;

    private int message_;
    private int m_;
    private int s_;

    public Container()
    {
        receiver_ = new Receiver();
    }

    public void perform(int m)
    {
        m_ = m;
        sender_ = new Sender(m);
        int MessageToSend = sender_.MessageToSend(receiver_.getNkey());
        message_= MessageToSend;
        s_ = receiver_.MessageToReceive(MessageToSend);
    }

    public Nkey getNkey()
    {
        return receiver_.getNkey();
    }

    public int getMessage()
    {
        return message_;
    }

    public int getMessageToReceive()
    {
        return s_;
    }

    public int getMessageToSend()
    {
        return m_;
    }
}
