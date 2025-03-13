package ru.words;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class fourth_Screen implements  Screen{
    button btn;
    button btn2;
    button btn3;
    button btn4;
    button btn5;
    button btn6;
    Main main;
    private Texture d12;
    public SpriteBatch batch;
    public OrthographicCamera camera;
    public Vector3 touch;
    public BitmapFont font;
    public fourth_Screen(Main main){
        this.main = main;
        batch = main.batch;
        camera = main.camera;
        touch = main.touch;
        font = main.font;
        btn6 = new button(font,"back",350,800);
        btn = new button(font,"second_screen",150,1000);
        btn2 = new button(font,"first_screen",150,1300);
        btn3 = new button(font,"third_screen",150,700);
        btn4 = new button(font,"fourth_screen",150,400);
        d12 = new Texture("d2.jpg");


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()){
            touch.set(Gdx.input.getX(),Gdx.input.getY(),0);
            camera.unproject(touch);
            if(btn6.hit(touch.y,touch.x)){
                main.setScreen(main.justScreen);
            }

        }
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(d12,0,0,900,1600);
        btn6.font.draw(batch,btn6.text,btn6.x,btn6.y);




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
        d12.dispose();

    }
}
