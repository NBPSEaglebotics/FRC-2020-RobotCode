package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * this is one of our auto commands, meant to drive backwards from the line and shoot 
 * the three balls preloaded
 */

public class AutoDriveToLineAndShootLeft extends CommandBase {
    private final DriveSubsystem m_drive;
    private final ShooterSubsystem m_shooter;
    

    public AutoDriveToLineAndShootLeft(DriveSubsystem subsystem, ShooterSubsystem shooter)
    {
        m_drive = subsystem;
        m_shooter = shooter;
        addRequirements(m_drive, m_shooter);
    }
    /*
    * All we do here is create a sequential group with the elements created from other simpler commands
    */
    @Override
    public void initialize() {
        new SequentialCommandGroup(
            new DriveForwardTime(1, 0.3, m_drive),
            new RotateToTargetLimelight(m_drive, -1.5, -3.5),
            new AutoShootWithIndex(m_shooter)
            
        ).schedule();
    }
}