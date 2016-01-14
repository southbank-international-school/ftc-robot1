package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by julian on 12/01/2016.
 */
public class DriveTest extends OpMode {

    DcMotor left_motor;
    DcMotor right_motor;

    public DriveTest(){

    }
    @Override
    public void init() {
        left_motor=hardwareMap.dcMotor.get("lmotor");
        right_motor=hardwareMap.dcMotor.get("rmotor");
        left_motor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;

        left_motor.setPower(leftY);
        right_motor.setPower(rightY);
    }

    @Override
    public void stop() {
        left_motor.setPower(0);
        right_motor.setPower(0);
    }
}
