package com.droidrank.tictactoe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button block1, block2, block3, block4, block5, block6, block7, block8, block9, restart;
    TextView result;


    private int[][] mTable;
    private boolean xMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        block1 = (Button) findViewById(R.id.bt_block1);
        block2 = (Button) findViewById(R.id.bt_block2);
        block3 = (Button) findViewById(R.id.bt_block3);
        block4 = (Button) findViewById(R.id.bt_block4);
        block5 = (Button) findViewById(R.id.bt_block5);
        block6 = (Button) findViewById(R.id.bt_block6);
        block7 = (Button) findViewById(R.id.bt_block7);
        block8 = (Button) findViewById(R.id.bt_block8);
        block9 = (Button) findViewById(R.id.bt_block9);
        result = (TextView) findViewById(R.id.tv_show_result);
        restart = (Button) findViewById(R.id.bt_restart_game);


        mTable = new int[3][3];
        xMove = true;

        /**
         * Restarts the game
         */
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewGame();

            }
        });

    }

    private void startNewGame() {
        mTable = null;
        mTable = new int[3][3];
        xMove = true;
        block1.setText("");
        block2.setText("");
        block3.setText("");
        block4.setText("");
        block5.setText("");
        block6.setText("");
        block7.setText("");
        block8.setText("");
        block9.setText("");
        result.setText("X move");

    }

    public void makeMove(View v) {
        int x = 0;
        int y = 0;

        int id = v.getId();
        switch (id) {
            case R.id.bt_block1:
                break;
            case R.id.bt_block2:
                x = 0;
                y = 1;
                break;
            case R.id.bt_block3:
                x = 0;
                y = 2;
                break;
            case R.id.bt_block4:
                x = 1;
                y = 0;
                break;
            case R.id.bt_block5:
                x = 1;
                y = 1;
                break;
            case R.id.bt_block6:
                x = 1;
                y = 2;
                break;
            case R.id.bt_block7:
                x = 2;
                y = 0;
                break;
            case R.id.bt_block8:
                x = 2;
                y = 1;
                break;
            case R.id.bt_block9:
                x = 2;
                y = 2;
                break;
        }

        if (mTable[x][y] != 0) {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);

            dlgAlert.setMessage("This cell is not empty!");
            dlgAlert.setTitle("Error");
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
            return;
        }
        Button btn = (Button) findViewById(id);

        if (xMove) {
            btn.setText("X");
            mTable[x][y] = 2;
            result.setText("O move");
            xMove = false;
        } else {
            btn.setText("O");
            mTable[x][y] = 1;
            xMove = true;

            result.setText("X move");
        }
        checkResult();
    }

    private void checkResult() {
        boolean empty = false;
        final AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        for (int i = 0; i != 3; ++i) {
            for (int j = 0; j != 3; ++j) {
                if (mTable[i][j] == 0) {
                    empty = true;
                    break;
                }
            }
        }
        if (!empty) {
            result.setText("Draw!");
            dlgAlert.setMessage("Draw!");
            dlgAlert.setTitle("Draw");
            dlgAlert.setCancelable(true);
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            dlgAlert.create().show();

        }
        //check horizontal lines
        for (int i = 0; i != 3; ++i) {
            if (mTable[i][0] == 1 && mTable[i][1] == 1 && mTable[i][2] == 1) {
                result.setText("O Player wins!");
                dlgAlert.setMessage("O Player wins!");
                dlgAlert.setTitle("congratulations");
                dlgAlert.setCancelable(true);
                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                dlgAlert.create().show();

            }
            if (mTable[i][0] == 2 && mTable[i][1] == 2 && mTable[i][2] == 2) {
                result.setText("X Player wins!");
                dlgAlert.setMessage("X Player wins!");
                dlgAlert.setTitle("congratulations");
                dlgAlert.setCancelable(true);
                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                dlgAlert.create().show();

            }
        }
        //check vertical lines
        for (int i = 0; i != 3; ++i) {
            if (mTable[0][i] == 1 && mTable[1][i] == 1 && mTable[2][i] == 1) {
                result.setText("O Player wins!");
                dlgAlert.setMessage("O Player wins!");
                dlgAlert.setTitle("congratulations");
                dlgAlert.setCancelable(true);
                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                dlgAlert.create().show();

            }
            if (mTable[0][i] == 2 && mTable[1][i] == 2 && mTable[2][i] == 2) {
                result.setText("X Player wins!");
                dlgAlert.setMessage("X Player wins!");
                dlgAlert.setTitle("congratulations");
                dlgAlert.setCancelable(true);
                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                dlgAlert.create().show();

            }
        }
        //check diagonals
        if (mTable[0][0] == 1 && mTable[1][1] == 1 && mTable[2][2] == 1) {
            result.setText("O Player wins!");
            dlgAlert.setMessage("O Player wins!");
            dlgAlert.setTitle("congratulations");
            dlgAlert.setCancelable(true);
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            dlgAlert.create().show();

        }
        if (mTable[0][0] == 2 && mTable[1][1] == 2 && mTable[2][2] == 2) {
            result.setText("X Player wins!");
            dlgAlert.setMessage("X Player wins!");
            dlgAlert.setTitle("congratulations");
            dlgAlert.setCancelable(true);
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            dlgAlert.create().show();

        }
        if (mTable[0][2] == 1 && mTable[1][1] == 1 && mTable[2][0] == 1) {
            result.setText("O Player wins!");
            dlgAlert.setMessage("O Player wins!");
            dlgAlert.setTitle("congratulations");
            dlgAlert.setCancelable(true);
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            dlgAlert.create().show();

        }
        if (mTable[0][2] == 2 && mTable[1][1] == 2 && mTable[2][0] == 2) {
            result.setText("O Player wins!");
            dlgAlert.setMessage("X Player wins!");
            dlgAlert.setTitle("congratulations");
            dlgAlert.setCancelable(true);
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            dlgAlert.create().show();

        }
    }



}
