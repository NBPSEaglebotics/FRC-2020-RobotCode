package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/*
* Super simple class that ends after x seconds, used in command groups
*/
public class TimerWait extends CommandBase {
    private final double seconds;
    private final Timer timer = new Timer();
    public TimerWait(double seconds) {
        this.seconds = seconds;
    }
    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }
    @Override
    public void end(boolean interrupted) {

    }
    @Override
    public boolean isFinished() {
        return (timer.get() >= seconds);
            
    }
    
}