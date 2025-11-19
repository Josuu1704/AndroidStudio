package com.Josuu1.zenvestprueba2.ui.frmanager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Josuu1.zenvestprueba2.mainfr.Arrecifes;
import com.Josuu1.zenvestprueba2.mainfr.Peces;

public class Paginador extends FragmentPagerAdapter {
    private final Context mContext;

    public Paginador(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Arrecifes();
            case 1:
                return new Peces();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}