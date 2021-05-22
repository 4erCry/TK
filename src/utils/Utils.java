package utils;

import java.util.ArrayList;

public class Utils
{
    private static int NOD(int a, int b){
        if (a == b) {
            return a;
        } else {
            if (a > b) {
                return NOD(a - b, b);
            } else {
                return NOD(b - a, a);
            }
        }
    }

    public static int phi(int p, int q){
        return (p-1)*(q-1);
    }

    public static int n(int p, int q){
        return p*q;
    }

    public static int RandomPrimeNumber(){
        boolean isNumberPrime;
        int randomPrimeNumber;
        do{
            isNumberPrime = true;
            randomPrimeNumber = 2+(int)(Math.random()*60);
            for (int i=2; i<randomPrimeNumber; i++){
                if ((randomPrimeNumber%i)==0){
                    isNumberPrime = false;
                    break;
                }
            }
        }while(!isNumberPrime);
        return randomPrimeNumber;
    }

    public static int SecretKeyGeneration(int e, int phi){
        int i=1+(int)(Math.random()*10);
        do{
            i++;
        }while((i*phi+1%e!=0));
        return (i*phi+1)/e;
    }

    public static int PrimeNumbersChecking(Integer d){
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        int e=2;
        while(e<d){
            if (NOD(e,d)==1){
                primeNumbers.add(e);
            }
            e++;
        }
        int PrimeIndex = (int)(Math.random()*(primeNumbers.size()));
        return primeNumbers.get(PrimeIndex);
    }

    private static int[] Bits(int n){
        int bitsArray = (int)(Math.log(n)/Math.log(2)+1);
        int[] binary = new int[bitsArray];
        int i=0;
        do{
            binary[i] = n%2;
            n /=2;
            i++;
        }while (n>0);
        return binary;
    }

    private static long Composition(int[] bits,int[] sequence){
        long binary=1;
        for(int i=1; i<bits.length; i++){
            binary *= sequence[i];
        }
        return binary;
    }

    public static int MOD(int a, int n, int d){
        int result;
        int[] e=Bits(a);
        int length = e.length;
        int[] sequence = new int[length];
        sequence[0]=d;
        for (int i=1; i<length; i++){
            long tmp = (sequence[i-1] * sequence[i-1]);
            sequence[i] = (int)(tmp % n);
        }
        long composition = Composition(e,sequence);
        result = (int)(composition % n);
        return result;
    }
}



