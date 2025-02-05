// Generated by view binder compiler. Do not edit!
package com.example.smarthomecontroller.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.smarthomecontroller.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMainBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button buttonDashboard;

  @NonNull
  public final Button buttonSettings;

  @NonNull
  public final Button buttonThermostat;

  @NonNull
  public final Switch switchLight;

  private FragmentMainBinding(@NonNull FrameLayout rootView, @NonNull Button buttonDashboard,
      @NonNull Button buttonSettings, @NonNull Button buttonThermostat,
      @NonNull Switch switchLight) {
    this.rootView = rootView;
    this.buttonDashboard = buttonDashboard;
    this.buttonSettings = buttonSettings;
    this.buttonThermostat = buttonThermostat;
    this.switchLight = switchLight;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_dashboard;
      Button buttonDashboard = ViewBindings.findChildViewById(rootView, id);
      if (buttonDashboard == null) {
        break missingId;
      }

      id = R.id.button_settings;
      Button buttonSettings = ViewBindings.findChildViewById(rootView, id);
      if (buttonSettings == null) {
        break missingId;
      }

      id = R.id.button_thermostat;
      Button buttonThermostat = ViewBindings.findChildViewById(rootView, id);
      if (buttonThermostat == null) {
        break missingId;
      }

      id = R.id.switch_light;
      Switch switchLight = ViewBindings.findChildViewById(rootView, id);
      if (switchLight == null) {
        break missingId;
      }

      return new FragmentMainBinding((FrameLayout) rootView, buttonDashboard, buttonSettings,
          buttonThermostat, switchLight);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
