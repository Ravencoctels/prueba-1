package com.example.prueba_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    List<lista_elementos> elementos;
    private ToggleButton tb1;
    private RatingBar rbar;
    private Button pagar;
    private int cont;
    private ProgressBar pbar;
    private CheckBox mayo, ketchup, picante;
    private RadioButton efectivo, debito, credito;
    private ImageButton ib_1,pizza,limonada,suchi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tb1 = findViewById(R.id.tb1);
        rbar = findViewById(R.id.rbar);
        pagar = findViewById(R.id.pagar);
        pbar = findViewById(R.id.pbar);
        mayo = findViewById(R.id.mayo);
        ketchup = findViewById(R.id.ketchup);
        picante = findViewById(R.id.picante);
        efectivo = findViewById(R.id.efectivo);
        debito = findViewById(R.id.debito);
        credito = findViewById(R.id.credito);
        ib_1 = findViewById(R.id.ib_1);
        pizza = findViewById(R.id.pizza);
        limonada = findViewById(R.id.limonada);
        suchi = findViewById(R.id.suchi);

        init();
        onoff();
        carga();
        checkboxes();
        radio();
        alerta();



        ib_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, detalle.class );
                startActivity(a);
            }
        });
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, Pizza.class);
                startActivity(a);
            }
        });
    }

    private void carga() {
        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Timer t = new Timer();
                TimerTask timertask = new TimerTask() {
                    @Override
                    public void run() {
                        cont++;
                        pbar.setProgress(cont);
                        if (cont == 100) {
                            t.cancel();
                        }
                    }
                };
                t.schedule(timertask, 0, 100);
            }
        });
    }

    private void onoff() {
        tb1.setTextOff("Pedido valorado");
        tb1.setTextOn("Valorar el pedido");

        tb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tb1.isChecked()) {
                    rbar.setEnabled(false);
                    rbar.setVisibility(View.INVISIBLE);
                    showToast("Pedido valorado");
                } else {
                    rbar.setEnabled(true);
                    rbar.setVisibility(View.VISIBLE);
                    showToast("Valorar el pedido");
                }
            }
        });
    }

    private void checkboxes() {
        mayo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    showToast("Mayo selected");
                } else {
                    showToast("Mayo deselected");
                }
            }
        });

        ketchup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    showToast("Ketchup selected");
                } else {
                    showToast("Ketchup deselected");
                }
            }
        });

        picante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    showToast("Picante selected");
                } else {
                    showToast("Picante deselected");
                }
            }
        });
    }

    private void radio() {
        efectivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Efectivo selected");
            }
        });

        debito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Débito selected");
            }
        });

        credito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Crédito selected");
            }
        });
    }

    public void init(){
        elementos = new ArrayList<>();
        elementos.add(new lista_elementos("Hamburguesa Clásica","Carne de res molida, " + "Lechuga, " + "Tomate, " + "Cebolla, " + "Queso cheddar, " + "Pan de hamburguesa ","hay stock"));
        elementos.add(new lista_elementos("Hamburguesa BBQ","Carne de res molida, " + "Salsa barbacoa, " + "Cebolla caramelizada, " + "Queso suizo, " + "Pan de hamburguesa","No hay stock"));
        elementos.add(new lista_elementos("Hamburguesa Vegetariana","Hamburguesa de garbanzos o soja, " + "Lechuga, " + "Tomate, " + "Cebolla morada, " + "Pan de hamburguesa integral","hay stock"));
        elementos.add(new lista_elementos("Hamburguesa Mexicana","Carne de res molida sazonada con especias mexicanas, " + "Guacamole, " + "Jalapeños, " + "Queso cheddar o queso mexicano, " + "Pan de hamburguesa","hay stock"));


        adaptador adaptador= new adaptador(elementos,this);
        RecyclerView recyclerView = findViewById(R.id.lista);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void alerta (){
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setCancelable(true);
        b.setTitle("arriba las manos");
        b.setMessage("ESTO ES UN ASALTO");
        b.show();

    }

}
