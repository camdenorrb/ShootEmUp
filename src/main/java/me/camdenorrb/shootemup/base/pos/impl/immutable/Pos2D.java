package me.camdenorrb.shootemup.base.pos.impl.immutable;

import me.camdenorrb.shootemup.base.pos.base.Pos;


public class Pos2D implements Pos {

	protected double x, y;


	public Pos2D(double x, double y) {
		this.x = x;
		this.y = y;
	}


	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

}
