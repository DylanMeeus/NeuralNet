package net.itca.activation;

public interface ActivationFunction {

    default double calc(double in){
        return 0;
    }

}
