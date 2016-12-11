package com.itransition.app.error;

import java.util.Random;

public class ErrorCreator {

    private Random random;
    private final static int DELETE_ERROR_FLAG = 1;
    private final static int REARRANGE_ERROR_FLAG = 2;
    private final static int ADD_ERROR_FLAG = 3;

    private final static int MAX_ERROR_FLAG = 3;

    public ErrorCreator(){
        this.random = new Random();
    }

    public StringBuilder addError(StringBuilder str, double errorCount){
        int errors = getIntegerProbability(errorCount);
        while(errors >= 0){
            switch(getErrorTypeProbability()){
                case DELETE_ERROR_FLAG: deleteSymbol(str);
                case REARRANGE_ERROR_FLAG: rearrangeSymbol(str);
                case ADD_ERROR_FLAG: addSymbol(str);
            }
            errors--;
        }
        return str;
    }

    private StringBuilder deleteSymbol(StringBuilder str){
        int index = getStringRandomIndex(str);
        str.deleteCharAt(index);
        return str;
    }

    private StringBuilder rearrangeSymbol(StringBuilder str){
        int index1 = getStringRandomIndex(str);
        int index2 = getStringRandomIndex(str);
        return swap(str, index1, index2);
    }

    private StringBuilder addSymbol(StringBuilder str){
        char randomChar = str.charAt(getStringRandomIndex(str));
        str.append(randomChar);
        return str;
    }

    private int getIntegerProbability(double errorCount) {
        double fraction = errorCount - (int) errorCount;
        double probability = random.nextDouble();
        if (probability <= fraction) {
            return (int) errorCount + 1;
        } else {
            return (int) errorCount;
        }
    }

    private int getErrorTypeProbability(){
        int pr = random.nextInt(MAX_ERROR_FLAG + 1) + 1;
        return pr;
    }

    private int getStringRandomIndex(StringBuilder str){
        return random.nextInt(str.length());
    }

    private StringBuilder swap(StringBuilder str, int index1, int index2){
        char temp = str.charAt(index1);
        str.setCharAt(index1, str.charAt(index2));
        str.setCharAt(index2, temp);
        return str;
    }
}
