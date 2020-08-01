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

    private HashMap<Integer, ImageView> mIdTileMap = new HashMap<>();
    private HashMap<Integer, Integer[]> mIdIndexMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mIv00 = findViewById(R.id.iv_00);
        mIv01 = findViewById(R.id.iv_01);
        mIv02 = findViewById(R.id.iv_02);
        mIv10 = findViewById(R.id.iv_10);
        mIv11 = findViewById(R.id.iv_11);
        mIv12 = findViewById(R.id.iv_12);
        mIv20 = findViewById(R.id.iv_20);
        mIv21 = findViewById(R.id.iv_21);
        mIv22 = findViewById(R.id.iv_22);

        mIdTileMap.put(R.id.iv_00, mIv00);
        mIdTileMap.put(R.id.iv_01, mIv01);
        mIdTileMap.put(R.id.iv_02, mIv02);
        mIdTileMap.put(R.id.iv_10, mIv10);
        mIdTileMap.put(R.id.iv_11, mIv11);
        mIdTileMap.put(R.id.iv_12, mIv12);
        mIdTileMap.put(R.id.iv_20, mIv20);
        mIdTileMap.put(R.id.iv_21, mIv21);
        mIdTileMap.put(R.id.iv_22, mIv22);

        mIdIndexMap.put(R.id.iv_00, new Integer[]{0, 0});
        mIdIndexMap.put(R.id.iv_01, new Integer[]{0, 1});
        mIdIndexMap.put(R.id.iv_02, new Integer[]{0, 2});
        mIdIndexMap.put(R.id.iv_10, new Integer[]{1, 0});
        mIdIndexMap.put(R.id.iv_11, new Integer[]{1, 1});
        mIdIndexMap.put(R.id.iv_12, new Integer[]{1, 2});
        mIdIndexMap.put(R.id.iv_20, new Integer[]{2, 0});
        mIdIndexMap.put(R.id.iv_21, new Integer[]{2, 1});
        mIdIndexMap.put(R.id.iv_22, new Integer[]{2, 2});
    }

    public void onTileClicked(View view) {
        int id = view.getId();
        Integer[] indices = mIdIndexMap.get(id);
        if (!isBoardActive || board[indices[0]][indices[1]] != Team.EMPTY) {
            return;
        }

        int image = mTurn == Team.LSU ? R.drawable.lsu_logo : R.drawable.alabama_logo;
        ImageView imageView = mIdTileMap.get(id);
        imageView.setImageResource(image);

        board[indices[0]][indices[1]] = mTurn;

        checkWon(id);

        mTurn = mTurn == Team.LSU ? Team.ALABAMA : Team.LSU;
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

    private boolean horizontal1() {
        if (areThreeEqual(board[0][0], board[0][1], board[0][2])) {
            won(new Integer[]{R.id.iv_00, R.id.iv_01, R.id.iv_02});
            return true;
        }
        return false;
    }

    private boolean horizontal2() {
        if (areThreeEqual(board[1][0], board[1][1], board[1][2])) {
            won(new Integer[]{R.id.iv_10, R.id.iv_11, R.id.iv_12});
            return true;
        }
        return false;
    }

    private boolean horizontal3() {
        if (areThreeEqual(board[2][0], board[2][1], board[2][2])) {
            won(new Integer[]{R.id.iv_20, R.id.iv_21, R.id.iv_22});
            return true;
        }
        return false;
    }

    // TODO (1): Similar to the above three methods, add checkWin methods for vertical1, vertical2, vertical3, diagonal1, diagonal2

    /**
     * Checks if the passed three parameters are equal
     * @param a Parameter 1
     * @param b Parameter 2
     * @param c Parameter 3
     * @param <T>
     * @return True if a, b, and c are equal. Else, false
     */
    private <T> boolean areThreeEqual(T a, T b, T c) {
        return a == b && b == c;
    }

    /**
     * Resets the board
     */
    private void resetApp() {

    }
}
