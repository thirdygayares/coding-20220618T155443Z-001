package com.example.tnrpizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button processOrder,newOrder;
    CheckBox onion,tomatoes,pineapple,extraCheese,mushroom;
    RadioGroup pizzaGroup,sizeGroup,crustGroup;
    RadioButton small,medium,large,hawaiian,hamCheese,thin,thick;
    TextView orderPizzaNameDisplay,sizeCrustDisplay,orderPizzaPriceDisplay,extraToppingsOrderDisplay,ExtratoppingPriceDisplay,totalWordDisplay,totalPrice;
    double pizzaPrize,extraToppings = 0, total=0, sizePrice  = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processOrder = (Button) findViewById(R.id.processOrder);
        newOrder = (Button) findViewById(R.id.newOrder);
        onion = (CheckBox) findViewById(R.id.onion);
        tomatoes = (CheckBox) findViewById(R.id.tomatoes);
        pineapple = (CheckBox) findViewById(R.id.pineapple);
        extraCheese = (CheckBox) findViewById(R.id.extraCheese);
        mushroom = (CheckBox) findViewById(R.id.mushroom);
        pizzaGroup = (RadioGroup) findViewById(R.id.pizzaGroup);
        sizeGroup = (RadioGroup) findViewById(R.id.sizeGroup);
        crustGroup = (RadioGroup) findViewById(R.id.crustGroup);
        small = (RadioButton) findViewById(R.id.smallSize);
        medium = (RadioButton) findViewById(R.id.medium);
        large = (RadioButton) findViewById(R.id.large);
        hawaiian = (RadioButton) findViewById(R.id.hawaiian);
        hamCheese = (RadioButton) findViewById(R.id.hamCheese);
        thin = (RadioButton) findViewById(R.id.thin);
        thick = (RadioButton) findViewById(R.id.thick);

        orderPizzaNameDisplay = (TextView) findViewById(R.id.orderPizzaNameDisplay);
        sizeCrustDisplay = (TextView) findViewById(R.id.sizeCrustDisplay);
        orderPizzaPriceDisplay = (TextView) findViewById(R.id.orderPizzaPriceDisplay);

        ExtratoppingPriceDisplay = (TextView) findViewById(R.id.ExtratoppingPriceDisplay);
        extraToppingsOrderDisplay = (TextView) findViewById(R.id.extraToppingsOrderDisplay);
        totalWordDisplay = (TextView) findViewById(R.id.totalWordDisplay);
        totalPrice = (TextView) findViewById(R.id.totalPrice);


    }

    @Override
    protected void onResume() {

        super.onResume();

        processOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             getSizeCrust();
             getExtraToppings();

                total(sizePrice,extraToppings);
                totalPrice.setText(String.valueOf(total));
                sizePrice = 0;
                extraToppings = 0;

            }
        });



        newOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = 0;
                orderPizzaNameDisplay.setText("");
                orderPizzaPriceDisplay.setText("");
                orderPizzaPriceDisplay.setText("");
                sizeCrustDisplay.setText("");
                extraToppingsOrderDisplay.setText("");
                ExtratoppingPriceDisplay.setText("");
                totalPrice.setText("0");
                 pizzaGroup.clearCheck();
                sizeGroup.clearCheck();
                crustGroup.clearCheck();
                tomatoes.setChecked(false);
                onion.setChecked(false);
                pineapple.setChecked(false);
                extraCheese.setChecked(false);
                mushroom.setChecked(false);
                //try this
            }
        });

    }

    public void getSizeCrust(){
        StringBuffer sizeText = new StringBuffer();

        if(small.isChecked()){
            sizeText.append("(Small& ");
            pizzaChoose(100);
        }

        if(medium.isChecked()){
            sizeText.append("(Medium& ");
            pizzaChoose(150);
        }

        if(large.isChecked()){
            sizeText.append("(Large& ");
            pizzaChoose(200);
        }


        if(thin.isChecked()){
            sizeText.append("thin)");
            pizzaPrice(sizePrice);
        }

        if(thick.isChecked()){
            sizeText.append("thick)");
            pizzaPrice(sizePrice,0.5);
        }

        //                Log.v("total",String.valueOf(sizePrice));
        orderPizzaPriceDisplay.setText(String.valueOf(sizePrice));
//                Log.v("total",String.valueOf(sizeText));
        sizeCrustDisplay.setText(String.valueOf(sizeText));

    }

    public void getExtraToppings(){
        StringBuffer extraToppingsText = new StringBuffer();

        if(extraCheese.isChecked()){
            extraToppings(20);
            extraToppingsText.append(" Extra Cheese ");
        }

        if(mushroom.isChecked()){
            extraToppings(20);
            extraToppingsText.append(" Mushroom ");
        }

        if(onion.isChecked()){
            extraToppings(10);
            extraToppingsText.append(" Onion ");
        }

        if(tomatoes.isChecked()){
            extraToppings(10);
            extraToppingsText.append(" Tomatoes ");
        }

        if(pineapple.isChecked()){
            extraToppings(15);
            extraToppingsText.append(" Pineapple ");
        }



//                Log.v("total",String.valueOf(extraToppingsText));
        extraToppingsOrderDisplay.setText(String.valueOf(extraToppingsText));
//                Log.v("total",String.valueOf(extraToppings));
        ExtratoppingPriceDisplay.setText(String.valueOf(extraToppings));
    }



    public void pizzaPrice(double pizza){
        this.sizePrice = pizza;
    }

    public void pizzaPrice(double pizza,double thick){
        this.sizePrice += pizza * thick;
    }

    public void pizzaChoose(double sizeChecked){
        StringBuffer pizzaname = new StringBuffer();
        if(hawaiian.isChecked()){
            pizzaname.append("Hawaiian");
            this.sizePrice += sizeChecked;
        }
         if(hamCheese.isChecked()){
             pizzaname.append("Ham & Cheese");
            this.sizePrice += sizeChecked * 2;
        }
        orderPizzaNameDisplay.setText(String.valueOf(pizzaname));

    }

    public void extraToppings(double extraToppings){
        this.extraToppings += extraToppings;
    }

    public void total(double pizza,double toppings){
       this.total = pizza + toppings;
    }



}