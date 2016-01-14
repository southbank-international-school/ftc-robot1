package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by julian on 31/12/2015.
 */
public class DriveInSquareLinear extends LinearOpMode {
    DcMotor left_motor;
    DcMotor right_motor;

    @Override
    public void runOpMode () throws InterruptedException {
        //get references to the motors from the hardware map
        //code to run before the start button gets pressed
        left_motor = hardwareMap.dcMotor.get("lmotor");
        right_motor = hardwareMap.dcMotor.get("rmotor");
        right_motor.setDirection(DcMotor.Direction.REVERSE);

       //starts the program
        waitForStart();

        //creates a variable called i, sets it equal to 0, and tells it to increase by 1 every loop until it reaches 4
        //all sleep functions delay the code after it by the amount of time set (in milliseconds)
        for (int i=0; i<4; i++) {
            left_motor.setPower(1.0);
            right_motor.setPower(1.0);
            sleep(1000);

            left_motor.setPower(0.5);
            right_motor.setPower(-0.5);
            sleep(1000);
        }

        //stops the motors
        left_motor.setPowerFloat();
        right_motor.setPowerFloat();
    }
}
