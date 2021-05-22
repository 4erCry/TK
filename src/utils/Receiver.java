package utils;

import controller.keysController.Dkey;
import controller.keysController.Nkey;

public class Receiver
{
    private Nkey nKey_;
    private Dkey dKey_;

    public Receiver(){
        DataGeneration();
    }

    private void DataGeneration(){
        int p = Utils.RandomPrimeNumber();
        int q = Utils.RandomPrimeNumber();
        int phi = Utils.phi(p,q);
        int n = Utils.n(p,q);
        int e = Utils.PrimeNumbersChecking(phi);
        int d = Utils.SecretKeyGeneration(e,phi);

        nKey_ = new Nkey(e,n);
        dKey_ = new Dkey(d,n);
    }

    public Nkey getNkey(){
        return nKey_;
    }

    public int MessageToReceive(Integer MessageToSend){
        return Utils.MOD(dKey_.getD(), dKey_.getN(), MessageToSend);
    }
}
