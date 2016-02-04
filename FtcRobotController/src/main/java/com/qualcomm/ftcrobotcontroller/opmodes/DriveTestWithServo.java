package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by julian on 12/01/2016.
 */
public class DriveTestWithServo extends OpMode {

    DcMotor left_motor;
    DcMotor right_motor;
    DcMotor drive_belt;
    Servo lock_1;
    final double lock_1_CLOSED = 0.0;
    final double lock_1_OPEN = 1.0;


    public DriveTestWithServo(){

    }
    @Override
    public void init() {
        left_motor=hardwareMap.dcMotor.get("lmotor");
        right_motor=hardwareMap.dcMotor.get("rmotor");
        drive_belt=hardwareMap.dcMotor.get("drive_belt");
        left_motor.setDirection(DcMotor.Direction.REVERSE);
        lock_1=hardwareMap.servo.get("lock_1");
    }

    @Override
    public void loop() {
        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;
        float driveY = gamepad2.left_stick_y;

        left_motor.setPower(leftY);
        right_motor.setPower(rightY);
        drive_belt.setPower(driveY);

        if(gamepad1.right_bumper) {
            lock_1.setPosition(lock_1_OPEN);
        }
        else if(gamepad1.left_bumper) {
            lock_1.setPosition(lock_1_CLOSED);
        }
    }

    @Override
    public void stop() {
        left_motor.setPower(0);
        right_motor.setPower(0);
        drive_belt.setPower(0);
    }
}
