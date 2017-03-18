package com.banadiga.ann;

import com.banadiga.ann.core.ArtificialNeuralNetwork;
import com.banadiga.ann.core.IArtificialNeuralNetwork;
import com.banadiga.ann.coach.AndCoach;
import com.banadiga.ann.coach.ICoach;

public class AndApplication {
  public static void main(String[] args) {

    System.out.println("Creating Coach... ");
    ICoach coach = new AndCoach();

    IArtificialNeuralNetwork artificialNeuralNetwork = new ArtificialNeuralNetwork(coach.getInputs());
    System.out.println(artificialNeuralNetwork);

    System.out.println("Training... ");
    coach.training(artificialNeuralNetwork);

    System.out.println();
    System.out.println("ArtificialNeuralNetwork: " + artificialNeuralNetwork);
    System.out.println("Forecast(0,0): " + artificialNeuralNetwork.forecast(new Double[]{0d, 0d}));
    System.out.println("Forecast(0,1): " + artificialNeuralNetwork.forecast(new Double[]{0d, 1d}));
    System.out.println("Forecast(1,0): " + artificialNeuralNetwork.forecast(new Double[]{1d, 0d}));
    System.out.println("Forecast(1,1): " + artificialNeuralNetwork.forecast(new Double[]{1d, 1d}));
  }
}
