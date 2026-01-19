package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IndexerSubsystem;

public class IndexerCommand extends Command {
  private final IndexerSubsystem indexerSubsystem;
  private final double indexerSpeed;

  public IndexerCommand(IndexerSubsystem indexerSubsystem, double indexerSpeed) {
    this.indexerSpeed = indexerSpeed;
    this.indexerSubsystem = indexerSubsystem;

    addRequirements(indexerSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    indexerSubsystem.runIndexer(indexerSpeed);

  }

  @Override
  public void end(boolean interrupted) {
    indexerSubsystem.runIndexer(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
