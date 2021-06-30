package com.example;

import com.vaadin.data.Binder;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;


public class JadwalLayout extends HorizontalLayout {
    private final CheckBox done;
    private final TextField text;

    public JadwalLayout(Jadwal jadwal, JadwalChangeListener changeListener) {
        setWidth("100%");
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        done = new CheckBox();
        text = new TextField();
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        text.setValueChangeMode(ValueChangeMode.BLUR);

        Binder<Jadwal> binder = new Binder<>(Jadwal.class);
        //Binds fields in this class to those in Jadwal based on their names
        binder.bindInstanceFields(this);
        // The following does the same more explicitly
        // binder.bind(text, Jadwal::getText, Jadwal::setText);
        // binder.bind(done, Jadwal::isDone, Jadwal::setDone);

        binder.setBean(jadwal);

        addComponent(done);
        addComponentsAndExpand(text);

        binder.addValueChangeListener(event -> changeListener.todoChanged(jadwal));
    }
}
