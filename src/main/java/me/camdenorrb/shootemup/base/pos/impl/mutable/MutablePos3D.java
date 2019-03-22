package me.camdenorrb.shootemup.base.pos.impl.mutable;


import me.camdenorrb.shootemup.base.pos.impl.immutable.Pos3D;


public class MutablePos3D extends Pos3D {

	public MutablePos3D(double x, double y, double z) {
		super(x, y, z);
	}


	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

}
