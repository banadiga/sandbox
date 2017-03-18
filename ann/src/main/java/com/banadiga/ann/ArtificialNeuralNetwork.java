package com.banadiga.ann;

import java.util.Random;

public class ArtificialNeuralNetwork implements IArtificialNeuralNetwork {

  private Double synapses[] = new Double[2];
  private Random random = new Random();

  public ArtificialNeuralNetwork() {
    for (int i = 0; i < 2; i++) {
      this.synapses[i] = random.nextDouble() * 0.1d + 0.1d;
    }
  }

  public Double forecast(Double[] input) {
    Double output = 0d;
    for (int i = 0; i < 2; i++) {
      output += input[i] * this.synapses[i];
    }
    if (output > 0.8) {
      return 1d;
    }
    return 0d;
  }

  public void updating(Double error, Double[] input) {
    for (int i = 0; i < 2; i++) {
      this.synapses[i] += 0.1 * error * input[i]  * random.nextDouble();
    }
  }

  @Override
  public String toString() {
    String result = "ArtificialNeuralNetwork(";
    for (int i = 0; i < 2; i++) {
      result += " " + this.synapses[i];
    }
    result += " )";
    return result;
  }
}
