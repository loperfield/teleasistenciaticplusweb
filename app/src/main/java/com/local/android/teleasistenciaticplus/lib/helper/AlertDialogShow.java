package com.local.android.teleasistenciaticplus.lib.helper;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;


/**
 * Created by GAMO1J on 25/02/2015.
 *
 * Clase genérica para mostrar mensajes en en el IU vía AlertDialog.
 * Sólo mostrará un AlertDialog con un botón.
 */
public class AlertDialogShow extends DialogFragment {

    //Datos de Entrada para la inicialización del dialog
    String titulo;
    String Message;
    String labelNeutral;


    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        // Usa la clase constructora para la creación del dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Definimos el título y el mensaje
        builder.setTitle(this.titulo);
        builder.setMessage(this.Message);
        //builder.setNeutralButton(this.labelNeutral);
        builder.setNeutralButton(this.labelNeutral, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // No requiere de implementación
            }
        });
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

    public void setMessage(String message) {
        this.Message = message;
    }

    public void setLabelNeutral(String labelNeutral) {
        this.labelNeutral = labelNeutral;
    }

}


