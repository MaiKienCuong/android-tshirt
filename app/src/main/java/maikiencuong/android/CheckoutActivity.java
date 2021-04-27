package maikiencuong.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    private ArrayList<Product> products;
    private Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        getSupportActionBar().hide();

        products = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Product product = (Product) bundle.getSerializable("product");
//            products= (ArrayList<Product>) bundle.getSerializable("products");
            products.add(product);
        }

        fragment = CheckoutFragment.newInstance(products);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment2, fragment).commit();

    }
}