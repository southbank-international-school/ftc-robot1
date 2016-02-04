package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by julian on 02/02/2016.
 */
public class DriveTest2 extends OpMode {

    DcMotor drive_belt;

    public DriveTest2(){

    }

    @Override
    public void init() {
        drive_belt=hardwareMap.dcMotor.get("drive_belt");
    }

    @Override
    public void loop() {
        float driveY = -gamepad1.left_stick_y;

        drive_belt.setPower(driveY);
    }

    @Override
    public void stop() {
        drive_belt.setPower(0);
    }
}
