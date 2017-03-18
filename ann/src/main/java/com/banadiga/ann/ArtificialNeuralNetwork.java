package com.banadiga.ann;

import java.util.Random;

public class ArtificialNeuralNetwork implements IArtificialNeuralNetwork {

  private Double synapses[][];
  private Random random = new Random();

  private int inputs;
  private int layers;

  public ArtificialNeuralNetwork(int inputs) {
    this(inputs, 1);
  }

  public ArtificialNeuralNetwork(int inputs, int layers) {
    this.inputs = inputs;
    this.layers = layers;

    this.synapses = new Double[this.layers][this.inputs];
    for (int i = 0; i < this.layers; i++) {
      this.synapses[i] = new Double[this.inputs];
      for (int j = 0; j < this.inputs; j++) {
        this.synapses[i][j] = random.nextDouble() * 0.1d + 0.1d;
      }
    }
  }

  public Double forecast(Double[] input) {
    Double output = 0d;
    for (int i = 0; i < this.layers ; i++) {
      for (int j = 0; j < this.inputs; j++) {
        output += input[j] * this.synapses[i][j];
      }
    }
    if (output > 0.8) {
      return 1d;
    }
    return 0d;
  }

  public void updating(Double error, Double[] input) {
    for (int i = 0; i < this.layers; i++) {
      for (int j = 0; j < this.inputs; j++) {
        this.synapses[i][j] += 0.1 * error * input[j] * random.nextDouble();
      }
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
