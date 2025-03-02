package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();
    Actor findById(long id);
    Actor save(Actor actor);
    void delete(Actor actor);
    Actor update(long id, Actor actor);

}
