package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * A command to drvie the robot using mecanum with joystick input
 */

public class AutoDriveToLineAndShoot extends CommandBase {
    private final DriveSubsystem m_drive;
    private final ShooterSubsystem m_shooter;
    

    public AutoDriveToLineAndShoot(DriveSubsystem subsystem, ShooterSubsystem shooter)
    {
        m_drive = subsystem;
        m_shooter = shooter;
        addRequirements(m_drive, m_shooter);
    }
    @Override
    public void initialize() {
        new SequentialCommandGroup(
            new DriveForwardTime(1, 0.3, m_drive),
            new RotateToTargetLimelight(m_drive),
            new AutoShootWithIndex(m_shooter)
            
        ).schedule();
    }
}