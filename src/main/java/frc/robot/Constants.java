/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        public static final int kFrontLeftWheelPort = 2;
        public static final int kFrontRightWheelPort = 3;
        public static final int kBackLeftWheelPort = 4;
        public static final int kBackRightWheelPort = 5;
    }
    
    public static final class IntakeConstants {
        public static final int kIntakePort = 0;
    }

    public static final class ShooterConstants {
        public static final int kShooter1Port = 0;
        public static final int kShooter2Port = 0;
        public static final int kIndexPort = 0;

        public static final int kIndexClosedPosition = 0;
        public static final int kIndexOpenPosition = 0;

        public static final double kIdealShotSpeed = 0;
        public static final double kTimeToChargeUp = 0;
    }

    public static final class LiftConstants {
        public static final int kFrontLeftLiftPort = 0;
        public static final int kFrontRightLiftPort = 0;
        public static final int kBackLeftLiftPort = 0;
        public static final int kBackRightLiftPort = 0;

        public static final int kTopLimitSwitchPort = 0;
        public static final int kBottomLimitSwitchPort = 0;
    }

    public static final class JoystickConstants {
        public static final int kXStick1 = 0;
        public static final int kYStick1 = 1;
        public static final int kXStick2 = 4;
        public static final int kYStick2 = 5;

        public static final int kJoysick1Port = 0;
        public static final int kJoystick2Port = 1;
    }
}
