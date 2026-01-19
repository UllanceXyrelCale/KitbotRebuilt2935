// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IndexerSubsystem extends SubsystemBase {
  // Initialize the motor
  private final SparkMax indexerMotor;

  /** Creates a new IndexerSubsystem. */
  public IndexerSubsystem() {
    // Set the motor
    indexerMotor = new SparkMax(44, MotorType.kBrushless);
    indexerMotor.setInverted(true);
  }

  @Override
  public void periodic() {

  }
  
  public void runIndexer (double indexerSpeed){
    indexerMotor.set(indexerSpeed);
  }
}
