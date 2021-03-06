package iss.workshop.adprojectmobile.activity.Store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import iss.workshop.adprojectmobile.R;
import iss.workshop.adprojectmobile.activity.LoginActivity;

public class StoreClerkHomePageActivity extends AppCompatActivity
implements View.OnClickListener{
Button requisitinBtn, stockBtn, logoutBtn;

    SharedPreferences session;
    SharedPreferences.Editor session_editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_store_clerk_home_page);
        requisitinBtn=findViewById(R.id.requisitionRelatedBtn);
        stockBtn=findViewById(R.id.stockRelatedBtn);
        logoutBtn=findViewById(R.id.logOutBtn);
        logoutBtn.setOnClickListener(this);

        session = getSharedPreferences("session", MODE_PRIVATE);
        session_editor = session.edit();

        if(requisitinBtn!=null && stockBtn !=null) {
            registerForContextMenu(requisitinBtn);
            registerForContextMenu(stockBtn);
        }

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        if(v.getId()==R.id.requisitionRelatedBtn){
            super.onCreateContextMenu(menu,v,menuInfo);
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.requisitionrelated_menu,menu);
        }
        if(v.getId()==R.id.stockRelatedBtn){
            super.onCreateContextMenu(menu,v,menuInfo);
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.stockrelated_menu,menu);
        }

    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.stationeryRetrieval:
                Intent intent=new Intent(this, StationeryRetrievalActivity.class);
                startActivity(intent);
                break;
            case R.id.disbursementList:
                Intent intent2=new Intent(this, DisbursementListActivity.class);
                startActivity(intent2);
                break;
            case R.id.invtCheck:
                Intent intent3=new Intent(this, InventoryCheckActivity.class);
                startActivity(intent3);
                break;
            case R.id.rcvGoods:
                Intent intent4=new Intent(this, ReceiveGoodsActivity.class);
                startActivity(intent4);
                break;
//            case R.id.raisePO:
//                Intent intent5=new Intent(this, RaisePurchaseOrderActivity.class);
//                startActivity(intent5);
//                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, LoginActivity.class);
        session_editor.putString("username", "");
        session_editor.putString("role", "");
        session_editor.putInt("departmentId", 0);
        session_editor.putInt("staffId", 0);
        session_editor.commit();
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }
}