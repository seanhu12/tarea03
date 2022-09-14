package app.movil.tarea03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import app.movil.tarea03.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private EditText txt_num1,txt_num2;
    private TextView txt_Res;
    private Spinner sp_operation;
    private operationAdapter adapter;

    int operations1[] = {R.drawable.descarga, R.drawable.resta, R.drawable.div, R.drawable.mult};

    String [] operations ={
            "Sumar",
            "Restar",
            "Multiplicar",
            "Dividir"
    };

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        txt_num1 = (EditText) binding.txtNumer1;
        txt_num2 = (EditText) binding.txtNumber2;
        txt_Res = (TextView) binding.txtResult;

        sp_operation = (Spinner) binding.spiOption;

        operationAdapter operationAdapter = new operationAdapter(getContext(),operations1,operations);

        sp_operation.setAdapter(operationAdapter);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
              String seleted = sp_operation.getSelectedItem().toString();

              switch (seleted){
                  case "2131165280":{
                      sum();
                      break;
                  }
                  case "2131165341":{
                      sub();
                      break;
                  }
                  case "2131165327":{
                      mul();
                      break;
                  }
                  case "2131165286":{
                      div();
                      break;
                  } default:{
                      showMesaggeEmpty();
                  }
              }
            }
        });
    }

    public String sum(){
        double val_1 = Integer.parseInt(txt_num1.getText().toString());
        double val_2 = Integer.parseInt(txt_num2.getText().toString());
        double sum = val_1+val_2;
        String res =String.valueOf(sum);
        txt_Res.setText(res);
        return res;
    }
    public String sub(){
        double val_1 = Integer.parseInt(txt_num1.getText().toString());
        double val_2 = Integer.parseInt(txt_num2.getText().toString());
        double rest = val_1-val_2;
        String res =String.valueOf(rest);
        txt_Res.setText(res);
        return res;
    }

    public String mul(){
        double val_1 = Integer.parseInt(txt_num1.getText().toString());
        double val_2 = Integer.parseInt(txt_num2.getText().toString());
        double mul = val_1*val_2;
        String res =String.valueOf(mul);
        txt_Res.setText(res);
        return res;
    }

    public String div(){
        double val_1 = Integer.parseInt(txt_num1.getText().toString());
        double val_2 = Integer.parseInt(txt_num2.getText().toString());
        String res= "";
        if (val_2 !=0){
            double div = val_1/val_2;
            res = String.valueOf(div);
            txt_Res.setText(res);
        }else {
            Toast.makeText(this.getContext(),"no puede ser 0",Toast.LENGTH_SHORT).show();

        }
        return res;
    }

    public void showMesaggeEmpty(){
        Toast.makeText(this.getContext(),"No se paso nada",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}