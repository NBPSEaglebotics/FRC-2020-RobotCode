package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ShooterConstants;

public class OpenIndex extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final ShooterSubsystem m_shooter;
    private final Timer timer = new Timer();
    private final double time;

    /**
     * Simple command that opens index, then closes after some time
     * 
     * @param shooter = the shooter
     * @param time    = how long index stays open
     */
    public OpenIndex(ShooterSubsystem shooter, double time) {
        m_shooter = shooter;
        this.time = time;
        addRequirements(shooter);
    }

    // start timer open index
    @Override
    public void initialize() {
      timer.reset();
      timer.start();
      m_shooter.moveIndex(ShooterConstants.kIndexOpenPosition);
  }
 

  @Override
  public void execute() {
  }

  //close the index servo
  @Override
  public void end(boolean interrupted) {
      m_shooter.moveIndex(ShooterConstants.kIndexClosedPosition);
  }

  //ends after however long
  @Override
  public boolean isFinished() {
    if(timer.get() >= time)
        return true;
    return false;
  }
}
