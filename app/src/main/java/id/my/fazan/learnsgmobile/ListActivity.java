package id.my.fazan.learnsgmobile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.my.fazan.learnsgmobile.adapter.ListUserAdapter;
import id.my.fazan.learnsgmobile.database.UserRepo;
import id.my.fazan.learnsgmobile.model.User;

public class ListActivity extends AppCompatActivity {


    ArrayList<User> listUser = new ArrayList<>();
    ListUserAdapter adapter;
    UserRepo repo = new UserRepo(this);

    @BindView(R.id.rv_user)
    RecyclerView rv_user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        ButterKnife.bind(this);
        rv_user = findViewById(R.id.rv_user);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            User user = extra.getParcelable("user");
            listUser.add(user);
        }
        
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new ListUserAdapter(listUser);
        rv_user.setAdapter(adapter);
        rv_user.setHasFixedSize(true);
        rv_user.setLayoutManager(mLayoutManager);

    }
}
