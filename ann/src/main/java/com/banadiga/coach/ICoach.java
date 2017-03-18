package com.banadiga.coach;

import com.banadiga.ann.IArtificialNeuralNetwork;

public interface ICoach {
  int getSize();
  void training(IArtificialNeuralNetwork artificialNeuralNetwork);
}
