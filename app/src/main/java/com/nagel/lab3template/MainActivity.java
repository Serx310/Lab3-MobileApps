package com.nagel.lab3template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List recipes;
    private Utils utils = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipes = utils.getRecipesFormJsonFile((Context)this,"recipes.json");
        displayRecipes();
    }

    private void displayRecipes() {
        LinearLayout layout = findViewById(R.id.layout_recipelist);
        List recipes = this.recipes;
        Iterator iterator = recipes.iterator();
        while (iterator.hasNext()){
            Recipe recipe = (Recipe) iterator.next();
            Button recipeButtons = new Button((Context)this);
            String name = recipe.getName();
            recipeButtons.setText(name);
            //lisame nupule id
            int id = recipe.getId();
            recipeButtons.setTag(id);
            //nupule  tegevuse määramine
            recipeButtons.setOnClickListener(view -> openDetailsActivity(name));
            layout.addView(recipeButtons);
        }
    }

    private void openDetailsActivity(String name){
        Intent openWithName = new Intent(this, DetailsActivity.class);
        openWithName.putExtra("name", name);
        startActivity(openWithName);

    }
}