package uk.fls.h2n0.main.core.tiles;

import fls.engine.main.util.Renderer;
import uk.fls.h2n0.main.core.World;

public class FloorTile extends Tile {

	int[] d = null;
	@Override
	public void render(World w, Renderer r, int dx, int dy, int tx, int ty) {
		if(d == null)d = sp.getData(1);
		r.renderSection(d, dx, dy, 8);
	}

	@Override
	public void update(World w, int tx, int ty) {

	}

}
