package me.camdenorrb.shootemup.base.pos.impl.immutable;

import me.camdenorrb.shootemup.base.pos.base.Pos;


public class Pos3D implements Pos {

	protected double x, y, z;


	public Pos3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}


	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

}