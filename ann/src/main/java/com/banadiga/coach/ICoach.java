package com.banadiga.coach;

import com.banadiga.ann.IArtificialNeuralNetwork;

public interface ICoach {
  int getInputs();
  void training(IArtificialNeuralNetwork artificialNeuralNetwork);
}
