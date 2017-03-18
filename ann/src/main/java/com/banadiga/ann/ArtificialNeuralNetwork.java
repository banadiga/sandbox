package com.banadiga.ann;

import java.util.Random;

public class ArtificialNeuralNetwork implements IArtificialNeuralNetwork {

  private Double synapses[][] = new Double[1][2];
  private Random random = new Random();

  public ArtificialNeuralNetwork(int inputs) {
    this(inputs, 1);
  }

  public ArtificialNeuralNetwork(int inputs, int layers) {
    this.synapses = new Double[layers][inputs];
    for (int i = 0; i < layers; i++) {
      this.synapses[i] = new Double[inputs];
      for (int j = 0; j < inputs; j++) {
        this.synapses[i][j] = random.nextDouble() * 0.1d + 0.1d;
      }
    }
  }

  public Double forecast(Double[] input) {
    Double output = 0d;
    for (int i = 0; i < 2; i++) {
      output += input[i] * this.synapses[0][i];
    }
    if (output > 0.8) {
      return 1d;
    }
    return 0d;
  }

  public void updating(Double error, Double[] input) {
    for (int i = 0; i < 2; i++) {
      this.synapses[0][i] += 0.1 * error * input[i] * random.nextDouble();
    }
  }

  @Override
  public String toString() {
    String result = "ArtificialNeuralNetwork(";
    for (int i = 0; i < 2; i++) {
      result += " " + this.synapses[0][i];
    }
    result += " )";
    return result;
  }
}
