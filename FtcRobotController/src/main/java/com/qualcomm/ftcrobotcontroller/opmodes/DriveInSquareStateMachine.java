package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by julian on 31/12/2015.
 */
public class DriveInSquareStateMachine extends OpMode {
    //Declare the motors and in the case of this program, the elapsed time
    DcMotor left_motor;
    DcMotor right_motor;
    ElapsedTime time;

    //final variables are variables that always point to the same object
    //changing the values of these variables will change the length of the sides of the square and the duration of the turn
    static final double forwardTime = 1.0;
    static final double turnTime = 1.0;
    int count = 0;

    //the state is declared as an enumeration
    enum State {drivingStraight, turning, done}
    State state;

    @Override
    public void init() {
        left_motor = hardwareMap.dcMotor.get("lmotor");
        right_motor = hardwareMap.dcMotor.get("rmotor");
        right_motor.setDirection(DcMotor.Direction.REVERSE);

        //the elapsed time object which will act as a counter is created
        time = new ElapsedTime();
        //the state variable is initially set to drivingStraight to reflect the first thing the robot will do
        state = State.drivingStraight;

    }

    @Override
    public void loop() {
        //writes the current time to the currentTime object
        double currentTime = time.time();
        switch(state) {
            case drivingStraight:
                left_motor.setPower(0.5);
                right_motor.setPower(0.5);
                if (currentTime > forwardTime) {
                    state = State.turning;
                    time.reset();
                }
                break;
            case turning:
                left_motor.setPower(0.5);
                right_motor.setPower(-0.5);
                if (currentTime > turnTime) {
                    count++;
                    if (count < 4) {
                        state = State.drivingStraight;
                    } else {
                        state = State.done;
                    }
                    time.reset();
                }
                break;
            case done:
                left_motor.setPower(0);
                right_motor.setPower(0);
        }
    }


}
