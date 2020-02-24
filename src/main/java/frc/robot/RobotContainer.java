/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.JoystickConstants;
import frc.robot.Constants.SpinnerConstants;
import frc.robot.commands.AutoDriveToLineAndShoot;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.DriveGivenAngle;
import frc.robot.commands.DriveToAngle;
import frc.robot.commands.DriveToTargetLimelight;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.FieldOrientedDrive;
import frc.robot.commands.Intake;
import frc.robot.commands.LiftSafely;
import frc.robot.commands.ShootWithIndex;
import frc.robot.commands.Spin;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.NAVXSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SpinnerSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  Joystick m_joystick1 = new Joystick(JoystickConstants.kJoysick1Port);
  Joystick m_joystick2 = new Joystick(JoystickConstants.kJoystick2Port);
  

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
  private final LiftSubsystem m_lift = new LiftSubsystem();
  private final SpinnerSubsystem m_spin = new SpinnerSubsystem();
  final NAVXSubsystem navx = new NAVXSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final FieldOrientedDrive m_FOD = new FieldOrientedDrive(m_drive, () -> m_joystick1.getRawAxis(JoystickConstants.kXStick1), () -> m_joystick1.getRawAxis(JoystickConstants.kYStick1), () -> m_joystick1.getRawAxis(JoystickConstants.kXStick2), () -> navx.getAngle());
  private final AutoDriveToLineAndShoot a_autoDriveToLineAndShoot = new AutoDriveToLineAndShoot(m_drive, m_shooterSubsystem);

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ta = table.getEntry("ta");

  

  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    
    m_drive.setDefaultCommand(m_FOD);
      

    m_lift.setDefaultCommand(
      new LiftSafely(m_lift,
      () -> (m_joystick2.getRawAxis(JoystickConstants.kYStick1)))
    );

    SmartDashboard.putNumber("navx", navx.getAngle());
    
    }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {


    new JoystickButton(m_joystick1, 1)
      .whenPressed(new Intake(m_intakeSubsystem, IntakeConstants.kIntakeSpeed))
      .whenReleased(new Intake(m_intakeSubsystem, 0));
    
    new JoystickButton(m_joystick1, 2)
    .whileHeld(new ShootWithIndex(m_shooterSubsystem));
    
    new JoystickButton(m_joystick1, 3)
    .whileHeld(new DriveToTargetLimelight(m_drive, navx));

    new JoystickButton(m_joystick1, 4)
    .whileHeld(new SequentialCommandGroup(
      new DriveToTargetLimelight(m_drive, navx),
      new ShootWithIndex(m_shooterSubsystem)
    ));
    
    new JoystickButton(m_joystick1, 5)
    .whileHeld(new DriveToAngle(m_drive, navx, 90));

    new JoystickButton(m_joystick2, 5)
    .whileHeld(new Spin(m_spin, -SpinnerConstants.kIdealSpinnerSpeed));

    new JoystickButton(m_joystick2, 6)
    .whileHeld(new Spin(m_spin, SpinnerConstants.kIdealSpinnerSpeed));

      
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return a_autoDriveToLineAndShoot;
  }
}
