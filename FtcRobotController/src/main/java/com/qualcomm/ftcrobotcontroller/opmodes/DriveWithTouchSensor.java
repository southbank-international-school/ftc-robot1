package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by julian on 17/01/2016.
 */
public class DriveWithTouchSensor extends OpMode {

    DcMotor left_motor;
    DcMotor right_motor;
    TouchSensor touch_sensor;

    @Override
    public void init() {
        left_motor = hardwareMap.dcMotor.get("lmotor");
        right_motor = hardwareMap.dcMotor.get("rmotor");
        left_motor.setDirection(DcMotor.Direction.REVERSE);

        //get a reference from the touch sensor
        touch_sensor = hardwareMap.touchSensor.get("touch_sensor");

    }

    @Override
    public void loop() {
        if (touch_sensor.isPressed()){
            left_motor.setPower(0);
            right_motor.setPower(0);
        } else {
            left_motor.setPower(0.5);
            right_motor.setPower(0.5);
        }
        telemetry.addData("isPressed", String.valueOf(touch_sensor.isPressed()));
    }
}
