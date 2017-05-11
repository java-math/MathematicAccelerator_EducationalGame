package com.mygdx.mathematicaccelerator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class KnowledgeScreen implements Screen, InputProcessor {
	
	/**Ka�dy KnowledgeScreen zawiera przyk�ady z poszczeg�lnych dzia��w kt�re akurat s� 
		wybrane w widoku z poziomami.
		Ka�dy Knowledge screen jest robiony prawie tak samo, dlatego komentarze zosta�y zapisane w pierwszym.
		Pozosta�e s� robione na przyk�adzie pierwszego tylko z inn� grafik�, jak r�wnie� HelpScreen, 
		GameOver i SettingScreen */
	
	
	private Math game;
	private InputProcessor processor;
	private Texture mainScreen = new Texture("KS1.png");
	private Texture playGame = new Texture("PLAYbutton.png");
	private Texture easyText = new Texture("easy1.png");
	private Texture veryEText = new Texture("veryeasy1.png");
	private Texture arrow = new Texture("arrow.png");
	private Texture testYou = new Texture("clear.png");
	public static Music musicForce;
	
	public KnowledgeScreen(Math game) // dzieki temu konstruktorowi jest mo�liwo�� przechwycenia ekranu w innej klasie
	{
		this.game = game;
		processor = this;
		Gdx.input.setInputProcessor(processor); // przechwytuje dzia�ania myszki 
		
	}
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();			// rysowanie na ekranie
		game.batch.draw(mainScreen,0,0);
		game.batch.draw(playGame,750,40);
		game.batch.draw(easyText,750,235);
		game.batch.draw(veryEText,720,150);
		game.batch.draw(testYou,0,40);
		game.batch.draw(arrow,625,160);
		game.batch.draw(arrow,663,245);
		
		game.batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		GameMenu.music.dispose();
		
	}


	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(screenX > 750 && screenX < 1000 && screenY < (game.height - 80 ) && screenY > (game.height -80 -30 ) )
		{
			game.getScreen().dispose(); // usuni�cie poprzedniego ekranu 
			game.setScreen(new MathematicAccelerator(game)); // zmiana ekranu 
			
			musicForce = Gdx.audio.newMusic(Gdx.files.internal("where.mp3"));
			if(SettingScreen.musicOn) // je�li w ustawieniach muzyka jest ustawiona na on w grze r�wnie� zostanie w�aczona
				musicForce.play(); // w�aczanie muzyki przypisanej do poziomu
		}
		return false;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override

	public boolean mouseMoved(int screenX, int screenY) {
		if(screenX > 625 && screenX < 700 && screenY < (game.height - 187 ) && screenY > (game.height - 187 - 30) )
			veryEText = new Texture("veryeasy.png");
			
		if(screenX > 663 && screenX < 715 && screenY < (game.height - 275) && screenY > (game.height - 275 - 30) )
			easyText = new Texture("easy.png");
		
		if(screenX > 390 && screenX < 400 && screenY < (game.height - 100 ) && screenY > (game.height - 100 -20 ) )
			testYou = new Texture("testYOU.png");
		else
			testYou = new Texture("clear.png");
		
		if(screenX > 750 && screenX < 1000 && screenY < (game.height - 80 ) && screenY > (game.height -80 -30 ) )
			playGame = new Texture("PLAYbuttonRED.png");
		else
			playGame = new Texture("PLAYbutton.png");
		
		return false;
	}


	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
