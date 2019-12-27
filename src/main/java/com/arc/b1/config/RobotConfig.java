package com.arc.b1.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arc.b1.robot.LeftArm;
import com.arc.b1.robot.RightArm;

@Configuration //spring이 객체를 만드려는 게 아니라 xml파일이라고 인식
public class RobotConfig {

	@Bean("left")
	//@Qualifier("la")
	public LeftArm getLeftArm() throws Exception {
		LeftArm leftArm = new LeftArm();
		
		return leftArm;
	}
	
	@Bean("right")
	public RightArm getRightArm() {
		RightArm rightArm = new RightArm();
		
		return rightArm;
	}
}
