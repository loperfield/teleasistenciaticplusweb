package com.local.android.teleasistenciaticplus.lib.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;


/**
 * Created by GAMO1J on 25/02/2015.
 *
 * Clase genérica para mostrar mensajes en en el IU vía AlertDialog.
 * Dependiendo de TipoDialogo mostrará 1, 2 ó 3 botones.
 * Implementa un interface para gestionar los clicks del usuario desde
 * la actividad que la llama (host). De esta forma se personaliza dinámicamente las acciones que
 * debe llevar a cabo cada botón.
 *
 */
public class AlertDialogShow extends DialogFragment {

    //Datos de Entrada para la inicialización del dialog
    String titulo;
    TipoDialogo tipoDialogo = TipoDialogo.TWO;
    String Message;
    String labelOk;
    String labelNeutral;
    String labelCancel;

    ////////
    //Declaramos un interface para implementar los clics desde la actividad host
    //Esta implementación se puede pasar un fichero de interface para el modelo, como Constants
    ////////
    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
        public void onDialogNeutralClick(DialogFragment dialog);
    }

    // Usamos esta instancia del interface para entregar al host los events
    NoticeDialogListener mListener;

    // Sobreescribimos Fragment.onAttach() para instanciar NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verificamos que la actividad host implementa el interface
        try {
            // Instanciamos NoticeDialogListener para que podamos enviar eventos al host
            mListener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }


    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        // Usa la clase constructora para la creación del dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Definimos el título y el mensaje
        builder.setTitle(this.titulo);
        builder.setMessage(this.Message);
        //Determinamos el número de botones del diálogo
        switch (tipoDialogo){
            case ONE:
                builder.setPositiveButton(this.labelOk, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the positive button event back to the host activity
                        mListener.onDialogPositiveClick(AlertDialogShow.this);
                    }
                });
                break;
            case TWO:
                builder.setPositiveButton(this.labelOk, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acción a realizar
                        mListener.onDialogPositiveClick(AlertDialogShow.this);

                    }
                });
                builder.setNegativeButton(this.labelCancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancela el dialog
                        mListener.onDialogNegativeClick(AlertDialogShow.this);
                    }
                });
                break;
            case THREE:
                builder.setPositiveButton(this.labelOk, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acción a realizar
                        mListener.onDialogPositiveClick(AlertDialogShow.this);

                    }
                });
                builder.setNegativeButton(this.labelCancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancela el dialog
                        mListener.onDialogNegativeClick(AlertDialogShow.this);
                    }
                });
                builder.setNeutralButton(this.labelNeutral, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acción a realizar: ninguna
                        mListener.onDialogNeutralClick(AlertDialogShow.this);
                    }
                });
        }

        return show(builder);
    }

    //Devolver el diálogo al host activity
    public AlertDialog show(AlertDialog.Builder builder) {
        return builder.create();
    }

    //Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTipoDialogo(TipoDialogo tipoDialogo) {
        this.tipoDialogo = tipoDialogo;
    }

    public void setMessage(String message) {
        this.Message = message;
    }

    public void setLabelOk(String labelOk) {
        this.labelOk = labelOk;
    }

    public void setLabelNeutral(String labelNeutral) {
        this.labelNeutral = labelNeutral;
    }

    public void setLabelCancel(String labelCancel) {
        this.labelCancel = labelCancel;
    }
}


