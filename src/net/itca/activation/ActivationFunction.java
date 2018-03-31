package net.itca.activation;

public interface ActivationFunction {

    public enum FunctionType {
        STEP,
        LINEAR,
        SIGMOID,
        HYPTERTAN
    }

    public double calc(double in);

}
