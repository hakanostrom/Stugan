package se.hakanostrom.stugan.service;

import se.hakanostrom.stugan.entity.Bokning;

import java.util.List;

public interface BokningService {
    Bokning sparaBokning(Bokning bokning);

    List<Bokning> listaBokningar();
}
