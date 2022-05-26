package com.example.test_sysco;

import static com.example.test_sysco.listeners.PaginationListener.PAGE_START;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.test_sysco.listeners.ItemClickListener;
import com.example.test_sysco.pojo.Planets;
import com.example.test_sysco.pojo.ResponseBean;
import com.example.test_sysco.listeners.PaginationListener;
import com.example.test_sysco.recycle_compo.RecyclerAdapter;
import com.example.test_sysco.viewmodel.MainActivityViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, ItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeRefresh)

    SwipeRefreshLayout swipeRefresh;
    private int currentPage = PAGE_START, itemCount = 0, totalPage = 10;
    private boolean isLastPage = false, isLoading = false;
    ProgressDialog progressDialog;

    RecyclerAdapter adapter;

    MainActivityViewModel viewModel;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();

        mRecyclerView.addOnScrollListener(new PaginationListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage++;
                viewModel.makeApiCall(currentPage + "");
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });


        viewModel.getRecyclerListObserver().observe(this, new Observer<ResponseBean>() {
            @Override
            public void onChanged(ResponseBean recyclerList) {

                if (recyclerList != null) {

                    if (currentPage != PAGE_START) adapter.removeLoading();
                    adapter.addItems(recyclerList.getResults());
                    swipeRefresh.setRefreshing(false);

                    if (recyclerList.getNext() != null) {
                        adapter.addLoading();
                    } else {
                        isLastPage = true;
                    }
                    isLoading = false;

                } else {
                    Toast.makeText(MainActivity.this, "No data received !", Toast.LENGTH_SHORT).show();
                }

                if (progressDialog.isShowing())
                    progressDialog.dismiss();

            }
        });

        viewModel.makeApiCall(String.valueOf(currentPage));
        showProgress();

    }


    public void initUI() {

        swipeRefresh.setOnRefreshListener(this);
        mRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(),
                layoutManager.getOrientation()));

        adapter = new RecyclerAdapter(new ArrayList<>(), MainActivity.this);
        mRecyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

    }

    public void makeDialogbox(Planets planets) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(getApplication()).inflate(R.layout.layout_dialog, viewGroup, false);
        builder.setView(dialogView);

        final AlertDialog alertDialog = builder.create();

        Button buttonOk = dialogView.findViewById(R.id.buttonOk);
        TextView tvName = dialogView.findViewById(R.id.tvDialogName);
        TextView tvOrbit = dialogView.findViewById(R.id.tvDialogOrbit);
        TextView tvGravity = dialogView.findViewById(R.id.tvDialogGravity);
        ImageView imgPic = dialogView.findViewById(R.id.imgDialogPic);

        Glide.with(imgPic).load("https://picsum.photos/200")
                .apply(RequestOptions.centerCropTransform())
                .into(imgPic);

        tvName.setText("Planet " + planets.getName());
        tvOrbit.setText("Orbital period : " + planets.getOrbital_period());
        tvGravity.setText("Gravity : " + planets.getGravity());

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();

    }


    @Override
    public void onRefresh() {
        itemCount = 0;
        currentPage = PAGE_START;
        isLastPage = false;
        adapter.clear();
        viewModel.makeApiCall(String.valueOf(currentPage));
    }

    @Override
    public void onListItemClicked(Planets planets) {
        makeDialogbox(planets);
    }

    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.show();
    }


}