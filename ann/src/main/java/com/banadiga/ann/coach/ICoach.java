package com.banadiga.ann.coach;

import com.banadiga.ann.core.IArtificialNeuralNetwork;

public interface ICoach {
  int getInputs();
  void training(IArtificialNeuralNetwork artificialNeuralNetwork);
}
