package de.hska.iwi.vislab.lab2.example;

public class FibonacciServiceImpl implements FibonacciService {
    private int currentFibonacci = 0;

    public int getFibonacci(int number){
        if(number == 0){
            return 0;
        }
        if(number == 1 || number == 2){
            return 1;
        }
        return getFibonacci(number-2) + getFibonacci(number-1);
    }

    @Override
    public int getNextFibonacci() {
        int result = getFibonacci(currentFibonacci);
        currentFibonacci++;
        return result;
    }

    @Override
    public void deleteFibonacci() {
        currentFibonacci = 0;
    }
}
