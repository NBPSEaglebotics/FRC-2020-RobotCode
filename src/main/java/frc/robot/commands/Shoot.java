package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.ShooterConstants;

public class Shoot extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterSubsystem m_shooter;

  /**
   * Just a simple command to shoot for use in command groups
   * @param shooter = the shooter
   */
  public Shoot(ShooterSubsystem shooter) {
    m_shooter = shooter;
    addRequirements(shooter);
  }

  //start charging up the motor (DOES NOT MOVE INDEX)
  @Override
  public void initialize() {
      m_shooter.shoot(ShooterConstants.kIdealShotSpeed);
  }
 
  //this waits until the shooter is charged up, then launches the balls
  @Override
  public void execute() {
  }

  //When the command is over, turn off the shooter and close the index servo
  @Override
  public void end(boolean interrupted) {
      m_shooter.shoot(0);
  }

  //Command is controlled by driver, doesnt need to end on its own
  @Override
  public boolean isFinished() {
    return false;
  }
}
