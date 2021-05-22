package utils;

import controller.keysController.Nkey;

public class Sender
{
    private Integer message_;

    public Sender(int M){
        message_ = M;
    }

    public int MessageToSend(Nkey key){
        return Utils.MOD(key.getE(),key.getN(),message_);
    }
}
