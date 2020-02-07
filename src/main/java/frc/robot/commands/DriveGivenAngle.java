package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort;


//this command will drive the robot plus or minus a given degree
public class DriveGivenAngle extends CommandBase {
    private final DriveSubsystem m_drive;
    private final double m_angle;
    private final double m_speed;
    private double currentAngle;
    private AHRS navx = new AHRS(SerialPort.Port.kMXP);


    public DriveGivenAngle(double angle, double speed, DriveSubsystem drive) {
        m_angle = angle;
        m_speed = speed;
        m_drive = drive;
    }

    @Override
    public void initialize() {
        currentAngle = navx.getAngle();
        if(m_angle < 0 )
            m_drive.mecanumDrive(0,0,-m_speed);
        else if(m_angle > 0)
            m_drive.mecanumDrive(0,0,m_speed);
        else 
            m_drive.mecanumDrive(0, 0, 0);
    }
    @Override
    public void end(boolean interrupted)
    {
        m_drive.mecanumDrive(0, 0, 0);
    }
    @Override
    public boolean isFinished() {
        if(m_angle+currentAngle + 3 > navx.getAngle() && m_angle+currentAngle - 3 < navx.getAngle())
            return true;
        else
            return false;
    }
}