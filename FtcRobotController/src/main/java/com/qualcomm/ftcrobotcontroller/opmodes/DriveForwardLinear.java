package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by julian on 31/12/2015.
 */
public class DriveForwardLinear extends LinearOpMode {

    DcMotor left_motor;
    DcMotor right_motor;

    @Override
    public void runOpMode () throws InterruptedException {
        left_motor = hardwareMap.dcMotor.get("lmotor");
        right_motor = hardwareMap.dcMotor.get("rmotor");
        right_motor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        left_motor.setPower(0.5);
        right_motor.setPower(0.5);

        sleep(2000);

        left_motor.setPower(0.5);
        right_motor.setPower(-0.5);

        sleep(1100);

        left_motor.setPower(0);
        right_motor.setPower(0);

    }

}
