package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by julian on 12/01/2016.
 */
public class DriveTest extends OpMode {

    DcMotor left_motor;
    DcMotor right_motor;
    DcMotor drive_belt;

    public DriveTest(){

    }
    @Override
    public void init() {
        left_motor=hardwareMap.dcMotor.get("lmotor");
        right_motor=hardwareMap.dcMotor.get("rmotor");
        drive_belt=hardwareMap.dcMotor.get("drive_belt");
        left_motor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;
        float driveY = gamepad2.left_stick_y;

        left_motor.setPower(leftY);
        right_motor.setPower(rightY);
        drive_belt.setPower(driveY);
    }

    @Override
    public void stop() {
        left_motor.setPower(0);
        right_motor.setPower(0);
        drive_belt.setPower(0);
    }
}
