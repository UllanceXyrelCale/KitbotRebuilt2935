// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DrivetrainCmd;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IndexerCommand;
import frc.robot.commands.ShooterCmd;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final IndexerSubsystem indexerSubsystem = new IndexerSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

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
    m_driverController.leftBumper().whileTrue(new IndexerCommand(indexerSubsystem, 3));
    m_driverController.a().whileTrue(new IndexerCommand(indexerSubsystem, -3));
    m_driverController.rightBumper().whileTrue(new ShooterCmd(shooterSubsystem, 90));

  }


  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}