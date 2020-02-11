package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
    private WPI_TalonSRX m_shooter = new WPI_TalonSRX(ShooterConstants.kShooter1Port);
    private WPI_TalonSRX m_shooter2 = new WPI_TalonSRX(ShooterConstants.kShooter2Port);
    private Servo m_index = new Servo(ShooterConstants.kIndexPort);

    /**
     * this is the shooter class
     * we have two motors for the shooting, but since they always follow eachother, we just have shooter2 follow shooter 
     * also, index is a servo that moves up or down depending on if we want the servo to go in or not
     */
    public ShooterSubsystem() {
        m_shooter2.follow(m_shooter);
    }
    /**
     * @param speed = speed to shoot at
     */
    public void shoot(double speed)
    {
        m_shooter.set(ControlMode.PercentOutput, speed);
    }
    /**
     * 
     * @param position = position for index servo to be at
     */
    public void moveIndex(double position)
    {
        m_index.set(position);
    }
}