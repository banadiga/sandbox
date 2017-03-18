package com.banadiga.ann;

public interface IArtificialNeuralNetwork {
  Double forecast(Double[] input);

  void updating(Double error, Double[] input);
}
