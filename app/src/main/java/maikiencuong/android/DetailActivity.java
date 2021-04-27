package maikiencuong.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName, tvPrice;
    private ImageView imageView;
    private Button buttonAdd;
    private Product product;
    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        tvName = findViewById(R.id.detail_name);
        tvPrice = findViewById(R.id.detail_price);
        imageView = findViewById(R.id.detail_img);
        buttonAdd = findViewById(R.id.btnAdd);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            product = (Product) bundle.getSerializable("product");
            products = (ArrayList<Product>) bundle.getSerializable("products");
            tvName.setText(product.getName());
            tvPrice.setText("$ " + product.getPrice());
            imageView.setImageResource(product.getImage());
        }

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, CheckoutActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("product", product);
                bundle.putSerializable("products", products);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}