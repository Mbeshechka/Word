package ru.words;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public static final float SCREEN_WIDTH = 900;
    public static final float SCREEN_HEIGHT = 1600;

    public SpriteBatch batch;
    public OrthographicCamera camera;
    public Vector3 touch;
    public BitmapFont font;

    first_screen firstScreen;
    second_Screen secondScreen;
    just_Screen justScreen;
    third_Screen thirdScreen;
    fourth_Screen fourthScreen;





    @Override
    public void create() {

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,SCREEN_WIDTH,SCREEN_HEIGHT);
        touch = new Vector3();
        font = new BitmapFont(Gdx.files.internal("stylo90gray.fnt"));
        firstScreen = new first_screen(this);
        secondScreen = new second_Screen(this);
        justScreen = new just_Screen(this);
        thirdScreen = new third_Screen(this);
        fourthScreen = new fourth_Screen(this);

        setScreen(justScreen);


    }



    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();

    }
}
