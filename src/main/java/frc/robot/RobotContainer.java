package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DrivetrainCmd;
import frc.robot.commands.IndexerCommand;
import frc.robot.commands.ShooterCmd;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  // Initialize and set the subsystems
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final IndexerSubsystem indexerSubsystem = new IndexerSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

  // Create an instance of a controller
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);


  public RobotContainer() {
    // Creates the drive for the drivetrain with lambda suppliers for real-time joystick values
    drivetrainSubsystem.setDefaultCommand(
      new DrivetrainCmd(
        drivetrainSubsystem, 
        () -> m_driverController.getLeftY(), 
        () -> m_driverController.getRightX()
      )
    );

    configureBindings();
  }


  private void configureBindings() {
    // Runs the indexer using left bumper and a button
    m_driverController.leftBumper().whileTrue(new IndexerCommand(indexerSubsystem, 3));
    m_driverController.a().whileTrue(new IndexerCommand(indexerSubsystem, -3));

    // Runs the shooter using the right bumper
    m_driverController.rightBumper().whileTrue(new ShooterCmd(shooterSubsystem, 90));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}