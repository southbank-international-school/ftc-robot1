package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.Range;

/**
 * Created by rCSB14 on 21/11/2015.
 */
public class ManualControl extends OpMode {
    // declare all the motors, inputs, etc. above public void init (or inside anything) because it keeps it global and not local
    //
    DcMotor left_motor;
    DcMotor right_motor;
    DcMotor drive_belt;
    DcMotor pulley;
    Servo lock1;
    Servo lock2;
    Servo trapdoor;
    Servo backpiece;
    //Servo pullback;
    //double servoOpen = 0.5;

    public ManualControl(){

    }
    @Override
    public void init() {
        //get references to the motors and servos from the hardware map
        pulley = hardwareMap.dcMotor.get("pulley");
        left_motor = hardwareMap.dcMotor.get("lmotor");
        right_motor = hardwareMap.dcMotor.get("rmotor");
        drive_belt = hardwareMap.dcMotor.get("drivebelt");
        lock1 = hardwareMap.servo.get("lock1");
        lock2 = hardwareMap.servo.get("lock2");
        trapdoor = hardwareMap.servo.get("trapdoor");
        backpiece = hardwareMap.servo.get("backpiece");
       // pullback = hardwareMap.servo.get("pullback");
        //reverse the left motor
        left_motor.setDirection(DcMotor.Direction.REVERSE);
    }



    @Override

    public void loop() {
        //get values from the gamepad (negated because pushing the stick away from you returns a negative value)
        float leftY = -gamepad1.left_stick_y ;
        float rightY = -gamepad1.right_stick_y ;
        //servoOpen = 0.5;

        left_motor.setPower(leftY);
        right_motor.setPower(rightY);
        drive_belt.setPower(-gamepad2.left_stick_y);
        pulley.setPower(-gamepad2.right_stick_y);

       // if(gamepad2.y) {
       //     servoOpen = 1.0;
       // }
       // if(gamepad2.a) {
       //     servoOpen = 0.0;
       // }

       // servoOpen = Range.clip(servoOpen, 0.0, 1.0);

       // pullback.setPosition(servoOpen);

        if(gamepad1.right_bumper) {
            lock1.setPosition(1.0);
        }
        if(gamepad1.left_bumper) {
            lock1.setPosition(0.0);
        }
        if(gamepad1.right_bumper) {
            lock2.setPosition(0.0);
        }
        if(gamepad1.left_bumper) {
            lock2.setPosition(1.0);
        }
        if(gamepad2.right_bumper) {
            trapdoor.setPosition(1.0);
        }
        if(gamepad2.left_bumper) {
            trapdoor.setPosition(0.0);
        }
        if(gamepad2.x) {
            backpiece.setPosition(1.0);
        }
        if(gamepad2.b) {
            backpiece.setPosition(0.0);
        }
        //telemetry.addData("servoPosition", "servoOpen:" + String.format("%.2f", pullback));

    }
    @Override

    public void stop() {
        left_motor.setPower (0);
        right_motor.setPower(0);
        drive_belt.setPower(0);
        pulley.setPower(0);
    }
}