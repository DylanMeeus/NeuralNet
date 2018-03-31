package net.itca.layers;

import net.itca.Neuron;
import net.itca.activation.ActivationFunction;

import java.util.List;

public abstract class NeuralLayer{

    protected int numberOfNeuronsInLayer;
    private List<Neuron> neurons;
    protected ActivationFunction func;
    protected NeuralLayer previous;
    protected NeuralLayer next;
    protected List<Double> inputs;
    protected List<Double> outputs;
    protected int numberOfInputs;

    protected void init(){
        for (var i = 0; i < numberOfNeuronsInLayer; i++) {
            if (neurons.size() < i) {
                neurons.get(i).setActivationFunction(func);
                neurons.get(i).init();
            } else {
                neurons.add(new Neuron(numberOfInputs, func));
                neurons.get(i).init();
            }
        }
    }

    protected void calc(){
        for (var i = 0; i < numberOfNeuronsInLayer; i++) {
            neurons.get(i).setInputs(inputs);
            neurons.get(i).calc();
            if (i < outputs.size()) {
                outputs.set(i, neurons.get(i).getOutput());
            } else {
                outputs.add(neurons.get(i).getOutput());
            }
        }
    }

}
