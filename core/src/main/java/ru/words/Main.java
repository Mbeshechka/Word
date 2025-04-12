package ru.words;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public static final float SCREEN_WIDTH = 900;
    public static final float SCREEN_HEIGHT = 1600;

    public SpriteBatch batch;
    public OrthographicCamera camera;
    public Vector3 touch;
    public BitmapFont font;
    public Boolean random_word ;
    first_screen firstScreen;
    second_Screen secondScreen;
    just_Screen justScreen;
    third_Screen thirdScreen;
    fourth_Screen fourthScreen;
    LeaderBoard led;
    public int whichSc,volume;
    public String word;
    public List myList;
    public Music cl;






    @Override
    public void create() {
        cl = Gdx.audio.newMusic(Gdx.files.internal("kn.mp3"));
        myList = new ArrayList();
        List<String> fileStrings = new ArrayList<>();

        try{
            fileStrings = Files.lines(Paths.get("C:\\ansd\\Words\\assets\\sl.txt")).collect(Collectors.toList());
        }catch(IOException e){
            e.printStackTrace();
        }

         for (int i = 0; i < fileStrings.size(); i++) {
            if ((fileStrings.get(i)).length() == 5 && !fileStrings.get(i).contains(String.valueOf("'"))&& !fileStrings.get(i).contains(String.valueOf('.')) && !fileStrings.get(i).contains(String.valueOf('-')) && !fileStrings.get(i).contains(String.valueOf(','))  && fileStrings.get(i).charAt(0) == fileStrings.get(i).toLowerCase().charAt(0)) {
                myList.add(fileStrings.get(i).toUpperCase());

            }
        }
        Collections.shuffle(myList);

        word = String.valueOf(myList.get(0));


        System.out.println(word);
        volume = 891-9;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,SCREEN_WIDTH,SCREEN_HEIGHT);
        random_word = false;
        touch = new Vector3();
        font = new BitmapFont(Gdx.files.internal("stylo90gray.fnt"));
        firstScreen = new first_screen(this);
        secondScreen = new second_Screen(this);
        justScreen = new just_Screen(this);
        thirdScreen = new third_Screen(this);
        fourthScreen = new fourth_Screen(this);
        led = new LeaderBoard(this);
        whichSc = 0;
        setScreen(justScreen);


    }



    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();

    }
}
