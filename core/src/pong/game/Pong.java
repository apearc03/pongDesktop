package pong.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import pong.game.gamescreen.GameScreen;
import pong.game.loadingscreen.LoadingScreen;
import pong.game.menuscreen.MenuScreen;
import pong.game.settingsscreen.SettingsScreen;

/**
 * @author Alex Pearce
 *
 */

public class Pong extends Game {
	


	//Variables and instance references created. Anything declared here will be in scope of the entire application for shared use.
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	private Skin skin;
	
	private MenuScreen menuScreen;
	private GameScreen gameScreen;

	private SettingsScreen settingsScreen;
	

	
	private Music music[] = new Music[2];

	

	
	
	private Sound buttonSound;
	private Sound backButtonSound;
	private Sound buttonErrorSound;
	private float globalVolume;
	
	private int appHeight;
	private int appWidth;
	
	
	
	private FreeTypeFontGenerator generator;
	
	private BitmapFont font16;
	private FreeTypeFontParameter parameter16;
	private BitmapFont font14;
	private FreeTypeFontParameter parameter14;
	private BitmapFont font12;
	private FreeTypeFontParameter parameter12;
	
	private BitmapFont font20; 
	private FreeTypeFontParameter parameter20;
	
	private BitmapFont font100;
	private FreeTypeFontParameter parameter100;
	

	

	/**
	 * The create method is the starting point of the application.
	 *
	 * 
	 */
	@Override
	public void create () {
		
		LoadingScreen l = new LoadingScreen(this);
		this.setScreen(l);
				
	}
	/**
	 * Init() initialises all necessary variables and object instances.
	 * 
	 */
	public void init() {

		
	
	
		
	
		
	
	
	
	camera = new OrthographicCamera();
	
	
	batch = new SpriteBatch();

	appWidth = 1024;
	appHeight = 768;
	
	
	
	
	music[0] = Gdx.audio.newMusic(Gdx.files.internal("music2.ogg"));
	music[1] = Gdx.audio.newMusic(Gdx.files.internal("music.ogg"));
	
	
	generator = new FreeTypeFontGenerator(Gdx.files.internal("openSans.ttf"));
	
	//Variables fonts created using a true type font file.
	
	parameter16 = new FreeTypeFontParameter();
	parameter16.size = 16;
	font16 = generator.generateFont(parameter16);
	font16.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
	
	
	parameter14 = new FreeTypeFontParameter();
	parameter14.size = 14;
	font14 = generator.generateFont(parameter14);
	font14.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
	
	
	parameter12 = new FreeTypeFontParameter();
	parameter12.size = 12;
	font12 = generator.generateFont(parameter12);
	font12.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
	
	parameter20 = new FreeTypeFontParameter();
	parameter20.size = 20;
	font20 = generator.generateFont(parameter20);
	font20.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
	
	
	parameter100 = new FreeTypeFontParameter();
	parameter100.size = 100;
	font100 = generator.generateFont(parameter100);
	font100.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
	
	
	//Button sounds initialized with internal sound files
	buttonSound = Gdx.audio.newSound(Gdx.files.internal("buttonSound.mp3"));	
	backButtonSound = Gdx.audio.newSound(Gdx.files.internal("backButtonSound.mp3"));
	buttonErrorSound = Gdx.audio.newSound(Gdx.files.internal("buttonError.mp3"));
	globalVolume = 0.2f;
	

	
	
	
	skin = new Skin(Gdx.files.internal("uiskin.json"));
	
	//I have created one instance of each screen that will be re-used throughout the application
	
	menuScreen = new MenuScreen(this);
	gameScreen = new GameScreen(this);
	settingsScreen = new SettingsScreen(this);
	


	
	
	this.setScreen(menuScreen); //Sets the first screen to the Menu
	
	
	music[0].play(); //Begins playing the music
	music[0].setVolume(globalVolume);
	music[0].setLooping(true);
	}

	/**
	 * Dispose is called when the application exits. All resources are disposed of to be garbage collected.
	 */
	@Override
	public void dispose() {
		
		super.dispose();
		generator.dispose();
		font100.dispose();
		font20.dispose();
		font16.dispose();
		font14.dispose();
		font12.dispose();
		music[0].dispose();
		music[1].dispose();
		
		buttonSound.dispose();
		backButtonSound.dispose();
		buttonErrorSound.dispose();
		batch.dispose();
		menuScreen.dispose();
		gameScreen.dispose();

		settingsScreen.dispose();
	
	
	}
	
	
	//Below are various getters and setters used by other classes in the application.
	
	public SpriteBatch getBatch() {
		return batch;
	}
	
	public OrthographicCamera getCamera() {
		return camera;
	}
	
	public int getAppWidth() {
		return appWidth;
	}
	
	public int getAppHeight() {
		return appHeight;
	}
	

	
	public BitmapFont getFont100() {
		return font100;
	}
	
	public BitmapFont getFont20() {
		return font20;
	}
	
	public BitmapFont getFont16() {
		return font16;
	}
	
	public BitmapFont getFont14() {
		return font14;
	}
	
	public BitmapFont getFont12() {
		return font12;
	}
	
	public Sound getButtonSound() {
		return buttonSound;
	}
	
	public Sound getBackButtonSound() {
		return backButtonSound;
	}
	
	public Sound getButtonErrorSound() {
		return buttonErrorSound;
	}
	
	public GameScreen getGameScreen() {
		return gameScreen;
	}
	
	public float getGlobalVolume() {
		return globalVolume;
	}
	
	public void setGlobalVolume(float volume) {
		this.globalVolume = volume;
	}
	

	
	public MenuScreen getMenuScreen() {
		return menuScreen;
	}

	
	public SettingsScreen getSettingsScreen() {
		return settingsScreen;
	}
	
	public Skin getSkin() {
		return skin;
	}

	
	
	public Music[] getMusic() {
		return music;
	}
}