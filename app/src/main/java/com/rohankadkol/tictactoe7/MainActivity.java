package com.rohankadkol.tictactoe7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    private HashMap<Integer, ImageView> mIdTileMap = new HashMap<>();
    private HashMap<Integer, Integer[]> mIdIndexMap = new HashMap<>();

    private Team[][] board = {
            {Team.EMPTY, Team.EMPTY, Team.EMPTY},
            {Team.EMPTY, Team.EMPTY, Team.EMPTY},
            {Team.EMPTY, Team.EMPTY, Team.EMPTY}
    };

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
        if (board[indices[0]][indices[1]] != Team.EMPTY) {
            return;
        }

        int image = mTurn == Team.LSU ? R.drawable.lsu_logo : R.drawable.alabama_logo;
        ImageView imageView = mIdTileMap.get(id);
        imageView.setImageResource(image);

        board[indices[0]][indices[1]] = mTurn;
        mTurn = mTurn == Team.LSU ? Team.ALABAMA : Team.LSU;
    }

    private void checkWon(int tileId) {
        switch (tileId) {
            case R.id.iv_00:
                if (areThreeEqual(board[0][0], board[0][1], board[0][2])) {
                    won(new Integer[]{R.id.iv_00, R.id.iv_01, R.id.iv_02});
                } else if (areThreeEqual(board[0][0], board[1][1], board[2][2])) {
                    won(new Integer[]{R.id.iv_00, R.id.iv_11, R.id.iv_22});
                } else if (areThreeEqual(board[0][0],board[1][0], board[2][0])) {
                    won(new Integer[]{R.id.iv_00, R.id.iv_10, R.id.iv_20});
                }
                break;
            case R.id.iv_01:
                if (areThreeEqual(board[0][0], board[0][1], board[0][2])) {
                    won(new Integer[]{R.id.iv_00, R.id.iv_01, R.id.iv_02});
                } else if (areThreeEqual(board[0][1], board[1][1], board[2][1])) {
                    won(new Integer[]{R.id.iv_01, R.id.iv_11, R.id.iv_21});
                }
                break;
            case R.id.iv_02:
                if (areThreeEqual(board[0][0], board[0][1], board[0][2])) {
                    won(new Integer[]{R.id.iv_00, R.id.iv_01, R.id.iv_02});
                } else if (areThreeEqual(board[0][2], board[1][1], board[2][0])) {
                    won(new Integer[]{R.id.iv_02, R.id.iv_11, R.id.iv_20});
                } else if (areThreeEqual(board[0][2], board[1][2], board[2][2])) {
                    won(new Integer[]{R.id.iv_02, R.id.iv_12, R.id.iv_22});
                }
                break;
            case R.id.iv_10:
                if (areThreeEqual(board[0][0], board[1][0], board[2][0])) {
                    won(new Integer[]{R.id.iv_00, R.id.iv_10, R.id.iv_20});
                } else if (areThreeEqual(board[1][0], board[1][1], board[1][2])) {
                    won(new Integer[]{R.id.iv_10, R.id.iv_11, R.id.iv_12});
                }
                break;
            case R.id.iv_11:
                if (areThreeEqual())
        }
    }

    private void horizontal1() {
        if (areThreeEqual(board[0][0], board[0][1], board[0][2])) {
            won(new Integer[]{R.id.iv_00, R.id.iv_01, R.id.iv_02});
        }
    }

    private void horizontal2() {
        if (areThreeEqual(board[1][0], board[1][1], board[1][2])) {
            won(new Integer[]{R.id.iv_10, R.id.iv_11, R.id.iv_12});
        }
    }

    private void horizontal3() {
        if (areThreeEqual(board[2][0], board[2][1], board[2][2])) {
            won(new Integer[]{R.id.iv_20, R.id.iv_21, R.id.iv_22});
        }
    }

    private void vertical1() {
        if (areThreeEqual(board[0][0], board[1][0], board[2][0])) {
            won(new Integer[]{R.id.iv_00, R.id.iv_10, R.id.iv_20});
        }
    }

    private void vertical2() {
        if (areThreeEqual(board[0][1], board[1][1], board[2][1])) {
            won(new Integer[]{R.id.iv_01, R.id.iv_11, R.id.iv_21});
        }
    }

    private void vertical3() {
        if (areThreeEqual(board[0][2], board[1][2], board[2][2])) {
            won(new Integer[]{R.id.iv_02, R.id.iv_12, R.id.iv_22});
        }
    }

    private void diagonal1() {
        if (areThreeEqual(board[0][0], board[1][1], board[2][2])) {
            won(new Integer[]{R.id.iv_00, R.id.iv_11, R.id.iv_22});
        }
    }

    private void diagonal2() {
        if (areThreeEqual(board[0][2], board[1][1], board[2][0])) {
            won(new Integer[]{R.id.iv_02, R.id.iv_11, R.id.iv_20});
        }
    }

    private void won(Integer[] winingIds) {
        int[] imageViewIds = new int[]{R.id.iv_00, R.id.iv_01, R.id.iv_02, R.id.iv_10, R.id.iv_11, R.id.iv_12, R.id.iv_20, R.id.iv_21, R.id.iv_22};
        for (int imageId : imageViewIds) {
            if (imageId != winingIds[0] && imageId != winingIds[1] && imageId != winingIds[2]) {
                mIdTileMap.get(imageId).setAlpha((float) 0.5);
            }
        }
    }

    private <T> boolean areThreeEqual(T a, T b, T c) {
        return a == b && b == c;
    }
}
