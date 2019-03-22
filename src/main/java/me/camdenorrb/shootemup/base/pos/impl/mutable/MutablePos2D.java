package me.camdenorrb.shootemup.base.pos.impl.mutable;


import me.camdenorrb.shootemup.base.pos.impl.immutable.Pos2D;


public class MutablePos2D extends Pos2D {

	public MutablePos2D(double x, double y) {
		super(x, y);
	}


	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

}
