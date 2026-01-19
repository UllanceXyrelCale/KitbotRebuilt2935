package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  // Initializes the motor and controller
  private final TalonFX shooterMotor;
  private final VelocityVoltage velocityControl;

  public ShooterSubsystem() {
    // Set up the motor
    shooterMotor = new TalonFX(50);

    // ------- Configures the motor -------- //
    TalonFXConfiguration config = new TalonFXConfiguration();

    // Set motor outputs
    config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    
    // Current limits
    config.CurrentLimits.SupplyCurrentLimit = 40.0;
    config.CurrentLimits.SupplyCurrentLimitEnable = true;

    // Feedback
    config.Feedback.SensorToMechanismRatio = 1;

    // Set up PID
    config.Slot0.kP = 0.1;
    config.Slot0.kI = 0;
    config.Slot0.kD = 0;
    config.Slot0.kV = 0.12;
    
    // Set up voltage
    config.Voltage.PeakForwardVoltage = 12.0;
    config.Voltage.PeakReverseVoltage = -12.0;

    // Apply configs and slots 
    shooterMotor.getConfigurator().apply(config);
    velocityControl = new VelocityVoltage(0).withSlot(0);
    
  }

  public void setVelocity(double velocityRPS) {
    shooterMotor.setControl(velocityControl.withVelocity(velocityRPS));
  }

  public void stop() {
    shooterMotor.stopMotor();
  }

  public boolean atTargetSpeed(double targetRPS, double toleranceRPS) {
    return Math.abs(shooterMotor.getVelocity().getValueAsDouble() - targetRPS) < toleranceRPS;
  }

  @Override
  public void periodic() {

  }
}
