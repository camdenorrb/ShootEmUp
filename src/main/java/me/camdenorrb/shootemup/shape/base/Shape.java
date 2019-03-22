package me.camdenorrb.shootemup.shape.base;

import me.camdenorrb.shootemup.base.pos.base.Pos;
import me.camdenorrb.shootemup.window.Window;


public interface Shape<P extends Pos> {

	void draw(Window window, P pos);

}
