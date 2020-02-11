package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.LiftConstants;

public class LiftSubsystem extends SubsystemBase {
    //creation of the motors for the lift
    private WPI_TalonSRX m_frontRightMotor = new WPI_TalonSRX(LiftConstants.kFrontRightLiftPort);
    private WPI_TalonSRX m_backRightMotor = new WPI_TalonSRX(LiftConstants.kBackRightLiftPort);
    private WPI_TalonSRX m_frontLeftMotor = new WPI_TalonSRX(LiftConstants.kFrontLeftLiftPort);
    private WPI_TalonSRX m_backLeftMotor = new WPI_TalonSRX(LiftConstants.kBackLeftLiftPort);

    //create a new LiftSubsystem
    public LiftSubsystem() {
        //due to how the lift works, front and back motors always mirror eachother
        //therefore, we can make them follow eachother to save time 
        m_backRightMotor.follow(m_frontRightMotor);
        m_backLeftMotor.follow(m_frontLeftMotor);
    }

    /**
     * Moves the lift up and down
     * @param speed = whatever speed it should run at
     */
    public void lift(double speed)
    {
        //motors are inverted on the right side, therefore negative speed
        m_frontRightMotor.set(ControlMode.PercentOutput, -speed);
        m_frontLeftMotor.set(ControlMode.PercentOutput, speed);
    }

}

