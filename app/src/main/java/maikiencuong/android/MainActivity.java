package maikiencuong.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Product> products;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        products = new ArrayList<>();
        products.add(new Product("Áo thun Google", 10, R.drawable.img1));
        products.add(new Product("Áo thun Java", 20, R.drawable.img2));
        products.add(new Product("Áo thun Facebook", 30, R.drawable.img3));
        products.add(new Product("Áo thun Youtube", 40, R.drawable.img4));
        products.add(new Product("Áo thun Zalo", 50, R.drawable.img1));

        fragment = ContentFragment.newInstance(products);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment, fragment).commit();
    }
}