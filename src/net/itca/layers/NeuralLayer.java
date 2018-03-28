package net.itca.layers;

import net.itca.Neuron;
import net.itca.activation.ActivationFunction;

import java.util.List;

public abstract class NeuralLayer{

    protected int numberOfNeuronsInLayer;
    private List<Neuron> neuron;
    protected ActivationFunction func;
    protected NeuralLayer previous;
    protected NeuralLayer next;
    protected List<Double> input;
    protected List<Double> output;
    protected int numberOfInputs;


}
