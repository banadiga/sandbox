package com.banadiga.ann.core;

public interface IArtificialNeuralNetwork {
  Double forecast(Double[] input);

  void updating(Double error, Double[] input);
}
