package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Timer;

//this command will drive a robot for a specified amount of time
public class DriveForwardTime extends CommandBase {
    private final DriveSubsystem m_drive;
    private final double m_time;
    private final double m_speed;
    private Timer timer = new Timer();


    public DriveForwardTime(double time, double speed, DriveSubsystem drive) {
        m_time = time;
        m_speed = speed;
        m_drive = drive;
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
        m_drive.mecanumDrive(0,m_speed,0);
    }
    @Override
    public void end(boolean interrupted)
    {
        m_drive.mecanumDrive(0, 0, 0);
    }
    @Override
    public boolean isFinished() {
        return timer.get() >= m_time;
    }
}