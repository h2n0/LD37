package uk.fls.h2n0.main.core.entity;

import java.util.List;

import fls.engine.main.util.Point;
import fls.engine.main.util.Renderer;

public class Decoration extends Entity {

	
	public Decoration(int x, int y) {
		this.pos = new Point(x,y);
		this.frameData = sp.getData(Math.random() > 0.5?0:1, 3);
		this.health = 1;
	}
	@Override
	public void render(Renderer r) {
		r.shadeElipse(this.pos.getIX() + 2, this.pos.getIY() + 6, 2, 4);
		r.renderSection(frameData, this.pos.getIX(), this.pos.getIY(), 8);
	}

	@Override
	public void update() {
		if(this.health == 0)this.alive = false;
		List<Entity> ents = this.world.getEntitysAround(this);
		for(Entity e : ents){
			if(e instanceof FireBall){
				FireBall fb = (FireBall)e;
				if(fb.getPos().dist(this.pos) < 8 * 8){
					this.health--;
					fb.alive = false;
				}
			}
		}
	}

}
