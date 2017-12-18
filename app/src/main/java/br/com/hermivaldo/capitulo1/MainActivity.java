package br.com.hermivaldo.capitulo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, TextWatcher {

    @BindView(R.id.seekBarPercent)
    public SeekBar mSeekBar;

    @BindView(R.id.txPercentual)
    public TextView peTextPercentual;

    @BindView(R.id.etValor)
    public TextView etValorPagamento;

    @BindView(R.id.txValorTotal)
    public TextView tvValorTotal;

    @BindView(R.id.tvValorPercentual)
    public TextView tvValorPercentual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mSeekBar.setOnSeekBarChangeListener(this);

        etValorPagamento.addTextChangedListener(this);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Integer intValorPercentual = seekBar.getProgress();
        this.peTextPercentual.setText(String.valueOf(intValorPercentual));
        calcularValor();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }


    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        calcularValor();
    }

    private void calcularValor() {
        Integer intValorPercentual = this.mSeekBar.getProgress();
        if (intValorPercentual > 0) {
            float valorTotal = Float.parseFloat(etValorPagamento.getText().toString());
            float valorPercentual = valorTotal += (valorTotal * intValorPercentual) / 100;
            this.tvValorTotal.setText("R$ " +etValorPagamento.getText().toString());
            this.tvValorPercentual.setText("R$ " +String.valueOf(valorPercentual));
        }else{
            this.tvValorTotal.setText("R$ " + etValorPagamento.getText().toString());
            this.tvValorPercentual.setText("R$ " +etValorPagamento.getText().toString());
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
