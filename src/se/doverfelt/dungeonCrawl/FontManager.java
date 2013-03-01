package se.doverfelt.dungeonCrawl;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class FontManager {
	
	private static UnicodeFont defaultFont;
	
	public static void loadFonts() throws FontFormatException, IOException, SlickException {
		Font defBase = Font.createFont(Font.TRUETYPE_FONT, org.newdawn.slick.util.ResourceLoader.getResourceAsStream("/data/default.ttf"));
		defBase = defBase.deriveFont(java.awt.Font.PLAIN, 24.f);
		defaultFont = new UnicodeFont(defBase);
		defaultFont.addAsciiGlyphs();
		defaultFont.getEffects().add(new ColorEffect());
		defaultFont.loadGlyphs();
	}
	
	public static UnicodeFont getDefault() {
		return defaultFont;
	}
	
}
