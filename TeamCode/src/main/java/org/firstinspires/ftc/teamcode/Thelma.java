package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import java.util.concurrent.TimeUnit;

import org.firstinspires.ftc.robotcore.external.navigation.Axis;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "ControlledByThelma", group = "z")

public class Thelma extends OpMode
{
   //* Define Robot
   RobotHardware robot = new RobotHardware();
   double turretTracker = 0.0;

   //* Code to run ONCE when the driver hits INIT
   @Override
   public void init()
   {
      robot.init(hardwareMap);
      telemetry.addData("Status", "1");
   }

   //* Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
   @Override
   public void init_loop()
   {
   }

   // Code to run ONCE when the driver hits PLAY
   @Override
   public void start()
   {
   }

   // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
   @Override
   public void loop()
   {
      double strafe = -gamepad1.left_stick_y / 2;
      double rotate = -gamepad1.right_stick_x * .5;
      double drive = -gamepad1.left_stick_x / 2;
      double tmSpin = gamepad2.right_stick_x / 1.3;
      double emLift = -gamepad2.right_stick_y / 2;
      double esLift = gamepad2.left_stick_y;
      double spin;

      robot.leftFront.setPower(-(-strafe - drive - rotate));
      robot.rightFront.setPower(-(-strafe + drive - rotate));
      robot.leftBack.setPower(-(strafe - drive - rotate));
      robot.rightBack.setPower(-(strafe + drive - rotate));
      robot.em.setPower(emLift);
      robot.es.setPower(esLift);
      robot.tm.setPower(tmSpin);

      if (gamepad2.y)
      {
         robot.gs.setPosition(.45);
         robot.gs1.setPosition(.3);
      }
      if (gamepad2.a)
      {
         robot.gs.setPosition(.7);
         robot.gs1.setPosition(0);
      }

      if (gamepad2.right_bumper == true)
      {
         robot.cm.setPower(-.5);
         try
         {
            TimeUnit.MILLISECONDS.sleep(30);
         }
         catch (InterruptedException ie)
         {
            Thread.currentThread().interrupt();
         }
      } else if (gamepad2.left_bumper == true)
      {
         robot.cm.setPower(.5);
         try
         {
            TimeUnit.MILLISECONDS.sleep(30);
         }
         catch (InterruptedException ie)
         {
            Thread.currentThread().interrupt();
         }
      } else
      {
         robot.cm.setPower(0);
      }

      if (gamepad2.b == true)
      {
         robot.cm.setPower(-.5);
         try
         {
            TimeUnit.MILLISECONDS.sleep(10);
         }
         catch (InterruptedException ie)
         {
            Thread.currentThread().interrupt();
         }
      } else if (gamepad2.x == true)
      {
         robot.cm.setPower(.5);
         try
         {
            TimeUnit.MILLISECONDS.sleep(10);
         }
         catch (InterruptedException ie)
         {
            Thread.currentThread().interrupt();
         }
      } else
      {
         robot.cm.setPower(0);
      }
   }

   // Code to run ONCE after the driver hits STOP
   @Override
   public void stop()
   {
   }
}
