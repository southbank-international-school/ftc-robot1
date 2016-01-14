package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by julian on 31/12/2015.
 */
public class DriveInCircle extends OpMode {
    DcMotor left_motor;
    DcMotor right_motor;

    @Override
    public void init() {
        left_motor = hardwareMap.dcMotor.get("lmotor");
        right_motor = hardwareMap.dcMotor.get("rmotor");
        right_motor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        left_motor.setPower(0.75);
        right_motor.setPower(0.15);
    }
}
