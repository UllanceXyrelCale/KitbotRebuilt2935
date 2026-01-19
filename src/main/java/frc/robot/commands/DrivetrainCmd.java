package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DrivetrainCmd extends Command {
  // Initialize the subsystem and joystick value suppliers
  private final DrivetrainSubsystem drivetrainSubsystem;
  private final Supplier<Double> speedFunction;
  private final Supplier<Double> turnFunction;


  public DrivetrainCmd(DrivetrainSubsystem drivetrainSubsystem, 
                       Supplier<Double> speedFunction, 
                       Supplier<Double> turnFunction) {
    this.drivetrainSubsystem = drivetrainSubsystem;
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    
    addRequirements(drivetrainSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    // Grabs the real time joystick values
    double realTimeSpeed = speedFunction.get();
    double realTimeTurn = turnFunction.get();

    // Arcade drive logic
    double leftSpeed = realTimeTurn - realTimeSpeed;
    double rightSpeed = realTimeTurn + realTimeSpeed;

    // Set motor speed
    drivetrainSubsystem.drive(leftSpeed, rightSpeed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}