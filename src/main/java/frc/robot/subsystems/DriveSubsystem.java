package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  // The motors on drive system
  WPI_TalonSRX m_frontLeftMotor = new WPI_TalonSRX(DriveConstants.kFrontLeftWheelPort);
  WPI_TalonSRX m_frontRightMotor = new WPI_TalonSRX(DriveConstants.kFrontRightWheelPort);
  WPI_TalonSRX m_backLeftMotor = new WPI_TalonSRX(DriveConstants.kBackLeftWheelPort);
  WPI_TalonSRX m_backRightMotor = new WPI_TalonSRX(DriveConstants.kBackRightWheelPort);

  MecanumDrive m_drive = new MecanumDrive(m_frontLeftMotor, m_backLeftMotor, m_frontRightMotor, m_backRightMotor);
  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    m_drive.setSafetyEnabled(false);
  }

  /**
   * Drives the robot using base mecanum (y stick 1 = forward, x stick 1 = sideways, x stick 2 = rotation)
   *
   * @param x = speed in x direction
   * @param y = speed in y direction
   * @param c = rotation speed
   */
  public void mecanumDrive(double x, double y, double c) {
    m_drive.driveCartesian(x,-y,c);
  }
  /**
   * Drives the robot using base mecanum (y stick 1 = forward, x stick 1 = sideways, x stick 2 = rotation)
   * This, however, is in relation to the field instead of the robot
   * @param x = speed in x direction
   * @param y = speed in y direction
   * @param c = rotation speed
   * @param theta = navx gyro angle
   */
  public void mecanumDriveGyro(double x, double y, double c, double theta)
  {
      m_drive.driveCartesian(x, -y, c, theta);
  }
}
