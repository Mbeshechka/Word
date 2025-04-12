package ru.words;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


public class second_Screen implements  Screen{
    button btn;
    button btn2;
    button btn3;
    button btn4;
    button btn5;
    button btn6;
    Main main;
    private Texture d11,bk;
    public SpriteBatch batch;
    public OrthographicCamera camera;
    public Vector3 touch;
    public BitmapFont font;
    public int volumes;

    public Music oiia;
    public second_Screen(Main main){
        this.main = main;
        volumes = main.volume;
        oiia = main.cl;
        batch = main.batch;
        camera = main.camera;
        touch = main.touch;
        font = main.font;
        btn6 = new button(font,"назад",0,1600);
        btn = new button(font,"second_screen",150,1000);
        btn2 = new button(font,"first_screen",150,1300);
        btn3 = new button(font,"third_screen",150,700);
        btn4 = new button(font,"fourth_screen",150,400);
        d11 = new Texture("bg.jpg");
        bk = new Texture("back.png");


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()){
            touch.set(Gdx.input.getX(),Gdx.input.getY(),0);
            camera.unproject(touch);
            if(touch.y> 1500 && touch.y < 1600 && touch.x > 0 && touch.x < 100){
                oiia.play();
                oiia.setVolume(((float)(main.volume/9))/ 100);
                main.setScreen(main.justScreen);
            }
        }
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(d11,0,0,900,1600);


        batch.draw(bk,0,1500,100,100);






        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        d11.dispose();
        bk.dispose();

    }
}
