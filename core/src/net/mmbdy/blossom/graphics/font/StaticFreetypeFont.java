package net.mmbdy.blossom.graphics.font;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader.FreeTypeFontLoaderParameter;

public class StaticFreetypeFont implements IStaticFont {
	
	private SpriteBatch batch;
	private BitmapFont font;
	
	private float x, y;
	
	public StaticFreetypeFont(AssetManager manager, FreeTypeFontParameter parameter) {
		// set the loaders for the generator and the fonts themselves
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		
		FreeTypeFontLoaderParameter size1Params = new FreeTypeFontLoaderParameter();
		size1Params.fontFileName = "data/arial.ttf";
		size1Params.fontParameters.size = 10;
		manager.load("size10.ttf", BitmapFont.class, size1Params);
		manager.get("size10.ttf");
	}
	
	public void render(SpriteBatch batch) {
		font.draw(batch, "Font Test", x, y);
	}
	
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void render() {
		// TODO Implement this
	}

}
