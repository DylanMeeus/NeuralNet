package net.itca;

import net.itca.activation.ActivationFunction;
import net.itca.util.RandomNumberGenerator;

import java.util.*;

public class Neuron{

    // protected
    protected List<Double> weights;
    protected Double bias = 1d;

    //privates
    private List<Double> inputs;
    private Double output;
    private double outputBeforeActivation;
    private int numberOfInputs;

    private ActivationFunction activationFunction;

    public Neuron(int numberOfInputs, ActivationFunction activationFunction){
        this.numberOfInputs = numberOfInputs;
        this.weights = new ArrayList<>(numberOfInputs+1);
        this.inputs = new ArrayList<>(numberOfInputs);
        this.activationFunction = activationFunction;

    }

    private void init(){
        for(var i = 0; i <= numberOfInputs; i++){
            var newWeight = RandomNumberGenerator.generateNext();
            if (i < weights.size()){
                weights.set(i, newWeight);
            } else {
                weights.add(newWeight);
            }
        }
    }


    private void calc(){
        outputBeforeActivation = 0;
        if (numberOfInputs > 0){
            if(inputs != null && weights != null){
                for(var i = 0; i <= numberOfInputs; i++){
                    outputBeforeActivation += (i == numberOfInputs ? bias : inputs.get(i)) * weights.get(i);
                }
            }
        }
        output = activationFunction.calc(outputBeforeActivation);
    }

}
