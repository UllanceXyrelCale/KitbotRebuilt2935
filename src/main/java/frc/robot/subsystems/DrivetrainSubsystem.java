package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  // Initialize the motors
  private final SparkMax leftMotorFront;
  private final SparkMax leftMotorBack;
  private final SparkMax rightMotorFront;
  private final SparkMax rightMotorBack;

  public DrivetrainSubsystem() {
    leftMotorFront = new SparkMax(40, MotorType.kBrushless);
    leftMotorBack = new SparkMax(41, MotorType.kBrushless);
    rightMotorFront = new SparkMax(42, MotorType.kBrushless);
    rightMotorBack = new SparkMax(43, MotorType.kBrushless);
    
    // Invert right side motors so both sides drive in the same direction
    rightMotorFront.setInverted(true);
    rightMotorBack.setInverted(true);
  }

  public void drive(double leftMotorSpeed, double rightMotorSpeed) {
    // Set different motor speed
    leftMotorFront.set(-leftMotorSpeed);
    // leftMotorBack.set(leftMotorSpeed);
    rightMotorFront.set(-rightMotorSpeed);
    // rightMotorBack.set(rightMotorSpeed);
  }

  @Override
  public void periodic() {

  }
}