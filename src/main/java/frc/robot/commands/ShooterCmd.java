package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCmd extends Command {
  private final ShooterSubsystem shooterSubsystem;
  private final double targetVelocityRPS;

  public ShooterCmd(ShooterSubsystem shooterSubsystem, double targetVelocityRPS) {
    this.shooterSubsystem = shooterSubsystem;
    this.targetVelocityRPS = targetVelocityRPS;

    addRequirements(shooterSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    shooterSubsystem.setVelocity(targetVelocityRPS);
  }

  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
