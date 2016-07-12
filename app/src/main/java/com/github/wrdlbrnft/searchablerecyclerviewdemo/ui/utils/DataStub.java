package com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.utils;

import com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.models.MainExampleModel;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Genka on 12.07.2016.
 * GensaGames
 */
public class DataStub {

    public static final int START_COUNT = 20;

    public static List<MainExampleModel> getBaseExampleModels (int count) {
        List<MainExampleModel> models = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            models.add(new MainExampleModel(LoremIpsum.getInstance().getFirstName(),
                    LoremIpsum.getInstance().getEmail(), "Log: " + LoremIpsum.getInstance().getZipCode()));
        }
        return models;
    }

}
