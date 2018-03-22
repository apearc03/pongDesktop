package pong.game.menuscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import pong.game.Pong;




/**
 * 
 * @author Alex Pearce
 *
 */
public class MenuScreen implements Screen{


	//Stage instance to display all scene2d actors
	private Stage stage;
	
	//Necessary text buttons
	private TextButton gameButton;
	private TextButton settingsButton;


	private TextButton exitButton;


	//References the Pong class. The class where the application started.
	private Pong pongGame;
	
	//Labels to display text on the screen.

	private final String title; 
	private final String author;
	
	private Label titleLabel;
	private Label authorLabel;
	
	//Background image texture and sprite
	private Texture background;
	
	private Sprite backgroundSprite;

	
	
	/**
	 * Constructor initializes all instance variables.
	 * @param pong
	 */
	public MenuScreen(final Pong pong) {
		
		pongGame = pong;
		
		stage = new Stage(new StretchViewport(pongGame.getAppWidth(), pongGame.getAppHeight(), pongGame.getCamera()));
		
		
		background = new Texture(Gdx.files.internal("menu.jpg"));
		
		
		backgroundSprite = new Sprite(background);
		backgroundSprite.setSize(pongGame.getAppWidth(), pongGame.getAppHeight());
		
		title = "Pong";
		author = "By Alex Pearce";
		
		
		authorLabel = new Label(author, new LabelStyle(pongGame.getFont20(),Color.WHITE));
		authorLabel.setPosition(pongGame.getAppWidth()/2-authorLabel.getWidth()/2, 500);
		stage.addActor(authorLabel);
		
		titleLabel = new Label(title, new LabelStyle(pongGame.getFont100(),Color.WHITE));
		titleLabel.setPosition(pongGame.getAppWidth()/2-titleLabel.getWidth()/2, 550);
		stage.addActor(titleLabel);
		
		
		//All buttons initialized. Their positions and size are set. They are then added to the stage.
		
		gameButton = new TextButton("Play", pongGame.getSkin());
		gameButton.setSize(100, 30);
		gameButton.setPosition(pongGame.getAppWidth()/2-(gameButton.getWidth()/2), 300);
		stage.addActor(gameButton);	
		
		settingsButton = new TextButton("Settings", pongGame.getSkin());
		settingsButton.setSize(100, 30);
		settingsButton.setPosition(pongGame.getAppWidth()/2-(settingsButton.getWidth()/2), 250);
		stage.addActor(settingsButton);
	
		

		
		


		
		
		exitButton = new TextButton("Exit", pongGame.getSkin());
		exitButton.setSize(100, 30);
		exitButton.setPosition(pongGame.getAppWidth()/2-(exitButton.getWidth()/2), 100);
		stage.addActor(exitButton);
		
		

	

		
		
		//Click listeners added to buttons. The Listener clicked method will execute when the button is clicked.
		
		gameButton.addListener(new ClickListener() { //Anonymous ClickListener created.
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				super.clicked(event, x, y);
				
				pongGame.getButtonSound().play(pongGame.getGlobalVolume()); //Plays the button sound
				pongGame.setScreen(pongGame.getGameScreen());
			
				
			}
		});
		
		
		settingsButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				super.clicked(event, x, y);
				pongGame.getButtonSound().play(pongGame.getGlobalVolume());
				pongGame.setScreen(pongGame.getSettingsScreen());
			}
		});
		
		
	
		
	
		
		exitButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				super.clicked(event, x, y);
				pongGame.getButtonSound().play(pongGame.getGlobalVolume());
				Gdx.app.exit();
			
			}
		});
		
		
	
		
		
	}

	

	/**
	 * This method is called once every time the Menu screen is set as the current screen. Sets is as the input processor and checks the database connection state.
	 */
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	
		
	
		
	}
	
	
	
	/**
	 * Render is called to display every frame. I have set the default fore-ground FPS to 58 so this method should be called approximately 58 times per second.
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		pongGame.getBatch().begin();
		
		
		
		backgroundSprite.draw(pongGame.getBatch());
	
		
		
		pongGame.getBatch().end();
		
		stage.act(delta);
		stage.draw();
		
	}
	
	
	/**
	 * Adjusts the stage viewport size when the window is size is changed
	 */
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, false); 


	}
	
	
	//Methods that are required to be implemented by the Screen interface but are unused.
	@Override
	public void pause() {}
	@Override
	public void resume() {}
	@Override
	public void hide() {}
	
	
	/**
	 * Releases any resources when the game exits. This is called within Pong.dispose
	 */
	@Override
	public void dispose() {
		background.dispose();
		

		stage.dispose();
	
		
		
	}

	

	
	
}

