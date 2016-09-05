package net.mmbdy.blossom.graphics.font;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader.FreeTypeFontLoaderParameter;

public class DynamicFreetypeFont implements IStaticFont {
	
	FreeTypeFontGenerator generator;
	FreeTypeFontParameter parameter;
	BitmapFont font;
	
	public DynamicFreetypeFont(AssetManager manager, FreeTypeFontParameter parameter) {
		
		// set the loaders for the generator and the fonts themselves
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		
		// load to fonts via the generator (implicitely done by the
		// FreetypeFontLoader).
		// Note: you MUST specify a FreetypeFontGenerator defining the ttf font
		// file name and the size
		// of the font to be generated. The names of the fonts are arbitrary and
		// are not pointing
		// to a file on disk!
		FreeTypeFontLoaderParameter size1Params = new FreeTypeFontLoaderParameter();
		size1Params.fontFileName = "data/arial.ttf";
		size1Params.fontParameters.size = 10;
		manager.load("size10.ttf", BitmapFont.class, size1Params);
		
		FreeTypeFontLoaderParameter size2Params = new FreeTypeFontLoaderParameter();
		size2Params.fontFileName = "data/arial.ttf";
		size2Params.fontParameters.size = 20;
		manager.load("size20.ttf", BitmapFont.class, size2Params);
		
		// we also load a "normal" font generated via Hiero
		manager.load("data/default.fnt", BitmapFont.class);
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
