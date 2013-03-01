package se.doverfelt.dungeonCrawl;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;

public class ChatWindow {
	
	private GameContainer gc;
	private boolean visible;
	private List<Image> messages;
	private TextField field;
	private Graphics g;
	private Image bgImg;
	private List<String> history;
	
	private int historyIndex;
	
	public ChatWindow(GameContainer gc, boolean visible, Graphics g) {
		this.g = g;
		this.gc = gc;
		this.visible = visible;
		messages = new ArrayList<Image>();
		history = new ArrayList<String>();
		historyIndex = history.size();
		field = new TextField(gc, gc.getGraphics().getFont(), 10, gc.getHeight() - (gc.getGraphics().getFont().getLineHeight() + 2) - 10, gc.getWidth() / 2, gc.getGraphics().getFont().getLineHeight() + 2);
		field.setBorderColor(Color.black);
		try {
			bgImg = Image.createOffscreenImage(gc.getWidth() / 2, 20);
			Graphics g2 = bgImg.getGraphics();
			g2.setBackground(Color.black);
			g2.clear();
			g2.flush();
			bgImg.setAlpha(0.5f);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void render() {
		if (visible) {
			field.render(gc, g);
		}
		for (int i = 0; i < messages.size(); i++) {
			g.drawImage(messages.get(i), i * 20, i * 30);
		}
		
	}
	
	public boolean hasFocus() {
		return field.hasFocus();
	}
	
	public void setFocus(boolean focus) {
		field.setFocus(focus);
	}
	
	public void sendMessage() {
		if (!field.getText().startsWith("/")) {
			messages.add(printImage(field.getText()));
		} else {
			if (field.getText().startsWith("/playerSpeed")) {
				String[] args = field.getText().split(" ");
				Player.SPEED = Float.parseFloat(args[1]);
			}
		}
		history.add(field.getText());
		historyIndex = history.size();
		field.setText("");
		render();
	}
	
	private Image printImage(String text) {
		Font f = g.getFont();
		
		int w = f.getWidth(text);
		
		Image img = null;
		try {
			img = Image.createOffscreenImage(w, 20);
			Graphics g2 = img.getGraphics();
			g2.drawImage(bgImg, 0, 0);
			g2.clear();
			g2.setColor(Color.white);
			g2.drawString(text, 0, 0);
			g2.flush();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		return img;
		
	}

	public void setVisible(boolean b) {
		visible = b;
	}

	public String getNextHistory() {
		
		if ((historyIndex - 1) > 0) {
			historyIndex--;
			return history.get(historyIndex);
		} else {
			return "";
		}
	}
	
	public String getPrevHistory() {
		
		if ((historyIndex + 1) < history.size()) {
			historyIndex++;
			return history.get(historyIndex);
		} else {
			return "";
		}
	}

	public void setMessage(String string) {
		field.setText(string);
		
	}
	
}
