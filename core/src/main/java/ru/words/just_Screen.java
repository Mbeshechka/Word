package ru.words;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class just_Screen implements  Screen{
    button btn;
    button btn2;
    button btn3;
    button btn4;
    button btn5;

    Main main;
    public SpriteBatch batch;
    public OrthographicCamera camera;
    public Vector3 touch;
    public BitmapFont font;
    private Texture d1;
    public just_Screen(Main main){
        this.main = main;
        batch = main.batch;

        camera = main.camera;
        touch = main.touch;
        font = main.font;


        btn = new button(font,"second_screen",150,1000);
        btn2 = new button(font,"first_screen",150,1300);
        btn3 = new button(font,"third_screen",150,700);
        btn4 = new button(font,"fourth_screen",150,400);
        d1 = new Texture("d1.jpg");


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()){
            touch.set(Gdx.input.getX(),Gdx.input.getY(),0);
            camera.unproject(touch);
            if(btn.hit(touch.y,touch.x)){
                main.setScreen(main.firstScreen);
            }
            else if(btn2.hit(touch.y,touch.x)){
                main.setScreen(main.secondScreen);
            }
            else if(btn3.hit(touch.y,touch.x)){
                main.setScreen(main.thirdScreen);
            }
            else if(btn4.hit(touch.y,touch.x)){
                main.setScreen(main.fourthScreen);
            }
        }
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(d1,0,0,900,1600);
        btn.font.draw(batch,btn.text,btn.x,btn.y);
        btn3.font.draw(batch,btn3.text,btn3.x,btn3.y);
        btn4.font.draw(batch,btn4.text,btn4.x,btn4.y);
        btn2.font.draw(batch,btn2.text,btn2.x,btn2.y);




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
        d1.dispose();

    }
}
