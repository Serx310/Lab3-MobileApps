package com.nagel.lab3template;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private List<Recipe> recipes;
    private Utils utils = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        recipes = utils.getRecipesFormJsonFile((Context)this, "recipes.json");
        int recipeId = getIntent().getIntExtra("id", 0);

        for(Recipe recipe: recipes){
            if(recipe.getId() == recipeId){
                ((TextView)this.findViewById(R.id.txtRecipeName)).setText(recipe.getName());
                ((TextView)this.findViewById(R.id.txtRecipeDetails)).setText(recipe.getDescription());
            }
        }
        ((Button)this.findViewById(R.id.saveBtn)).setOnClickListener(view -> getRatingAndClose(recipeId));

        /*
        Intent nameIntent = getIntent();
        String recipeName = nameIntent.getStringExtra("name");
        TextView txtName = findViewById(R.id.txtRecipeName);
        txtName.setText(recipeName);
        */
    }

    private void getRatingAndClose(int id) {
        int rating = (int) ((RatingBar)this.findViewById(R.id.ratingBar)).getRating();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("rating", rating);
        resultIntent.putExtra("id", id);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}