package com.tutorialsee.ecommer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductDetails extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {
    SliderLayout mDemoSlider;
    LinearLayout adsds;
    private ExpandableHeightGridView gridview;
    private ArrayList<Bean> beanclassArrayList;
    private GridviewDetailsAdapter gridviewAdapter;
    private int[] IMAGEgrid = {R.drawable.a1, R.drawable.a3, R.drawable.a6, R.drawable.a4};
    private String[] TITLeGgrid = {"Min 70% off", "Min 50% off", "Min 45% off",  "Min 60% off"};
    private String[] DIscriptiongrid = {"Laptop", "Notebook", "Smartphone","Smartphone"};
    private String[] Dategrid = {"Explore Now!","Grab Now!","Discover now!", "Great Savings!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetails);

        gridview = (ExpandableHeightGridView)findViewById(R.id.gridview);
        adsds = (LinearLayout)findViewById(R.id.adsds);
        adsds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(getApplicationContext(),AddToCart.class);
                startActivity(ii);

            }
        });
        beanclassArrayList= new ArrayList<Bean>();

        for (int i= 0; i< IMAGEgrid.length; i++) {

            Bean beanclass = new Bean(IMAGEgrid[i], TITLeGgrid[i], DIscriptiongrid[i], Dategrid[i]);
            beanclassArrayList.add(beanclass);

        }
        gridviewAdapter = new GridviewDetailsAdapter(ProductDetails.this, beanclassArrayList);
        gridview.setExpanded(true);

        gridview.setAdapter(gridviewAdapter);

        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.hp1);
        file_maps.put("2",R.drawable.hp2);
        file_maps.put("3",R.drawable.hp3);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    //  .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);


            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
        //mDemoSlider.addOnPageChangeListener(this);

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}