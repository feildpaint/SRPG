package com.ash.srpg.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MapType {

    private int id;
    private int backid;
    private String title;
    private int buttonCount;
    private boolean hasBack = true;

    private ArrayList<MapButton> mapButtons;

    private Sprite mapSprite;

    public MapType(int id) {
        mapButtons = new ArrayList<>();
        this.id = id;
        loadMap(id);
    }

    private void loadMap(int id) {

        FileHandle file = Gdx.files.internal("map/mapData.dat");

        boolean doNext = false;

        try {
            Scanner stream = new Scanner(new FileInputStream(file.file()));

            while (stream.hasNext()) {
                String next = stream.next();

                if (next.contains("#")) stream.nextLine();

                // gets ID
                else if (next.equals("id:")) {
                    int currentID = Integer.parseInt(stream.next());
                    if (id == currentID) {
                        this.id = currentID;
                        mapSprite = new Sprite(new Texture("map/mapScreen" + id + ".png"));
                        doNext = true;
                    }
                }

                // gets title
                else if (next.equals("title:") && doNext)
                    title = stream.nextLine().trim();

                else if (next.equals("count:") && doNext)
                    buttonCount = Integer.parseInt(stream.next());

                else if (next.equals("button:") && doNext) {
                    int newid = Integer.parseInt(stream.next());
                    int x = Integer.parseInt(stream.next());
                    int y = Integer.parseInt(stream.next());
                    String title = stream.nextLine().trim();

                    MapButton button = new MapButton(newid, x, y, title);
//                    System.out.println(button.toString());
                    mapButtons.add(button);
//                    System.out.println(mapButtons.size());
                }

                else if (next.equals("backid:") && doNext)
                    backid = Integer.parseInt(stream.next());

                else if (next.equalsIgnoreCase("hasNoBack") && doNext)
                    hasBack = false;

                // adds new armor to the list
                else if (next.equals("end") && doNext) {
                    break;
                }
            }

            stream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getId() {
        return id;
    }

    public int getBackid() {
        return backid;
    }

    public String getTitle() {
        return title;
    }

    public int getButtonCount() {
        return buttonCount;
    }

    public boolean isHasBack() {
        return hasBack;
    }

    public ArrayList<MapButton> getMapButtons() {
        return mapButtons;
    }

    public Sprite getMapSprite() {
        return mapSprite;
    }
}
