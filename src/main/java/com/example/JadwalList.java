package com.example;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@UIScope
@SpringComponent
class JadwalList extends VerticalLayout implements JadwalChangeListener {
    @Autowired
    JadwalRepository repository;
    private List<Jadwal> jadwals;

    @PostConstruct
    void init() {
        setWidth("80%");

        update();
    }

    private void update() {
        setJadwals(repository.findAll());
    }

    private void setJadwals(List<Jadwal> jadwals) {
        this.jadwals = jadwals;
        removeAllComponents();
        jadwals.forEach(todo -> addComponent(new JadwalLayout(todo, this)));
    }

     void addTodo(Jadwal jadwal) {
        repository.save(jadwal);
        update();
    }

    @Override
    public void todoChanged(Jadwal jadwal) {
        addTodo(jadwal);
    }


    public void deleteCompleted() {
        repository.deleteByDone(true);
        update();
    }
}
