package com.example.bohyun.ppd;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListOfPermissions extends AppCompatActivity {

    ListView listOfAppNames;
    ArrayList<String> ar = new ArrayList<String>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_permissions);

        PackageManager pm = getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        listOfAppNames = findViewById(R.id.listOFApps);

        for (ApplicationInfo applicationInfo : packages) {
            try {
                ar.add("App: " + applicationInfo.name + " Package: " + applicationInfo.packageName + "\n");

            } catch (Exception e) {
                //Error
            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ar);
        listOfAppNames.setAdapter(arrayAdapter);

        listOfAppNames.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selected = String.valueOf(parent.getItemAtPosition(position));

                        if (position >= 0) {
                            Intent intent = new Intent(getBaseContext(), Permissions.class);
                            intent.putExtra("EXTRA_SESSION_ID", selected);
                            startActivityForResult(intent, 0);

                        }
                    }
                });
    }
}
