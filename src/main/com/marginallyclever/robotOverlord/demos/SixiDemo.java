package com.marginallyclever.robotOverlord.demos;

import javax.vecmath.Vector3d;

import com.marginallyclever.robotOverlord.Entity;
import com.marginallyclever.robotOverlord.Light;
import com.marginallyclever.robotOverlord.RobotOverlord;
import com.marginallyclever.robotOverlord.demoAssets.Box;
import com.marginallyclever.robotOverlord.demoAssets.TrayCabinet;
import com.marginallyclever.robotOverlord.robots.sixi3.Sixi3FK;
import com.marginallyclever.robotOverlord.robots.sixi3.Sixi3IK;
import com.marginallyclever.robotOverlord.shape.Shape;

public class SixiDemo implements Demo {
	@Override
	public String getName() {
		return "Sixi3s";
	}
	
	@Override
	public void execute(RobotOverlord ro) {
		ro.newScene();
		Entity sc = ro.getScene();
		
		// adjust default camera
		ro.camera.setPosition(new Vector3d(40,-91,106));
		ro.camera.setPan(-16);
		ro.camera.setTilt(53);
		ro.camera.setZoom(100);
		ro.camera.update(0);
		
		// add some lights
    	Light light;

		sc.addChild(light = new Light());
		light.setName("Light");
    	light.lightIndex=1;
    	light.setPosition(new Vector3d(60,-60,160));
    	light.setDiffuse(1,1,1,1);
    	light.setSpecular(0.5f, 0.5f, 0.5f, 1.0f);
    	light.attenuationLinear.set(0.0014);
    	light.attenuationQuadratic.set(7*1e-6);
    	light.setDirectional(true);
    	
		// add some collision bounds
		Box box;
		
		sc.addChild(box = new Box());
		box.setName("Front wall");
		box.setSize(233.5,100,1);
		box.setPosition(new Vector3d(69.75,65,0));
		box.getMaterial().setDiffuseColor(0f/255f,169f/255f,255f/255f,1f);
		
		sc.addChild(box = new Box());
		box.setName("Back wall");
		box.setSize(180,100,1);
		box.setPosition(new Vector3d(-47.5,-25.5,0));
		box.setRotation(new Vector3d(0, 0, Math.toRadians(-90)));
		box.getMaterial().setDiffuseColor(0f/255f,169f/255f,255f/255f,1f);

		Shape table = new Shape("/table.stl");
		sc.addChild(table);
		table.setName("Table");
		table.setPosition(new Vector3d(0,0,-0.75));
		//box.setSize(160,1,110);
		//box.setPosition(new Vector3d(59.5,0,-2.5));
/*
		// adjust grid
		GridEntity grid = new GridEntity();
		addChild(grid);
		grid.width.set(140);
		grid.height.set(90);
		grid.setPosition(new Vector3d(60.0,0,-0.5));
*/
    	// add a sixi robot
		//Sixi2 sixi2=new Sixi2();
		//addChild(sixi2);
		Sixi3FK s0 = new Sixi3FK();
		sc.addChild(s0);
		
		Sixi3IK s1 = new Sixi3IK();
		sc.addChild(s1);
		s1.setPosition(new Vector3d(50,0,0));
		
		
		//sixi2.setPosition(new Vector3d(78,-25,0));
		//Matrix3d m=new Matrix3d();
		//m.setIdentity();
		//m.rotZ(Math.toRadians(-90));
		//sixi2.setRotation(m);
		
		TrayCabinet trayCabinet;
		sc.addChild(trayCabinet=new TrayCabinet());
		trayCabinet.setPosition(new Vector3d(35,49.5,0));
		sc.addChild(trayCabinet=new TrayCabinet());
		trayCabinet.setPosition(new Vector3d(35,49.5,21.75));
	}
}
