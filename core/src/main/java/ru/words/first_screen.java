package ru.words;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class first_screen implements  Screen{
    button btn;
    button btn2;
    button btn3;
    button btn4;
    button btn5;
    button btn6;
    Main main;

    private Texture d13,bk,rand,on,off,c1,c2,ny,muz,mus;
    public SpriteBatch batch;
    public OrthographicCamera camera;
    public Vector3 touch;
    public BitmapFont font;
    public int x1,y1;

    public Music oiia;
    public first_screen(Main main){

        this.main = main;
        oiia = main.cl;
        batch = main.batch;
        camera = main.camera;
        touch = main.touch;
        font = main.font;
        btn6 = new button(font,"Назад",0,1600);
        btn = new button(font,"second_screen",150,1000);
        btn2 = new button(font,"Случайное слово",150,1300);
        btn3 = new button(font,"",150,700);
        btn4 = new button(font,"fourth_screen",150,400);
        d13 = new Texture("bg.jpg");
        bk = new Texture("back.png");
        rand = new Texture("nadpis.png");
        on = new Texture("ON.png");
        off = new Texture("OFF.png");

        muz = new Texture("muz.png");
        mus = new Texture("beg.png");
        ny = new Texture("nad.png");




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
                oiia.setVolume(((float)(main.volume / 9))/ 100);
                main.setScreen(main.justScreen);
            }
            if (touch.y > 1300 && touch.y < 1400 && touch.x > 800 && touch.x < 900){
                oiia.play();
                oiia.setVolume(((float)(main.volume/9))/ 100);
                main.random_word = !main.random_word;
            }
            if (touch.y > 950 && touch.y < 1050 ){
                main.volume = (int) touch.x;
                y1 = (int) touch.y;
                oiia.play();
                oiia.setVolume(((float)(main.volume/9))/ 100);
            }
        }
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(d13,0,0,900,1600);
        batch.draw(bk,0,1500,100,100);
        batch.draw(rand,0,1300,900,100);
        if (main.random_word) {
            batch.draw(on,800,1300,100,100);

        }
        else {
            batch.draw(off,800,1300,100,100);
        }
        batch.draw(ny,0,1100,900,100);
        batch.draw(muz,-20,950,940,100);
        batch.draw(mus,main.volume,950,20,100);
        if (main.volume / 9 == 100){
            c1 = new Texture("1.png");
            c2 = new Texture("0.png");
            batch.draw(c1,400,900,50,50);
            batch.draw(c2,450,900,50,50);
            batch.draw(c2,500,900,50,50);
        } else if (main.volume / 9 > 9) {
            c1 = new Texture(String.valueOf(main.volume/ 90) + ".png");
            c2 = new Texture(String.valueOf(main.volume / 9 % 10) + ".png");
            batch.draw(c1,450,900,50,50);
            batch.draw(c2,500,900,50,50);


        } else if (main.volume / 9 < 10) {
            c1 = new Texture(String.valueOf(main.volume / 9) + ".png");
            batch.draw(c1,500,900,50,50);
        }


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
        d13.dispose();
        bk.dispose();
        on.dispose();
        off.dispose();
        rand.dispose();
        ny.dispose();
        c1.dispose();
        c2.dispose();
        mus.dispose();
        muz.dispose();

    }
}
