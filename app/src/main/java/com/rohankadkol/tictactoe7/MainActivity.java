package com.rohankadkol.tictactoe7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ImageView mIv00;
    private ImageView mIv01;
    private ImageView mIv02;
    private ImageView mIv10;
    private ImageView mIv11;
    private ImageView mIv12;
    private ImageView mIv20;
    private ImageView mIv21;
    private ImageView mIv22;

    private enum Team {LSU, ALABAMA, EMPTY}

    private Team mTurn = Team.LSU;

    private Team[][] board = {
            {Team.EMPTY, Team.EMPTY, Team.EMPTY},
            {Team.EMPTY, Team.EMPTY, Team.EMPTY},
            {Team.EMPTY, Team.EMPTY, Team.EMPTY}
    };

    private boolean isBoardActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO COMPLETED (2): Use findViewById() to initialize all the above global ImageView variables.
        mIv00 = findViewById(R.id.iv_00);
        mIv01 = findViewById(R.id.iv_01);
        mIv02 = findViewById(R.id.iv_02);
        mIv10 = findViewById(R.id.iv_10);
        mIv11 = findViewById(R.id.iv_11);
        mIv12 = findViewById(R.id.iv_12);
        mIv20 = findViewById(R.id.iv_20);
        mIv21 = findViewById(R.id.iv_21);
        mIv22 = findViewById(R.id.iv_22);
    }

    public void onTileClicked(View view) {
        // TODO COMPLETED (3): This method should be called when any tile is clicked.
        //  Hence, add this to the onClick property of all the tiles (ImageViews)
    }

    /**
     * Checks the board combinaition to see if any team has won.
     * @param tileId The XML id for the pressed tile.
     */
    private void checkWon(int tileId) {

    }

    /**
     * Call this when you found a winning combination
     * @param winingIds XML Ids Array of three winning tiles
     */
    private void won(Integer[] winingIds) {

    }

    /**
     * Resets the board
     */
    private void resetApp() {

    }
}
