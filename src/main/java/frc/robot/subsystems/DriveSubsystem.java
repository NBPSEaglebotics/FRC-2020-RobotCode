package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  // The motors on drive system
  TalonSRX m_frontLeftMotor = new TalonSRX(DriveConstants.kFrontLeftWheelPort);
  TalonSRX m_frontRightMotor = new TalonSRX(DriveConstants.kFrontRightWheelPort);
  TalonSRX m_backLeftMotor = new TalonSRX(DriveConstants.kBackLeftWheelPort);
  TalonSRX m_backRightMotor = new TalonSRX(DriveConstants.kBackRightWheelPort);
 
  

 
  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void mecanumDrive(double x, double y, double c) {
    m_frontLeftMotor.set(ControlMode.PercentOutput, x+y+c);
    m_backLeftMotor.set(ControlMode.PercentOutput, -x+y+c);
    m_frontRightMotor.set(ControlMode.PercentOutput, x-y+c);
    m_backRightMotor.set(ControlMode.PercentOutput, -x-y+c);
  }
}
