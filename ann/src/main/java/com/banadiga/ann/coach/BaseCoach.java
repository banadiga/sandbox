package com.banadiga.ann.coach;

import com.banadiga.ann.core.IArtificialNeuralNetwork;

import static java.lang.Math.abs;

public abstract class BaseCoach implements ICoach {

  protected abstract int getSize();

  protected abstract Double[] getInputs(int index);

  protected abstract Double getExpectedResult(int index);

  protected abstract int getMaxSteps();

  protected abstract int getMinSteps();

  protected abstract Double getExpectedError();

  public void training(final IArtificialNeuralNetwork artificialNeuralNetwork) {
    final int maxStep = getMaxSteps();
    final int minStep = getMinSteps();
    final double expectedError = getExpectedError();
    final int trainSize = getSize();

    double error;
    int step = 1;
    do {
      error = 0d;
      System.out.println("Step: " + (step++));
      for (int i = 0; i < trainSize; i++) {
        Double[] input = getInputs(i);
        Double expected = getExpectedResult(i);

        Double result = artificialNeuralNetwork.forecast(input);

        Double mistake = expected - result;
        error += abs(mistake);

        artificialNeuralNetwork.updating(mistake, input);
      }

      System.out.println("ANN:" + artificialNeuralNetwork + " Error: " + error);

    } while (abs(error) > expectedError && step <= maxStep || step <= minStep);
  }
}
