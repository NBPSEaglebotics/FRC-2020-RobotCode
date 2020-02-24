package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.NAVXSubsystem;
import frc.robot.Constants.LimelightConstants;

/**
 * A command to drvie the robot using mecanum with joystick input
 */

public class RotateToTargetLimelight extends CommandBase {
    private final DriveSubsystem m_drive;
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ta = table.getEntry("ta");
    double x, a, error, current, straighten;
    Timer timer = new Timer();

    public RotateToTargetLimelight(DriveSubsystem subsystem) {
        m_drive = subsystem;
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }
    @Override
    public void execute() {
        x = tx.getDouble(0.0);
        a = ta.getDouble(0.0);
        if(x >= -1.5)
            m_drive.mecanumDrive(0, 0, LimelightConstants.kIdealRotateValue);
        else if(x <= -3.5)
            m_drive.mecanumDrive(0, 0, -LimelightConstants.kIdealRotateValue);
    }
    @Override
    public void end(boolean interrupetd) {
        m_drive.mecanumDrive(0, 0, 0);
    }
    @Override
    public boolean isFinished() {
         if(x<=-1&&x>=-4&&timer.get()>1.5)
            return true;
        return false;
    }
}