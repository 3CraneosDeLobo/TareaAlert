package com.example.tareaalertas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

//Para la segunda clase
import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3;
    CheckBox cB1, cB2, cB3, cB4;
String data;
    LinearLayout fondo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = "Nombre: Darlin Santana - Matricula: 20175032 - Institucion: ITLA";
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        cB1 = findViewById(R.id.cB1);
        cB2 = findViewById(R.id.cB2);
        cB3 = findViewById(R.id.cB3);
        cB4 = findViewById(R.id.cB4);




        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


//Swipe Event
        fondo = findViewById(R.id.fondo);

        fondo.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            public void onSwipeLeft(){
             finish();

            }
            public void onSwipeRight(){

                finish();
            }


        });


    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);




        switch (view.getId()){
    case R.id.btn2:
        alerta.setMessage(data)
                .setCancelable(false)
                .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertaShow = alerta.create();
        alertaShow.setTitle("Information");
        alertaShow.show();


        break;
            case R.id.btn3:
                final EditText editData = new EditText(this);
                editData.setText(data);
                alerta.setTitle("Modificar Info");
                alerta.setView(editData);
                alerta.setCancelable(false);
                alerta.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        data = editData.getText().toString();
                    }
                });
                alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                alerta.show();

                break;
            case R.id.btn1:
                final ImageView img = new ImageView(this);
             boolean musica, carro, calle, persona;
             String opcion, titulo;

             musica = cB1.isChecked();
             carro = cB2.isChecked();
             calle =  cB3.isChecked();
             persona = cB4.isChecked();


             //IMAGENES INICIO
              if(musica ||  carro || calle || persona){
                  titulo = "";
                  opcion = "";
                if(musica){
                    titulo += " Musica -";
                    opcion += "m";
                }
                if(carro){
                    titulo += " Carro -";
                   opcion += "c";
                }
                  if(calle){
                      titulo += " Calle -";
                      opcion += "s";
                  }
                  if(persona){
                      titulo += " Persona -";
                      opcion += "p";
                  }

                  switch (opcion){
                      case "m":

                          img.setImageResource(R.drawable.m);
                          break;
                      case "c":
                          img.setImageResource(R.drawable.ca);
                          break;
                      case "s":
                          img.setImageResource(R.drawable.s);
                          break;
                      case "p":
                          img.setImageResource(R.drawable.p);
                          break;
                      case "mc":
                          img.setImageResource(R.drawable.mc);
                          break;
                      case "mp":
                          img.setImageResource(R.drawable.mp);
                          break;
                      case "ms":
                          img.setImageResource(R.drawable.ms);
                          break;
                      case "cs":
                          img.setImageResource(R.drawable.cs);
                          break;
                      case "cp":
                          img.setImageResource(R.drawable.cp);
                          break;
                      case "sp":
                          img.setImageResource(R.drawable.sp);
                          break;
                      case "mcp":
                          img.setImageResource(R.drawable.mcp);
                          break;
                      case "mcs":
                          img.setImageResource(R.drawable.mcs);
                          break;
                      case "msp":
                          img.setImageResource(R.drawable.msp);
                          break;
                      case "csp":
                          img.setImageResource(R.drawable.csp);
                          break;
                      case "mcsp":
                          img.setImageResource(R.drawable.todo);
                          break;
                  }


                // Do ALERT
                  alerta.setTitle(titulo)
                          .setView(img)
                          .setNeutralButton("Cerrar Ventana", new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialogInterface, int i) {
                                  dialogInterface.cancel();
                              }
                          })
                          .show();



              }
              else{
                  alerta.setTitle("Sin Opcion")
                          .setMessage("No selecciono ninguna Opcion")
                          .setNeutralButton("Cerrar Ventana", new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialogInterface, int i) {
                                  dialogInterface.cancel();
                              }
                          })
                          .show();
              }



              // IMAGENES FINAL
                break;
}



    }
}


// CLASE SWIPE

class OnSwipeTouchListener implements OnTouchListener {

    private final GestureDetector gestureDetector;

    public OnSwipeTouchListener (Context ctx){
        gestureDetector = new GestureDetector(ctx, new GestureListener());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                        result = true;
                    }
                }
                else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeBottom();
                    } else {
                        onSwipeTop();
                    }
                    result = true;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public void onSwipeRight() {
    }

    public void onSwipeLeft() {
    }

    public void onSwipeTop() {
    }

    public void onSwipeBottom() {
    }
}
