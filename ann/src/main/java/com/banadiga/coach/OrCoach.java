package com.banadiga.coach;

public class OrCoach extends BaseCoach implements ICoach {

  private static final double ERROR = 0.0001D;
  private static final int MAXSTEP = 100000;
  private static final int MINSTEP = 2;


  private Double inputs[][] = {{0d, 0d}, {1d, 1d}, {1d, 0d}, {0d, 1d}};
  private Double outputs[] = {0d, 1d, 1d, 1d};

  public int getSize() {
    return inputs.length;
  }

  protected Double[] getInputs(int index) {
    return inputs[index];
  }

  protected Double getExpectedResult(int index) {
    return outputs[index];
  }

  protected int getMaxSteps() {
    return MAXSTEP;
  }

  protected int getMinSteps() {
    return MINSTEP;
  }

  protected Double getExpectedError() {
    return ERROR;
  }

  public int getInputs() {
    return 2;
  }
}
