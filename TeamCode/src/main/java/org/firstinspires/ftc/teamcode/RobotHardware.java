package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.Range;

import java.util.Map;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cAddressableDevice;


public class RobotHardware
{
   /* Public OpMode members. */
   public DcMotor leftFront;
   public DcMotor rightFront;
   public DcMotor leftBack;
   public DcMotor rightBack;
   public DcMotor cm;
   public DcMotor tm;
   public DcMotor em;
   public DcMotor es;
   public Servo gs;
   public Servo gs1;
   public ColorSensor sensorColorRange;

   /* local OpMode members. */
   HardwareMap hardwareMap;

   /* Initialize standard Hardware interfaces */
   public void init(HardwareMap hardwareMap)
   {
      // Define and Initialize Motors
      leftFront = hardwareMap.get(DcMotor.class, "frontLeft");
      rightFront = hardwareMap.get(DcMotor.class, "frontRight");
      leftBack = hardwareMap.get(DcMotor.class, "backLeft");
      rightBack = hardwareMap.get(DcMotor.class, "backRight");
      cm = hardwareMap.get(DcMotor.class, "CM");
      tm = hardwareMap.get(DcMotor.class, "TM");
      em = hardwareMap.get(DcMotor.class, "EM");
      es = hardwareMap.get(DcMotor.class, "ES");
      gs = hardwareMap.get(Servo.class, "GS");
      gs1 = hardwareMap.get(Servo.class, "GS1");
      sensorColorRange = hardwareMap.get(ColorSensor.class, "sensorColorRange");

      // Set all motors to zero power
      leftFront.setPower(0);
      rightFront.setPower(0);
      leftBack.setPower(0);
      rightBack.setPower(0);
      cm.setPower(0);
      tm.setPower(0);
      em.setPower(0);
      es.setPower(0);


      // Set all motors to run without encoders.
      // May want to use RUN_USING_ENCODERS if encoders are installed.
      leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      cm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      tm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      em.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

      leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      cm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      tm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      em.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
   }
}

